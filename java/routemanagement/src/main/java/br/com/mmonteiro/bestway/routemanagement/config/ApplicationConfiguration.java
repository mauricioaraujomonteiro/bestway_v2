/**
 * 
 */
package br.com.mmonteiro.bestway.routemanagement.config;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

/**
 * class we can register all the beans that are going to be used on the project.
* @author Mauricio Monteiro
*
*/
@Configuration
@PropertySource(value =
{ "classpath:application.properties" })
public class ApplicationConfiguration
{
   @Value("${spring.data.mongodb.host}")
   private String databaseHost;
   @Value("${spring.data.mongodb.database}")
   private String databaseName;
   @Value("${mongo.max_connection_idle_time}")
   private int connectionIdleTime;
   @Value("${mongo.connection_pool_size}")
   private int connectionPerHost;
   private static MongoClient mongoConnection;

   /**
    * Mongo db connection bean, it is used to connect to the mongo db database.
    * @return {@link org.springframework.data.mongodb.core.MongoTemplate}
    * @throws Exception
    */
   @Bean
   public MongoTemplate mongoTemplate() throws Exception
   {
       Logger.getGlobal().info("Creating database Connection: mongoTemplate()");
       MongoClientOptions mongoOptions = new MongoClientOptions.Builder().maxWaitTime(1000 * 60 * 5)
               .maxConnectionIdleTime(connectionIdleTime).connectionsPerHost(connectionPerHost).build();
       getMongoConnection(mongoOptions);
       MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoConnection, databaseName);
       return new MongoTemplate(mongoDbFactory);
   }

   private void getMongoConnection(MongoClientOptions mongoOptions)
   {
       if (null == mongoConnection)
       {
           mongoConnection = new MongoClient(databaseHost, mongoOptions);
       }
   }

   
   @Bean
   public static PropertySourcesPlaceholderConfigurer propertyConfigInDev()
   {
       return new PropertySourcesPlaceholderConfigurer();
   }
}
