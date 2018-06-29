package com.niit.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;




@Component
@Entity
@Table
public class Forum {
	
	
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	@Id
	private int forumId;
	private String forumName;
	private String forumContext;
	private Date createDate;
	private String loginname;
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumContext() {
		return forumContext;
	}
	public void setForumContext(String forumContext) {
		this.forumContext = forumContext;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

}
