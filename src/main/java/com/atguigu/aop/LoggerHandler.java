package com.atguigu.aop;

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
        System.out.println("=====before=====");
        Object result = method.invoke(target, args);
        System.out.println("=====after=====");
        return result;
    }
}
