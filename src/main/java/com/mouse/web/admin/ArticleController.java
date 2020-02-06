package com.mouse.web.admin;
/*
 *created by mouse on 2020/2/5
 */

import com.mouse.po.Article;
import com.mouse.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Autowired
    private ArticleService articleService;




    //  创建Pageable
    //    Sort sort = new Sort(Sort.Direction.DESC,"updateTime");
    //    Pageable pageable = new PageRequest(0, size, sort);

    @GetMapping("/article")
    public String toArticle(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                            Model model) {
        model.addAttribute("articles", articleService.listArticle(pageable));
        return "admin/article";
    }

    @GetMapping("/editArticle")
    public String toEditArticle() {
        return "admin/editArticle";
    }

    //修改或新增一个文章
    @PostMapping("/article")
    public String SaveOrModifyArticle(Article article, RedirectAttributes attributes){
        Article a;

        if (article.getId() == null) {
            //  新文章
            a = articleService.saveArticle(article);
        } else {
            //
        }


        return "redirect:/admin/index";
    }






}
