package com.atguigu.aop3;

import com.atguigu.util.SysUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther zzyy
 * @create 2018-08-10 15:03
 */
public class LoggerHandler implements InvocationHandler
{
    private Object target;

    public LoggerHandler(Object target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        SysUtil.checkSecurity();
        Object result = method.invoke(target, args);
        SysUtil.checkSecurity();
        return result;
    }
}
