package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {
	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHeom() {
		System.out.println("temp()");
		//여기서 vue.js파일 읽어오는 것 찾아보기
		//기본경로: /src/main/resouces/static
		//리턴명: /home.html
		//풀경로: /src/main/resouces/static/home.html
		return "/home.html";
	}
	@GetMapping("/temp/new")
	public String tempJsp() {
		//prefix: /WEB-INF/views/
		//suffix: .jsp
		// 풀경로: /Web-INF/views/test.jsp
		return "/new";// /new까지는 sping이 인식해줌 .jsp는 안됨
	}

}
