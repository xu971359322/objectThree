package org.java.entity;

import java.io.Serializable;

public class OaTeamRole implements Serializable{
    private Integer roId;

    private String roName;

    private Integer roAvailable;

    private String roRemark;

    public String getRoRemark() {
        return roRemark;
    }

    public void setRoRemark(String roRemark) {
        this.roRemark = roRemark;
    }

    public Integer getRoId() {
        return roId;
    }

    public void setRoId(Integer roId) {
        this.roId = roId;
    }

    public String getRoName() {
        return roName;
    }

    public void setRoName(String roName) {
        this.roName = roName == null ? null : roName.trim();
    }

    public Integer getRoAvailable() {
        return roAvailable;
    }

    public void setRoAvailable(Integer roAvailable) {
        this.roAvailable = roAvailable;
    }

    @Override
    public String toString() {
        return "OaTeamRole{" +
                "roId=" + roId +
                ", roName='" + roName + '\'' +
                ", roAvailable=" + roAvailable +
                '}';
    }
}