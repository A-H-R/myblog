package com.mouse.service;

import com.mouse.dao.TypeRepository;
import com.mouse.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *created by mouse on 2020/2/6
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type getOneType(Long id) {
        return typeRepository.getOne(id);
    }

    @Override
    public Type saveType(Type type) {
//        if (type.getId() == null) {
//            //  新增分类
//            return typeRepository.save(type);
//        } else {
//            // 修改分类
//
//        }
        return typeRepository.save(type);
    }

    @Override
    public Type updateStatus(Long id) {
        Type type = typeRepository.getOne(id);
        type.setStatus(true);
        return typeRepository.save(type);
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public Page<Type> pageType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }
}
