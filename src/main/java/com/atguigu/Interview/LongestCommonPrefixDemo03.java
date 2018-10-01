package com.atguigu.Interview;

import java.util.Arrays;

/**
 * @auther zzyy
 * @create 2018-09-24 22:46
 * 题目03： 最长公共前缀(Leetcode)
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串""。
 */
public class LongestCommonPrefixDemo03
{
    public static String longestCommonPrefix(String[] strArray)
    {
        //非空判断
        if(strArray == null || strArray.length == 0) return "";
        //return结果集返回值承载器定义
        StringBuffer stringBuffer = new StringBuffer();
        //1 先给String[]数组里面的每一个元素按照a-z进行升序排列
        Arrays.sort(strArray);
        //2 通过上面的排序，String[]里面的每一个元素都是升序的了，我们只需要取得第一个和最后一个的元素进行比较最长公共前缀即可.
        char[] first_CharArray = strArray[0].toCharArray();
        char[] last_CharArray = strArray[strArray.length - 1].toCharArray();
        int adjustLength = first_CharArray.length < last_CharArray.length ? first_CharArray.length : last_CharArray.length;
        int i = 0;
        while(i < adjustLength)
        {
            if(first_CharArray[i] == last_CharArray[i])
            {
                stringBuffer.append(first_CharArray[i]);
                ++i;
            }else{
                break;
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args)
    {
        String[] strArray = new String[]{"appxl","app","apply","apple","application"};

        System.out.println(longestCommonPrefix(strArray));
    }
}
