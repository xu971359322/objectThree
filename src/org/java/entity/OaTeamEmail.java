package org.java.entity;

import java.io.Serializable;
import java.util.Date;

public class OaTeamEmail implements Serializable{
    private String emId;

    private String emTitle;

    private String woFid;

    private Date emTime;

    private Integer emLevel;

    private Integer emStauts;

    private String emFile;

    private String emInfomation;

    public String getEmId() {
        return emId;
    }

    public void setEmId(String emId) {
        this.emId = emId == null ? null : emId.trim();
    }

    public String getEmTitle() {
        return emTitle;
    }

    public void setEmTitle(String emTitle) {
        this.emTitle = emTitle == null ? null : emTitle.trim();
    }

    public String getWoFid() {
        return woFid;
    }

    public void setWoFid(String woFid) {
        this.woFid = woFid == null ? null : woFid.trim();
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

    public String getEmFile() {
        return emFile;
    }

    public void setEmFile(String emFile) {
        this.emFile = emFile == null ? null : emFile.trim();
    }

    public String getEmInfomation() {
        return emInfomation;
    }

    public void setEmInfomation(String emInfomation) {
        this.emInfomation = emInfomation == null ? null : emInfomation.trim();
    }


    @Override
    public String toString() {
        return "OaTeamEmail{" +
                "emId='" + emId + '\'' +
                ", emTitle='" + emTitle + '\'' +
                ", woFid='" + woFid + '\'' +
                ", emTime=" + emTime +
                ", emLevel=" + emLevel +
                ", emStauts=" + emStauts +
                ", emFile='" + emFile + '\'' +
                ", emInfomation='" + emInfomation + '\'' +
                '}';
    }
}