package com.mouse.service;
/*
 *created by mouse on 2020/2/19
 */

import com.mouse.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    //  保存评论
    Comment saveComment(Comment comment);

    //  更新状态
    Comment updateStatus(Long id);

    //  获取一个评论
    Comment getOneComment(Long id);

    //  获取未读评论数量
    int getCommentNum();
    //  获取分页评论
    Page<Comment> PageComment(Pageable pageable);
    //  获取未读的分页评论
    Page<Comment> PageComment(Pageable pageable,boolean status);

}
