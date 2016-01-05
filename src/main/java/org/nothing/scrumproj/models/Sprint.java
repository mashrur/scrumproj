package org.nothing.scrumproj.models;

import java.util.Date;

public class Sprint {
	private long id;
	private String name;
	private long productReference;
	private Date start;
	private Date end;

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

	public long getProductReference() {
		return productReference;
	}

	public void setProductReference(long productReference) {
		this.productReference = productReference;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
