package com.example.igonan.Controller;


import com.example.igonan.Service.AbanDogService;
import com.example.igonan.Service.PetDogService;
import com.example.igonan.dto.AbandogDTO;
import com.example.igonan.dto.PetdogDTO;
import com.example.igonan.mindmapper.AbanDogmapper;
import com.example.igonan.mindmapper.PetDogmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class petDogController {


    @Autowired
    PetDogmapper pdm;

    private PetDogService petDogService;

    public petDogController(PetDogService petDogService) {
        this.petDogService = petDogService;
    }




    // 반려견 전체 리스트 출력
    @RequestMapping(value = "/petdoglist", method = { RequestMethod.POST }) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object petdoglist(){
        //반려견 전체 리스트를 db에서 가져온다
        List<PetdogDTO> list = petDogService.getPetdogList();// List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }

    // 특정 반려견 데이터만 출력 (반려견 이름으로 검색하여 출력)
    @RequestMapping(value = "/onepet", method = { RequestMethod.POST }) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public Object petdogone(HttpServletRequest rq){ // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //반려견의 이름으로 검색하여 db에서 데이터를 찾아옴
        String dogname = "아롱이"; // = rq.getParameter("petdog_name");
        // 웹에서 보내진 파라미터 값을 변수에 저장 여기선 임시로 '아롱이'로 설정
        List<PetdogDTO> list = petDogService.getOnePet(dogname); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }


}
