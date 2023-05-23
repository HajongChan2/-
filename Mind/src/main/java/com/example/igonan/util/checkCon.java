package com.example.igonan.util;


import com.example.igonan.Service.UserService;
import com.example.igonan.dto.UserDTO;
import com.example.igonan.mindmapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class checkCon {

    @Autowired
    Usermapper usermapper;

    private UserService userService;

    public  checkCon(UserService userService) {
        this.userService = userService;
    }
/*
    @RequestMapping("/logincheck")
    public String logincheck( ) {
        String inputid = "tttt";
        String addr = "loginsuccess?id=";
        return "redirect:/"+addr+inputid;
    }
*/
/*
    @RequestMapping("/logincheck")
    public String logincheck(HttpServletRequest rq) {

        String inputid = rq.getParameter("id");
       // String inputpw = rq.getParameter("pw");
        List<UserDTO> loggedin = userService.getOneUser(inputid);
      //  loggedInSession result = (userService.loginUser(inputid));
        System.out.println(loggedin.isEmpty());
        if(loggedin.isEmpty()==false){

            String addr = "loginsuccess?id=";
            return "redirect:/"+addr+inputid;
        }

        System.out.println("아이디 틀림");
        return "redirect:/login";
    }
*/
@RequestMapping("/logincheck")
public String logincheck(HttpServletRequest rq) {
    String addr = "loginsuccess?id=";
    String inputid = rq.getParameter("id");
     String inputpw = rq.getParameter("pw");
    List<UserDTO> loggedin = userService.getOneUser(inputid);

    System.out.println(loggedin.isEmpty());
    if(loggedin.isEmpty()==false){
        loggedInSession result = (userService.loginUser(inputid));
        if(inputpw.equals(result.getPw())){
            return "redirect:/"+addr+inputid;
        }else {
            System.out.println("비밀번호 틀림");
            return "redirect:/login";
        }
        }

    System.out.println("아이디 틀림");
    return "redirect:/login";
}


    @RequestMapping("/logout")
    public String logout(HttpSession hs) {

    System.out.println("로그아웃 완료");
        hs.removeAttribute("userid");

        return "redirect:/main";
    }



}
