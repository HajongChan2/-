package com.example.igonan.Service;


import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.mindmapper.Paymentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {


    @Autowired
    private Paymentmapper pmm;

    public List<PaymentDTO> getUsersBuyList(){
        List<PaymentDTO> userBuyList= pmm.userBuyList();
        return userBuyList;
    }
    public List<PaymentDTO> mypageuserbuylist(String buyerid,int startnum, int endnum){
        List<PaymentDTO> oneUserBuyList = pmm.mypageuserbuylist(buyerid,startnum,endnum);

        return oneUserBuyList;
    }
    public PaymentDTO getOneBuyResult(String buyerid,String productname){
        PaymentDTO oneBuyResult = pmm.finduserbuyresult(buyerid,productname);
        //     System.out.println(oneBuy.getuPhone());

        return oneBuyResult;
    }














}
