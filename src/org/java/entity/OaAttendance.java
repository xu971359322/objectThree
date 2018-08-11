package org.java.entity;

import java.util.Date;

public class OaAttendance {
    private Integer atId;

    private Date atBegintime;

    private String atContent;

    private Date atEndtime;

    private String woId;

    public Integer getAtId() {
        return atId;
    }

    public void setAtId(Integer atId) {
        this.atId = atId;
    }

    public Date getAtBegintime() {
        return atBegintime;
    }

    public void setAtBegintime(Date atBegintime) {
        this.atBegintime = atBegintime;
    }

    public String getAtContent() {
        return atContent;
    }

    public void setAtContent(String atContent) {
        this.atContent = atContent == null ? null : atContent.trim();
    }

    public Date getAtEndtime() {
        return atEndtime;
    }

    public void setAtEndtime(Date atEndtime) {
        this.atEndtime = atEndtime;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }
}