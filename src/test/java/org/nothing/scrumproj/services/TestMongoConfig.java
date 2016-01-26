package org.nothing.scrumproj.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.WriteConcern;

import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.distribution.Version;

@ComponentScan("org.nothing.scrumproj")
@EnableMongoRepositories
@Configuration
public class TestMongoConfig {
    //@Autowired
    //private MongoProperties properties;

    @Autowired(required = false)
    private MongoClientOptions options;

    @Bean(destroyMethod = "close")
    public Mongo mongo(MongodProcess mongodProcess) throws IOException {
       // Net net = mongodProcess.getConfig().net();
        //properties.setHost(net.getServerAddress().getHostName());
        //properties.setPort(net.getPort());
        //return properties.createMongoClient(this.options);
    	Mongo mongo = new EmbeddedMongoBuilder()
 	            .version("2.6.1")
 	            .bindIp("127.0.0.1")
 	            .port(27017)
 	            .build();
 		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo;
    }

    @Bean(destroyMethod = "stop")
    public MongodProcess mongodProcess(MongodExecutable mongodExecutable) throws IOException {
        return mongodExecutable.start();
    }

    @Bean(destroyMethod = "stop")
    public MongodExecutable mongodExecutable(MongodStarter mongodStarter, IMongodConfig iMongodConfig) throws IOException {
        return mongodStarter.prepare(iMongodConfig);
    }

    @Bean
    public IMongodConfig mongodConfig() throws IOException {
        return new MongodConfigBuilder().version(Version.Main.PRODUCTION).build();
    }

    @Bean
    public MongodStarter mongodStarter() {
        return MongodStarter.getDefaultInstance();
    }

    @Bean(name="mongoClient")
    public MongoClient mongoClient() throws IOException {
        return new MongoClient("localhost", 27017);
    }

    @Autowired
    @Bean(name="mongoDbFactory")
    public MongoDbFactory mongoDbFactory(MongoClient mongoClient) {
        return new SimpleMongoDbFactory(mongoClient, getDatabaseName());
    }

    @Autowired
    @Bean(name="mongoTemplate")
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, getDatabaseName());
    }
    
    protected String getDatabaseName() {
		return "test-db";
	}

	/*@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/
}
