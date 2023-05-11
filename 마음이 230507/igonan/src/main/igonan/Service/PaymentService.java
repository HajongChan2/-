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
    public PaymentDTO getOneBuyList(String buyername){
        PaymentDTO oneBuy = pmm.findOne(buyername);
   //     System.out.println(oneBuy.getuPhone());

        return oneBuy;
    }








}
