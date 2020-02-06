package com.mouse.service;
/*
 *created by mouse on 2020/2/5
 */

import com.mouse.po.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ArticleService {

    Article saveArticle(Article article);

    Article getOneArticle(Long id);

    Page<Article> listArticle(Pageable pageable);

    void deleteArticle(Long id);
}
