package com.example.igonan.util;


import com.example.igonan.Service.UserService;
import com.example.igonan.dto.UserDTO;
import com.example.igonan.mindmapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/logincheck",method = {RequestMethod.POST})
    @ResponseBody
    public Boolean logincheck(HttpServletRequest rq, HttpSession hs) {
        String inputid = rq.getParameter("id");
        String inputpw = rq.getParameter("pw");

        List<UserDTO> loggedin = userService.getOneUser(inputid);
        System.out.println(loggedin.isEmpty());
        if(loggedin.isEmpty()==false){
            loggedInSession result = (userService.loginUser(inputid));
            if(inputpw.equals(result.getPw())){
                hs.setAttribute("username",result.getName());
                hs.setAttribute("userid",inputid);
                return true;
            }else {
                System.out.println("비밀번호 틀림");
                return false;
            }
        }
        System.out.println("아이디 틀림");
        return false;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession hs) {

    System.out.println("로그아웃 완료");
        hs.removeAttribute("username");
        hs.removeAttribute("userid");
        return Script.href("/main","로그아웃되었습니다.");
    }



}


/*
@RequestMapping(value = "/logincheck",method = {RequestMethod.POST})
@ResponseBody
public String logincheck(HttpServletRequest rq, HttpSession hs) {
    String inputid = rq.getParameter("id");
     String inputpw = rq.getParameter("pw");
    String inputaddr = rq.getParameter("addr");
    System.out.println(inputaddr);
    List<UserDTO> loggedin = userService.getOneUser(inputid);
    System.out.println(loggedin.isEmpty());
    if(loggedin.isEmpty()==false){
        loggedInSession result = (userService.loginUser(inputid));
        if(inputpw.equals(result.getPw())){
            hs.setAttribute("username",result.getName());
            hs.setAttribute("userid",inputid);
            String ssname = hs.getAttribute("username").toString();
            String ssid = hs.getAttribute("userid").toString();
            System.out.println("세션 생성 완료 이름 : "+ssname);
            System.out.println("세션 생성 완료 id : "+ssid);
          //  hs.removeAttribute("username");

            return Script.tohref(inputaddr);
        }else {
            System.out.println("비밀번호 틀림");

            return Script.href("/login","비밀번호를 잘못 입력하셨습니다.");
        }
        }

    System.out.println("아이디 틀림");

    return Script.href("/login","아이디를 틀리게 입력하셨습니다.");
}
 */