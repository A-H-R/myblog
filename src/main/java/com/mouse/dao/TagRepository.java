package com.mouse.dao;
/*
 *created by mouse on 2020/2/7
 */

import com.mouse.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {


    Tag findTagByName(String name);
}
