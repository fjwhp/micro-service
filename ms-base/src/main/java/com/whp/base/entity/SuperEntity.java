package com.whp.base.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @描述：实体父类
 *
 * @作者：whp
 *
 * @时间：2017年4月24日 下午12:27:26
 */

public class SuperEntity<T extends Model<T>> extends Model<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4325616953838672659L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@TableField(strategy = FieldStrategy.IGNORED, value = "sid")
	@ApiModelProperty(value = "主键ID", required = false, hidden = true)
	private Integer sid;
	/**
	 * 创建用户ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@TableField(strategy = FieldStrategy.IGNORED, value = "create_by")
	@ApiModelProperty(value = "创建用户ID", required = false, hidden = true)
	private Integer createBy;
	/**
	 * 创建时间
	 */
	@TableField(strategy = FieldStrategy.IGNORED, value = "create_time")
	@ApiModelProperty(value = "创建时间", required = false, hidden = true)
	private Date createTime;
	/**
	 * 修改用户ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@TableField(strategy = FieldStrategy.IGNORED, value = "update_by")
	@ApiModelProperty(value = "修改用户ID", required = false, hidden = true)
	private Integer updateBy;
	/**
	 * 修改时间
	 */
	@TableField(strategy = FieldStrategy.IGNORED, value = "update_time")
	@ApiModelProperty(value = "修改时间", required = false, hidden = true)
	private Date updateTime;
	/**
	 * 版本号
	 */
	@TableField(strategy = FieldStrategy.IGNORED, value = "version")
	@ApiModelProperty(value = "版本号", required = false, hidden = true)
	// @Version
	private Integer version;
	/**
	 * 是否已被删除
	 */
	@TableField(strategy = FieldStrategy.IGNORED, value = "delete_status")
	@TableLogic
	@ApiModelProperty(value = "是否已被删除", required = false, hidden = true)
	private Integer deleteStatus;

	/**
	 * 自动创建主键
	 */
	@Override
	protected Serializable pkVal() {
		return this.sid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	@Override
	public String toString() {
		return "Entity [sid=" + sid + ", createBy=" + createBy + ", createTime=" + createTime + ", updateBy=" + updateBy
				+ ", updateTime=" + updateTime + ", version=" + version + ", deleteStatus=" + deleteStatus + "]";
	}

}
