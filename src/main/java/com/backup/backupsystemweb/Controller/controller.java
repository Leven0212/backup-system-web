package com.backup.backupsystemweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

    @GetMapping("/")
    public static String main_page() {
        return "index";
    }
}
