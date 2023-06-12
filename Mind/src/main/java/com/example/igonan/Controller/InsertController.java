package com.example.igonan.Controller;


import com.example.igonan.Service.AbanDogService;
import com.example.igonan.Service.ImageService;
import com.example.igonan.Service.PaymentService;
import com.example.igonan.Service.UserService;
import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.dto.ProductDTO;
import com.example.igonan.mindmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    Imagemapper imp;

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

    private ImageService imageService;
    public ImageService getImageService(){return  imageService;}

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
    String prName = rq.getParameter("prName");
    hs.setAttribute("productname",rq.getParameter("prName"));
    int asd = Integer.parseInt(prName);
    String prMemo = "";
    prMemo = pmp.findOneProduct(asd).get(0).getPrMemo().toString();

    String prImg = "";
    prImg = pmp.findOneProduct(asd).get(0).getPrGallery().toString();

    paymentmapper.mindpaymentinsert(
            id,
            rq.getParameter("name"),
            rq.getParameter("phone"),rq.getParameter("address"),
            rq.getParameter("address_detail"),rq.getParameter("prName"),
            Integer.parseInt(rq.getParameter("totalPay")),
            rq.getParameter("memo"),
            pr_count,rq.getParameter("payment_method"),buydate,prMemo,prImg
    );
    return "/main";
}

    @PostMapping("/abandog/insert") //해당 url로 데이터가 post 되었을 경우 실행
    public String abanDogInsert(HttpServletRequest rq,@RequestParam(name = "imgs[]") List<String> img){ //보내진 데이터이용을 위해 HttpServletRequest를 rq로 선언하여 이용

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


        abdmp.mindAbanDogInsert(name,age,area,sex,size,spec,vac,neut,dead,memo,img.get(1));
        int dognum = Integer.parseInt(abdmp.Abandoginsertwire(name).getAdNum());
        for(int i = 1; i < img.size();i++) {

           abdmp.mindAbanDogImageInsert(dognum, img.get(i));
        }
//select ad_num , ad_name , ad_age, ad_area, ad_sex , ad_size , ad_spec , ad_vac , ad_neut , ad_dead, ad_memo from ad_dog;

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

/*

@RequestMapping("/product/insert")
    public String productinsert(HttpSession hs, HttpServletRequest rq){
        String name = "사진 테스트2";
        int price = 30000;
        int dpay= 3000;
        String seller = "E_AhyeonPig";
        int count = 100;
        String memo = "이아현 도애지이야";
        int type = 3;
        String imgs[] ={"https://img.freepik.com/premium-photo/fun-pig-animation_183364-42986.jpg","zxc.jpg","qwe.jpg"};
        String content = "";
        pmp.mindProductInsert(name,price,count,memo,dpay,type,imgs[0],seller,content);
        int igonanProductNumber = Integer.parseInt(pmp.productImageWireNumberReturn(name).getPrNum());

        for(int i =0;i<3;i++) {
            pmp.mindProductImageInsert(igonanProductNumber,imgs[i]);
        }
        return "redirect:/petcesary";
    }
*/

@PostMapping("/product/insert")
    public String productinsert(HttpSession hs, HttpServletRequest rq,@RequestParam(name = "imgs[]") List<String> img){

        String name = rq.getParameter("name");
        int price = Integer.parseInt(rq.getParameter("price"));
        int count = Integer.parseInt(rq.getParameter("count"));
        int dpay =  Integer.parseInt(rq.getParameter("dpay"));
        String memo = rq.getParameter("memo");
        int type = Integer.parseInt(rq.getParameter("type"));
        String seller = rq.getParameter("seller");
        String content = rq.getParameter("content");
        pmp.mindProductInsert(name,price,count,memo,dpay,type,img.get(1),seller,content);
        int igonanProductNumber = Integer.parseInt(pmp.productImageWireNumberReturn(name).getPrNum());

        for(int i = 1;i < img.size();i++) {
            pmp.mindProductImageInsert(igonanProductNumber,img.get(i));

        }

        return "redirect:/petcesary";
}


    @PostMapping("/delivery/update")
    @ResponseBody
    public Object deliveryStatusUpdate(HttpSession hs, HttpServletRequest rq){

        int num = Integer.parseInt(rq.getParameter("num"));
        String id = hs.getAttribute("userid").toString();
        String status = "입금/결제";

        String nowStatus = paymentmapper.oneUsersOneRowWithNum(id,num).getuDel();
        System.out.println("현재 배송 상태 : "+nowStatus);
        switch (nowStatus){

            case "입금/결제":
                status = "배송중";
                paymentmapper.paymentDeleveryStatusUpdate(status,num);
                System.out.println("변경된 배송 상태 : "+status);
                break;
            case "배송중":
                status = "배송완료";
                paymentmapper.paymentDeleveryStatusUpdate(status,num);
                System.out.println("변경된 배송 상태 : "+status);
                break;
        }
       List<PaymentDTO> list =  paymentmapper.oneUsersAllIgonanBuyListReturn(id);
        return list; //insert 완료 시 /users 로 리다이렉트하여 주문자 리스트를 보여줌
    }



    @PostMapping("/delivery/delete")
    public String deliveryStatusDelete(HttpSession hs, HttpServletRequest rq){

        int num = Integer.parseInt(rq.getParameter("num"));

        paymentmapper.paymentDataDelete(num);

        return "redirect:/purchase"; //insert 완료 시 /users 로 리다이렉트하여 주문자 리스트를 보여줌
    }

    @PostMapping("/abandog/delete")
    public String AbandogDelete(HttpSession hs, HttpServletRequest rq){

        int num = Integer.parseInt(rq.getParameter("num"));
        abdmp.mindAbanDogImageDelete(num);
        abdmp.mindAbanDogDelete(num);

        return "redirect:/abandog/list";
    }

    @PostMapping("/product/delete")
    public String productDelete(HttpSession hs, HttpServletRequest rq){

        int num = Integer.parseInt(rq.getParameter("num"));

        pmp.mindProductDelete(num);
        pmp.mindProductImageDelete(num);
        return "redirect:/petcesary";
    }

    @PostMapping("/abandog/update")
    public String AbandogUpdate(HttpSession hs, HttpServletRequest rq,@RequestParam(name = "imgs[]") List<String> img) {

        int num = Integer.parseInt(rq.getParameter("num"));
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

        abdmp.mindAbanDogUpdate(num,name,age,area,sex,size,spec,vac,neut,dead,memo,img.get(1));
        int dognum = num;

        abdmp.mindAbanDogImageDelete(dognum);
        for(int i = 1; i < img.size();i++) {
            abdmp.mindAbanDogImageInsert(dognum, img.get(i));
        }

        return "redirect:/abandog/list";
    }

    @PostMapping("/product/update")
    public String ProductUpdate(HttpSession hs, HttpServletRequest rq,@RequestParam(name = "imgs[]") List<String> img){

        int num = Integer.parseInt(rq.getParameter("num"));
        String name = rq.getParameter("name");
        int price = Integer.parseInt(rq.getParameter("price"));
        int count = Integer.parseInt(rq.getParameter("count"));
        int dpay =  Integer.parseInt(rq.getParameter("dpay"));
        String memo = rq.getParameter("memo");
        int type = Integer.parseInt(rq.getParameter("type"));
        String seller = rq.getParameter("seller");
        String content = rq.getParameter("content");
        pmp.mindProductUpdate(num,name,price,count,memo,dpay,type,img.get(1),seller,content);

        int igonanProductNumber = num;

        pmp.mindProductImageDelete(igonanProductNumber);
        for(int i = 1;i < img.size();i++) {
            pmp.mindProductImageInsert(igonanProductNumber,img.get(i));

        }

        return "redirect:/petcesary";
    }



///

    @PostMapping("/abandog/add")
    public String abandogApp(HttpSession hs, HttpServletRequest rq){

        String id = hs.getAttribute("userid").toString();
        int num = Integer.parseInt(rq.getParameter("num"));
        String name = rq.getParameter("name");
        String phone = rq.getParameter("phone");
        String addr = rq.getParameter("addr");
        String saddr = rq.getParameter("saddr");
        String memo = rq.getParameter("memo");
        String dogname = abdmp.findOneDog(num).get(0).getAdName().toString();
        LocalDate appdate = LocalDate.now();
        
        abdmp.mindAbanDogAppInsert(id,name,num,dogname,phone,addr,saddr,memo,appdate);
        abdmp.mindAbanDogDelete(num);

        return "redirect:/abandog/list";
    }




}
