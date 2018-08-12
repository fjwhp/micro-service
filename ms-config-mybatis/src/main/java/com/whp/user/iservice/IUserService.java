package com.whp.user.iservice;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

public interface IUserService<User> extends IService<User> {

	boolean deleteAll();

	public List<User> selectListBySQL();

	public List<User> selectListByWrapper(Wrapper wrapper);
}
