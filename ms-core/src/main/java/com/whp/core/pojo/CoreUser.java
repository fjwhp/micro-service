package com.whp.core.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the core_user database table.
 * 
 */
@Entity
@Table(name = "core_user")
@NamedQuery(name = "CoreUser.findAll", query = "SELECT c FROM CoreUser c")
public class CoreUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user_id")
    private BigInteger createUserId;

    @Column(name = "create_user_name")
    private String createUserName;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "is_delete")
    private String isDelete;

    private int platform;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user_id")
    private BigInteger updateUserId;

    @Column(name = "update_user_name")
    private String updateUserName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pwd")
    private String userPwd;

    private int version;

    public CoreUser() {}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigInteger getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(BigInteger createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return this.createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public int getIsActive() {
        return this.isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public int getPlatform() {
        return this.platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigInteger getUpdateUserId() {
        return this.updateUserId;
    }

    public void setUpdateUserId(BigInteger updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return this.updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return this.userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}