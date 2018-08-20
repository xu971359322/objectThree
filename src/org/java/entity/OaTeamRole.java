package org.java.entity;

import java.io.Serializable;

public class OaTeamRole implements Serializable{
    private Integer roId;

    private String roName;

    private Integer roAvailable;

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