package org.java.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	private List<String> name;
	private String content;
	private String time;
	private String personName;
	private Boolean flag;

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	private Gson gson=new Gson();//创建Gson实例，可以将对象转换成json格式的字符串
	
	public String toJson(){
		return gson.toJson(this);//注意只是将对象转换成json格式的字符串，并不是json
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
}
