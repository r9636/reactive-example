package com.example.controllers;

import com.example.entities.FeedGroup;
import com.example.entities.FeedGroupDTO;
import com.example.services.FeedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private FeedGroupService feedGroupService;
    @GetMapping("/{dataProviderId}")
    public Flux<FeedGroup> getAllFeeds(@PathVariable("dataProviderId") String dataProviderId){
        return feedGroupService.findAllFeedGroups(dataProviderId);
    }

    @PostMapping
    public Mono<FeedGroupDTO> saveFeedGroup(@RequestBody FeedGroup feedGroup){
        return feedGroupService.saveFeed(feedGroup);
    }
}
