package com.mouse.service;

import com.mouse.dao.CommentRepository;
import com.mouse.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *created by mouse on 2020/2/19
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        if (comment.getParentComment().getId() == -1) {
            //  没有父级评论
            comment.setParentComment(null);
        } else {
            comment.setParentComment(commentRepository.getOne(comment.getParentComment().getId()));
        }
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateStatus(Long id) {
        Comment c =commentRepository.getOne(id);
        c.setStatus(true);
        return commentRepository.save(c);
    }

    @Override
    public Comment getOneComment(Long id) {
        return commentRepository.getOne(id);
    }

    @Override
    public int getCommentNum() {
        return commentRepository.getCommentByStatus(false).size();
    }

    @Override
    public Page<Comment> PageComment(Pageable pageable) {
        return commentRepository.PageAllVisitorComment(pageable);
    }

    @Override
    public Page<Comment> PageComment(Pageable pageable,boolean status) {
        return commentRepository.getCommentByStatus(pageable,false);
    }
}
