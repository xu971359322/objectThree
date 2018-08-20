package org.java.entity;

public class OaTeamWorker {
    private String woId;

    private String woName;

    private String woLoginname;

    private String woLoginpwd;

    private Integer woRole;

    private String woGender;

    private String woEmail;

    private String woInfomation;

    private String woPhoto;

    private Integer woStauts;

    private Integer woStationid;

    private Integer woDeptid;

    private String woPhone;

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }

    public String getWoName() {
        return woName;
    }

    public void setWoName(String woName) {
        this.woName = woName == null ? null : woName.trim();
    }

    public String getWoLoginname() {
        return woLoginname;
    }

    public void setWoLoginname(String woLoginname) {
        this.woLoginname = woLoginname == null ? null : woLoginname.trim();
    }

    public String getWoLoginpwd() {
        return woLoginpwd;
    }

    public void setWoLoginpwd(String woLoginpwd) {
        this.woLoginpwd = woLoginpwd == null ? null : woLoginpwd.trim();
    }

    public Integer getWoRole() {
        return woRole;
    }

    public void setWoRole(Integer woRole) {
        this.woRole = woRole;
    }

    public String getWoGender() {
        return woGender;
    }

    public void setWoGender(String woGender) {
        this.woGender = woGender == null ? null : woGender.trim();
    }

    public String getWoEmail() {
        return woEmail;
    }

    public void setWoEmail(String woEmail) {
        this.woEmail = woEmail == null ? null : woEmail.trim();
    }

    public String getWoInfomation() {
        return woInfomation;
    }

    public void setWoInfomation(String woInfomation) {
        this.woInfomation = woInfomation == null ? null : woInfomation.trim();
    }

    public String getWoPhoto() {
        return woPhoto;
    }

    public void setWoPhoto(String woPhoto) {
        this.woPhoto = woPhoto == null ? null : woPhoto.trim();
    }

    public Integer getWoStauts() {
        return woStauts;
    }

    public void setWoStauts(Integer woStauts) {
        this.woStauts = woStauts;
    }

    public Integer getWoStationid() {
        return woStationid;
    }

    public void setWoStationid(Integer woStationid) {
        this.woStationid = woStationid;
    }

    public Integer getWoDeptid() {
        return woDeptid;
    }

    public void setWoDeptid(Integer woDeptid) {
        this.woDeptid = woDeptid;
    }

    public String getWoPhone() {
        return woPhone;
    }

    public void setWoPhone(String woPhone) {
        this.woPhone = woPhone == null ? null : woPhone.trim();
    }

    @Override
    public String toString() {
        return "OaTeamWorker{" +
                "woId='" + woId + '\'' +
                ", woName='" + woName + '\'' +
                ", woLoginname='" + woLoginname + '\'' +
                ", woLoginpwd='" + woLoginpwd + '\'' +
                ", woRole=" + woRole +
                ", woGender='" + woGender + '\'' +
                ", woEmail='" + woEmail + '\'' +
                ", woInfomation='" + woInfomation + '\'' +
                ", woPhoto='" + woPhoto + '\'' +
                ", woStauts=" + woStauts +
                ", woStationid=" + woStationid +
                ", woDeptid=" + woDeptid +
                ", woPhone='" + woPhone + '\'' +
                '}';
    }
}