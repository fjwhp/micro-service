package com.whp.user.repository;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.whp.user.entity.User;
@CacheConfig(cacheNames="users")
public interface UserRepository extends  JpaRepository<User, Long> {

    @Cacheable(key="#p0")
    User findByUserName(String userName);

    User findByUserNameAndPwd(String userName, String pwd);

    @Query("from User u where u.userName=:userName")
    User findUser(@Param("userName") String userName);

    @Transactional  
    @Modifying
    @CacheEvict(key="#p1")
    @Query("update User u set u.email=:email where u.userName=:userName")
    void updateUser(@Param("email")String eamil,@Param("userName")String user);
    
}
