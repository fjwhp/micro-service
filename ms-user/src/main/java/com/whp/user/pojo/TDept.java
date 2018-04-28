package com.whp.user.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @描述：部门表(实体类).
 * 
 * @作者：wuhp
 * 
 * @时间: 2018-04-27
 */

@Entity
@Table(name="t_dept")
@NamedQuery(name="TDept.findAll", query="SELECT t FROM TDept t")
public class TDept implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
	@Column(name="dept_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deptId;
    /**
     * 部门名称
     */
	@Column(name="dept_name11")
	private String deptName11;
	@Column(name="samill")
	private Integer samill;
	@Column(name="sdssss")
	private Double sdssss;
	@Column(name="ddd")
	private BigDecimal ddd;
	@Column(name="ttt")
	private Date ttt;
	@Column(name="bb")
	private Blob bb;


	public Long getDeptId() {
		return deptId;
	}

	public TDept setDeptId(Long deptId) {
		this.deptId = deptId;
		return this;
	}

	public String getDeptName11() {
		return deptName11;
	}

	public TDept setDeptName11(String deptName11) {
		this.deptName11 = deptName11;
		return this;
	}

	public Integer getSamill() {
		return samill;
	}

	public TDept setSamill(Integer samill) {
		this.samill = samill;
		return this;
	}

	public Double getSdssss() {
		return sdssss;
	}

	public TDept setSdssss(Double sdssss) {
		this.sdssss = sdssss;
		return this;
	}

	public BigDecimal getDdd() {
		return ddd;
	}

	public TDept setDdd(BigDecimal ddd) {
		this.ddd = ddd;
		return this;
	}

	public Date getTtt() {
		return ttt;
	}

	public TDept setTtt(Date ttt) {
		this.ttt = ttt;
		return this;
	}

	public Blob getBb() {
		return bb;
	}

	public TDept setBb(Blob bb) {
		this.bb = bb;
		return this;
	}

}
