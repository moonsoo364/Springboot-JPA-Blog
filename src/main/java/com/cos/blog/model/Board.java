package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@Column
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER) //Many=Board User=One 한명의 유저는 여러 게시글 작성가능
	@JoinColumn(name="userid")
	private User user;//DB는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트 저장할 수 있다.
	
	//mappedBy 연관관계의 주인이 아니다(FK가 아니에요) DB에 컬럼을 만들지 마세요
	@OneToMany(mappedBy = "board",fetch=FetchType.EAGER) //reply 클래스에 있는 필드명을 등록
	private List<Reply> reply;	//DB에서 데이터는 하나의 원자성을 갖는다, JoinColumn이 불필요함
	
	
	@CreationTimestamp
	private Timestamp createDate;

}
