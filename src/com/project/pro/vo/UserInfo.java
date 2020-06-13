package com.project.pro.vo;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

    // Fields

    private Integer id;
    private Test test;
    private String code;
    private String cnname;
    private String sex;
    private String birDate;
    private String spec;
    private String remarks;

    // Constructors

    /**
     * default constructor
     */
    public UserInfo() {
    }

    /**
     * minimal constructor
     */
    public UserInfo(Test test, String code, String cnname, String sex, String spec) {
        this.test = test;
        this.code = code;
        this.cnname = cnname;
        this.sex = sex;
        this.spec = spec;
    }

    /**
     * full constructor
     */
    public UserInfo(Test test, String code, String cnname, String sex, String birDate, String spec, String remarks) {
        this.test = test;
        this.code = code;
        this.cnname = cnname;
        this.sex = sex;
        this.birDate = birDate;
        this.spec = spec;
        this.remarks = remarks;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCnname() {
        return this.cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirDate() {
        return this.birDate;
    }

    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }

    public String getSpec() {
        return this.spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}