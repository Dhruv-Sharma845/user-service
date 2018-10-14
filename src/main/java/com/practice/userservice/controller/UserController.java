package com.practice.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.userservice.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

	/**
	 * This method is GET method which returns all the users in the database
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllUsers() {

		// creating some hardcoded data
		// in real applications this data should be fetched from database

		User user = new User();
		user.setId(1);
		user.setFirstName("Pooja");
		user.setLastName("Satija");

		List<User> usersList = new ArrayList<>();
		usersList.add(user);

		return usersList;
	}

	/**
	 * This method is also example of GET request but it is also receiving id as
	 * "path variable" This method should be called from browser as
	 * 
	 * http://localhost:8811/api/users/1 
	 * 
	 * where 1 can be replaced with any id you
	 * want
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Integer id) {

		// creating some hardcoded data
		// in real application you have to find the user from DB corresponding to "id"
		// you are receiving as parameter
		User user = new User();
		user.setId(1);
		user.setFirstName("Pooja");
		user.setLastName("Satija");

		return user;
	}

	/**
	 * This method is same as above request but
	 * this method should be called from browser in different way
	 * 
	 * http://localhost:8811/api/users?id=1
	 * 
	 * Here id is received as query parameter
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public User getUserByIdAsQueryParam(@RequestParam("id") Integer id) {
		// creating some hardcoded data
		// in real application you have to find the user from DB corresponding to "id"
		// you are receiving as parameter
		User user = new User();
		user.setId(1);
		user.setFirstName("Pooja");
		user.setLastName("Satija");

		return user;
	}
	
	/**
	 * This method is example of POST request (POST is for creating new)
	 * It will receive the filled `User` object from the front end as parameter
	 * 
	 * Note: This api can not be called from browser
	 * (How can we send filled user object from browser?)
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Boolean saveUser(@RequestBody User user) {
		
		//code for saving the user in DB will go here
		return true;
	}
	
	/**
	 * This method is example of DELETE request
	 * It is receiving the id of user as path variable
	 * It can be called from browser just as the second api above.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable("id") Integer id) {
		
		//delete the user corresponding to the id received 
		return true;
	}
	
	/**
	 * This method is example of PUT request
	 * It receives id of user that is to be updated
	 * also the filled user object is received from front end
	 * This object contains the new values that replaces the fields of user in database
	 * 
	 * Note: as there is no way of knowing which of the fields needs to be updated,
	 * all the fields have to be updated
	 * @param id
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/{id}" , method=RequestMethod.PUT)
	public Boolean updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		
		//updates all the fields of user corresponding to the id received
		//The new fields are there in the user object which replaces the fields in database
		return true;
	}
}
