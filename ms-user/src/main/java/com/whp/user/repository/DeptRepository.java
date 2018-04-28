package com.whp.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whp.user.pojo.TDept;
public interface DeptRepository extends  JpaRepository<TDept, Long> {

    List<TDept> findAll();
    
}
