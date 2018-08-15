package com.atguigu.jdk8;

import com.atguigu.entities.User;

import java.util.Arrays;
import java.util.List;

/**
 * @auther zzyy
 * @create 2018-08-13 14:37
 */
public class StreamDemo3
{
    public void test01()
    {
        //要求：去重+数值大于4+升序排列后只返回前3个元素
        List<Integer> list = Arrays.asList(1,2,3,3,3,4,0,-11,5,6,7,8,9);

        list.stream().distinct().filter(p -> p > 4).sorted().limit(3).forEach(a -> System.out.println(a));
    }

    /**
     * 取age等于22的Student并按照ID降序打印出来
     */
    public void findStudentByCondition()
    {
        List<User> list = Arrays.asList(
                new User(11, "z3", 22),
                new User(12, "z4", 23),
                new User(13, "z5", 24),
                new User(14, "z6", 22),
                new User(15, "z6", 22)
        );

/*        Collections.sort(list, new Comparator<User>()
        {
            @Override
            public int compare(User u1, User u2)
            {
                return u2.getId().compareTo(u1.getId());
            }
        });
        //Collections.sort(list, (User u1, User u2) -> { return u1.getId().compareTo(u2.getId());});
        for (User user : list)
        {
            if(user.getAge() == 22)
            {
                System.out.println(user.toString());
            }
        }*/


        // 取age等于22的Student并按照ID降序打印出来
        // Stream解决
        list.stream().filter(p -> p.getAge() == 22).sorted((User u1, User u2) -> {
            return u2.getId().compareTo(u1.getId());
        }).forEach(System.out::print);
    }

    public static void main(String[] args)
    {
        StreamDemo3 demo3 = new StreamDemo3();
        demo3.findStudentByCondition();
    }
}
