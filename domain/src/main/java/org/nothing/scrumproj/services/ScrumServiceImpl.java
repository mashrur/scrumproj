package org.nothing.scrumproj.services;

import javax.validation.ValidationException;

import org.nothing.scrumproj.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScrumServiceImpl implements ScrumService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void registerProduct(String name, String description) {
		if (name == null)
			throw new ValidationException("Name must be provided");
		Product product = Product.createProduct(name, description);
		mongoTemplate.save(product);
	}

}
