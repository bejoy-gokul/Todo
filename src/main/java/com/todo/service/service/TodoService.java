package com.todo.service.service;

import java.util.List;

import com.todo.service.dto.request.TaskRequest;
import com.todo.service.dto.response.TaskResponse;

public interface TodoService {

	void createTask(TaskRequest task);
	
	TaskResponse getTask(Long id);
	
	List<TaskResponse> getTasks();
	
	void updateTask(TaskResponse task);
	
	void deleteTask(Long id);
	
	
	
}
