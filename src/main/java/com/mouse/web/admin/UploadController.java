package com.mouse.web.admin;

import org.springframework.stereotype.Controller;
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

    @GetMapping("/admin/text")
    public String toTest() {
        return "test";
    }


    @RequestMapping(value = "/admin/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "上传失败";
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        byte[] bytes = file.getBytes();
        Path path = Paths.get(FILE_UPLOAD_PATH + fileName);
        Files.write(path, bytes);
        return "上传成功";
    }
}
