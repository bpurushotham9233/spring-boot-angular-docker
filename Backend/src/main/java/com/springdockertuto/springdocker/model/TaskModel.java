package com.springdockertuto.springdocker.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class TaskModel {
	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String image;
	
	public TaskModel() {
	}
	
	public TaskModel(String _desc, String _image) {
		this.description = _desc;
		this.image = _image;
	}
	
	public String getId() {
		return id;
	}
		
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setDescription(String _desc) {
		this.description = _desc;
	}
	
	public void setImage(String _img) {
		this.image = _img;
	}

	public void setName(String _name) {
		this.name = _name;
	}
}