package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;

//DataAccessObject
//자동으로 bean등록된다.
public interface UserRepository extends JpaRepository<User, Integer>{
	//SELECT * FROM user WHERE username=?;
	Optional<User> findByUsername(String username);

	

}


//JPA Naming전략
//SELECT * FROM user WHERE username=? AND password=?;
/* User findByUsernameAndPassword(String username, String password); */

//@Query(value="SELECT * FROM user WHERE username=? AND password=?",nativeQuery = true)
//User login(String username, String password);
