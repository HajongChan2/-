package com.example.igonan.Controller;

import com.example.igonan.Service.PaymentService;
import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.dto.ProductDTO;
import com.example.igonan.mindmapper.Paymentmapper;
import com.example.igonan.util.Script;
import com.example.igonan.util.countDTO;
import com.example.igonan.util.myPageTotalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    @RequestMapping(value = "/productbuyresult", method = {RequestMethod.POST})
    @ResponseBody
    public Object buyresultreturn(HttpSession hs){

       String wireid =  hs.getAttribute("userid").toString();
       String prName = hs.getAttribute("productname").toString();
       PaymentDTO list = paymentService.getOneBuyResult(wireid,prName);
        hs.removeAttribute(prName);
       return list;

    }

    @RequestMapping(value = "/mypagebuylist", method = { RequestMethod.POST })
    @ResponseBody
    public Object usersbuylist(HttpServletRequest rq,HttpSession hs){

        String wireid =  hs.getAttribute("userid").toString();
        int startnum = Integer.parseInt(rq.getParameter("start"));
        int endnum = Integer.parseInt(rq.getParameter("end"));
        List<PaymentDTO> list = paymentService.mypageuserbuylist(wireid,startnum,endnum);


        return list;

    }

    @RequestMapping(value = "/mypagebuytotal", method = { RequestMethod.POST})
    @ResponseBody
    public Object usersbuytotal(HttpSession hs){

        String wireid =  hs.getAttribute("userid").toString();
        List<myPageTotalDTO> list = paymentService.getuserBuytotal(wireid);

        return list;

    }
    @RequestMapping(value = "/mypagebuytotalmonth", method = { RequestMethod.POST})
    @ResponseBody
    public Object usersbuytotalmonth(HttpSession hs){

       String wireid =  hs.getAttribute("userid").toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter formatmonth = DateTimeFormatter.ofPattern("mm");
        // 포맷 적용

        LocalDate asd = LocalDate.now();
        int thismonth = asd.getMonthValue();

        String thisyear = asd.format(formatter);

        String thisdate = thisyear+"-%"+thismonth+"-%";

        System.out.println(wireid);
        System.out.println(thisdate);

        List<myPageTotalDTO> list = paymentService.getuserBuytotalmonth(wireid,thisdate);

        return list;

    }

    @RequestMapping(value = "/userbuylists", method = { RequestMethod.POST })
    @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환
    public Object test(){ // Object 대신에 String, list<DTO>, Map<String,Object> 등 .. 도 사용 가능

        // ex_3
        List<PaymentDTO> list = paymentService.getUsersBuyList(); // List에 select 결과 list를 담음
        // list에 name, phone, addr,
        // {"id":"admin"},{"pw":"1234"},{"content":"내용 입니다."}

        return list; // Ajax로 넘겨줄 select 결과값

    }
    @RequestMapping(value = "/userallbuylist", method = { RequestMethod.POST })
    @ResponseBody
    public Object oneUsersAllBuyList(HttpSession hs){

        String buyerid = hs.getAttribute("userid").toString();
        List<PaymentDTO> list = paymentService.getOneUsersAllBuyList(buyerid);

        return list;

    }


    @RequestMapping(value = "/userdeliveryreturn/{Status}") //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public Object productType(@PathVariable String Status, HttpSession hs)throws IOException {

        String buyerid = hs.getAttribute("userid").toString();
        String deliveryStatus = "입금/결제";
        switch (Status){
            case "pay":
                 deliveryStatus = "입금/결제";
                break;

            case "ship" :
                 deliveryStatus = "배송중";
                break;

            case "complete" :
                 deliveryStatus = "배송완료";
                break;
            default:
                if (Status != "pay" || Status != "ship" || Status != "complete"){
                    return Script.back("유효하지 않은 url 요청입니다.");
                }
                break;
        }
        List<PaymentDTO> list = paymentService.oneUsersDeliveryStatusReturn(buyerid,deliveryStatus); // List에 select 결과 list를 담음

        return list; // Ajax로 넘겨줄 select 결과값

    }



    @RequestMapping(value = "/userdeliverycount"//, method = { RequestMethod.POST }
    )
    @ResponseBody
    public Object userdeliverycount(HttpSession hs, Model model ){

        String buyerid = hs.getAttribute("userid").toString();
        List<Integer> list = new ArrayList<Integer>();
        int allCount = mindm.oneUsersDeliveryStatuscountReturn(buyerid,"%").getuCount();
        int payCount = mindm.oneUsersDeliveryStatuscountReturn(buyerid,"입금/결제").getuCount();
        int shipCount = mindm.oneUsersDeliveryStatuscountReturn(buyerid,"배송중").getuCount();
        int completeCount = mindm.oneUsersDeliveryStatuscountReturn(buyerid,"배송완료").getuCount();

      /*  model.addAttribute(allCount);
        model.addAttribute(payCount);
        model.addAttribute(shipCount);
        model.addAttribute(completeCount);
        */

        list.add(0,allCount);
        list.add(payCount);
        list.add(shipCount);
        list.add(completeCount);

        List test = new ArrayList();
        test.add(new countDTO("전체",allCount));
        test.add(new countDTO("입금/결제",payCount));
        test.add(new countDTO("배송중",shipCount));
        test.add(new countDTO("배송완료",completeCount));

        return test;

    }

    /*

@RestController @RequestMapping(value = "/jsontest") public class TestClass {
         @GetMapping()   public TestDTO test() {
             TestDTO test = new TestDTO(1, "1111");      return test;    }
               @GetMapping("/2")
               public List test2() {
               List test = new ArrayList();
                      test.add(0, new TestDTO(1, "1111"));
                      test.add(1, new TestDTO(2, "2222"));
                       test.add(2, new TestDTO(3, "3333"));
                         return test;    }

                  }



 */



/*
   @RequestMapping(value = "/userdeliveryreturn") //데이터가 보내지는 주소와 메소드 설정
    @ResponseBody
    public Object productType(@RequestParam("status")int Status, HttpSession hs)throws IOException {

        String buyerid = hs.getAttribute("userid").toString();
        String deliveryStatus = "입금/결제";
        switch (Status){
            case 1:
                 deliveryStatus = "입금/결제";
                break;

            case 2 :
                 deliveryStatus = "배송중";
                break;

            case 3 :
                 deliveryStatus = "배송완료";
                break;
            default:
                if (Status != 1 || Status != 2 || Status != 3){
                    return Script.back("유효하지 않은 url 요청입니다.");
                }
                break;
        }
        List<PaymentDTO> list = paymentService.oneUsersDeliveryStatusReturn(buyerid,deliveryStatus); // List에 select 결과 list를 담음

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



}



