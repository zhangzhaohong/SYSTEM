package com.project.pro.vo;

import java.util.Date;

/**
 * Lytable entity. @author MyEclipse Persistence Tools
 */

public class LyTable implements java.io.Serializable {

	// Fields

	private Integer id;
	private Test test;
	private Date lydate;
	private String title;
	private String lyContent;
	private String username;

	// Constructors

	/** default constructor */
	public LyTable() {
	}

	/** full constructor */
	public LyTable(Test test, Date lydate, String title, String lyContent) {
		this.test = test;
		this.lydate = lydate;
		this.title = title;
		this.lyContent = lyContent;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Date getLydate() {
		return this.lydate;
	}

	public void setLydate(Date lydate) {
		this.lydate = lydate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLyContent() {
		return this.lyContent;
	}

	public void setLyContent(String lyContent) {
		this.lyContent = lyContent;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}