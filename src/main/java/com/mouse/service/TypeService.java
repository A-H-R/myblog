package com.mouse.service;
/*
 *created by mouse on 2020/2/6
 */

import com.mouse.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {


    //  数据库
    Type getOneType(Long id);
    Type saveType(Type type);
    Type updateStatus(Long id);
    void deleteType(Long id);

    //  页面显示

    Page<Type> pageType(Pageable pageable);




}
