package com.example.igonan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sibal {

    public class mangoCon {

        @RequestMapping("/mango")
        public String newArticleForm() {
            return "mango";
        }
    }



}
