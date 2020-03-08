package com.mouse.web.admin;

import com.mouse.po.Images;
import com.mouse.service.ImageService;
import com.mouse.util.TimeString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 *created by mouse on 2020/2/18
 */
@Controller
public class UploadController {
    private final static String FILE_UPLOAD_PATH = "src/main/resources/static/images/article/";

    @Autowired
    private ImageService imageService;

    @GetMapping("/admin/text")
    public String toTest() {
        return "test";
    }


    @RequestMapping(value = "/admin/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        //  保存图片
        String fileName = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        Path path = Paths.get(FILE_UPLOAD_PATH + fileName);
        Files.write(path, bytes);
        String imagePath = "/images/article/"+fileName;

        //  保存图片信息
//        Images image = new Images();
//        image.setCreateTime(TimeString.getTime());
//        image.setPath("/images/article/"+fileName);
//        imageService.saveImage(image);
        //  反馈
//        model.addAttribute("image", image);
        model.addAttribute("message", "上传成功");
        return "admin/editArticle :: imagesPart";
    }
}
