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
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;

@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Autowired
    private ArticleService articleService;




    //  创建Pageable
    //    Sort sort = new Sort(Sort.Direction.DESC,"updateTime");
    //    Pageable pageable = new PageRequest(0, size, sort);

    @GetMapping("/article")
    public String toArticle(@PageableDefault(size = 3,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                            Model model) {
        model.addAttribute("articles", articleService.listArticle(pageable));
        return "admin/article";
    }

    //  跳转到编写页面
    @GetMapping("/editArticle/{id}")
    public String toEditArticle(@PathVariable Long id,Model model) {
        if (id == -1){
            Article article = new Article();
            article.setStatus(false);
            model.addAttribute("article", article);
            return "admin/editArticle";
        } else {
            Article article = articleService.getOneArticle(id);
            //  分类和标签没有做

            model.addAttribute("article", article);
            return "admin/editArticle";
        }

    }

    //修改或新增一个文章
    @PostMapping("/article")
    public String SaveOrModifyArticle(Article article, RedirectAttributes attributes) throws ParseException {

        Article a = articleService.saveArticle(article);

        return "redirect:/admin/index";
    }

    //  发布文章按钮
    @GetMapping("/publish/{id}")
    public String publishArticle(@PathVariable Long id) {
        articleService.updateArticle(id);
        return "redirect:/admin/article";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/admin/article";
    }




}
