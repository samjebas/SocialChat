package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
@SequenceGenerator(name = "blogcommentidseq", sequenceName="blogComment_id_seq", allocationSize = 1)
public class BlogComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blogcommentidseq")
	private int commentId;
	private int blogId;
	private String commentText;
	private String loginname;
	private Date commentDate;

	public int getCommentid() {
		return commentId;
	}

	public void setCommentid(int commentId) {
		this.commentId = commentId;
	}

	public int getBlogid() {
		return blogId;
	}

	public void setBlogid(int blogId) {
		this.blogId = blogId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

}
