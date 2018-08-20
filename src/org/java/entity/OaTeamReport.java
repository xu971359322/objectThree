package org.java.entity;

import java.util.Date;

public class OaTeamReport {
    private String reId;

    private String reName;

    private Date reTime;

    private String reFile;

    private Integer reStatus;

    private String woId;

    private String reContent;

    public String getReId() {
        return reId;
    }

    public void setReId(String reId) {
        this.reId = reId == null ? null : reId.trim();
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName == null ? null : reName.trim();
    }

    public Date getReTime() {
        return reTime;
    }

    public void setReTime(Date reTime) {
        this.reTime = reTime;
    }

    public String getReFile() {
        return reFile;
    }

    public void setReFile(String reFile) {
        this.reFile = reFile == null ? null : reFile.trim();
    }

    public Integer getReStatus() {
        return reStatus;
    }

    public void setReStatus(Integer reStatus) {
        this.reStatus = reStatus;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent == null ? null : reContent.trim();
    }
}