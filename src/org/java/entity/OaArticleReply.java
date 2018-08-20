package org.java.entity;

import java.io.Serializable;
import java.util.Date;

public class OaArticleReply implements Serializable{
    private Integer bbsReplyId;

    private Integer bbsTopicId;

    private String bbsReplyContent;

    private String woId;

    private Date bbsReplyTime;

    public Integer getBbsReplyId() {
        return bbsReplyId;
    }

    public void setBbsReplyId(Integer bbsReplyId) {
        this.bbsReplyId = bbsReplyId;
    }

    public Integer getBbsTopicId() {
        return bbsTopicId;
    }

    public void setBbsTopicId(Integer bbsTopicId) {
        this.bbsTopicId = bbsTopicId;
    }

    public String getBbsReplyContent() {
        return bbsReplyContent;
    }

    public void setBbsReplyContent(String bbsReplyContent) {
        this.bbsReplyContent = bbsReplyContent == null ? null : bbsReplyContent.trim();
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId == null ? null : woId.trim();
    }

    public Date getBbsReplyTime() {
        return bbsReplyTime;
    }

    public void setBbsReplyTime(Date bbsReplyTime) {
        this.bbsReplyTime = bbsReplyTime;
    }
}