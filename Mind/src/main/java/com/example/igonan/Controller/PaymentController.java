package com.example.igonan.Controller;

import com.example.igonan.Service.PaymentService;
import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.mindmapper.Paymentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class PaymentController {


    @Autowired
    Paymentmapper mindm;



    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

/*
    @GetMapping("/userbuylists")
    public List<PaymentDTO> AllUserbuylist(){

        return  paymentService.getUsersBuyList();

    }
    */

//    @GetMapping("/userbuylist")
//    public PaymentDTO oneUsernuylist(){
//        String buyername = "방국봉";
//        return  paymentService.getOneBuyList(buyername);
//
//    }
//

    @RequestMapping(value = "/userbuylists", method = { RequestMethod.POST })
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object test(){ // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능

        // ex_3
        List<PaymentDTO> list = paymentService.getUsersBuyList(); // List에 select 결과 list를 담음
        // list에 name, phone, addr,
        // {"id":"admin"},{"pw":"1234"},{"content":"내용 입니다."}

        return list; // Ajax로 넘겨줄 select 결과값

    }

/*
    @ResponseBody
    @RequestMapping(value = "/abandog/detail/{param}", method = { RequestMethod.GET }) //데이터가 보내지는 주소와 메소드 설정
    public Object oneUser(@PathVariable("param")String buyername){ // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능
        //유기견의 이름으로 검색하여 db에서 데이터를 찾아옴

        List<AbandogDTO> list = paymentService.getOneBuyList(buyername);// List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }
*/




/*
    @ResponseBody
    @RequestMapping("/hanpanman")
    public PaymentDTO hanpanman(@RequestParam("username") String username)throws IOException {

        return  paymentService.getOneBuyList(username);

    }
*/

/*
("/request-param-v2")
public String requestParamV2(@RequestParam("username") String username,
				@RequestParam("age") int age) throws IOException {
	return "username : " + username + "</br>age :" + age ;
	}

 */

}
