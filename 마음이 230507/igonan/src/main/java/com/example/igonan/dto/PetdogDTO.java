package com.example.igonan.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetdogDTO {

    private String petNum;
    private String petName;
    private int petAge;
    private String petDate;
    private String petSex;
    private String petSize;
    private String petSpec;
    private String petVac;
    private String petNeut;
    private String petMemo;
    private String petGallery;

    public String getpetNum() {
        return petNum;
    }

    public String getpetName() {
        return petName;
    }

    public int getpetAge() {
        return petAge;
    }

    public String getpetDate() {
        return petDate;
    }

    public String getpetSex() {
        return petSex;
    }

    public String getpetSize() {
        return petSize;
    }

    public String getpetSpec() {
        return petSpec;
    }

    public String getpetVac() {
        return petVac;
    }

    public String getpetNeut() {
        return petNeut;
    }

    public String getpetMemo() {
        return petMemo;
    }

    public String getpetGallery() {
        return petGallery;
    }
}
