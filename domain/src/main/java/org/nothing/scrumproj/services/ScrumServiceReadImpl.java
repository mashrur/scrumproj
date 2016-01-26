package org.nothing.scrumproj.services;

import java.util.List;

import org.nothing.scrumproj.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScrumServiceReadImpl implements ScrumServiceRead{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = mongoTemplate.findAll(Product.class);
		return products;
	}

}
