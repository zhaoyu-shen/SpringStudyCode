package com.szy.service.impl;

import com.szy.service.SomeService;
import com.szy.util.ServiceTools;

import java.util.Date;

//service��Ĵ��벻�޸ģ�Ҳ��������־
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("ִ��ҵ�񷽷�doSome");
    }

    @Override
    public void doOther() {
        System.out.println("ִ��ҵ�񷽷�doOther");
    }
}
