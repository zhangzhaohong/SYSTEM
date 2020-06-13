package com.project.org.model;

/**
 * SuccessId entity. @author MyEclipse Persistence Tools
 */

public class SuccessId implements java.io.Serializable {

    // Fields

    private String sno;
    private String cno;

    // Constructors

    /**
     * default constructor
     */
    public SuccessId() {
    }

    /**
     * full constructor
     */
    public SuccessId(String sno, String cno) {
        this.sno = sno;
        this.cno = cno;
    }

    // Property accessors

    public String getSno() {
        return this.sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return this.cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof SuccessId))
            return false;
        SuccessId castOther = (SuccessId) other;

        return ((this.getSno() == castOther.getSno())
                || (this.getSno() != null && castOther.getSno() != null && this.getSno().equals(castOther.getSno())))
                && ((this.getCno() == castOther.getCno()) || (this.getCno() != null && castOther.getCno() != null
                && this.getCno().equals(castOther.getCno())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getSno() == null ? 0 : this.getSno().hashCode());
        result = 37 * result + (getCno() == null ? 0 : this.getCno().hashCode());
        return result;
    }

}