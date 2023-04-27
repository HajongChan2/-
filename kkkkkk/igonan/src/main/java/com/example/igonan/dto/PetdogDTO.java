package com.example.igonan.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetdogDTO {


    private String num;
    private String name;
    private String age;
    private String area;
    private String sex;
    private String spec;
    private String vac;
    private String neut;
    private String dead;
    private String memo;
    private String gallery;


    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getArea() {
        return area;
    }

    public String getSex() {
        return sex;
    }

    public String getSpec() {
        return spec;
    }

    public String getVac() {
        return vac;
    }

    public String getNeut() {
        return neut;
    }

    public String getDead() {
        return dead;
    }

    public String getMemo() {
        return memo;
    }

    public String getGallery() {
        return gallery;
    }
}
