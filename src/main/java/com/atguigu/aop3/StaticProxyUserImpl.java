package com.atguigu.aop3;

import com.atguigu.util.SysUtil;

/**
 * @auther zzyy
 * @create 2018-08-14 9:34
 */
public class StaticProxyUserImpl implements UserService
{
    //目标接口
    private UserService service;

    //通过接口关联实现类，在构造方法里面对目标对象进行代理
    public StaticProxyUserImpl (UserService service)
    {
        this.service = service;
    }

    @Override
    public void add()
    {
        SysUtil.checkSecurity();
        service.add();
    }

    @Override
    public void delete()
    {
        SysUtil.checkSecurity();
        service.add();
    }


}
