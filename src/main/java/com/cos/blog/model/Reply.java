package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;
	
	@Column(nullable=false,length=200)
	private String content;
	
	@ManyToOne//하나의 게시글에 여러 답글이 들어갈수 있다.
	@JoinColumn(name="boardid")
	private Board board;
	
	@ManyToOne//유저 한 명은 여러 답글을 달수있다.
	@JoinColumn(name="userid")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;

}
