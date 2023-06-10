package com.example.igonan.util;

public class countDTO {

    private String status;
    private Integer count;
    public countDTO(){
        super();
    }
    public countDTO(String status,Integer count){
        super();
        this.status=status;
        this.count=count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


