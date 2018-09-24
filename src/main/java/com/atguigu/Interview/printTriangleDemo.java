package com.atguigu.Interview;

/**
 * @auther zzyy
 * @create 2018-09-24 19:29
 * 题目02：JAVA 打印正三角形+倒三角形+菱形
 */
public class printTriangleDemo
{
    public static void main(String[] args)
    {
        for (int i = 1; i <=5; i++)
        {
            for (int j = 5; j >=i; j--)
            {
                System.out.print(" ");
            }
            for (int j = 1; j <=i; j++)
            {
                System.out.print("*");
            }
            for (int j = 1; j <i; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }

        for (int i = 1; i <=5; i++)
        {
            //打印空格
            for (int j = 1; j <= i; j++)
            {
                System.out.print(" ");
            }
            //打印*
            for (int x = 1; x <= 9 - 2 * (i - 1); x++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
