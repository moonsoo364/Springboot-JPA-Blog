package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.print.attribute.standard.RequestingUserName;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//데이터 받환
@RestController
public class DummyController {
	
	@Autowired//의존성주입
	private UserRepository userRepository;
	//save함수는 id를 전달하지 않으면 insert를 해주고
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해요.
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return "삭제에 실패하였습니다. 해당ID는 DB에 없습니다.";
		}
		
		
		
		return "삭제되었습니다.id:"+id;
	}
	
	@Transactional//함수 종료시에 자동 commit이 됨
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requesUser) {//json데이터요청 => Java Object(MessageConverter의 Jackson라이브러리가)로 변환해서 받았다
		System.out.println("id: "+id);
		System.out.println("password: "+requesUser.getPassword());
		System.out.println("email: "+requesUser.getEmail());
		
		User user=userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requesUser.getPassword());
		user.setEmail(requesUser.getEmail());
		
		//userRepository.save(user);
		//더티 체킹 
		
		return user;
		
		
	}
	
	@GetMapping("/dummy/users")
	public List<User> list(){
		
		return userRepository.findAll();
	}
	//한페이지당 2건에 데이터를 리턴받아 볼 예정
	@GetMapping("/dummy/user")
	public Page<User> pageList(@PageableDefault(size=2,sort="id",direction=Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser=userRepository.findAll(pageable);
		
		
		List<User> users=pagingUser.getContent();
		return pagingUser;
	}
	//{id} 주소로 파라미터를 전달받을 수 있음
	//http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id){
		//user 4을 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될것아냐?
		//그럼 return null 이 리턴이 되자나 그럼 프로그램에 문제가 있지 않겠니?
		//Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해
		
		User user =userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id"+id);
			}
			
		});
		//user 객체 =자바 오브젝트 
		//요청 (웹브라우저가 이해할 수 있는 데이터)->json(Gson 라이브러리)
		//스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
		//만약 자바 오브젝트를 리턴하게 되면 
		return user;
		
	}
	
	//http://localhost:8000/blog/dummy/join
	//http의 body에 username, password,email 데이터를 가지고 (요청)
	@PostMapping("/dummy/join")
	public String join(User user) {//Spring이 key-value형태로 Json 파일로 전달한다. 
		
		
		
		System.out.println("id : "+user.getId());
		System.out.println("username :"+user.getUsername());
		System.out.println("password :"+user.getPassword());
		System.out.println("email :"+user.getEmail());
		System.out.println("role : "+user.getRole());
		System.out.println("CreateDate : "+user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";
		
	}
}
