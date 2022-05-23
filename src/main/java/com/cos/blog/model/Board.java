package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private int id;
	
	@Column(nullable=false,length=100)
	private String title;
	
	@Lob//대용량 데이터
	private String content;//섬머노트 라이브러리 <html<태그가 섞여서 디자인됨
	
	@ColumnDefault("0")
	private String count;//
	
	@ManyToOne //Many=Board User=One 한명의 유저는 여러 게시글 작성가능
	@JoinColumn(name="userid")
	private User user;//DB는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트 저장할 수 있따.
	
	@CreationTimestamp
	private Timestamp createData;

}
