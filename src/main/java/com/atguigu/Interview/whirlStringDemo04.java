package com.atguigu.Interview;

/**
 * @auther zzyy
 * @create 2018-09-25 15:04
 * 题目04：旋转字符串操作
 * 给定两个字符串string1和string2，
 * string1的旋转操作就是每一次将string1最左边的一个字符移动到该字符串最右边。
 * 若string1 = "abcd"，如果在若干次旋转操作之后，string1能变成string2，那么返回True。
 *
 *  例如:
 *  string1 = "abcd"，旋转的全部可能
 *
 *      在移动1次之后结果就是"bcda"
 *      在移动2次之后结果就是"cdab"
 *      在移动3次之后结果就是"dabc"
 *      在移动4次之后结果就是"abcd"
 *
 *  假如string2 = "dabc",说明string1可以通过自旋操作变为string2字符串，返回true
 *  假如string2 = "abdc",说明string1不能通过自旋操作变为string2字符串，返回false
 */
public class whirlStringDemo04
{
    public static boolean testWhirl(String str1,String str2)
    {
        return str1.length() == str2.length() && (str1+str1).contains(str2);
    }

    public static void main(String[] args)
    {
        String str1 = "abcd";
        String str2 = "abc";

        boolean result = testWhirl(str1,str2);

        System.out.println(result);
    }
}
