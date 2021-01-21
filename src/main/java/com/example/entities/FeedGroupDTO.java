package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeedGroupDTO {
    private String id;
    private String dataProviderId;
    private String name;
}