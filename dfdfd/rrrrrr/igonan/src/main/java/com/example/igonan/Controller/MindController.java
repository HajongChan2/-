package com.example.igonan.Controller;


import com.example.igonan.Service.PaymentService;
import com.example.igonan.mindmapper.Paymentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MindController {



    @RequestMapping("/main")
    public String main( ) {

        return "main";
    }
    @RequestMapping("/info")
    public String information( ) {

        return "information";
    }
    @RequestMapping("/abandog/detail")
    public String abandog_detail( ) {

        return "abandog_detail";
    }
    @RequestMapping("/abandog/form")
    public String abandog_form( ) {

        return "abandog_form";
    }
    @RequestMapping("/dog/adoption")
    public String dog_adoption( ) {

        return "dog_adoption";
    }

    @RequestMapping("/dog/detail")
    public String dog_detail_inq( ) {

        return "dog_detail_inq";
    }

    @RequestMapping("/dog/select")
    public String dog_inquiry( ) {

        return "dog_inquiry";
    }
    @RequestMapping("/dog/detail/form")
    public String dog_infomation_detail( ) {

        return "dog_infomation_detail";
    }


    @RequestMapping("/petcesary")
    public String petcesary(){

        return "petcesory";
    }
    @RequestMapping("/product/detail")
    public String petcede(){

        return "product_detail";
    }

    @RequestMapping("/payment")
    public String payment(){

        return "payment";
    }
    @RequestMapping("/purchase")
    public String purchase(){

        return "purchase_select";
    }



    @RequestMapping("/ttttt")
    public String test(){

        return "test";
    }

    @RequestMapping("/doglist")
    public String dogdogtest(){

        return "testdog";
    }
    @RequestMapping("/onedog")
    public String dogparamtest(){

        return "abandog_detail";
    }

}
