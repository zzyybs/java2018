package com.atguigu.Interview;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

class MyObject
{
    byte[] byteArray = new byte[1*1024*1024];//1MB
}

/**
 * @auther zzyy
 * @create 2018-10-16 16:50
 * 题目：一个进程有3个线程，若一个线程抛出oom，其他两个线程还能运行么?
 *
 * 解题说明：虚拟机参数配置修改为 -Xms16m -Xmx32m -XX:+PrintGCDetails
 *
 * 答案：一个线程溢出后，进程里的其他线程还能照常运行，线程不像进程，
 * 一个进程中的线程之间是没有父子之分的，都是平级关系。即线程都是一样的,
 * 退出了一个不会影响另外一个。
 */
public class OOM_ThreadDemo14
{
    public static void main(String[] args) throws Exception
    {

        new Hashtable<>();


        List<MyObject> list = new ArrayList<MyObject>();

        new Thread(() -> {
            while (true)
            {
                System.out.println("********** "+Thread.currentThread().getName()+"\t"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                list.add(new MyObject());
            }
        },"A").start();

        new Thread(() -> {
            while (true)
            {
                System.out.println("##### "+Thread.currentThread().getName()+"\t"+LocalDateTime.now());
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        },"B").start();

        new Thread(() -> {
            while (true)
            {
                System.out.println("********** "+Thread.currentThread().getName()+"\t"+LocalDateTime.now());
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        },"C").start();
    }
}
