package com.zyq.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Catfish on 18/4/8.
 */
@Mapper
public interface SysUserRoleDao {
    @Insert("INSERT INTO SYS_USER_ROLE(id,uid) VALUES(#{id},#{uid})")
    public void insertUserRole(@Param("id") String id, @Param("uid") String uid);
}
