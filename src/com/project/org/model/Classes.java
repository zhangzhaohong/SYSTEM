package com.project.org.model;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

    // Fields

    private String cno;
    private String cname;
    private Short openSmt;
    private Integer chours;
    private Integer credit;

    // Constructors

    /**
     * default constructor
     */
    public Classes() {
    }

    /**
     * full constructor
     */
    public Classes(String cname, Short openSmt, Integer chours, Integer credit) {
        this.cname = cname;
        this.openSmt = openSmt;
        this.chours = chours;
        this.credit = credit;
    }

    // Property accessors

    public String getCno() {
        return this.cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Short getOpenSmt() {
        return this.openSmt;
    }

    public void setOpenSmt(Short openSmt) {
        this.openSmt = openSmt;
    }

    public Integer getChours() {
        return this.chours;
    }

    public void setChours(Integer chours) {
        this.chours = chours;
    }

    public Integer getCredit() {
        return this.credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

}