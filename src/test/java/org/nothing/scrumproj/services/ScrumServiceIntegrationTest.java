package org.nothing.scrumproj.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nothing.scrumproj.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestMongoConfig.class })
public class ScrumServiceIntegrationTest{

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
	public void shouldAbleToSaveProductInMongodb() {
		String name = "testName";
		String description = "desc";
		scrumService.registerProduct(name, description);
		List<Product> products = scrumServiceRead.getAllProducts();
		System.out.println(products.size());
		assertTrue(products.size() == 1);
		assertEquals("testName", products.get(0).getName());
		assertEquals("desc", products.get(0).getDescription());
	}

	@Test(expected = DuplicateKeyException.class)
	public void shouldNotBeAbleToSaveTwoProductsWithSameNameInMongodb() {
		String name = "testName2";
		String description = "desc2";
		scrumService.registerProduct(name, description);
		description = "desc3";
		scrumService.registerProduct(name, description);		
	}

}
