package com.mouse.dao;
/*
 *created by mouse on 2020/2/24
 */

import com.mouse.po.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Images,Long> {

    Images findImagesByPath(String path);
}
