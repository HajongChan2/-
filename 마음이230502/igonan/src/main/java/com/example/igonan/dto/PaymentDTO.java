package com.example.igonan.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDTO {

    private String uName;
    private String uPhone;
    private String uAddr;
    private String uSaddr;
    private String uMemo;
    private int uCount;
    private String uCashsel;
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

    public String getuMemo() {
        return uMemo;
    }

    public int getuCount() {return uCount;}

    public String getuCashsel() {return uCashsel;}
}
