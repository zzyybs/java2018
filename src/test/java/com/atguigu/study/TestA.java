package com.atguigu.study;

import com.atguigu.entities.User;
import org.junit.Test;

/**
 * @auther zzyy
 * @create 2018-08-10 14:21
 */
public class TestA
{
    @Test
    public void testLombok()
    {
        User u = new User(11,"z3",25);
        System.out.println(u.toString());
    }

}
