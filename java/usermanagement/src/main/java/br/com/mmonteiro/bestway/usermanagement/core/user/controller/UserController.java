/**
 * 
 */
package br.com.mmonteiro.bestway.usermanagement.core.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import br.com.mmonteiro.bestway.usermanagementcore.user.entity.User;

/**
 * @author mmont
 *
 */
@RestController
@RequestMapping(value = "user")
@CrossOrigin
public class UserController
{

    /**
     * Creates an user for a given json. 
     * @param pUser
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody String pUser)
    {
        User user = new Gson().fromJson(pUser, User.class);
        user.save();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Creates an user for a given json. 
     * @param pUser
     * @return
     */
    @RequestMapping(value="/route", method = RequestMethod.POST)
    public ResponseEntity<?> addUserRoute(@RequestBody String pUser)
    {
        User user = new Gson().fromJson(pUser, User.class);
        user.save();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
