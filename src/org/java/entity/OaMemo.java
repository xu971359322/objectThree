package org.java.entity;

import java.util.Date;

public class OaMemo {
    private Integer meId;

    private String meTitle;

    private String meContent;

    private Date meTime;

    private String woId;

    public Integer getMeId() {
        return meId;
    }

    public void setMeId(Integer meId) {
        this.meId = meId;
    }

    public String getMeTitle() {
        return meTitle;
    }

    public void setMeTitle(String meTitle) {
        this.meTitle = meTitle == null ? null : meTitle.trim();
    }

    public String getMeContent() {
        return meContent;
    }

    public void setMeContent(String meContent) {
        this.meContent = meContent == null ? null : meContent.trim();
    }

    public Date getMeTime() {
        return meTime;
    }

    public void setMeTime(Date meTime) {
        this.meTime = meTime;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }
}