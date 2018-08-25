package org.java.entity;

import java.io.Serializable;

public class OaMeetingCustom extends OaMeeting implements Serializable {//扩展属性

    private Boolean ifAllDay;// 是否全天
    private String colorInfo;// 颜色状态   1绿色,2灰色,3橙色
    private String startTime;
    private String endTime;
    private String mremark;
    private Integer mType;

    public Integer getmType() {
        return mType;
    }

    public void setmType(Integer mType) {
        this.mType = mType;
    }

    public String getMremark() {
        return mremark;
    }

    public void setMremark(String mremark) {
        this.mremark = mremark;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getIfAllDay() {
        return ifAllDay;
    }

    public void setIfAllDay(Boolean ifAllDay) {
        this.ifAllDay = ifAllDay;
    }

    public String getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(String colorInfo) {
        this.colorInfo = colorInfo;
    }

}
