/**
 * 
 */
package br.com.mmonteiro.bestway.test.utils;

import java.security.SecureRandom;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.mmonteiro.bestway.usermanagement.core.route.Coordinate;
import br.com.mmonteiro.bestway.usermanagement.core.route.Route;
import br.com.mmonteiro.bestway.usermanagementcore.user.entity.User;

/**
 * @author mmont
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BaseTest
{

    @Resource
    protected WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;

    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    
    /**
     * @return
     */
    protected int getDelta()
    {
        SecureRandom delta = new SecureRandom();
        delta.setSeed(new Date().getTime());
        return delta.nextInt();
    }

    protected User getCommonUser()
    {
        User user = new User();
        int delta = getDelta();
        user.setEmail(delta+"email@email.com");
        user.setNome(delta+"MyName");
        user.setPassword(delta+"myPassword");
        return user;
    }
    
    protected Route getCommonRoute()
    {
        Route route = new Route();
        route.setActived(true);
        route.setFromDestination(new Coordinate("1111.1", "-2332.4324"));
        route.setToDestination(new Coordinate("34242.1", "-555.4324"));
        return route;
    }
}
