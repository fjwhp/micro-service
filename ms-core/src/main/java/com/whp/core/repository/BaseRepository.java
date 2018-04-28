package com.whp.core.repository;

import java.io.Serializable;
/**
 * 
 * @描述：基础Repository文件
 *
 * @作者：whp
 * 
 * @时间：2018年4月28日 下午9:19:27
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.whp.core.pojo.CoreUser;
public interface BaseRepository <T, ID extends Serializable> extends  JpaRepository<CoreUser, Long> {

}
