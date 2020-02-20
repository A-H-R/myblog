package com.mouse.web;

import com.mouse.po.Comment;
import com.mouse.service.CommentService;
import com.mouse.util.TimeString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *created by mouse on 2020/2/19
 */
@Controller
public class Comment_f_Controller {

    @Autowired
    private CommentService commentService;


    //  首页提交留言
    @PostMapping("/postComment")
    public String postComment(Comment comment, RedirectAttributes attributes) {
        comment.setCreateTime(TimeString.getTime());
        comment.setStatus(false);
        Comment c = commentService.saveComment(comment);
        if (c == null) {
            attributes.addFlashAttribute("messageFlag", "error");
            attributes.addFlashAttribute("message", "出错了");
        } else {
            attributes.addFlashAttribute("messageFlag", "success");
            attributes.addFlashAttribute("message", "完美");
        }
        return "redirect:/";
    }
}
