package org.nothing.scrumproj.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.nothing.scrumproj.models.Product;
import org.nothing.scrumproj.test.SpringUnitTest;
import org.springframework.beans.factory.annotation.Autowired;

public class ScrumServiceIntegrationTest extends SpringUnitTest{

	@Autowired
	private ScrumService scrumService;
	
	@Autowired
	private ScrumServiceRead scrumServiceRead;

	@Test
	public void shouldAbleToSaveDataInMongodb() {
		String name = "testName";
		String description = "desc";
		scrumService.registerProduct(name, description);

		List<Product> products = scrumServiceRead.getAllProducts();
		assertTrue(products.size() == 1);
		assertEquals("testName", products.get(0).getName());
		assertEquals("desc", products.get(0).getDescription());
	}

}
