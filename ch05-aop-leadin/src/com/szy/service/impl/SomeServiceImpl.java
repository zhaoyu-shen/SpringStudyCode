package com.szy.service.impl;

import com.szy.service.SomeService;
import com.szy.util.ServiceTools;

import java.util.Date;

//service类的代码不修改，也能增加日志
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome");
    }

    @Override
    public void doOther() {
        System.out.println("执行业务方法doOther");
    }
}
