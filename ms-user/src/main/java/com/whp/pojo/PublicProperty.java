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
	/**
	 * 版本
	 */
	private Integer version;
	/**
	 * 是否有效 1有效，0无效
	 */
	private Integer isValid;
	/**
	 * 是否删除-系统逻辑删除，1是，0否
	 */
	private Integer isDelete;
	
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
}
