package com.example.igonan.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

    private String prNum;
    private String prName;
    private int prPrice;
    private int prCount;
    private String prMemo;
    private int prDpay;
    private int prType;
    private String prGallery;
    private String prSeller;
    private String prContent;

  //  pr_seller varchar(50),pr_content longtext);

    public String getPrNum() {
        return prNum;
    }

    public String getPrName() {
        return prName;
    }

    public int getPrPrice() {
        return prPrice;
    }

    public int getPrCount() {
        return prCount;
    }

    public String getPrMemo() {
        return prMemo;
    }

    public int getPrDpay() {
        return prDpay;
    }

    public int getPrType() {
        return prType;
    }

    public String getPrGallery() {
        return prGallery;
    }

    public String getPrSeller() {
        return prSeller;
    }

    public String getPrContent() {
        return prContent;
    }
}
