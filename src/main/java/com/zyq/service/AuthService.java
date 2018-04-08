package com.zyq.service;

import com.zyq.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Catfish on 18/4/8.
 */
@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails = userDao.getUserByUsername(s);
        if(userDetails == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return userDetails;
    }
}
