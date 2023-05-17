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
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    public Object malware(HttpServletRequest rq) {

        String id = rq.getParameter("id");
        //String id = "zxc";
        List<UserDTO> list = userService.getOneUser(id);
        if (list.isEmpty()) {
            System.out.println("사용 가능한 아이디 ");

            return null;
        }
        return list;
    }

    @RequestMapping(value = "/loginsuccess")
    @ResponseBody
    public Object logedin(HttpServletRequest rq, HttpSession hs) {

// String resultname = select name from users where id = inputid;
        //hs.setattribute("username",resultname);


        return null;
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






