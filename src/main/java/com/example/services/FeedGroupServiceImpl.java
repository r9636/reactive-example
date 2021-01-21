package com.example.services;

import com.example.entities.FeedGroup;
import com.example.entities.FeedGroupDTO;
import com.example.utils.TaskMapper;
import com.example.repositories.FeedGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Transactional
public class FeedGroupServiceImpl implements FeedGroupService {

    private final DatabaseClient databaseClient;
    @Autowired
    private FeedGroupRepository feedGroupRepository;

    public FeedGroupServiceImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public Flux<FeedGroup> findAllFeedGroups(String dataProviderId) {
        String query = "SELECT feed_group.id, feed_group.data_provider_id, feed_group.name FROM feed_group INNER JOIN data_provider ON feed_group.data_provider_id = data_provider.id "
                + " WHERE data_provider.id = :dataProviderId";

        TaskMapper taskMapper = new TaskMapper();
        Flux<FeedGroup> result = databaseClient.sql(query)
                .bind("dataProviderId", dataProviderId)
                .map(taskMapper::apply)
                .all();
        return result;
    }

    @Override
    public Mono<FeedGroupDTO> saveFeed(FeedGroup feedGroup) {
//        feedGroup.setId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        return feedGroupRepository.save(feedGroup.setAsNew()).map(feed -> {
           return modelMapper.map(feed, FeedGroupDTO.class);
        });
    }
}
