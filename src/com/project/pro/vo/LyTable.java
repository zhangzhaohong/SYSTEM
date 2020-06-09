package com.project.pro.vo;

import java.sql.Date;

public class LyTable {

    private int id;
    private int userid;
    private Date lydate;
    private String title;
    private String lyContent;

    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getLydate() {
        return lydate;
    }

    public void setLydate(Date lydate) {
        this.lydate = lydate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyContent() {
        return lyContent;
    }

    public void setLyContent(String lyContent) {
        this.lyContent = lyContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
