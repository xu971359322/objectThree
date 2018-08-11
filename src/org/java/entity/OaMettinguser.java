package org.java.entity;

public class OaMettinguser {
    private Integer muId;

    private Integer mId;

    private String woId;

    public Integer getMuId() {
        return muId;
    }

    public void setMuId(Integer muId) {
        this.muId = muId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }
}