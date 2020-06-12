package com.project.pro.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */

public class Test implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String userpwd;
	private String usertype;
	private UserInfo userinfo;
	private Set lytables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** minimal constructor */
	public Test(String username, String userpwd, String usertype) {
		this.username = username;
		this.userpwd = userpwd;
		this.usertype = usertype;
	}

	/** full constructor */
	public Test(String username, String userpwd, String usertype, UserInfo userinfo, Set lytables) {
		this.username = username;
		this.userpwd = userpwd;
		this.usertype = usertype;
		this.userinfo = userinfo;
		this.lytables = lytables;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public UserInfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public Set getLytables() {
		return this.lytables;
	}

	public void setLytables(Set lytables) {
		this.lytables = lytables;
	}

}