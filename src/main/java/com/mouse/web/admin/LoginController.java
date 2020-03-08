package com.mouse.web.admin;
/*
 *created by mouse on 2020/2/4
 */


import com.mouse.po.User;
import com.mouse.service.CommentService;
import com.mouse.service.UserService;
import com.mouse.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public String toLogin(){
        return "admin/login";
    }

    @GetMapping("/index")
    public String toIndex(Model model) {

        model.addAttribute("commentNum", commentService.getCommentNum());
        return "admin/index";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) throws NoSuchAlgorithmException {
        User user = userService.checkUser(username, MD5Utils.code(password));
        if (user != null) {
            //  查到
            user.setPassword(null);
            session.setAttribute("user", user);
            return "redirect:/admin/index";
        } else {
            //  失败
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }

    }



}
