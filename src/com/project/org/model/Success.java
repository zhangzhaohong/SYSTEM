package com.project.org.model;

/**
 * Success entity. @author MyEclipse Persistence Tools
 */

public class Success implements java.io.Serializable {

    // Fields

    private SuccessId id;
    private Integer success;
    private Integer credit;

    // Constructors

    /**
     * default constructor
     */
    public Success() {
    }

    /**
     * minimal constructor
     */
    public Success(SuccessId id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public Success(SuccessId id, Integer success, Integer credit) {
        this.id = id;
        this.success = success;
        this.credit = credit;
    }

    // Property accessors

    public SuccessId getId() {
        return this.id;
    }

    public void setId(SuccessId id) {
        this.id = id;
    }

    public Integer getSuccess() {
        return this.success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getCredit() {
        return this.credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

}