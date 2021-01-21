package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("employee")
public class EmployeeDTO implements Persistable<String> {
    @Id
    private String id;
    private String name;
    @Transient
    private List<AddressDTO> addresses;

    @Transient
    private boolean newEmp;

    @Override
    @Transient
    public boolean isNew() {
        return this.newEmp || id == null;
    }

    public EmployeeDTO setAsNew() {
        this.newEmp = true;
        return this;
    }
}
