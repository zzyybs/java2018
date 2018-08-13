package com.atguigu.jdk8;

import com.atguigu.entities.User;

import java.util.Arrays;
import java.util.List;

/**
 * @auther zzyy
 * @create 2018-08-10 15:46
 */
public class StreamDemo
{
    public static void main(String[] args)
    {
        //查找男生age等于22的数量
        User u1 = new User(1, "z1", 22);
        User u2 = new User(2, "z2", 21);
        User u3 = new User(3, "z3", 22);
        User u4 = new User(4, "z4", 24);

        List<User> list = Arrays.asList(u1,u2,u3,u4);
        int count = 0;
        for (User element : list)
        {
            if(element.getAge() == 22)
            {
                count++;
            }
        }
        System.out.println(count);

        long result = list.stream().filter(t -> t.getAge() == 22).count();
        System.out.println(result);
    }
}
