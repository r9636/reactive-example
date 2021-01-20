package com.example.repositories;

import com.example.entities.FeedGroup;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedGroupRepository extends ReactiveCrudRepository<FeedGroup, String> {
}
