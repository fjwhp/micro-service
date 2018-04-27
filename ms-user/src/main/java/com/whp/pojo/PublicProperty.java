package com.whp.pojo;
import java.sql.Date;

/**
 * 
 * @描述：公共属性
 *
 * @作者：whp
 * 
 * @时间：2018年4月27日 下午8:45:58
 */
public class PublicProperty {

	/**
	 * 创建人id
	 */
	private long createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改人
	 */
	private long updateByUserId;
	/**
	 * 修改时间
	 */
	private Date UpdateTime;
	public long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public long getUpdateByUserId() {
		return updateByUserId;
	}
	public void setUpdateByUserId(long updateByUserId) {
		this.updateByUserId = updateByUserId;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	
	
}
