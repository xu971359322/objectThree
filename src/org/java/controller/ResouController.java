package org.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//资源管理Controller
@Controller
@RequestMapping("/resou")
public class ResouController {

    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/Load")
    public void up(){
        System.out.println("12333");
    }

}
