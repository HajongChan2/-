package com.example.igonan.Controller;

import com.example.igonan.Service.ProductService;
import com.example.igonan.Service.UserService;
import com.example.igonan.dto.AbandogDTO;
import com.example.igonan.dto.PaymentDTO;
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

        String id = rq.getParameter("id");
        //String id = "zxc";
        List<UserDTO> list = userService.getOneUser(id);
        if(list.isEmpty()){
            System.out.println("사용 가능한 아이디 ");

            return null;
        }
        return list;
    }

    @RequestMapping(value = "/loginsuccess")
    @ResponseBody
    public Object logedin(HttpServletRequest rq){


        return null;
    }



    @GetMapping("/users")
    public List<UserDTO> AllUserlist(){
        return  userService.getUsersList();

    }
}

/*
@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;


   // @return null 로그인 실패

public Member login(String loginId, String password) {
    return memberRepository.findByLoginId(loginId)
            .filter(m -> m.getPassword().equals(password))
            .orElse(null);
}
}
// 로그인의 핵심 비즈니스 로직은 회원을 조회한 다음에 파라미터로 넘어온 password와 비교해서, 같으면 회원을 반환하고, 다르면 null을 반환한다!

 */






