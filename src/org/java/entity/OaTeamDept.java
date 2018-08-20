package org.java.entity;

import java.io.Serializable;

public class OaTeamDept implements Serializable {
    private Integer deId;

    private String deName;

    private String dePhone;

    private String deFax;

    public Integer getDeId() {
        return deId;
    }

    public void setDeId(Integer deId) {
        this.deId = deId;
    }

    public String getDeName() {
        return deName;
    }

    public void setDeName(String deName) {
        this.deName = deName == null ? null : deName.trim();
    }

    public String getDePhone() {
        return dePhone;
    }

    public void setDePhone(String dePhone) {
        this.dePhone = dePhone == null ? null : dePhone.trim();
    }

    public String getDeFax() {
        return deFax;
    }

    public void setDeFax(String deFax) {
        this.deFax = deFax == null ? null : deFax.trim();
    }
}