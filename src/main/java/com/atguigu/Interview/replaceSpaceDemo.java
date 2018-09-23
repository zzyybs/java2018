package com.atguigu.Interview;

/**
 * @auther zzyy
 * @create 2018-09-23 21:31
 * 题目01：请实现一个函数，将一个字符串中的每个空格替换成@。
 * 例如，当字符串为we like java.则经过替换之后的字符串为we@like@java.
 */
public class replaceSpaceDemo
{

    /**
     * 练习String+正排
     * @param str
     * @return
     */
    public static String replaceSpace(String str)
    {
        if (null == str || str.length() < 1) return "null or \"\" is not correct,please input correct parameter again";

        char[] charArray = str.toCharArray();
        //正排
        for (int i = 0; i <charArray.length; i++)
        {
            if(charArray[i] == ' ')
            {
                charArray[i] = '@';
            }
        }

        return new String(charArray);
    }

    /**
     *练习StringBuilder+逆排
     * @param str
     * @return
     */
    public static String replaceSpace2(String str)
    {
        if (null == str || str.length() < 1) return "null or \"\" is not correct, please input correct parameter again";

        StringBuilder sb = new StringBuilder();
        //逆排
        for (int i = str.length()-1; i >=0 ; i--)
        {
            if(str.charAt(i) == ' ')
            {
                sb.append("@");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args)
    {
        System.out.println(replaceSpace("we like      java."));
        System.out.println("------------------------------------");
        System.out.println(replaceSpace2(null));
        System.out.println(replaceSpace2("we like      java."));
    }
}
