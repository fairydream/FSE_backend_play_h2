package controllers;

import java.util.Iterator;
import java.util.List;

import play.mvc.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;

import models.User;
import models.UserRepository;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * The main set of web services.
 */
@Named
@Singleton
public class UserController extends Controller {

	private final UserRepository userRepository;

	// We are using constructor injection to receive a repository to support our
	// desire for immutability.
	@Inject
	public UserController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Result test() {
		return ok("helloworld");
	}
	
	
	public Result addUser() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			System.out.println("User not created, expecting Json data");
			return badRequest("User not created, expecting Json data");
		}

		// Parse JSON file
		String userName = json.findPath("userName").asText();
		String password = json.findPath("password").asText();

		try {
			User user = new User(userName, password);
			userRepository.save(user);
			System.out.println("User saved: " + user.getId());
			Gson gson = new Gson();
			String jsonstring = gson.toJson(user);
			return created(jsonstring);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			System.out.println("User not saved: " + userName + " " + password);
			return badRequest("User not saved: " + userName + " " + password);
		}
	}
	
	public Result getAllUsers() {
		Iterable<User> users = userRepository.findAll();
		
		String result = new Gson().toJson(users);
		System.out.println(result);
		return ok(result);
		
	}
	
}
