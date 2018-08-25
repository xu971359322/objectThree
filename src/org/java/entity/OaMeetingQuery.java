package org.java.entity;

import java.io.Serializable;

public class OaMeetingQuery implements Serializable {
    //会议信息
    private OaMeeting oaMeeting;

    //为了系统的可扩展性，对原始的entity进行扩展
    private OaMeetingCustom oaMeetingCustom;
}
