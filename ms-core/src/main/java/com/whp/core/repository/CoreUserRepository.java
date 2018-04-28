package com.whp.core.repository;

import com.whp.core.pojo.CoreUser;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @描述：用户表(dao接口).
 * 
 * @作者：wuhp
 * 
 * @时间: 2018-04-28
 */
public interface CoreUserRepository extends JpaRepository<CoreUser, Long> {


}