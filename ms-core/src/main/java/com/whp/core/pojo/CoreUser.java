package com.whp.core.pojo;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @描述：用户表(实体类).
 * 
 * @作者：wuhp
 * 
 * @时间: 2018-04-29
 */

@Entity
@Table(name="core_user")
@NamedQuery(name="CoreUser.findAll", query="SELECT t FROM CoreUser t")
public class CoreUser implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * 用户Id 主键
     */
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long userId;
    /**
     * 用户登录名字
     */
	@Column(name="user_name")
	private String userName;
    /**
     * 用户密码
     */
	@Column(name="user_pwdr")
	private String userPwdr;
    /**
     * 是否冻结
     */
	@Column(name="is_active")
	private Integer isActive;
    /**
     * 修改人ID
     */
	@Column(name="update_user_id")
	private Long updateUserId;
    /**
     * 修改时间
     */
	@Column(name="update_time")
	private Date updateTime;
    /**
     * 修改人登录帐号
     */
	@Column(name="update_user_name")
	private String updateUserName;
    /**
     * 平台
     */
	@Column(name="platform")
	private Integer platform;


	public Long getUserId() {
		return userId;
	}

	public CoreUser setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public CoreUser setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getUserPwdr() {
		return userPwdr;
	}

	public CoreUser setUserPwdr(String userPwdr) {
		this.userPwdr = userPwdr;
		return this;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public CoreUser setIsActive(Integer isActive) {
		this.isActive = isActive;
		return this;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public CoreUser setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public CoreUser setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public CoreUser setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
		return this;
	}

	public Integer getPlatform() {
		return platform;
	}

	public CoreUser setPlatform(Integer platform) {
		this.platform = platform;
		return this;
	}
	/**
	 * 版本号
	 */
	 @Column(name="version") 
	private Integer version;
	/**
	 * 是否删除 1 是 ，0否
	 */
	 @Column(name="is_delete")
	private String isDelete;
	/**
     * 创建时间
     */
	@Column(name="create_time")
	private Date createTime;
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public CoreUser setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
}
