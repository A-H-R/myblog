package com.mouse.dao;
/*
 *created by mouse on 2020/2/5
 */

import com.mouse.po.Article;
import com.mouse.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long>, JpaSpecificationExecutor<Article> {

    @Query("select a from Article a where a.status = true")
    Page<Article> findShowArticle(Pageable pageable);

    Article findArticleByIdAndStatus(Long id,Boolean status);

    @Transactional
    @Modifying
    @Query("update Article a set a.views = a.views+1 where a.id = ?1")
    int updateViews(Long id);



    List<Article> findArticlesByTypeAndStatus(Type type,Boolean status);


}
