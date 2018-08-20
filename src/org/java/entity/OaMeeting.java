package org.java.entity;

import java.util.Date;

public class OaMeeting {
    private Integer mId;

    private String mTitle;

    private Integer mpId;

    private Date mBegintime;

    private Date eEndtime;

    private String mContent;

    private String woId;

    private Integer mstate;

    public Integer getMstate() {
        return mstate;
    }

    public void setMstate(Integer mstate) {
        this.mstate = mstate;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle == null ? null : mTitle.trim();
    }

    public Integer getMpId() {
        return mpId;
    }

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    public Date getmBegintime() {
        return mBegintime;
    }

    public void setmBegintime(Date mBegintime) {
        this.mBegintime = mBegintime;
    }

    public Date geteEndtime() {
        return eEndtime;
    }

    public void seteEndtime(Date eEndtime) {
        this.eEndtime = eEndtime;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent == null ? null : mContent.trim();
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }

    @Override
    public String toString() {
        return "OaMeeting{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mpId=" + mpId +
                ", mBegintime=" + mBegintime +
                ", eEndtime=" + eEndtime +
                ", mContent='" + mContent + '\'' +
                ", woId='" + woId + '\'' +
                ", mstate=" + mstate +
                '}';
    }
}