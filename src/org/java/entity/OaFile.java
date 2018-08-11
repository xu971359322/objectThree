package org.java.entity;

import java.util.Date;

public class OaFile {
    private Integer fId;

    private String fName;

    private Date fTime;

    private String fType;

    private Integer fStauts;

    private String woId;

    private String selUid;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType == null ? null : fType.trim();
    }

    public Integer getfStauts() {
        return fStauts;
    }

    public void setfStauts(Integer fStauts) {
        this.fStauts = fStauts;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }

    public String getSelUid() {
        return selUid;
    }

    public void setSelUid(String selUid) {
        this.selUid = selUid == null ? null : selUid.trim();
    }
}