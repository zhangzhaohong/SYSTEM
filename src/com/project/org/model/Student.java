package com.project.org.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

    // Fields

    private String sno;
    private Major major;
    private String sname;
    private Short sex;
    private String birthday;
    private Integer totalCredits;
    private String remarks;
    private byte[] photo;
    private Set signins = new HashSet(0);

    // Constructors

    /**
     * default constructor
     */
    public Student() {
    }

    /**
     * minimal constructor
     */
    public Student(Major major, String sname, Short sex) {
        this.major = major;
        this.sname = sname;
        this.sex = sex;
    }

    /**
     * full constructor
     */
    public Student(Major major, String sname, Short sex, String birthday, Integer totalCredits, String remarks,
                   byte[] photo, Set signins) {
        this.major = major;
        this.sname = sname;
        this.sex = sex;
        this.birthday = birthday;
        this.totalCredits = totalCredits;
        this.remarks = remarks;
        this.photo = photo;
        this.signins = signins;
    }

    // Property accessors

    public String getSno() {
        return this.sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Major getMajor() {
        return this.major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;

    }

    public Short getSex() {
        return this.sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getTotalCredits() {
        return this.totalCredits;
    }

    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Set getSignins() {
        return this.signins;
    }

    public void setSignins(Set signins) {
        this.signins = signins;
    }

}