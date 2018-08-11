package org.java.entity;

import java.util.Date;

public class OaArticleTopic {
    private Integer bbsTopicId;

    private String bbsTopicTitle;

    private String bbsTopicContent;

    private Date bbsTopicTime;

    private String woId;

    private Integer bbsTypeId;

    public Integer getBbsTopicId() {
        return bbsTopicId;
    }

    public void setBbsTopicId(Integer bbsTopicId) {
        this.bbsTopicId = bbsTopicId;
    }

    public String getBbsTopicTitle() {
        return bbsTopicTitle;
    }

    public void setBbsTopicTitle(String bbsTopicTitle) {
        this.bbsTopicTitle = bbsTopicTitle == null ? null : bbsTopicTitle.trim();
    }

    public String getBbsTopicContent() {
        return bbsTopicContent;
    }

    public void setBbsTopicContent(String bbsTopicContent) {
        this.bbsTopicContent = bbsTopicContent == null ? null : bbsTopicContent.trim();
    }

    public Date getBbsTopicTime() {
        return bbsTopicTime;
    }

    public void setBbsTopicTime(Date bbsTopicTime) {
        this.bbsTopicTime = bbsTopicTime;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }

    public Integer getBbsTypeId() {
        return bbsTypeId;
    }

    public void setBbsTypeId(Integer bbsTypeId) {
        this.bbsTypeId = bbsTypeId;
    }
}