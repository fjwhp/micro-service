package com.whp.config.mybatis.superentity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotations.TableId;

public class SuperEntity {
	

	/**
	 * 主键ID
	 */
	@TableId("test_id")
	private Long id;

	private Date createTime;
	private Long createby;

	private Date updateTime;
	private Long updateby;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateby() {
		return createby;
	}

	public void setCreateby(Long createby) {
		this.createby = createby;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUpdateby() {
		return updateby;
	}

	public void setUpdateby(Long updateby) {
		this.updateby = updateby;
	}

}
