package com.mouse.web.admin;
/*
 *created by mouse on 2020/2/7
 */


import com.mouse.po.Tag;
import com.mouse.po.Type;
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

@Controller
@RequestMapping("/admin/tag")
public class TagController {

    private final int pageSize = 3;


    @Autowired
    private TagService tagService;

    @GetMapping
    public String toTag(@PageableDefault(size = pageSize,sort = {"id"},direction = Sort.Direction.ASC) Pageable pageable,
                        Model model) {
        model.addAttribute("tag", tagService.pageTag(pageable));
        return "admin/tag";
    }

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




    @GetMapping("/deleteTag/{id}")
    public String deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "redirect:/admin/tag";
    }


    @PostMapping("/saveTag")
    public String saveTag(Tag tag) {
        tagService.saveTag(tag);
        return "redirect:/admin/tag/editTag/-1";
    }





}
