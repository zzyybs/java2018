package com.atguigu.jdk8;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther zzyy
 * @create 2018-08-10 22:28
 */
public class StreamDemo2
{
    public static void main(String[] args) throws Exception
    {

        List<List<Integer>> list3 = new ArrayList<List<Integer>>();
        list3.add(Arrays.asList(1,2));
        list3.add(Arrays.asList(1,2,3,4,8));
        list3.add(Arrays.asList(1,2,-3,-5));

        List<Integer> list4 = list3.stream().flatMap(i -> i.stream()).collect(Collectors.toList());
        for (Integer element : list4) {
            System.out.print(element);
        }
    }

    public static void base64Test() throws UnsupportedEncodingException
    {
        // 使用基本编码
        String base64encodedString = Base64.getEncoder().encodeToString("123".getBytes("utf-8"));
        System.out.println("Base64 比那么字符串 (基本) :" + base64encodedString);

        // 解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

        System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
    }

    public static void forEachMap()
    {
        List<String> list = Arrays.asList("a","b","c","d","e","f","b","c","d");
        list.stream().forEach(System.out::print);
        System.out.println();
        list = list.stream().map(x -> {return x.toUpperCase();}).collect(Collectors.toList());
        //list = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        list.stream().forEach(System.out::print);
        System.out.println();
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,0);
        list2 = list2.stream().filter(p -> p != 0).map(n -> n*n).sorted().collect(Collectors.toList());
        list2.stream().forEach(System.out::print);


    }
}
