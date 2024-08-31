package com.rk.iom.service; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.iom.exception.InvalidUserException;
import com.rk.iom.model.User;
import com.rk.iom.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service 
public class UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	public User fetchUserByIdAndPassword(int userId, String password)
	{
		return userRepo.findByUserIdAndPassword(userId, password);
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
		
		return userRepo.save(user);	
	}

	
	@Transactional
	public User editUser(User user) {
		
		return userRepo.save(user);

	}

	
	@Transactional
	public List<User> removeUser(Integer userId) {
		
		userRepo.deleteById(userId);
		return userRepo.findAll();
		
	}
 
  }
  
 