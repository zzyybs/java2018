package com.atguigu.aop3;

import java.lang.reflect.Proxy;

/**
 * @auther zzyy
 * @create 2018-08-14 15:54
 */
public class ClientTest
{
    public static void main(String[] args)
    {
        //-------第一步测试
        UserService service = new UserServiceImpl();
        service.add();
        System.out.println("********************************");
        System.out.println();
        System.out.println();
        System.out.println();

        //-------第二步测试，静态代理加了checkSecurity()方法，

        UserService service2 = new StaticProxyUserImpl(new UserServiceImpl());
        service2.add();
        System.out.println("********************************");
        System.out.println();
        System.out.println();

        //-------第三步测试，动态代理加了checkSecurity()方法，
//
        UserService service3 = new UserServiceImpl();
        LoggerHandler loggerHandler = new LoggerHandler(service3);
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?>[] interfaces = service3.getClass().getInterfaces();

        UserService proxyService = (UserService) Proxy.newProxyInstance(loader,interfaces,loggerHandler);

        proxyService.add();
        proxyService.delete();


        System.out.println("********************************");
        System.out.println();
        System.out.println();

        IHelloWorld hello = new HelloWorldImpl();
        LoggerHandler loggerHandler2 = new LoggerHandler(hello);

        IHelloWorld proxyService2 = (IHelloWorld)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),hello.getClass().getInterfaces(),loggerHandler2);
        proxyService2.sayHello();









//
        System.out.println("********************************");
        System.out.println();
        System.out.println();

        Dun dun = new Creditor();
        LoggerHandler loggerHandler3 = new LoggerHandler(dun);
        Dun proxyService3 = (Dun)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),dun.getClass().getInterfaces(),loggerHandler3);
        proxyService3.getMoney();



        //第4步, spring aop

    }
}


/**
 *
 主题：aop   ----   面向切面的编程
 1  代理

 2  静态代理：
 结合上面对于User类的case，已经封装好并交付使用，突然某一天收到新需求，需要在每一个方法前面增加安全检查、
 日志记录或点击率分析这样的情况，那就需要在原来基础上大面积修改：

 	假如我们选取安全性检查作为新增需求，将该需求封装为一个方法导致结果就是：
 2.1 整个系统中对应的CRUD方法都需要新增上述方法，导致修改面积过大且整个系统中处处散落着类似的方法，试想这才一个USER类就新增4个，
        那200个类需要新增多少？
 2.2 原来的代码已经稳定，新的修改导致新的测试工作扩大，根据OCP原则，对新增开启对修改关闭，能不能想到一个好方法可以对原来的功能不
        破坏还加上了安全性检查?
 【解决方法】
 静态代理：
 1	新增一个实现类StaticProxyUserImpl，让它具备两个特点：一）实现checkSecurity方法，二）同样的实现UserService接口。
 2	组合优于继承的原则，让StaticProxyUserImpl通过UserService接口和UserServiceImpl发生组合关系，让StaticProxyUserImpl
 代理UserServiceImpl

 3  动态代理
 【场景描述】
 针对上面静态代理的情况，已经解决了我们的需求。在不对原有代码修改的情况下，新
 增加了我们的安全性检查方法，完成功能。但随之带来新的问题，一个类对应一个接口，代理类也对应实现类同样的接口，
 虽然我们把散落在系统中各个方法都收集汇拢到一块了，但一个接口就要出来一个代理类导致数量又膨胀，不利于管理。
 能否整个系统中就一份，大家来使用，不用一个接口一个代理类来实现，减少因为代理接口的情况而导致系统膨胀。
 【解决方法】
 动态代理：

 3  Spring AOP

 **/