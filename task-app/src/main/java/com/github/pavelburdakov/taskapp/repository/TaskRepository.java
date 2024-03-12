package com.github.pavelburdakov.taskapp.repository;

import com.github.pavelburdakov.taskapp.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task>  findAllByUserId (String userId);
}
