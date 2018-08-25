package org.java.entity;

import java.io.Serializable;

public class OaArticleType implements Serializable{
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