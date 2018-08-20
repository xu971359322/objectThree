package org.java.entity;

import java.io.Serializable;

public class OaMettingplace implements Serializable {
    private Integer mpId;

    private String mpTitle;

    private String mpContent;

    private Integer mpPeople;

    private String mpPlace;

    private String mpFacility;

    public Integer getMpId() {
        return mpId;
    }

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    public String getMpTitle() {
        return mpTitle;
    }

    public void setMpTitle(String mpTitle) {
        this.mpTitle = mpTitle == null ? null : mpTitle.trim();
    }

    public String getMpContent() {
        return mpContent;
    }

    public void setMpContent(String mpContent) {
        this.mpContent = mpContent == null ? null : mpContent.trim();
    }

    public Integer getMpPeople() {
        return mpPeople;
    }

    public void setMpPeople(Integer mpPeople) {
        this.mpPeople = mpPeople;
    }

    public String getMpPlace() {
        return mpPlace;
    }

    public void setMpPlace(String mpPlace) {
        this.mpPlace = mpPlace == null ? null : mpPlace.trim();
    }

    public String getMpFacility() {
        return mpFacility;
    }

    public void setMpFacility(String mpFacility) {
        this.mpFacility = mpFacility == null ? null : mpFacility.trim();
    }
}