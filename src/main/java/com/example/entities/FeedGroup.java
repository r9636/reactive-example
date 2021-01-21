package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
public class FeedGroup implements Persistable<String> {
    @Id
    private String id;
    private String dataProviderId;
    private String name;

    @Override
    @Transient
    public boolean isNew() {
        return true;
    }
}
