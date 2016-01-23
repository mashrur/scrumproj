package org.nothing.scrumproj.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@ComponentScan("org.nothing")
@EnableMongoRepositories
public class IntegrationTestApplicationConfig extends
		AbstractMongoConfiguration {

	
	/*
	 * @Autowired private Environment env;
	 * 
	 * @Override protected String getDatabaseName() { return
	 * env.getRequiredProperty("mongo.db.name"); }
	 * 
	 * @Override public Mongo mongo() throws Exception { return new
	 * EmbeddedMongoBuilder().version("2.6.1").bindIp("127.0.0.1")
	 * .port(12345).build(); }
	 */

	/*@Autowired
	private Environment env;

	@Override
	protected String getDatabaseName() {
		return env.getRequiredProperty("mongo.db.name");
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Fongo(getDatabaseName()).getMongo();
	}*/
	/*@Override
    protected String getDatabaseName() {
        return "demo-test";
    }*/

    /*@Override
    public Mongo mongo() {
        // uses fongo for in-memory tests
        return new Fongo("mongo-test").getMongo();
    }*/
    /*@Override
    public Mongo mongo() throws Exception {
        return new EmbeddedMongoBuilder()
            .version("2.6.1")
            .bindIp("127.0.0.1")
            .port(12344)//27017)
            .build();
    }
    @Override
    protected String getMappingBasePackage() {
        return "org.nothing.scrumproj.models";
    }*/
	
	 	@Override
	    public Mongo mongo() throws Exception {
	        return new Mongo();
	    }

	@Override
	protected String getDatabaseName() {
		return "demo-test";
	}
}
