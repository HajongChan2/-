package com.example.igonan.util;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class testLoggedIn {


    @RequestMapping("/hhhtttt")
    @ResponseBody
    public String malfurion() {

        return Script.href("/main","아야어여오요우유으이");
    }
}
