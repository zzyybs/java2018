package com.atguigu.Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther zzyy
 * @create 2018-10-05 22:23
 * 题目11：
 * 前置条件：无序数组+不使用索引+有重复值
 * 按照传入的具体值，对数组的插入、删除和查找操作,本次不能使用下标索引
 */
public class ArrayNoSeqNoIndexDemo11
{
    private String[] strArray = null;
    private int currentIndex = 0;

    public ArrayNoSeqNoIndexDemo11(int arrayLength)
    {
        strArray = new String[arrayLength];
    }

    /**
     * 按照传入的参数值将它插入当前数组的最后一个位置
     * @param dataValue
     * @return
     */
    public int insertArray(String dataValue)
    {
        strArray[currentIndex++] = dataValue;
        return currentIndex - 1;
    }

    public void delArray(String dataValue)
    {
        int beginIndex = this.getIndex(0,dataValue);

        while(beginIndex >= 0)
        {
            for (int i = beginIndex; i <currentIndex; i++)
            {
                strArray[i] = strArray[i+1];
            }
            currentIndex--;

            beginIndex = this.getIndex(beginIndex,dataValue);
        }
    }

    /**
     * 按照给定的值，找出它在对应数组的下标，找不到返回-1
     * @param dataValue
     * @return
     */
    public int getIndex(int beginIndex,String dataValue)
    {
        for (int i = beginIndex; i < strArray.length; i++)
        {
            if(strArray[i] == dataValue)
            {
                return i;
            }
        }
        return -1;
    }

    public List<String> searchOne(int beginIndex,String dataValue)
    {
        List<String> list = new ArrayList<String>();

        beginIndex = this.getIndex(beginIndex,dataValue);

        while(beginIndex >= 0)
        {
            list.add("index:"+beginIndex+"\t dataValue:"+dataValue);
            beginIndex = this.getIndex(beginIndex+1,dataValue);
        }
        return list;
    }

    /**
     * 遍历打印数组
     */
    public void showArray()
    {
        for (String element : strArray)
        {
            System.out.print(element+" ");
        }
        System.out.println();
        System.out.println();
        System.out.println("currentIndex:  "+currentIndex);
    }
    public static void main(String[] args)
    {
        ArrayNoSeqNoIndexDemo11 demo = new ArrayNoSeqNoIndexDemo11(8);

        demo.insertArray("c");
        demo.insertArray("a");
        demo.insertArray("b");
        demo.insertArray("c");
        demo.insertArray("c");
        demo.insertArray("x");

        demo.showArray();

        demo.delArray("c");

        demo.showArray();
        demo.insertArray("x");
        demo.insertArray("u");
        demo.insertArray("z");
        demo.insertArray("w");
        demo.insertArray("x");

        demo.showArray();

        demo.searchOne(0,"x").forEach(System.out::println);

        System.out.println("================end");
    }
}
