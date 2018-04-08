package com.zyq.dao;

import com.zyq.entity.SysRoleEntity;
import com.zyq.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by Catfish on 18/4/8.
 */
@Mapper
public interface UserDao {
    @Select("SELECT * FROM user WHERE username = #{username}")
    @Results(value = {
            @Result(id = true, property = "id", javaType = String.class, column = "id", jdbcType = JdbcType.VARCHAR),
            @Result(property = "username", javaType = String.class, column = "username", jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", javaType = String.class, column = "password", jdbcType = JdbcType.VARCHAR),
            @Result(property = "roles",javaType = List.class,column = "id",many = @Many(select = "com.zyq.dao.SysRoleDao.getRolesByUid"))
    })
    UserEntity getUserByUsername(@Param("username") String username);
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results(value = {
            @Result(id = true, property = "id", javaType = String.class, column = "id", jdbcType = JdbcType.VARCHAR),
            @Result(property = "username", javaType = String.class, column = "username", jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", javaType = String.class, column = "password", jdbcType = JdbcType.VARCHAR),
            @Result(property = "roles",javaType = List.class,column = "id",many = @Many(select = "com.zyq.dao.SysRoleDao.getRolesByUid"))
    })
    UserEntity getUserById(@Param("id") String id);


    @Insert("INSERT INTO user(id,username,password) values(#{id},#{username},#{password})")
    void add(@Param("id") String id, @Param("username") String username, @Param("password") String password);
}
