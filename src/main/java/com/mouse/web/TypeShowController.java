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
import org.springframework.web.bind.annotation.PathVariable;

/*
 *created by mouse on 2020/2/12
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/category/{id}")
    public String toCategory(@PathVariable Long id, Model model) {
        model.addAttribute("types", typeService.listType());

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "updateTime");
        Pageable pageable = PageRequest.of(0,10000,Sort.by(order));

        if (id == -1) {
            model.addAttribute("flag", id);
            model.addAttribute("articles", articleService.listArticleByTime(pageable));
        } else {
            model.addAttribute("flag", typeService.getOneType(id).getName());
            model.addAttribute("articles", typeService.getOneType(id).getArticles());
        }

        return "category";
    }
}
