package com.springdockertuto.springdocker.controller;

import java.util.List;

import com.springdockertuto.springdocker.model.TaskModel;
import com.springdockertuto.springdocker.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService _taskService;

	@GetMapping("/getTasks")
	public List<TaskModel> getItems() {
		return this._taskService.getTaskList();
	}

	@GetMapping("/getTaskById/{_id}")
	public TaskModel getTaskById(@PathVariable String _id) {
		return this._taskService.findById(_id);
	}

	@GetMapping("/getTaskByName/{_name}")
	public List<TaskModel> getTaskByName(@PathVariable String _name) {
		return this._taskService.findByName(_name);
	}

	@PostMapping("/addTask")
	public TaskModel addTask(@RequestBody TaskModel model) {
		return this._taskService.addTask(model);
	}

	@DeleteMapping("/removeTask/{_id}")
	public void removeTask(@PathVariable String _id) {
		this._taskService.removeTask(_id);
	}

	@PutMapping("/updateTask/{_id}")
	public TaskModel updateTask(@PathVariable String _id, @RequestBody TaskModel model) {
		return this._taskService.updateTask(_id, model);
	}
}