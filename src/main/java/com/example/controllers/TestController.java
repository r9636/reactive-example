package com.example.controllers;

import com.example.entities.Employee;
import com.example.entities.EmployeeDTO;
import com.example.entities.FeedGroup;
import com.example.entities.FeedGroupDTO;
import com.example.services.EmployeeService;
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

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{dataProviderId}")
    public Flux<FeedGroup> getAllFeeds(@PathVariable("dataProviderId") String dataProviderId){
        return feedGroupService.findAllFeedGroups(dataProviderId);
    }

    @PostMapping
    public Mono<FeedGroupDTO> saveFeedGroup(@RequestBody FeedGroup feedGroup){
        return feedGroupService.saveFeed(feedGroup);
    }

    @PostMapping("/addEmployee")
    public Mono<EmployeeDTO> saveFeedGroup(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
}
