package com.mouse.web.admin;

import com.mouse.po.Comment;
import com.mouse.po.User;
import com.mouse.service.CommentService;
import com.mouse.service.util.EmailService;
import com.mouse.util.TimeString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/*
 *created by mouse on 2020/2/19
 */
@Controller
@RequestMapping("/admin")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private EmailService emailService;

    //  评论页面，显示未读评论
    @GetMapping("/comment")
    public String toComment(@PageableDefault(size = 12, sort = {"createTime"},direction = Sort.Direction.DESC) Pageable pageable,
                            Model model){
        model.addAttribute("comments", commentService.PageComment(pageable));
        return "admin/comment";
    }

    @PostMapping("/reply")
    public String replyComment(Comment comment, HttpSession session, RedirectAttributes attributes) {
        //  设置父级评论
        Long id = comment.getParentComment().getId();
        comment.setParentComment(commentService.getOneComment(id));
        //  设置状态未读
        comment.setStatus(false);
        //   设置回复人信息
        User user = (User) session.getAttribute("user");
        comment.setEmail(user.getEmail());
        comment.setNickname(user.getUsername());
        //  设置时间
        comment.setCreateTime(TimeString.getTime());
        //  保存管理员的回复
        commentService.saveComment(comment);
        //  更新父级状态
        commentService.updateStatus(id);

        //  邮件回复留言者
        Comment parent = commentService.getOneComment(id);
        String content = "关于'"+parent.getContent()+"'的回复\n==>" + comment.getContent();
        emailService.sendSimpleMail(parent.getEmail(),"回复您的留言",content);

        attributes.addFlashAttribute("message", "成功回复");

        return "redirect:/admin/comment";
    }



}
