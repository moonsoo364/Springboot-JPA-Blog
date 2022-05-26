package com.cos.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록해줌. IOC를 해준다.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public int register(User user) {
		user.setRole(RoleType.USER);
		
		String rawPassword =user.getPassword();//1234원문
		String encPassword=encoder.encode(rawPassword);//해시
		user.setPassword(encPassword);
		
		try {
			userRepository.save(user);
			return 1;
		} catch(Exception e) {
			return -1;
		}
		
	}

	

}
