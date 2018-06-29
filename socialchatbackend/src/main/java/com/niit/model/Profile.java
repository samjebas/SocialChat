package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import oracle.sql.BLOB;

@Component
@Entity
@Table
public class Profile {

	private String loginname;
	private BLOB image;

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public BLOB getImage() {
		return image;
	}

	public void setImage(BLOB image) {
		this.image = image;
	}

}
