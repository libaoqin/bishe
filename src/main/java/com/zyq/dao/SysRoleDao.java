package com.zyq.dao;

import com.zyq.entity.SysRoleEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by Catfish on 18/4/8.
 */
@Mapper
public interface SysRoleDao {
    @Insert("INSERT INTO SYS_ROLE(id,role) VALUES(#{id},#{role})")
    public void insertRole(@Param("id") String id, @Param("role") String role);

    @Select("Select SYS_ROLE.* FROM SYS_ROLE,SYS_USER_ROLE WHERE SYS_ROLE.id=SYS_USER_ROLE.id AND SYS_USER_ROLE.uid = #{uid}")
    @Results(value = {
            @Result(id = true, property = "id", javaType = String.class, column = "id", jdbcType = JdbcType.VARCHAR),
            @Result(id = true, property = "role", javaType = String.class, column = "role", jdbcType = JdbcType.VARCHAR)
    })
    List<SysRoleEntity> getRolesByUid(@Param("uid") String uid);

}
