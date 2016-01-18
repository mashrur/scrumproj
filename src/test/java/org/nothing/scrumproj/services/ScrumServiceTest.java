package org.nothing.scrumproj.services;

import javax.validation.ValidationException;

import org.junit.Test;

public class ScrumServiceTest {

	@Test(expected = ValidationException.class)
	public void productShouldNotRegisterWithoutName() {
		ScrumService ss = new ScrumServiceImpl();
		String name = null;
		String description = "description";
		ss.registerProduct(name, description);
	}
	
	public void shouldAbleToSaveDataInMongodb(){
		
	}
	
}
