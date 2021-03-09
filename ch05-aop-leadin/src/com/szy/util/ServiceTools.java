package com.szy.util;

import java.util.Date;

public class ServiceTools {

    public static void doLog() {
        System.out.println("非事务方法，方法执行时间" + new Date());

    }

    public static void doTrans() {
        //方法最后提交事务
        System.out.println("非业务方法，方法执行完毕，提交事务");
    }
}
