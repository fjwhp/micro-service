<#-- TODO 改为实际使用的包名 -->
package com.able.model ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;

 /**
 * 
 * @描述：TODO
 *
 * @作者：wuhp
 * 
 * @时间：${.now?string("yyyy/MM/dd")}
 */
@Entity
@Table(name = "${tableName}",catalog="" )
@NamedQuery(name = "${className}.findAll", query = "SELECT t FROM ${className} t")
public class ${className} extends IDEntity{
	<#list columns as column>
	<#if column.propertyType == "java.util.Date">
	@javax.persistence.Temporal(javax.persistence.TemporalType
	<#if column.columnType == "DATE" || column.columnType == "date">
	.DATE
	<#else>
	.TIMESTAMP
	</#if>)
	</#if>
	<#assign autograph = "private " + column.propertyType + " " + column.propertyName + " ;">
	<#if column.propertyName != "id">
		<#if (column.columnComment?? && column.columnComment?length > 0)>
	/*
	 *  ${column.columnComment}
	 */
	 <#if column.columnKey=='PRI'>
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	</#if>
	@Column(name = "${column.columnName}"<#if column.columnSize != 0> ,length = ${column.columnSize}</#if><#if column.isNullable == "NO"> ,nullable = false</#if><#if column.columnKey == "UNI"> ,unique = true</#if> ,columnDefinition="${column.columnType} <#if column.columnComment!=''>comment '${column.columnComment}'"</#if>)
	${autograph}
		<#else>
	@Column(name = "${column.columnName}"<#if column.columnSize != 0> ,length = ${column.columnSize}</#if><#if column.isNullable == "NO"> ,nullable = false</#if><#if column.columnKey == "UNI"> ,unique = true</#if>)	
	${autograph}
		</#if>
	</#if>
	</#list>	
	
	//  setter  getter     #####################################################################
	<#list columns as column>
	<#if column.propertyName != "id">
	public void set${column.propertyName?cap_first} (${column.propertyType} ${column.propertyName}){
		this.${column.propertyName} = ${column.propertyName} ;
	}
	
	public ${column.propertyType} get${column.propertyName?cap_first} (){
		return this.${column.propertyName} ;
	}
	
	</#if>
	</#list>	
}