package com.example.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class FeedGroup implements Persistable<String> {
    @Id
    private String id;
    private String dataProviderId;
    private String name;
    @Transient
    private boolean newFeed;

    public FeedGroup(String id, String dataProviderId, String name) {
        this.id = id;
        this.dataProviderId = dataProviderId;
        this.name = name;
    }

    @Override
    @Transient
    public boolean isNew() {
        return this.newFeed || id == null;
    }

    public FeedGroup setAsNew() {
        this.newFeed = true;
        return this;
    }
}