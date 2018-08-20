package org.java.entity;

import java.io.Serializable;

public class OaTeamStation implements Serializable{
    private Integer stId;

    private String stName;

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName == null ? null : stName.trim();
    }
}