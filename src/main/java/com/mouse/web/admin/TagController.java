package com.mouse.web.admin;
/*
 *created by mouse on 2020/2/7
 */


import com.mouse.po.Tag;
import com.mouse.po.Type;
import com.mouse.service.ArticleService;
import com.mouse.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/tag")
public class TagController {

    private final int pageSize = 6;

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String toTag(@PageableDefault(size = pageSize,sort = {"id"},direction = Sort.Direction.ASC) Pageable pageable,
                        Model model) {
        model.addAttribute("tag", tagService.pageTag(pageable));
        return "admin/tag";
    }

    /*
    //  废弃了
    @GetMapping("/editTag/{id}")
    public String editTag(@PathVariable Long id,Model model) {
        Type type = new Type();
        model.addAttribute("type", type);
        if (id == -1) {
            //  新标签
            Tag tag  = new Tag();
            model.addAttribute("tag", tag);
        } else {
            //  修改标签
            model.addAttribute("tag", tagService.getOneTag(id));
        }
        return "admin/editTotal";
    }
    */

    @GetMapping("/deleteTag/{id}")
    public String deleteTag(@PathVariable Long id,RedirectAttributes attributes) {
        if (articleService.getByTag(tagService.getOneTag(id)).size() > 0) {
            attributes.addFlashAttribute("message", "想什么呢，还有文章用人家呢。");
            return "redirect:/admin/tag";
        }
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "你竟真的删了人家~");
        return "redirect:/admin/tag";
    }


    @PostMapping("/saveTag")
    public String saveTag(Tag tag, RedirectAttributes attributes) {

        if (tagService.getTagByName(tag.getName()) != null) {
            attributes.addFlashAttribute("message", "有人和人家重名了，爱我就删了它。");
            return "redirect:/admin/tag";
        }
        tagService.saveTag(tag);
        attributes.addFlashAttribute("message", "呦~，还成功了~~");
        return "redirect:/admin/tag";
    }



}
