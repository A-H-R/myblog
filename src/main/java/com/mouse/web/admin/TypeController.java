package com.mouse.web.admin;
/*
 *created by mouse on 2020/2/6
 */

import com.mouse.po.Tag;
import com.mouse.po.Type;
import com.mouse.service.ArticleService;
import com.mouse.service.TypeService;
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
@RequestMapping("/admin/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private ArticleService articleService;

    //  跳转作用，跳转到分类页面展示
    @GetMapping("/sort")
    public String toType(@PageableDefault(size = 5,sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                         Model model) {
        model.addAttribute("type", typeService.pageType(pageable));
        return "admin/sort";
    }

    /*
    //  跳转到编辑页面
    @GetMapping("/editType/{id}")
    public String toEditType(@PathVariable Long id,Model model) {
        Tag tag = new Tag();
        model.addAttribute("tag", tag);
        if (id == -1) {
            //  添加分类按钮
            Type type = new Type();
            type.setStatus(false);
            model.addAttribute("type", type);
        } else {
            //  编辑按钮
            model.addAttribute("type", typeService.getOneType(id));
        }
        return "admin/editTotal";
    }

    @GetMapping("/updateTypeStatus/{id}")
    public String updateTypeStatus(@PathVariable Long id) {
        typeService.updateStatus(id);
        return "redirect:/admin/type/sort";
    }
    */


    @GetMapping("/deleteType/{id}")
    public String deleteType(@PathVariable Long id, RedirectAttributes attributes) {
        if (articleService.getArticleByType(typeService.getOneType(id)).size() > 0 ){
            attributes.addFlashAttribute("message", "还有文章呢，要删先删他们。");
            return "redirect:/admin/type/sort";
        }
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "呦~，小子，还真删了，不错啊");
        return "redirect:/admin/type/sort";
    }


    @PostMapping("/saveType")
    public String saveType(Type type,RedirectAttributes attributes) {
        if (typeService.getTypeByName(type.getName()) != null) {
            attributes.addFlashAttribute("message", "有人和老子重名了，不高兴");
            return "redirect:/admin/type/sort";
        }
        typeService.saveType(type);
        attributes.addFlashAttribute("message", "不错不错，真的加上了。");
        return "redirect:/admin/type/sort";
    }








}
