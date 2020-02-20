package com.mouse.dao;
/*
 *created by mouse on 2020/2/19
 */

import com.mouse.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("select c from Comment c where c.parentComment is null ")
    Page<Comment> PageAllVisitorComment(Pageable pageable);

    //  根据状态获取分页评论
    @Query("select c from Comment c where c.status = ?2 and c.parentComment is null ")
    Page<Comment> getCommentByStatus(Pageable pageable, Boolean status);

    //  根据状态获取评论列表
    @Query("select c from Comment c where c.status = ?1 and c.parentComment is null ")
    List<Comment> getCommentByStatus(Boolean status);
}
