package com.springdockertuto.springdocker.service;

import java.util.List;
import java.util.Optional;

import com.springdockertuto.springdocker.dao.AppDBRepository;
import com.springdockertuto.springdocker.dao.TaskRepository;
import com.springdockertuto.springdocker.model.AppModel;
import com.springdockertuto.springdocker.model.TaskModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	private TaskRepository _taskRepo;

	public List<TaskModel> getTaskList() {
		return this._taskRepo.findAll();
	}

	public TaskModel findById(String _id) {
		return this._taskRepo.findById(_id).get();
	}

	public List<TaskModel> findByName(String _name) {
		return this._taskRepo.findByNameLike(_name);
	}
	
	public TaskModel addTask(TaskModel model) {
		return this._taskRepo.save(model);
	}

	public void removeTask(String _id) {
		this._taskRepo.deleteById(_id);
	}

	public TaskModel updateTask(String _id, TaskModel model) {
		TaskModel _existingTask = this._taskRepo.findById(_id).get();
		_existingTask.setDescription(model.getDescription());
		_existingTask.setImage(model.getImage());
		_existingTask.setName(model.getName());
		return this._taskRepo.save(_existingTask);
	}
}