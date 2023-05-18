package com.example.igonan.util;




import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class loggedInSession {


    private String name;

    public String getName() {
        return name;
    }
}
