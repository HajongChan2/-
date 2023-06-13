package com.example.igonan.Controller;

import com.example.igonan.Service.AbanDogAppService;
import com.example.igonan.dto.AbandogAppDTO;
import com.example.igonan.mindmapper.AbanDogAppmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AbanDogAppController {

    @Autowired
    AbanDogAppmapper ada;

    private AbanDogAppService abanDogAppService;

    public AbanDogAppController(AbanDogAppService abanDogAppService) {
        this.abanDogAppService = abanDogAppService;
    }


    @RequestMapping(value = "/mypage/abanapplist", method = {RequestMethod.POST}) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public Object AbandogApp(HttpSession hs) {

        String appuserid = hs.getAttribute("userid").toString();
        List<AbandogAppDTO> Applist = abanDogAppService.getMainAbanDogAppList(appuserid);

        return Applist; // Ajax로 넘겨줄 select 결과값

    }


}