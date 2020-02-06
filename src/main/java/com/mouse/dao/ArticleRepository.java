package com.mouse.dao;
/*
 *created by mouse on 2020/2/5
 */

import com.mouse.po.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}
