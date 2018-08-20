package org.java.entity;

import java.io.Serializable;
import java.util.Date;

public class OaTeamSemail implements Serializable{
    private Integer seId;

    private String emId;

    private String woId;

    private Date seTime;

    private Integer seStatus;

    public Integer getSeId() {
        return seId;
    }

    public void setSeId(Integer seId) {
        this.seId = seId;
    }

    public String getEmId() {
        return emId;
    }

    public void setEmId(String emId) {
        this.emId = emId == null ? null : emId.trim();
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }

    public Date getSeTime() {
        return seTime;
    }

    public void setSeTime(Date seTime) {
        this.seTime = seTime;
    }

    public Integer getSeStatus() {
        return seStatus;
    }

    public void setSeStatus(Integer seStatus) {
        this.seStatus = seStatus;
    }
}