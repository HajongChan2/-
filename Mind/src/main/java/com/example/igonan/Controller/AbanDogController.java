package com.example.igonan.Controller;

import com.example.igonan.Service.AbanDogService;
import com.example.igonan.dto.AbandogDTO;
import com.example.igonan.mindmapper.AbanDogmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class AbanDogController {

    @Autowired
    AbanDogmapper adm;

    private AbanDogService abanDogService;

    public AbanDogController(AbanDogService abanDogService) {
        this.abanDogService = abanDogService;
    }


    @RequestMapping(value = "/doglist", method = {RequestMethod.POST}) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object AllDogs() {
        //유기견의 전체 리스트를 db에서 가져온다
        List<AbandogDTO> list = abanDogService.getAbanDogList(); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }

    // 유기견 전체 리스트 출력
    @RequestMapping(value = "/abandog/list", method = {RequestMethod.POST}) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object abandoggglists() {
        //유기견의 전체 리스트를 db에서 가져온다
        List<AbandogDTO> list = abanDogService.getAbanDogList(); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }

    @ResponseBody
    @RequestMapping(value = "/abandog/detail/{param}", method = { RequestMethod.GET }) //데이터가 보내지는 주소와 메소드 설정
    public Object abandogone(@PathVariable("param")int parameter){ // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //유기견의 이름으로 검색하여 db에서 데이터를 찾아옴

        List<AbandogDTO> list = abanDogService.getOneDog(parameter); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }

    @RequestMapping(value = "/main/abandoglist", method = {RequestMethod.POST}) //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object mainAbandogList() {
        //유기견의 전체 리스트를 db에서 가져온다
        List<AbandogDTO> list = abanDogService.getMainAbanDogList(); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }



}