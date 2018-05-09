package com.whp.user.pojo ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
/**
 * 
 * @desc	AutUser(实体类)
 * @date 	2018/05/09
 */
 /**
 * 
 * @描述：TODO
 *
 * @作者：
 * 
 * @时间：
 */
import javax.persistence.Table;
@Entity
@Table(name = "aut_user",catalog="")
@NamedQuery(name = "AutUser.findAll", query = "SELECT t FROM AutUser t")
public class AutUser extends IDEntity{
	/*
	 *  主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "aut_id" ,length = 11 ,nullable = false ,columnDefinition="int(11) comment '主键'")
	private Long autId ;
	/*
	 *  授权名字
	 */
	@Column(name = "aut_name" ,length = 255 ,nullable = false ,columnDefinition="varchar(255) comment '授权名字'")
	private String autName ;
	@javax.persistence.Temporal(javax.persistence.TemporalType
	.DATE
)
	/*
	 *  创建时间
	 */
	@Column(name = "create_time" ,columnDefinition="date comment '创建时间'")
	private java.util.Date createTime ;
	/*
	 *  浮点数
	 */
	@Column(name = "dec_num" ,columnDefinition="bigint(10) comment '浮点数'")
	private Long decNum ;
	@Column(name = "text_str")	
	private String textStr ;
	
	//  setter  getter     #####################################################################
	public void setAutId (Long autId){
		this.autId = autId ;
	}
	
	public Long getAutId (){
		return this.autId ;
	}
	
	public void setAutName (String autName){
		this.autName = autName ;
	}
	
	public String getAutName (){
		return this.autName ;
	}
	
	public void setCreateTime (java.util.Date createTime){
		this.createTime = createTime ;
	}
	
	public java.util.Date getCreateTime (){
		return this.createTime ;
	}
	
	public void setDecNum (Long decNum){
		this.decNum = decNum ;
	}
	
	public Long getDecNum (){
		return this.decNum ;
	}
	
	public void setTextStr (String textStr){
		this.textStr = textStr ;
	}
	
	public String getTextStr (){
		return this.textStr ;
	}
	
}