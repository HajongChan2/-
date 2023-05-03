package com.example.igonan.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetdogDTO {

    private String pdNum;
    private String pdName;
    private int pdAge;
    private String pdDate;
    private String pdSex;
    private String pdSize;
    private String pdSpec;
    private String pdVac;
    private String pdNeut;
    private String pdMemo;
    private String pdGallery;

    public String getPdNum() {
        return pdNum;
    }

    public String getPdName() {
        return pdName;
    }

    public int getPdAge() {
        return pdAge;
    }

    public String getPdDate() {
        return pdDate;
    }

    public String getPdSex() {
        return pdSex;
    }

    public String getPdSize() {
        return pdSize;
    }

    public String getPdSpec() {
        return pdSpec;
    }

    public String getPdVac() {
        return pdVac;
    }

    public String getPdNeut() {
        return pdNeut;
    }

    public String getPdMemo() {
        return pdMemo;
    }

    public String getPdGallery() {
        return pdGallery;
    }
}
