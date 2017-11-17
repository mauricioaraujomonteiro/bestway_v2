/**
 * 
 */
package br.com.mmonteiro.bestway.usermanagement.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.mmonteiro.bestway.usermanagement.config.ApplicationConfiguration;

/**
 * @author mmont
 *
 */
public class DomainObject
{
    @Transient
    protected transient MongoTemplate mongoTemplate;

    public DomainObject()
    {
        @SuppressWarnings("resource")
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        
    }

    /**
     * Save the object to the collection for the entity type of the object to save.
     * This will perform an insert if the object is not already present, that is an 'upsert'. 
     */
    public void save()
    {
        mongoTemplate.save(this);
    }

}
