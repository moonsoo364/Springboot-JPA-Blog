package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//ORM -> Java(다른언어) Object-> 다른 테이블로 매칭해주는 기술

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert //인서트시 null인 컬럼 제외시켜준다.
@Entity//user클래스가 MariaDB에 테이블 생성
public class User {
	
	@Id//Primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다. 오라클->시퀀스 Mysql->오토인크리먼트
	private int id;//시퀀스, auto_increment
	
	@Column(nullable =false,length=30, unique=true)
	private String username;//ID
	
	@Column(nullable =false,length=100)//123456 -->해쉬로 변경 암호화
	private String password;
	
	@Column(nullable =false,length=50)
	private String email;
	
	//DB는 RoleType이 없다
	//@ColumnDefault("user")
	@Enumerated(EnumType.STRING)
	private RoleType role;//Enum을 쓰는게 좋다.//도메인 설정으로 범위 설정ADMIN,USERmanager(managrrr오타)
	
	@CreationTimestamp//시간이 자동입력
	private Timestamp createDate;

}
