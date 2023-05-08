package com.example.igonan.Controller;


import com.example.igonan.Service.PaymentService;
import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.mindmapper.Paymentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MindController {


    @RequestMapping("/mmain")
    public String mmain( ) {

        return "vvv/main";
    }
    @RequestMapping("/main")
    public String main( ) {

        return "main";
    }
    @RequestMapping("/info")
    public String information( ) {


        return "service/information";
    }
    @RequestMapping("/abandog/detail")
    public String abandog_detail() {


        return "abandog/abandog_detail";
    }
    @RequestMapping("/abandog/form")
    public String abandog_form( ) {


        return "service/abandog_form";
    }
    @RequestMapping("/abandog/list")
    public String dog_adoption( ) {


        return "abandog/abandog_list";
    }

    @RequestMapping("/dog/detail")
    public String dog_detail_inq( ) {

        return "dog/dog_detail";
    }

    @RequestMapping("/dog/list")
    public String dog_inquiry( ) {

        return "dog/dog_list";
    }
    @RequestMapping("/dog/detail/form")
    public String dog_infomation_detail( ) {

        return "abandog/abandog_insert";
    }


    @RequestMapping("/petcesary")
    public String petcesary(){

        return "product/petcesory";
    }
    @RequestMapping("/product/detail")
    public String petcede(){

        return "product/product_detail";
    }


    @RequestMapping("/payment")
    public String payment(){

        return "service/payment";
    }
    @RequestMapping("/purchase")
    public String purchase(){

        return "service/product_select";
    }



    @RequestMapping("/userlist")
    public String test(){

        return "test";
    }

    @RequestMapping("/doglist")
    public String dogdogtest(){

        return "testdog";
    }





}
