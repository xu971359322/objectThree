package org.java.entity;

public class OaArticleType {
    private Integer bbsTypeId;

    private String bbsTypeName;

    public Integer getBbsTypeId() {
        return bbsTypeId;
    }

    public void setBbsTypeId(Integer bbsTypeId) {
        this.bbsTypeId = bbsTypeId;
    }

    public String getBbsTypeName() {
        return bbsTypeName;
    }

    public void setBbsTypeName(String bbsTypeName) {
        this.bbsTypeName = bbsTypeName == null ? null : bbsTypeName.trim();
    }
}