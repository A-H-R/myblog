package com.mouse.web;
/*
 *created by mouse on 2020/2/21
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AboutMe_f_controller {
    @GetMapping("/aboutme")
    public String toMe(){
        return "aboutme";
    }
}
