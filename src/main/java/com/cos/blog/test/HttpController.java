package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자 요청 -> 응답(HTML)
//@controller
//사용자 요청 ->응답(Data)
@RestController
public class HttpController {
	private static final String TAG ="HTTPControllerTest :";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m =Member.builder().username("ssar").password("1234").email("ssar@naver.com").build();//객체를의 key값을 보여줘서 순서를 고려안하고 코드 작성가능
		System.out.println(TAG+"getter:"+m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"setter:"+m.getUsername());
		return "lombok test 완료";
	}
	//select
	@GetMapping("/http/get")
	public String getTest(Member m) {//id=1&username-ssar&password=1234&email=ssar@nate.com //MessageConverter(스프링부트)
		
		return "get 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	//insert
	@PostMapping("/http/post")//text/plain, application/json
	public String postTest(@RequestBody Member m) {//MessageConverter(스프링부트)
		return "post 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	//update
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	//delete
	@DeleteMapping("/http/put")
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청";
	}

}
