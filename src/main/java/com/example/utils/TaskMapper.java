package com.example.utils;

import com.example.entities.FeedGroup;
import io.r2dbc.spi.Row;

import java.util.function.BiFunction;

public class TaskMapper implements BiFunction<Row, Object, FeedGroup> {
    @Override
    public FeedGroup apply(Row row, Object o) {
         String id = row.get("id", String.class);
         String dataProviderId = row.get("data_provider_id", String.class);
         String name = row.get("name", String.class);
         FeedGroup feedGroup = new FeedGroup(id, dataProviderId, name);
        return feedGroup;
    }
}
