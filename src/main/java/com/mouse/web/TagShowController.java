package com.mouse.web;

import com.mouse.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *created by mouse on 2020/2/12
 */
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public String toTag (Model model) {
        model.addAttribute("tags", tagService.listTag());
        System.out.println(tagService.listTag());
        return "tag";
    }
}
