package com.atguigu.aop;

import java.lang.reflect.Proxy;

/**
 * @auther zzyy
 * @create 2018-08-10 15:05
 */
public class ClientTest
{
    public static void main(String[] args)
    {
        IHelloWorld hello = new HelloWorldImpl();
        hello.sayHello();

        System.out.println();
        System.out.println();
        System.out.println();

        LoggerHandler loggerHandler = new LoggerHandler(hello);

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = hello.getClass().getInterfaces();

        IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(loader,interfaces,loggerHandler);

        proxy.sayHello();

    }
}
