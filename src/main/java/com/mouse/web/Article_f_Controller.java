package com.mouse.web;

import com.mouse.po.Article;
import com.mouse.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *created by mouse on 2020/2/8
 */
@Controller
public class Article_f_Controller {

    @Autowired
    private ArticleService articleService;



    @GetMapping()
    public String index(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("articles", articleService.listArticleByTime(pageable));
        return "index";
    }



    @GetMapping("/time")
    public String toTime (Model model) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "updateTime");
        Pageable pageable = PageRequest.of(0,10000,Sort.by(order));
        model.addAttribute("articles", articleService.listArticleByTime(pageable));
        return "byTime";
    }

    @GetMapping("/article/{id}")
    public String toDetail(@PathVariable Long id, Model model) {

        model.addAttribute("article", articleService.getAndConvert(id));

        return "detail";
    }






}
