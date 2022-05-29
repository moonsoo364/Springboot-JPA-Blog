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
	@Transactional
	public void UpdateUser(User user) {
		//수정시에는 영속성 컨텍스트 User 오브젝트를 영속화시키고 User오브젝트 수정
		//select해서 User오브젝트를 DB로 부터 가져오는 이유 영소고하르 ㄹ하기 위해서
		//영속화된 오브젝트를 변경하면 자동으로 DB에 update문 날려줌
		User persistance=userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원 찾기 실패");
		});
		String rawPassword=user.getPassword();
		String encPassword=encoder.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
		//회원 수정 함수 종료시 =서비스 종료 =트랜잭션 종료=commit자동으로 되요
		//영속화된 persistance 객체의 변화가 감지되면 더티체킹이 되어 update문을 날려줌
		
				
	}

	

}
