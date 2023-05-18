package com.example.igonan.util;




import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class loggedInSession {


    private String name;
    private String pw;
    public String getName() {
        return name;
    }
    public String getPw() {
        return pw;
    }
}
