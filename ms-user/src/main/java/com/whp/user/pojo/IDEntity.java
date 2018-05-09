package com.whp.user.pojo;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * 公共主键映射
 * @author  ZhangLiKun
 * @title   IDEntity
 * @date    2013-6-6
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