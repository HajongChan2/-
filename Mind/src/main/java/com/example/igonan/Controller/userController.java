package com.example.igonan.Controller;

import com.example.igonan.Service.ProductService;
import com.example.igonan.Service.UserService;
import com.example.igonan.dto.UserDTO;
import com.example.igonan.mindmapper.Productmapper;
import com.example.igonan.mindmapper.Usermapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class userController {

    @Autowired
    Usermapper usermapper;

    private UserService userService;

    public userController (UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "/idcheck")
    @ResponseBody
    public Object malware(HttpServletRequest rq){

        //String id = rq.getParameter("id");
        String id = "zxc";
        List<UserDTO> list = userService.getOneUser(id);
        System.out.println(list);
        return list;
    }




}
