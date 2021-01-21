package com.example.repositories;

import com.example.entities.EmployeeDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<EmployeeDTO, String> {
}
