package com.rk.iom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.iom.exception.InvalidUserException;
import com.rk.iom.model.User;
import com.rk.iom.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws InvalidUserException{
		int tempUserId = user.getUserId();
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempUserId != 0 && tempPassword != null){
			userObj = userService.fetchUserByIdAndPassword(tempUserId, tempPassword);
		}
		if(userObj == null){
			throw new InvalidUserException("Wrong userId and Password");
		}
		return new ResponseEntity<User>(userObj,HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws InvalidUserException{
		User existingUser = userService.getByUserId(user.getUserId());
		if(existingUser != null) {
			return new ResponseEntity("User with that ID already Exists", HttpStatus.BAD_REQUEST);
		}
		User u = userService.addUser(user);
		if(u == null) {
			return new ResponseEntity("Sorry! User are not available!", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<User>(u,HttpStatus.OK);
		}
	}
	
	@GetMapping("/byId/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) throws InvalidUserException{
		User u = userService.getByUserId(userId);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@PutMapping("/user/editUser")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User u = userService.editUser(user);
		if(u == null) {
			return new ResponseEntity("oops! User cannot be edited ", HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<User>(u,HttpStatus.OK);
		}
		
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<List<User>> deleteUser(@PathVariable("userId") Integer userId) {
		
		List<User> users = userService.removeUser(userId);
		if(users.isEmpty() || users == null) {
			return new ResponseEntity("Sorry! UserId not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}


