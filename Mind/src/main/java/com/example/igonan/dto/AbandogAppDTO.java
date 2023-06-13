package com.example.igonan.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AbandogAppDTO {
    private int num;
    private String id;
    private String name;
    private int dognum;
    private String dogname;
    private String phone;
    private String addr;
    private String saddr;
    private String memo;
    private String date;

    public int getNum() {
        return num;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDognum() {
        return dognum;
    }

    public String getDogname() {
        return dogname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddr() {
        return addr;
    }

    public String getSaddr() {
        return saddr;
    }

    public String getMemo() {
        return memo;
    }

    public String getDate() {
        return date;
    }
}
