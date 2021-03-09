package com.szy.dao.impl;

import com.szy.dao.UserDao;
import com.szy.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository("oracleDao")
public class OracleDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("user插入到oracle数据库");
    }
}
