package com.project.org.model;

/**
 * Signin entity. @author MyEclipse Persistence Tools
 */

public class SignIn implements java.io.Serializable {

	// Fields

	private Integer id;
	private Student student;
	private String stupwd;

	// Constructors

	/** default constructor */
	public SignIn() {
	}

	/** minimal constructor */
	public SignIn(Student student) {
		this.student = student;
	}

	/** full constructor */
	public SignIn(Student student, String stupwd) {
		this.student = student;
		this.stupwd = stupwd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStupwd() {
		return this.stupwd;
	}

	public void setStupwd(String stupwd) {
		this.stupwd = stupwd;
	}

}