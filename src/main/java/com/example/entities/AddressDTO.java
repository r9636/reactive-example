package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {
    @Id
    private String id;
    private String empId;
    private String city;
}