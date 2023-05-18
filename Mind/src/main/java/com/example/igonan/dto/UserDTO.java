package com.example.igonan.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private String num;
    private String name;
    private String id;
    private String pw;
    private String phone;
    private String addr;
    private String saddr;


    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getphone() {
        return phone;
    }

    public String getAddr() {
        return addr;
    }

    public String getSaddr() {
        return saddr;
    }
}

