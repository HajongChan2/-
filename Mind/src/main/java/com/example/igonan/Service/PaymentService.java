package com.example.igonan.Service;


import com.example.igonan.dto.PaymentDTO;
import com.example.igonan.util.myPageTotalDTO;
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
    public List<PaymentDTO> getOneUsersAllBuyList(String buyerid){
        List<PaymentDTO> userAllBuyList= pmm.oneUsersAllIgonanBuyListReturn(buyerid);
        return userAllBuyList;
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
    public List<myPageTotalDTO> getuserBuytotal(String buyerid){
        List<myPageTotalDTO> userBuyTotal = pmm.mypageuserbuytotal(buyerid);
        //     System.out.println(oneBuy.getuPhone());

        return userBuyTotal;
    }

    public List<myPageTotalDTO> getuserBuytotalmonth(String buyerid,String year){
        List<myPageTotalDTO> userBuyTotalmonth = pmm.mypageuserbuytotalmonth(buyerid,year);
        //     System.out.println(oneBuy.getuPhone());

        return userBuyTotalmonth;
    }


    public List<PaymentDTO> oneUsersBuyListWireDateRangeReturn(String buyerid,String startDate,String endDate){
        List<PaymentDTO> oneUsersDateRange = pmm.oneUsersBuyListWireDateRange(buyerid,startDate,endDate);

        return oneUsersDateRange;
    }

    public List<PaymentDTO> oneUsersDeliveryStatusReturn(String buyerid,String Status){
        List<PaymentDTO> oneUsersDeliveryStatus = pmm.oneUsersDeliveryStatusDataReturn(buyerid,Status);

        return oneUsersDeliveryStatus;
    }
//









}
