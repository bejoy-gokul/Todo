package com.todo.service.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.service.dto.request.TaskRequest;
import com.todo.service.dto.response.TaskResponse;
import com.todo.service.entity.Task;
import com.todo.service.exception.NotFoundException;
import com.todo.service.mapper.TodoMapper;
import com.todo.service.repository.TaskRepository;
import com.todo.service.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	private final TaskRepository taskRepository;

	private Logger log = LoggerFactory.getLogger(TodoServiceImpl.class);

	@Autowired
	public TodoServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public void createTask(TaskRequest taskR) {
		// TODO Auto-generated method stub

		log.info("Creating task!");

		LocalDateTime now = LocalDateTime.now();
		Task task = TodoMapper.INSTANCE.toTask(taskR);
		task.setCreatedAt(now);
		task.setUpdatedAt(now);
		taskRepository.save(task);

		log.info("Task created successfully");
	}

	@Override
	public TaskResponse getTask(Long id) {
		// TODO Auto-generated method stub
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Task not found"));
		return TodoMapper.INSTANCE.toTaskResponse(task);
	}

	@Override
	public List<TaskResponse> getTasks() {
		// TODO Auto-generated method stub
		List<Task> tasks = taskRepository.findAll();
		return TodoMapper.INSTANCE.toTasks(tasks);
	}

	@Override
	public void updateTask(TaskResponse task) {
		// TODO Auto-generated method stub
		log.info("Updating task...");
		Long id = task.id();
		Task taskU = taskRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Task not found"));
		Task updatedTask = TodoMapper.INSTANCE.toTaskResponse(task);
		updatedTask.setUpdatedAt(LocalDateTime.now());
		taskRepository.save(updatedTask);

		log.info("Task updated successfully");
	}

	@Override
	public void deleteTask(Long id) {
		log.info("Deleting task...");
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Task not found"));
		task.setDeleted(true);
		taskRepository.save(task);
		log.info("Task deleted successfully");
	}

}
