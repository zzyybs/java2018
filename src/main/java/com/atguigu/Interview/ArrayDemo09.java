package com.atguigu.Interview;

/**
 * @auther zzyy
 * @create 2018-10-03 11:09
 * 题目09：对数组的插入、删除和查找操作
 * 说明：只研究最基本的算法思路，不引入其他复杂性，比如接口、参数校验、多线程环境运行等
 *
 * 1：无序数组,使用下标索引来操作,构造数组，暂时不考虑数组下标越界
 */
public class ArrayDemo09
{
    String[] strArray = null;

    //口语上的第几个位置，实际程序数组操作时候位置减1
    int currentIndex = 0;

    public ArrayDemo09(int arrayLength)
    {
        strArray = new String[arrayLength];
    }

    /**
     * 按照传入的参数值将它插入当前数组的最后一个位置
     * @param dataValue
     * @return 插入数据在数组中的实际位置
     */
    public int insertArray(String dataValue)
    {
        strArray[currentIndex++] = dataValue;

        return currentIndex - 1;
    }

    /**
     * 按照给出的下标，删除对应的下标数组值
     * 重点：
     * 1    后面的数组往前移动
     * 2    当前下标值由于删除了一个，需要减少一个。
     * @param index
     */
    public void delArray(int index)
    {
        for (int i = index; i < currentIndex; i++)
        {
            strArray[i] = strArray[i+1];
        }
        currentIndex--;
    }

    /**
     * 按照给出的索引下标值找出对应值
     * @param index
     * @return
     */
    public String getData(int index)
    {
        return strArray[index];
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
        System.out.println("currentIndex:  "+currentIndex);
    }


    public static void main(String[] args)
    {
        int init = 8;
        ArrayDemo09 demo09 = new ArrayDemo09(init);

        System.out.println(demo09.insertArray("a"));
        System.out.println(demo09.insertArray("b"));
        System.out.println(demo09.insertArray("c"));
        System.out.println(demo09.insertArray("d"));
        System.out.println(demo09.insertArray("e"));
        System.out.println(demo09.insertArray("f"));

        demo09.showArray();

        demo09.delArray(1);

        //demo09.showArray();

        System.out.println(demo09.getData(3));

    }
}
