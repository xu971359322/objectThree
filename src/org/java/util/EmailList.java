package org.java.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmailList {

    private List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();

    private EmailList(){}

    private  static  EmailList emailList;

    public static EmailList getEmailList(){
        if(emailList==null){
            emailList = new EmailList();
        }
        return emailList;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
}
