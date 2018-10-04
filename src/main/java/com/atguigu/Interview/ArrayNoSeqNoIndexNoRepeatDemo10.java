package com.atguigu.Interview;

/**
 * @auther zzyy
 * @create 2018-10-04 22:04
 * 题目10：
 * 前置条件：无序数组+不按照索引+没有重复值
 * 按照传入的具体值，对数组的插入、删除和查找操作,本次不能使用下标索引
 *
 *
 */
public class ArrayNoSeqNoIndexNoRepeatDemo10
{
    private String[] strArray = null;
    private int currentIndex = 0;

    public ArrayNoSeqNoIndexNoRepeatDemo10(int arrayLength)
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
        int index = this.getIndex(dataValue);
        if(index >= 0)
        {
            for (int i = index; i <currentIndex ; i++)
            {
                strArray[i] = strArray[i+1];
            }
            currentIndex--;
        }
    }

    /**
     * 按照给定的值，找出它在对应数组的下标，找不到返回-1
     * @param dataValue
     * @return
     */
    public int getIndex(String dataValue)
    {
        for (int i = 0; i < strArray.length; i++)
        {
            if(strArray[i] == dataValue)
            {
                return i;
            }
        }
        return -1;
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
        ArrayNoSeqNoIndexNoRepeatDemo10 demo = new ArrayNoSeqNoIndexNoRepeatDemo10(10);

        demo.insertArray("3");
        demo.insertArray("6");
        demo.insertArray("1");
        demo.insertArray("2");


        demo.showArray();
        System.out.println(demo.getIndex("1"));
        System.out.println("================================");
        demo.delArray("1");
        demo.showArray();

        System.out.println(demo.getIndex("6"));
        System.out.println(demo.getIndex("1"));
    }
}
