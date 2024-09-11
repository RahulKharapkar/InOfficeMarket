package com.rk.iom.service; 
import java.util.List;
import java.util.Optional;

import com.rk.iom.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rk.iom.exception.InvalidUserException;
import com.rk.iom.model.User;
import com.rk.iom.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service 
public class UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private SecurityConfig securityConfig;

	
	public User fetchUserByIdAndPassword(int userId, String password)
	{
		return userRepo.findByUserIdAndPassword(userId, securityConfig.passwordEncoder().encode(password)); //securityConfig.passwordEncoder().encode(password);
	}

	
	public User getByUserId(int userId) throws InvalidUserException {
	    Optional<User> user = userRepo.findById(userId);
	    if (!user.isPresent()) {
	        throw new InvalidUserException("No user available with the ID: " + userId);
	    } else {
	        return user.get();
	    }
	}

	
	@Transactional
	public User addUser(User user) {
		user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
		return userRepo.save(user);	
	}

	@Transactional
	public User editUser(User user) {

		return userRepo.save(user);

	}

	/**
	 * Deletes a user by their user ID and returns a list of all the remaining users.
	 *
	 * @param userId The ID of the user to be deleted.
	 * @return A list of all users except the one that was just deleted.
	 * @throws InvalidUserException If the user ID does not exist.
	 */
	@Transactional
	public List<User> removeUser(Integer userId) throws InvalidUserException {

		// Find the user and check if it exists
		Optional<User> user = userRepo.findById(userId);
		if (!user.isPresent()) {
			throw new InvalidUserException("No user available with the ID: " + userId);
		}

		// Delete the user
		userRepo.deleteById(userId);

		// Return a list of all users except the one that was just deleted
		return userRepo.findAll();

	}
  }
  
 