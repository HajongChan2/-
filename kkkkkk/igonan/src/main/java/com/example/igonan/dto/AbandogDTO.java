package com.example.igonan.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AbandogDTO {


    private String aNum;
    private String aName;
    private int aAge;
    private String aArea;
    private String aSex;
    private String aSpec;
    private String aVac;
    private String aNeut;
    private String aDead;
    private String aMemo;
    private String aGallery;

    public String getaNum() {
        return aNum;
    }

    public String getaName() {
        return aName;
    }

    public int getaAge() {
        return aAge;
    }

    public String getaArea() {
        return aArea;
    }

    public String getaSex() {
        return aSex;
    }

    public String getaSpec() {
        return aSpec;
    }

    public String getaVac() {
        return aVac;
    }

    public String getaNeut() {
        return aNeut;
    }

    public String getaDead() {
        return aDead;
    }

    public String getaMemo() {
        return aMemo;
    }

    public String getaGallery() {
        return aGallery;
    }
}
