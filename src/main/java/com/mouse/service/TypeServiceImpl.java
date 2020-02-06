package com.mouse.service;

import com.mouse.dao.TypeRepository;
import com.mouse.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public Type updateStatus(Long id) {
        Type type = typeRepository.getOne(id);
        type.setPublic(true);
        typeRepository.save(type);
        return null;
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public Page<Type> pageType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }
}
