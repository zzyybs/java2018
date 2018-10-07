package com.atguigu.Interview;

/**
 * @auther zzyy
 * @create 2018-10-06 19:50
 * 题目12：升序数组+不用索引+没有重复
 */
public class ArraySeqNoIndexNoRepeatDemo12
{
    private int[] intArray = null;
    private int currentIndex = 0;

    public ArraySeqNoIndexNoRepeatDemo12(int length)
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

    /**
     * 升序+无重复，所以按照数值找到下标后直接删除即可，但是需要后面的往前顶+currentIndex自己减少一
     * @param dataValue
     */
    public void delArray(int dataValue)
    {
        int index = this.getIndex(dataValue);
        if(index >= 0)
        {
            for (int i = index; i < currentIndex; i++)
            {
                intArray[i] = intArray[i+1];
            }
            currentIndex--;
        }
    }

    /**
     * 升序+无重复,按照值直接对应找到下标即可。
     * @param dataValue
     * @return
     */
    public int getIndex(int dataValue)
    {
        for (int i = 0; i < currentIndex; i++)
        {
            if(intArray[i] == dataValue)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        ArraySeqNoIndexNoRepeatDemo12 demo = new ArraySeqNoIndexNoRepeatDemo12(8);

        demo.insertArray(4);
        demo.insertArray(1);
        demo.insertArray(3);
        demo.insertArray(77);
        demo.insertArray(-32);
        demo.showArray();


        demo.delArray(77);
        demo.showArray();


        System.out.println(demo.getIndex(3));

    }
}
