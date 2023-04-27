package com.example.igonan.Controller;

import com.example.igonan.Service.PaymentService;
import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.mindmapper.Paymentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    Paymentmapper mindm;

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/users")
    public List<PaymentDTO> AllUser(){
        return  paymentService.getUsersBuyList();

    }
    @GetMapping("/user")
    public PaymentDTO oneUser(){
        String buyername = "방국봉";
        return  paymentService.getOneBuyList(buyername);

    }


    @RequestMapping(value = "/ttttt", method = { RequestMethod.POST })
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object test(){ // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능

        // ex_3
        List<PaymentDTO> list = paymentService.getUsersBuyList(); // List에 select 결과 list를 담음
        // list에 name, phone, addr,
        // {"id":"admin"},{"pw":"1234"},{"content":"내용 입니다."}

        return list; // Ajax로 넘겨줄 select 결과값

    }







}
