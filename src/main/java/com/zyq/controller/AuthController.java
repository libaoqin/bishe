package com.zyq.controller;

import com.zyq.dao.UserDao;
import com.zyq.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Catfish on 18/4/8.
 */
@Controller
public class AuthController {
    @Autowired
    UserDao userDao;
    @RequestMapping(path = "login",method = RequestMethod.GET)
    public String beforeLogin(@RequestParam("id") String id, Model model){

        UserEntity entity = userDao.getUserById(id);
        model.addAttribute("name",entity.getUsername());
        return "login";
    }
    @RequestMapping(path = "login",method = RequestMethod.POST)
    public void afterLogin(){

    }
}
