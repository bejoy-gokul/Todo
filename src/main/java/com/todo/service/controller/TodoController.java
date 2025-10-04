package com.todo.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.service.dto.request.TaskRequest;
import com.todo.service.dto.response.TaskResponse;
import com.todo.service.service.TodoService;



@RestController
@RequestMapping("api/v1/todo")
public class TodoController {

	private final TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		// TODO Auto-generated constructor stub
		this.todoService = todoService;
	}
	
	@PostMapping
	public ResponseEntity<String> createTask(@RequestBody TaskRequest entity) {
		//TODO: process POST request
		
		todoService.createTask(entity);
		return new ResponseEntity<String>("Task Created Successfully", HttpStatus.OK);
	}
	
	@GetMapping("find")
	public ResponseEntity<TaskResponse> findTask(@RequestParam Long id) {
		
		return ResponseEntity.ok(todoService.getTask(id));
	}
	
	@GetMapping("all")
	public ResponseEntity<List<TaskResponse>> findAllTask() {
		
		return ResponseEntity.ok(todoService.getTasks());
	
	}
	
	@PutMapping
	public ResponseEntity<String> updateTask(@RequestBody TaskResponse task) {
		//TODO: process PUT request
		
		todoService.updateTask(task);
		return new ResponseEntity<String>("Task updated successfully", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteTask(@RequestParam Long id) {
		
		todoService.deleteTask(id);
		return new ResponseEntity<String>("Task deleted successfully", HttpStatus.OK);
	}
}
