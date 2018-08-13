package com.whp.demo.entity;

import com.whp.base.entity.SuperEntity;

/**
 * 
 * @描述：(实体类).
 * 
 * @作者：whp
 * 
 * @时间: 2018-08-13
 */
public class DemoUser extends SuperEntity<DemoUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
	private String userName;
    /**
     * 邮箱
     */
	private String email;


	public String getUserName() {
		return userName;
	}

	public DemoUser setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public DemoUser setEmail(String email) {
		this.email = email;
		return this;
	}

}
