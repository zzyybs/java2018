package com.atguigu.aop3;

/**
 * @auther zzyy
 * @create 2018-08-14 9:20
 */
public class UserServiceImpl implements UserService
{
    @Override
    public void add()
    {

        System.out.println("==========add ok");
    }

    @Override
    public void delete()
    {

        System.out.println("==========delete ok");
    }


}
