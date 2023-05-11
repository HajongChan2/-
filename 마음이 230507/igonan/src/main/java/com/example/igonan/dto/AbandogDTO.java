package com.example.igonan.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AbandogDTO {

    private String adNum;
    private String adName;
    private int adAge;
    private String adArea;
    private String adSex;
    private String adSize;
    private String adSpec;
    private String adVac;
    private String adNeut;
    private String adDead;
    private String adMemo;
    private String adGallery;

    public String getAdNum() {
        return adNum;
    }

    public String getAdName() {
        return adName;
    }

    public int getAdAge() {
        return adAge;
    }

    public String getAdArea() {
        return adArea;
    }

    public String getAdSex() {
        return adSex;
    }

    public String getAdSize() {
        return adSize;
    }

    public String getAdSpec() {
        return adSpec;
    }

    public String getAdVac() {
        return adVac;
    }

    public String getAdNeut() {
        return adNeut;
    }

    public String getAdDead() {
        return adDead;
    }

    public String getAdMemo() {
        return adMemo;
    }

    public String getAdGallery() {
        return adGallery;
    }
}
