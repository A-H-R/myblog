package com.mouse.service;
/*
 *created by mouse on 2020/2/24
 */

import com.mouse.po.Images;


import java.awt.*;
import java.util.List;

public interface ImageService {

    List<Images> ListImages();

    Images saveImage(Images image);
    Images getOneImage();
}
