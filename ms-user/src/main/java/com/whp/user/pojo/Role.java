package com.whp.user.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	@Column(columnDefinition="varchar(20) comment '角色名称'")
	private String roleName;
	@Column(columnDefinition="varchar(20) comment '创建人id'")
	private long createUserId;
}
