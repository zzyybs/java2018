package com.atguigu.study;

/**
 * @auther zzyy
 * @create 2018-08-13 16:08
 * 守护进程
 * 1    此案例两个进程，一个是主线程main，另外一个是用户进程AAA
 *      平时情况下，各自独立各自忙各自的，假如main线程运行完毕但是AAA线程还没有运行完的话，
 *      AAA会继续运行，直到自己运行完成。
 *
 * 2    t1.setDaemon(true);假如添加了此句，AAA线程就变成了一个守护进程，也即主线程运行完毕了，它也
 *      跟着销毁了，不管自己时候还可以运行，简单一句话，就是陪葬线程。
 */
public class ThreadDemo01
{

    public static void main(String[] args)
    {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <=50; i++)
            {
                //暂停一会儿线程
                try { Thread.sleep( 100 ); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
        },"AAA");

        t1.setDaemon(true);
        t1.start();

        for (int i = 1; i <=3; i++)
        {
            try { Thread.sleep( 500 ); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"\t"+i);
        }
        System.out.println("***********main thread over");
    }



}
