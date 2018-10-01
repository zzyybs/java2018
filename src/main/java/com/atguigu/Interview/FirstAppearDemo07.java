package com.atguigu.Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther zzyy
 * @create 2018-10-01 12:16
 * 题目07: 第一个只出现过一次的字符,给出该字符的出现下标
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现过一次的字符,并返回该字符所在字符串的位置,
 * 如果没有则返回 -1.
 */
public class FirstAppearDemo07
{
    public static int firstAppearNoRepeated(String str)
    {
        if(str == null || str.length() == 0) return -1;

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int strLength = str.length();
        int count = 0;

        for (int i = 0; i < strLength; i++)
        {
            if(map.containsKey(str.charAt(i)))
            {
                count = map.get(str.charAt(i));
                map.put(str.charAt(i), count + 1);
            }else{
                map.put(str.charAt(i),1);
            }
        }

        for (int i = 0; i < strLength; i++)
        {
            if(map.get(str.charAt(i)) == 1)
            {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println(firstAppearNoRepeated("asdabc"));
    }
}
