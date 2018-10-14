package com.atguigu.jdk8;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/**
 * @auther zzyy
 * @create 2018-10-14 15:33
 *
 * 函数式编程更多时候是一种编程的思维方式，是种方法论。
 *
 * 函数式与命令式编程的区别主要在于：
 * 函数式编程是告诉代码你要做什么，而命令式编程则是告诉代码要怎么做。
 *
 * 说白了，
 * 函数式编程是基于某种语法或调用API去进行编程。
 *
 */
public class WhyFunctionProgram
{
    /**
     * 命令式编程从一组数字中，找出最小的那个数字，
     */
    public static void getMinNumber(int[] intArray)
    {
        if(intArray == null || intArray.length < 0) return;

        int targetNumber = 0;

        for (int element : intArray)
        {
            if(element < targetNumber)
            {
                targetNumber = element;
            }
        }
        System.out.println("*******intArray min number: "+targetNumber);

        //第2中方法Arrays.sort默认是将定的数组从小到大排列，(Sorts the specified array into ascending numerical order.)
        // 所以第0个下标的数组值一定是最小的一个。
        Arrays.sort(intArray);
        System.out.println(intArray[0]);
    }

    /**
     * 命令式编程需要自己去实现具体的逻辑细节。
     * 而函数式编程则是调用API完成需求的实现，将原本命令式的代码写成一系列嵌套的函数调用，
     * 在函数式编程下显得代码更简洁易懂，这就是为什么要使用函数式编程的原因之一。
     * 所以才说函数式编程是告诉代码你要做什么，而命令式编程则是告诉代码要怎么做，是一种思维的转变。
     * @param intArray
     */
    public static void getMinNumber2(int[] intArray)
    {
        System.out.println(IntStream.of(intArray).max().getAsInt());
    }



    public static void main(String[] args)
    {
        BiFunction<Integer, String, String> moneyFormat = null;
        getMinNumber(new int[]{1,2,3,44,-55,-99,-2,77});
        getMinNumber2(new int[]{1,2,3,44,-55,-99,-2,77});
    }
}
