package com.example.igonan.dto;


import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDTO {

    private int uNum;
    private String uId;
    private String uName;
    private String uPhone;
    private String uAddr;
    private String uSaddr;
    private String uPrname;
    private  int uTotalpay;
    private String uMemo;
    private int uCount;
    private String uCashsel;
    private String uDate;
    private String uDel;
    private String uPrmemo;
    private String uPrimg;

    public int getuNum() {
        return uNum;
    }
    public String getuId() {
        return uId;
    }

    public String getuName() {
        return uName;
    }

    public String getuPhone() {
        return uPhone;
    }

    public String getuAddr() {
        return uAddr;
    }

    public String getuSaddr() {
        return uSaddr;
    }

    public String getuPrname() {
        return uPrname;
    }

    public int getuTotalpay() {
        return uTotalpay;
    }

    public String getuMemo() {
        return uMemo;
    }

    public int getuCount() {return uCount;}

    public String getuCashsel() {return uCashsel;}

    public String getuDate() {
        return uDate;
    }

    public String getuDel() {
        return uDel;
    }

    public String getuPrmemo() {
        return uPrmemo;
    }

    public String getuPrimg() {
        return uPrimg;
    }
}
