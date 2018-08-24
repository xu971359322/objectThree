package org.java.entity;

import java.util.Date;

public class OaTeamReport {
    private String reId;

    private String reTitle;

    private Date reTime;

    private String reFile;

    private Integer reStatus;

    private String woId;

    private Double reMoney;

    private String reContent;

    public String getReId() {
        return reId;
    }

    public void setReId(String reId) {
        this.reId = reId == null ? null : reId.trim();
    }

    public String getReTitle() {
        return reTitle;
    }

    public void setReTitle(String reTitle) {
        this.reTitle = reTitle == null ? null : reTitle.trim();
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

    public Double getReMoney() {
        return reMoney;
    }

    public void setReMoney(Double reMoney) {
        this.reMoney = reMoney;
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent == null ? null : reContent.trim();
    }
}