package org.nothing.config;

import org.nothing.scrumproj.services.ScrumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
		ScrumService serv = context.getBean(ScrumService.class);
		serv.registerProduct("testProd", "description");
		serv.registerProduct("real Prod", "real description");

	}

}
