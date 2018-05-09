package com.whp.jpa.model;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * 
 * @描述：公共字段映射
 *
 * @作者：whp
 * 
 * @时间：2018年5月9日 下午9:15:49
 */
@MappedSuperclass
public class IDEntity {
    
    private Long id ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}