package com.mouse.dao;
/*
 *created by mouse on 2020/2/6
 */

import com.mouse.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long> {

    @Query("select t from Type t where t.status = true ")
    List<Type> findShowType();

    Type findTypeByIdAndStatus(Long id,Boolean status);
}
