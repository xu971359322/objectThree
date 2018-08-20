package org.java.entity;

import java.io.Serializable;
import java.util.Date;

public class OaFile implements Serializable {
    private Integer fId;

    private String fName;

    private Date fTime;

    private String fType;

    private Integer fStauts;

    private String woId;

    private String selUid;

    private String fMess;

    private Integer fLenth;

    private Integer fdownCount;


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

    public String getfMess() {
        return fMess;
    }

    public void setfMess(String fMess) {
        this.fMess = fMess;
    }


    public Integer getFdownCount() {
        return fdownCount;
    }

    public void setFdownCount(Integer fdownCount) {
        this.fdownCount = fdownCount;
    }

    public Integer getfLenth() {
        return fLenth;
    }

    public void setfLenth(Integer fLenth) {
        this.fLenth = fLenth;
    }
}