package com.whp.model.dao.entity;

import java.math.BigDecimal;
import java.querys.Blob;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @描述：(实体类).
 * 
 * @作者：wuhp
 * 
 * @时间: 2018-04-27
 */

@Entity
@Table("dept")
@NamedQuery(name="Dept.findAll", query="SELECT t FROM Dept t")
public class Dept implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
	@Column(name="dept_id",columnDefinition="部门id")
	private Long deptId;
    /**
     * 部门名称
     */
	@Column(name="dept_name11",columnDefinition="部门名称")
	private String deptName11;
	@Column(name="smallint",columnDefinition="")
	private Integer smallint;
	@Column(name="sdssss",columnDefinition="")
	private Double sdssss;
	@Column(name="ddd",columnDefinition="")
	private BigDecimal ddd;
	@Column(name="ttt",columnDefinition="")
	private Date ttt;
	@Column(name="bb",columnDefinition="")
	private Blob bb;


	public Long getDeptId() {
		return deptId;
	}

	public Dept setDeptId(Long deptId) {
		this.deptId = deptId;
		return this;
	}

	public String getDeptName11() {
		return deptName11;
	}

	public Dept setDeptName11(String deptName11) {
		this.deptName11 = deptName11;
		return this;
	}

	public Integer getSmallint() {
		return smallint;
	}

	public Dept setSmallint(Integer smallint) {
		this.smallint = smallint;
		return this;
	}

	public Double getSdssss() {
		return sdssss;
	}

	public Dept setSdssss(Double sdssss) {
		this.sdssss = sdssss;
		return this;
	}

	public BigDecimal getDdd() {
		return ddd;
	}

	public Dept setDdd(BigDecimal ddd) {
		this.ddd = ddd;
		return this;
	}

	public Date getTtt() {
		return ttt;
	}

	public Dept setTtt(Date ttt) {
		this.ttt = ttt;
		return this;
	}

	public Blob getBb() {
		return bb;
	}

	public Dept setBb(Blob bb) {
		this.bb = bb;
		return this;
	}

}
