package com.example.services;

import com.example.entities.FeedGroup;
import com.example.entities.FeedGroupDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedGroupService {
    public Flux<FeedGroup> findAllFeedGroups(String dataProviderId);

    Mono<FeedGroupDTO> saveFeed(FeedGroup feedGroup);
}
