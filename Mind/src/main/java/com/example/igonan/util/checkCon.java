package com.example.igonan.util;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class checkCon {

    @RequestMapping("/logincheck")
    public String logincheck( ) {
        String inputid = "tttt";
        String addr = "loginsuccess?id=";
        return "redirect:/"+addr+inputid;
    }

/*
    @RequestMapping("/logincheck")
    public String logincheck(HttpServletRequest rq) {
        String inputid = rq;
        String addr = "loginsuccess?id=";
        return "redirect:/"+addr+asd;
    }
*/

}
