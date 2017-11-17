package br.com.mmonteiro.bestway.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mmont
 *
 */
@SpringBootApplication
public class Application
{
    /**
     * This method is responsible to initialize the application server.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
