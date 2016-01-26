package org.nothing.scrumproj.models;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private BigInteger id;
	@Indexed(unique = true)
	private String name;
	private String description;

	

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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

	private Product() {
	}

	public static Product createProduct(String name, String description) {
		Product prod = new Product();
		prod.setId(null);
		prod.setName(name);
		prod.setDescription(description);
		return prod;
	}

}
