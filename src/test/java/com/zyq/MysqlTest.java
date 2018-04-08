package com.zyq;

import com.zyq.dao.SysRoleDao;
import com.zyq.dao.SysUserRoleDao;
import com.zyq.dao.UserDao;
import com.zyq.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Catfish on 18/4/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MysqlTest {
    @Autowired
    UserDao userDao;
    @Autowired
    SysRoleDao sysRoleDao;
    @Autowired
    SysUserRoleDao sysUserRoleDao;
    @Test
    public void testInsertUser(){
        userDao.add("001","test1","666666");
    }
    @Test
    public void testGetUser(){
        UserEntity entity = userDao.getUserByUsername("test1");
        log.info(entity.toString());
    }
    @Test
    public void insertRoles() throws Exception{
        sysRoleDao.insertRole("1","ROLE_USER");
        sysRoleDao.insertRole("2","ROLE_ADMIN");
        sysUserRoleDao.insertUserRole("1","001");
        sysUserRoleDao.insertUserRole("2","001");
    }
}
