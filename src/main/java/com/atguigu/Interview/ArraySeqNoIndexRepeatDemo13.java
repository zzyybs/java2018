package com.atguigu.Interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther zzyy
 * @create 2018-10-07 17:17
 *题目13：升序数组+不用索引+有重复
 */
public class ArraySeqNoIndexRepeatDemo13
{
    private int[] intArray = null;
    private int currentIndex = 0;

    public ArraySeqNoIndexRepeatDemo13(int length)
    {
        intArray = new int[length];
    }

    /**
     * 遍历打印数组
     */
    public void showArray()
    {
        for (int element : intArray)
        {
            System.out.print(element+" ");
        }
        System.out.println();
        System.out.println();
        System.out.println("currentIndex:  "+currentIndex);
    }


    /**
     * 按照传入的参数值将它插入当前数组的合适位置，首位或中间插入时候需要后面的数组值往后移动
     * @param dataValue
     * @return
     */
    public int insertArray(int dataValue)
    {
        int index = 0;
        for (index = 0; index < currentIndex ; index++)
        {
            if(intArray[index] > dataValue)
            {
                System.out.println(index);
                break;
            }
        }
        for (int i = currentIndex; i > index ; i--)
        {
            intArray[i] = intArray[i-1];
        }

        intArray[index] = dataValue;
        currentIndex++;
        return currentIndex - 1;
    }
    public void delArray(int dataValue)
    {
        int beginIndex = this.getIndex(0,dataValue);

        while(beginIndex >= 0)
        {
            for (int i = beginIndex; i <currentIndex; i++)
            {
                intArray[i] = intArray[i+1];
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
    public int getIndex(int beginIndex,int dataValue)
    {
        for (int i = beginIndex; i < currentIndex; i++)
        {
            if(intArray[i] == dataValue)
            {
                return i;
            }
        }
        return -1;
    }

    public List<String> searchOne(int beginIndex, int dataValue)
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
    public static void main(String[] args)
    {
        ArraySeqNoIndexRepeatDemo13 demo = new ArraySeqNoIndexRepeatDemo13(8);

        demo.insertArray(3);
        demo.insertArray(6);
        demo.insertArray(2);
        demo.insertArray(1);
        demo.insertArray(2);
        demo.insertArray(-4);

        demo.showArray();

        demo.delArray(2);
        demo.showArray();

        demo.insertArray(2);
        demo.insertArray(2);
        demo.insertArray(2);

        List<String> retValue = demo.searchOne(0,2);
        demo.showArray();
        for (String element : retValue)
        {
            System.out.println(element);
        }
    }
}
