package org.java.entity;

import java.io.Serializable;

public class Info implements Serializable{
	private String msg;
	private Integer type;//聊天的类型
	private String toUser;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
}