package com.atguigu.study;

/**
 * @auther zzyy
 * @create 2018-08-10 14:22
 * 面试题：只能用一个for循环完成99乘法表
 */
public class Multi99
{
    public static void main(String[] args)
    {
        for (int i = 1,j=1; j<=9 ; i++)
        {
            System.out.print(i+"*"+j+"="+i*j+" ");
            if(i == j)
            {
                i=0;
                j++;
                System.out.println();
            }
        }
    }
}
