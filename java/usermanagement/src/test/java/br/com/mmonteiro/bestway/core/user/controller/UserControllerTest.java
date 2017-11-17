/**
 * 
 */
package br.com.mmonteiro.bestway.core.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

import br.com.mmonteiro.bestway.test.utils.BaseTest;
import br.com.mmonteiro.bestway.usermanagement.core.route.Coordinate;
import br.com.mmonteiro.bestway.usermanagement.core.route.Route;
import br.com.mmonteiro.bestway.usermanagementcore.user.entity.User;

/**
 * @author mmont
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserControllerTest extends BaseTest
{
    
    private User user;

    @Before
    public void setup()
    {
        this.user = super.getCommonUser();
    }

    

    @Test
    public void testAddNewUser() throws Exception
    {
        mockMvc.perform(post("/user").content(new Gson().toJson(user))).andExpect(status().isCreated());
    }
    
    @Test
    public void testAddRouteToBeMonitored() throws Exception
    {
        List<Route> routes = new ArrayList<>();
        routes.add(getCommonRoute());
        this.user.setRoutes(routes);
        mockMvc.perform(post("/user/route").content(new Gson().toJson(user))).andExpect(status().isCreated());
    }
}