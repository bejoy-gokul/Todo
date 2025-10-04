package com.todo.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.todo.service.dto.request.TaskRequest;
import com.todo.service.dto.response.TaskResponse;
import com.todo.service.entity.Task;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TodoMapper {

	TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);
	
	Task toTask(TaskRequest task);
	
	Task toTask(TaskResponse task);
	
	TaskResponse toTaskResponse(Task task);
	
	Task toTaskResponse(TaskResponse task);
	
	List<TaskResponse> toTasks(List<Task> tasks);
}
