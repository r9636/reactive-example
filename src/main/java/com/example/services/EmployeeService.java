package com.example.services;

import com.example.entities.Employee;
import com.example.entities.EmployeeDTO;
import com.example.entities.FeedGroupDTO;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeeDTO> saveEmployee(Employee employee);
}
