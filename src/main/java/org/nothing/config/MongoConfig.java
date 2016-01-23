package org.nothing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@ComponentScan("org.nothing")
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {
	@Override
	public Mongo mongo() throws Exception {
		return new Mongo();
	}

	@Override
	protected String getDatabaseName() {
		return "demo-test";
	}
}
