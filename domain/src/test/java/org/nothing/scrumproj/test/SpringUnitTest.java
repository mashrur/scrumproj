package org.nothing.scrumproj.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.nothing.scrumproj.services.IntegrationTestApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles({ "test", "unit" })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestApplicationConfig.class })
public abstract class SpringUnitTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	protected void importJSON(String collection, String file) {
		try {
			for (Object line : FileUtils.readLines(new File(file), "utf8")) {
				mongoTemplate.save(line, collection);
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not import file: " + file, e);
		}
	}
}
