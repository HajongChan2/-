package com.example.igonan.util;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class myPageTotalDTO {


    private String uName;
    private  int uTotalpay;
    private  int uCount;

    public String getuName() {
        return uName;
    }

    public int getuTotalpay() {
        return uTotalpay;
    }

    public int getuCount() {
        return uCount;
    }
}
