package com.example.igonan.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImageDTO {

    private int num;
    private int fNum;
    private String imgSrc;


    public int getNum() {
        return num;
    }

    public int getfNum() {
        return fNum;
    }

    public String getImgSrc() {
        return imgSrc;
    }
}
