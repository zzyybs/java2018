package com.atguigu.aop3;

interface Dun //债务
{
    public void getMoney();
}

class Creditor implements Dun
{
    public void getMoney()
    {
        System.out.println("get My Money");
    }
}

class ProxyDun implements Dun//ProxyDun讨债人
{
    Dun dun;

    public ProxyDun(Dun dun)
    {
        this.dun=dun;
    }

    public void getMoney()
    {
        System.out.println("扁他一顿");
        dun.getMoney();
        System.out.println("讨债结束......");
    }
}

/**
 * 一句话：在真实主题之间，前后均可包一层，实现代理的额外拓展功能+真实主题的原有实现，
 * 目的是在不破坏原来真实主题的目标意图和功能下，对真实主题进行了功能加强和扩展。
 */
public class ProxyDemo
{
    public static void main(String[] args)
    {
        Dun dun = new Creditor();
        dun.getMoney();

        System.out.println("******************************");

        Dun proxy = new ProxyDun(new Creditor());
        proxy.getMoney();
    }
}
