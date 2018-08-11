package org.java.entity;

import java.util.Date;

public class OaTeamEmail {
    private String emId;

    private String emTheme;

    private String woFid;

    private String woSid;

    private Date emTime;

    private Integer emLevel;

    private Integer emStauts;

    private String emInfomation;

    public String getEmId() {
        return emId;
    }

    public void setEmId(String emId) {
        this.emId = emId == null ? null : emId.trim();
    }

    public String getEmTheme() {
        return emTheme;
    }

    public void setEmTheme(String emTheme) {
        this.emTheme = emTheme == null ? null : emTheme.trim();
    }

    public String getWoFid() {
        return woFid;
    }

    public void setWoFid(String woFid) {
        this.woFid = woFid == null ? null : woFid.trim();
    }

    public String getWoSid() {
        return woSid;
    }

    public void setWoSid(String woSid) {
        this.woSid = woSid == null ? null : woSid.trim();
    }

    public Date getEmTime() {
        return emTime;
    }

    public void setEmTime(Date emTime) {
        this.emTime = emTime;
    }

    public Integer getEmLevel() {
        return emLevel;
    }

    public void setEmLevel(Integer emLevel) {
        this.emLevel = emLevel;
    }

    public Integer getEmStauts() {
        return emStauts;
    }

    public void setEmStauts(Integer emStauts) {
        this.emStauts = emStauts;
    }

    public String getEmInfomation() {
        return emInfomation;
    }

    public void setEmInfomation(String emInfomation) {
        this.emInfomation = emInfomation == null ? null : emInfomation.trim();
    }
}