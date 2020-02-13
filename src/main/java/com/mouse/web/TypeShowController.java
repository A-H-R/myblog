package com.mouse.web;

import com.mouse.service.ArticleService;
import com.mouse.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *created by mouse on 2020/2/12
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/category")
    public String toCategory(Model model) {
        model.addAttribute("types", typeService.listType());


        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "updateTime");
        Pageable pageable = PageRequest.of(0,10000,Sort.by(order));
        model.addAttribute("articles", articleService.listArticleByTime(pageable));
        return "category";
    }
}
