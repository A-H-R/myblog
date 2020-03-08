package com.mouse.service;
/*
 *created by mouse on 2020/2/24
 */

import com.mouse.dao.ImageRepository;
import com.mouse.po.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Images> ListImages() {
        return imageRepository.findAll();
    }

    @Override
    public Images saveImage(Images image) {
        return imageRepository.save(image);
    }

    public Images getOneImage() {
        return imageRepository.getOne((long) 1);
    }


}
