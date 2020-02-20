package com.mouse.service;
/*
 *created by mouse on 2020/2/6
 */

import com.mouse.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {


    // 后端
    Type getOneType(Long id);
    Type saveType(Type type);
    Type updateStatus(Long id);
    void deleteType(Long id);
    Page<Type> pageType(Pageable pageable);
    List<Type> listType();

    //  前端
    List<Type> showType();

    Type showOneType(Long id);



}
