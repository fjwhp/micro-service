package com.whp.user.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;

/**
 * 
 * @desc TDept(实体类)
 * @date 2018/05/09
 */
/**
 * 
 * @描述：TODO
 *
 * @作者：
 * 
 * @时间：
 */
@Entity
@Table(name = "t_dept")
@NamedQuery(name = "TDept.findAll", query = "SELECT t FROM TDept t")
public class TDept {
    /*
     *  主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id", length = 20, nullable = false, columnDefinition = "int(20) comment '主键'")
    private Long deptId;
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    /*
     *  创建时间
     */
    @Column(name = "create_date", columnDefinition = "timestamp comment '创建时间'")
    private java.util.Date createDate;
    /*
     *  部门名称
     */
    @Column(name = "dept_name", length = 19, columnDefinition = "varchar(19) comment '部门名称'")
    private String deptName;
    /*
     *  部门代码
     */
    @Column(name = "dept_code", length = 255, columnDefinition = "varchar(255) comment '部门代码'")
    private String deptCode;
    @Column(name = "relativ_id", length = 11)
    private Long relativId;
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    /*
     *  备注
     */
    @Column(name = "remark", columnDefinition = "datetime comment '备注'")
    private java.util.Date remark;

    // setter getter #####################################################################
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return this.deptId;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public void setRelativId(Long relativId) {
        this.relativId = relativId;
    }

    public Long getRelativId() {
        return this.relativId;
    }

    public void setRemark(java.util.Date remark) {
        this.remark = remark;
    }

    public java.util.Date getRemark() {
        return this.remark;
    }

}