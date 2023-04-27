package com.example.igonan.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

    private String pNum;
    private String pName;
    private int pPrice;
    private int pCount;
    private String pMemo;
    private int pDpay;
    private String pGallery;


    public String getpNum() {
        return pNum;
    }

    public String getpName() {
        return pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public int getpCount() {
        return pCount;
    }

    public String getpMemo() {
        return pMemo;
    }

    public int getpDpay() {
        return pDpay;
    }

    public String getpGallery() {
        return pGallery;
    }
}
