package com.atguigu.Interview;

/**
 * @auther zzyy
 * @create 2018-09-21 14:19
 * 题目01：交换变量的3种方法，百度实习生面试题
 */
public class Swap3TypeDemo01
{

    //第一种：通过第三个变量
    public static void swap_3trd(int x ,int y)
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println("---------------");

        int temp = x;
        x = y;
        y = temp;

        System.out.println(x);
        System.out.println(y);
    }

    //第二种：通过相加
    public static void swap_plus(int x ,int y)
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println("---------------");

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println(x);
        System.out.println(y);
    }
    //第三种：通过异或的方式：
    //位异或运算符(^)有这样的一个性质，就是两个整型的数据x与y，有：(x ^ y ^ y) == x
    //这说明，如果一个变量x异或另外一个变量y两次，结果为x
    //异或的方法比相加更加可取的地方在于，异或不存在数据溢出。
    public static void swap_yh(int x ,int y)
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println("---------------");
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x);
        System.out.println(y);
    }


    public static void main(String[] args)
    {
        //swap_3trd(5,7);
        //swap_plus(5,7);
        //swap_yh(5,7);

        System.out.println(5 ^ 7);//5(0101)  7(0111) 0010
        System.out.println(2 ^ 7);//2(0010)  7(0111) 0101
    }
}
