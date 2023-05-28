package com.example.igonan.Controller;

import com.example.igonan.Service.UserService;
import com.example.igonan.dto.UserDTO;
import com.example.igonan.mindmapper.Usermapper;
import com.example.igonan.util.loggedInSession;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class userController {

    @Autowired
    Usermapper usermapper;

    private UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/idcheck")
    @ResponseBody
    public boolean malware(HttpServletRequest rq) {

        String id = rq.getParameter("id");
        //String id = "zxc";
        List<UserDTO> list = userService.getOneUser(id);
        if (list.isEmpty()) {
            System.out.println("사용 가능한 아이디 ");

            return true;
        }
        return false;
    }
/*
    @RequestMapping(value = "/loginsuccess")
    @ResponseBody
    public loggedInSession logedin(HttpServletRequest rq, HttpSession hs) {
        String userid = rq.getParameter("id");
      loggedInSession resultname = (userService.loginUser(userid));
        hs.setAttribute("username",resultname.getName());
        String ssname = hs.getAttribute("username").toString();
        System.out.println("세션 생성 완료 이름 : "+ssname);
        hs.removeAttribute("username");
        System.out.println(resultname.getName());
        System.out.println(resultname.getPw());
        return resultname;
    }
    */

/*
    @RequestMapping(value = "/loginsuccess")
    @ResponseBody
    public loggedInSession logedin(HttpServletRequest rq, HttpSession hs) {
        String userid = rq.getParameter("id");
      loggedInSession resultname = (userService.loginUser(userid));
        //hs.setattribute("username",resultname);
        System.out.println(resultname.getName());

        return resultname;
    }



 */
/*
    @RequestMapping(value = "/logout")
    @ResponseBody
    public loggedInSession logedin(HttpSession hs) {
        String userid = rq.getParameter("id");
      loggedInSession resultname = (userService.loginUser(userid));
        hs.setAttribute("username",resultname.getName());
        String ssname = hs.getAttribute("username").toString();
        System.out.println("세션 생성 완료 이름 : "+ssname);
        hs.removeAttribute("username");
        System.out.println(resultname.getName());
        System.out.println(resultname.getPw());
        return resultname;
    }




 */

    @ResponseBody
    @RequestMapping("/mypage/return")
    public Object mypagedatareturn(HttpSession hs){
    String ssid = hs.getAttribute("userid").toString();

    List<UserDTO> list = userService.getOneUser(ssid);
    return list;
}



    @ResponseBody
    @RequestMapping(value = "/userlist") //데이터가 보내지는 주소와 메소드 설정
    public Object joinuserlist() { // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //유기견의 이름으로 검색하여 db에서 데이터를 찾아옴

        List<UserDTO> list = userService.getUsersList(); // List에 select 결과 list를 담음


        return list; // Ajax로 넘겨줄 select 결과값

    }




}
/*
 */





