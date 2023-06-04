package com.example.igonan.Controller;


import com.example.igonan.Service.AbanDogService;
import com.example.igonan.Service.PaymentService;
import com.example.igonan.Service.UserService;
import com.example.igonan.mindmapper.AbanDogmapper;
import com.example.igonan.mindmapper.Paymentmapper;
import com.example.igonan.mindmapper.Productmapper;
import com.example.igonan.mindmapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class InsertController {

    @Autowired
    Paymentmapper paymentmapper;
    @Autowired
    AbanDogmapper abdmp;
    @Autowired
    Usermapper ump;
    @Autowired
    Productmapper pmp;

    private PaymentService paymentService;

    public PaymentService getPaymentService() {
        return paymentService;
    }

    private AbanDogService abanDogService;

    public AbanDogService getAbanDogService() {
        return abanDogService;
    }

    private UserService userService;

    public  UserService getUserService() {return userService;}
/*

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
            rq.getParameter("name"),
            rq.getParameter("phone"),rq.getParameter("address"),
            rq.getParameter("address_detail"),rq.getParameter("memo"),
            //Integer.parseInt(rq.getParameter("p_count")),
            pr_count,rq.getParameter("payment_method")
    );

    return "/main"; //insert 완료 시 /users 로 리다이렉트하여 주문자 리스트를 보여줌
}
*/
@PostMapping("/payment/insert") //해당 url로 데이터가 post 되었을 경우 실행
public String paymentinsert(HttpServletRequest rq,HttpSession hs){ //보내진 데이터이용을 위해 HttpServletRequest를 rq로 선언하여 이용
    int pr_count = 0; // 사용자가 구매하려는 상품의 개수를 담는 변수
    if(rq.getParameter("count")==null){ // 사용자가 구매하려는 상품의 개수가 post되지 않으면 0을 담음
        pr_count = 0;
    }else {
        pr_count = Integer.parseInt(rq.getParameter("count"));
        //사용자가 구매하려는 상품의 개수를 int형으로 변환하여 담음
    }
    String id = hs.getAttribute("userid").toString();
    System.out.println(id);
    LocalDate buydate = LocalDate.now();

    hs.setAttribute("productname",rq.getParameter("prName"));
    paymentmapper.mindpaymentinsert(
            id,
            rq.getParameter("name"),
            rq.getParameter("phone"),rq.getParameter("address"),
            rq.getParameter("address_detail"),rq.getParameter("prName"),
            Integer.parseInt(rq.getParameter("totalPay")),
            rq.getParameter("memo"),
            pr_count,rq.getParameter("payment_method"),buydate
    );

    return "/main";
}

    @PostMapping("/abandog/insert") //해당 url로 데이터가 post 되었을 경우 실행
    public String abanDogInsert(HttpServletRequest rq){ //보내진 데이터이용을 위해 HttpServletRequest를 rq로 선언하여 이용


        String name =rq.getParameter("name");
        int age = Integer.parseInt(rq.getParameter("age"));
        String area=  rq.getParameter("area");
        String sex = rq.getParameter("sex");
        String size = rq.getParameter("size");
        String spec = rq.getParameter("spec");
        String vac = rq.getParameter("vac");
        String neut = rq.getParameter("neut");
        String dead = rq.getParameter("dead");
        String memo = rq.getParameter("memo");
        String[] img = rq.getParameterValues("imgs");
        System.out.println(img[0]);
        abdmp.mindAbanDogInsert(name,age,area,sex,size,spec,vac,neut,dead,memo,img[0]);
        int dognum = Integer.parseInt(abdmp.Abandoginsertwire(name).getAdNum());

        for(int i = 0; i< img.length;i++) {

           abdmp.mindAbanDogImageInsert(dognum, img[i]);
        }
        return "redirect:/abandog/list"; //insert 완료 시 /users 로 리다이렉트하여 주문자 리스트를 보여줌
    }

    @RequestMapping("/imsiman")
    public String petcesary(){

        return "index";
    }


@PostMapping("/join/insert") //해당 url로 데이터가 post 되었을 경우 실행
public String joinuserinsert(HttpServletRequest rq, HttpSession hs){ //보내진 데이터이용을 위해 HttpServletRequest를 rq로 선언하여 이용

    String name = rq.getParameter("name");
    String id = rq.getParameter("id");
    String pw = rq.getParameter("pw");
    String phone = rq.getParameter("phone");
    String addr = rq.getParameter("addr");
    String saddr = rq.getParameter("saddr");
    ump.mindjoinUserInsert(name,id,pw,phone,addr,saddr);
    hs.setAttribute("userid",id);
    hs.setAttribute("username",name);
    return "redirect:/main"; //insert 완료 시 /users 로 리다이렉트하여 주문자 리스트를 보여줌
}

    @PostMapping("/mypage/update")
    public String mypagedataupdate(HttpSession hs, HttpServletRequest rq){

        String name = rq.getParameter("name");
        String id = hs.getAttribute("userid").toString();
        System.out.println(id);
        String pw = rq.getParameter("pw");
        String phone = rq.getParameter("phone");
        String addr = rq.getParameter("addr");
        String saddr = rq.getParameter("saddr");
        hs.removeAttribute("username");
        ump.userinfoupdate(name,pw,phone,addr,saddr,id);
        hs.setAttribute("username",name);
        return "member/member_page"; //insert 완료 시 /users 로 리다이렉트하여 주문자 리스트를 보여줌
    }


@PostMapping("/product/insert")
    public String productinsert(HttpSession hs, HttpServletRequest rq){
/*
        String[] imgs = rq.getParameterValues("imgs");
        for ( int i  = 0; i < imgs.length; i++){
            //이미지 어떻게 받아올지 다시 생각해서 작성하기
            System.out.println(imgs[i]);
        }
        String name = rq.getParameter("name");
        String prcie = rq.getParameter("price");
        String dpay = rq.getParameter("dpay");
        String seller = rq.getParameter("seller");
        int count = Integer.parseInt(rq.getParameter("count"));
*/

        String name = "사진 테스트";
        int price = 30000;
        int dpay= 3000;
        String seller = "E_AhyeonPig";
        int count = 100;
        String memo = "이아현 도애지이야";
        int type = 3;
        String imgs[] ={"https://img.freepik.com/premium-photo/fun-pig-animation_183364-42986.jpg","zxc.jpg","qwe.jpg"};

        pmp.mindProductInsert(name,price,count,memo,dpay,type,imgs[0]);
        int igonanProducNumber = Integer.parseInt(pmp.productImageWireNumberReturn(name).getPrNum());
        for(int i =0;i<3;i++) {
            pmp.mindProductImageInsert(igonanProducNumber,imgs[i]);
        }
        return "redirect:/petcesary";
    }


}
