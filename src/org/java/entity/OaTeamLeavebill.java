package org.java.entity;

import java.util.Date;

public class OaTeamLeavebill {
    private String lbId;

    private Integer lbDays;

    private String lbContent;

    private String lbRemark;

    private Date lbTime;

    private Integer lbStatus;

    private String woId;

    public String getLbId() {
        return lbId;
    }

    public void setLbId(String lbId) {
        this.lbId = lbId == null ? null : lbId.trim();
    }

    public Integer getLbDays() {
        return lbDays;
    }

    public void setLbDays(Integer lbDays) {
        this.lbDays = lbDays;
    }

    public String getLbContent() {
        return lbContent;
    }

    public void setLbContent(String lbContent) {
        this.lbContent = lbContent == null ? null : lbContent.trim();
    }

    public String getLbRemark() {
        return lbRemark;
    }

    public void setLbRemark(String lbRemark) {
        this.lbRemark = lbRemark == null ? null : lbRemark.trim();
    }

    public Date getLbTime() {
        return lbTime;
    }

    public void setLbTime(Date lbTime) {
        this.lbTime = lbTime;
    }

    public Integer getLbStatus() {
        return lbStatus;
    }

    public void setLbStatus(Integer lbStatus) {
        this.lbStatus = lbStatus;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }

    @Override
    public String toString() {
        return "OaTeamLeavebill{" +
                "lbId='" + lbId + '\'' +
                ", lbDays=" + lbDays +
                ", lbContent='" + lbContent + '\'' +
                ", lbRemark='" + lbRemark + '\'' +
                ", lbTime=" + lbTime +
                ", lbStatus=" + lbStatus +
                ", woId='" + woId + '\'' +
                '}';
    }
}