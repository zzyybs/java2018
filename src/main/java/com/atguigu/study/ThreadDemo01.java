package com.atguigu.study;

import java.util.stream.IntStream;

/**
 * @auther zzyy
 * @create 2018-08-13 16:08
 */
public class ThreadDemo01
{

    public static void enjoyMusic() throws  Exception
    {
        while (true)
        {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"*******haha******");
        }
    }



    public static void main(String[] args)
    {
        IntStream.range(1,5).boxed().map(p -> new Thread(() -> System.out.println(Thread.currentThread().getName()))).forEach(Thread::start);
    }



}
