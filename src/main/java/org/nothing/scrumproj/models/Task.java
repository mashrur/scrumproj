package org.nothing.scrumproj.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
	@Id
	private long id;
	private String name;
	private String description;
	private long points;
	private long memberReference;
	private List<TaskUpdate> taskUpdates;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public long getMemberReference() {
		return memberReference;
	}

	public void setMemberReference(long memberReference) {
		this.memberReference = memberReference;
	}

	public List<TaskUpdate> getTaskUpdates() {
		return taskUpdates;
	}

	public void setTaskUpdates(List<TaskUpdate> taskUpdates) {
		this.taskUpdates = taskUpdates;
	}

}
