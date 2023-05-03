package com.example.igonan.Controller;


import com.example.igonan.Service.AbanDogService;
import com.example.igonan.Service.PaymentService;
import com.example.igonan.mindmapper.AbanDogmapper;
import com.example.igonan.mindmapper.Paymentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InsertController {

    @Autowired
    Paymentmapper paymentmapper;

    @Autowired
    AbanDogmapper abdmp;

    private PaymentService paymentService;

    public PaymentService getPaymentService() {
        return paymentService;
    }

    private AbanDogService abanDogService;

    public AbanDogService getAbanDogService() {
        return abanDogService;
    }

    @PostMapping("/payment/insert") //해당 url로 데이터가 post 되었을 경우 실행
    public String paymentinsert(HttpServletRequest rq){ //보내진 데이터이용을 위해 HttpServletRequest를 rq로 선언하여 이용
        int pr_count = 0; // 사용자가 구매하려는 상품의 개수를 담는 변수
        if(rq.getParameter("count")==null){ // 사용자가 구매하려는 상품의 개수가 post되지 않으면 0을 담음
            pr_count = 0;
        }else {
            pr_count = Integer.parseInt(rq.getParameter("count"));
            //사용자가 구매하려는 상품의 개수를 int형으로 변환하여 담음
        }

        paymentmapper.mindpaymentinsert(   //구매자 주문정보를 insert하는 mindpaymentinsert 호출과 파라미터 값 입력
                rq.getParameter("user_name"),
                rq.getParameter("phone"),rq.getParameter("addr"),
                rq.getParameter("saddr"),rq.getParameter("memo"),
                //Integer.parseInt(rq.getParameter("p_count")),
                pr_count,rq.getParameter("payment_method")
        );

        return "redirect:/userlist"; //insert 완료 시 /users 로 리다이렉트하여 주문자 리스트를 보여줌
    }



    @RequestMapping("/abandog/insert") //해당 url로 데이터가 post 되었을 경우 실행
    public String abanDogInsert(HttpServletRequest rq){ //보내진 데이터이용을 위해 HttpServletRequest를 rq로 선언하여 이용

        String name = "임시맨";//rq.getParameter("name");
        int age = 21;//Integer.parseInt(rq.getParameter("age")),
        String area = "임시맨"; //rq.getParameter("area");
        String sex = "여";//rq.getParameter("sex");
        String size = "임시맨";//rq.getParameter("size");
        String spec = "임시맨";//rq.getParameter("spec");
        String vac = "O";//rq.getParameter("vac");
        String neut = "O";//rq.getParameter("neut");
        String dead = "2022-09-09";//rq.getParameter("dead");
        String memo = "임시맨";//rq.getParameter("memo");
        String gallery = null;//rq.getParameter("gallery");

        abdmp.mindAbanDogInsert(name,age,area,sex,size,spec,vac,neut,dead,memo,gallery);
//a_num,a_name,age,area ,sex,size,spec,vac,neut,dead,memo,gallery) <
        return "redirect:/dogs"; //insert 완료 시 /users 로 리다이렉트하여 주문자 리스트를 보여줌
    }
    @RequestMapping("/imsiman")
    public String petcesary(){

        return "dummyform";
    }

}
