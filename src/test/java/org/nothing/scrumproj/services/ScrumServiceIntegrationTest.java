package org.nothing.scrumproj.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nothing.scrumproj.models.Product;
import org.nothing.scrumproj.test.SpringUnitTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.Mongo;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

public class ScrumServiceIntegrationTest extends SpringUnitTest {

	
	MongodExecutable mongodExecutable = null;

	@Before
	public void beforeEach() throws Exception {
		MongodStarter starter = MongodStarter.getDefaultInstance();

		int port = 12345;
		IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
				.net(new Net(port, Network.localhostIsIPv6())).build();

		

		mongodExecutable = starter.prepare(mongodConfig);
		MongodProcess mongod = mongodExecutable.start();
	}

	@After
	public void afterEach() throws Exception {
		if (mongodExecutable != null)
            mongodExecutable.stop();
	}

	@Autowired
	private ScrumService scrumService;

	@Autowired
	private ScrumServiceRead scrumServiceRead;

	@Test
	public void shouldAbleToSaveDataInMongodb() {
		String name = "testName";
		String description = "desc";
		scrumService.registerProduct(name, description);
		scrumService.registerProduct(name + name, description);
		List<Product> products = scrumServiceRead.getAllProducts();
		System.out.println(products.size());
		assertTrue(products.size() == 1);
		assertEquals("testName", products.get(0).getName());
		assertEquals("desc", products.get(0).getDescription());
	}

}
