package com.rk.iom.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.iom.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	public User findByUserIdAndPassword(int userId, String password);
		
}
 