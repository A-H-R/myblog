package com.mouse.service;
/*
 *created by mouse on 2020/2/7
 */

import com.mouse.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    //  后端
    Tag getOneTag(Long id);
    Tag saveTag(Tag tag);
    void deleteTag(Long id);
    Page<Tag> pageTag(Pageable pageable);
    List<Tag> listTag();

    Tag getTagByName(String name);

    //  前端

}
