package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("address")
public class Address implements Persistable<String> {
    @Id
    private String id;
    private String empId;
    private String city;
    @Transient
    private boolean newAdd;

    @Override
    @Transient
    public boolean isNew() {
        return this.newAdd || id == null;
    }

    public Address setAsNew() {
        this.newAdd = true;
        return this;
    }
}
