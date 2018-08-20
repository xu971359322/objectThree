package org.java.controller;

import org.java.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController extends BaseController {

    @Autowired
    private ReportService reportService;

    public String selReportById(String woId){

        return "";
    }

    //添加业务单
    @RequestMapping("")
    public String addReport(){

        return "";
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
