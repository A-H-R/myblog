package com.mouse.service;
/*
 *created by mouse on 2020/2/5
 */

import com.mouse.dao.ArticleRepository;
import com.mouse.po.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    //  保存一份文章
    @Override
    public Article saveArticle(Article article) {
        if (article.getId() == null){
            //  新编辑的一份文章
            article.setCreateTime(new Date());
            article.setUpdateTime(new Date());
            article.setViews(0);
        } else {
            //  修改文章
            article.setUpdateTime(new Date());
        }
        return articleRepository.save(article);
    }

    @Override
    public Article getOneArticle(Long id) {
        return articleRepository.getOne(id);
    }

    //  初始化页面时，充实表格
    @Override
    public Page<Article> listArticle(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }


    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
