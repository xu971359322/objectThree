package org.java.entity;

import java.io.Serializable;
import java.util.Date;

public class OaDocument implements Serializable {
    private Integer doId;

    private String doTitle;

    private Date doTime;

    private String doLever;

    private Integer doType;

    private String woId;

    public Integer getDoId() {
        return doId;
    }

    public void setDoId(Integer doId) {
        this.doId = doId;
    }

    public String getDoTitle() {
        return doTitle;
    }

    public void setDoTitle(String doTitle) {
        this.doTitle = doTitle == null ? null : doTitle.trim();
    }

    public Date getDoTime() {
        return doTime;
    }

    public void setDoTime(Date doTime) {
        this.doTime = doTime;
    }

    public String getDoLever() {
        return doLever;
    }

    public void setDoLever(String doLever) {
        this.doLever = doLever == null ? null : doLever.trim();
    }

    public Integer getDoType() {
        return doType;
    }

    public void setDoType(Integer doType) {
        this.doType = doType;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }
}