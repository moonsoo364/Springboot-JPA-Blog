package com.cos.blog.controller.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		
		
		userService.register(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){// key=value, x -www-form-unlencoded
		userService.UpdateUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}

}
