package com.whp.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whp.core.pojo.CoreUser;
/**
 * 
 * @描述：用户表(dao接口).
 * 
 * @作者：wuhp
 * 
 * @时间: 2018-04-28
 */
public interface CoreUserRepository extends JpaRepository<CoreUser, Long> {

    List<CoreUser> findAll();
}