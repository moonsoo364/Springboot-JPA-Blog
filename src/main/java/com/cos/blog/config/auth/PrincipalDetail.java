package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Getter;
//스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
//스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
@Getter
public class PrincipalDetail implements UserDetails{
	private User user;//콤포지션

	public PrincipalDetail(User user) {
		this.user =user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	//계정이 만료되지 않았는 지 리턴한다.(true 만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	//계정이 잠겨있는 지 리턴한다. (true: 잠기지않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	//비밀번호가 만료 됬는지 리턴한다. true:만료 안됨
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	//계정활성화인지 리턴한다. true:활성화
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	//계정 권한 목록 리턴한다. (권한이 여러개 있을 수 있어서 루프를 돌아야하는데 우리는 하나만) 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		
		collectors.add(()->{return "ROLE_"+user.getRole();});
		
		return collectors;
	}
 
}
