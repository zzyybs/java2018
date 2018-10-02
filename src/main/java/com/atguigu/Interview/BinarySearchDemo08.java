package com.atguigu.Interview;

/**
 * @auther zzyy
 * @create 2018-10-02 12:21
 * 题目08：二分查找
 * 在有序数据且无重复中进行查找,在给定的数组种找到目标关键字的下标位置，找不到返回-1;
 *
 * 其中，有几个要注意的点：
 * 1. 循环的判定条件是：low <= high
 * 2. 为了防止数值溢出，mid = low + (high - low)/2
 * 3. 当 A[mid]不等于target时，high = mid - 1或low = mid + 1
 */
public class BinarySearchDemo08
{

    public static int binarySearch(int[] intArray,int target)
    {
        if(intArray == null || intArray.length == 0) return -1;

        int low = 0;
        int high = intArray.length - 1;
        int middle = -1;

        while(low <= high)
        {
            middle = low + (high - low)/2;

            if(intArray[middle] == target)
            {
                return middle;
            }else if(intArray[middle] < target){
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] intArray = new int[]{1,3,5};
        System.out.println(binarySearch(intArray,5));
    }
}
