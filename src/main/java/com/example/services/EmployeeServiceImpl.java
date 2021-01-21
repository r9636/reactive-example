package com.example.services;

import com.example.entities.Address;
import com.example.entities.Employee;
import com.example.entities.EmployeeDTO;
import com.example.repositories.AddressRepository;
import com.example.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Mono<Employee> saveEmployee(EmployeeDTO employee) {
        ModelMapper mapper = new ModelMapper();
        employee.setId(UUID.randomUUID().toString());


        List<Address> addresses = employee.getAddresses().stream().peek(address -> {
            address.setId(UUID.randomUUID().toString());
            address.setEmpId(employee.getId());
            address.setAsNew();
//            addressRepository.save(address.setAsNew()).log().subscribe();
//            System.out.println(address);
        }).collect(Collectors.toList());

        employeeRepository.save(employee.setAsNew()).
                thenMany(addressRepository.saveAll(addresses)).subscribe();
        return Mono.just(mapper.map(employee,Employee.class));
    }
}
