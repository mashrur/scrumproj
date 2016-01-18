package org.nothing.scrumproj.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BacklogItem {
	private long id;
	private String name;
	private String story;
	private String validationConditions;
	private int priority;
	private int points;
	private long productReference;
	private long sprintReference;
	private List<Task> tasks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getValidationConditions() {
		return validationConditions;
	}

	public void setValidationConditions(String validationConditions) {
		this.validationConditions = validationConditions;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public long getProductReference() {
		return productReference;
	}

	public void setProductReference(long productReference) {
		this.productReference = productReference;
	}

	public long getSprintReference() {
		return sprintReference;
	}

	public void setSprintReference(long sprintReference) {
		this.sprintReference = sprintReference;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
