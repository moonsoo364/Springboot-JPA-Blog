package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


//변수는 private선언해서 메서드를 통해 변수가 바뀌게 함


@Data//setter,getter생성
@NoArgsConstructor//빈생성자

public class Member {
	//불변성 유지 final
	private int id;
	private String username;
	private String password;
	private String email;
	@Builder//
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	

}
