package com.github.pavelburdakov.taskapp.service;

import com.github.pavelburdakov.taskapp.entity.Task;

import java.util.List;

public interface TaskService {

    Task getById(String id);

    List<Task> getByUserId(String userId);

    Task add(Task task);

    Task update(Task task, String taskId);

    void deleteById(String id);

}
