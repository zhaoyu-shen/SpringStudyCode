package com.szy.service.impl;

import com.szy.dao.UserDao;
import com.szy.domain.SysUser;
import com.szy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {


//    @Autowired
//    @Qualifier("mysqlDao")
    @Resource(name = "oracleDao")
    private UserDao dao=null;

    //可以不需要
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        //调用dao的方法
        dao.insertUser(user);
    }
}
