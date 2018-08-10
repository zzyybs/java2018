package com.atguigu.jdk8;

import com.atguigu.entities.BaseEntity;
import com.atguigu.entities.Person;
import com.atguigu.entities.User;

/**
 * 静态方法引用，有形参+有返回
 * @param <R>
 * @param <P>
 */
@FunctionalInterface
interface StaticMethodRef<R,P>
{
    public R transfer(P p);
}

/**
 * 普通方法引用
 * @param <R>
 */
@FunctionalInterface
interface NormalMethodRef<R>
{
    public R toUpper();
}

/**
 * 构造方法引用
 * @param <O>
 */
@FunctionalInterface
interface ConstructMethodRef<O>
{
    public O createObject(int id,String name,int age);
}

/**
 * 特定类型的方法引用
 * @param <P>
 */
@FunctionalInterface
interface SpecialMethodRef<P>
{
    public int myCompare(P p1,P p2);
}


/**
 * @auther zzyy
 * @create 2018-08-10 15:36
 */
public class MethodRef
{
    public static void main(String[] args)
    {
        testSpecialMethodRef();
    }

    public static void testConstructMethodRef()
    {
        ConstructMethodRef<BaseEntity> cmf = Person:: new;
        System.out.println(cmf.createObject(11, "z3", 25));
        cmf = User:: new;
        System.out.println(cmf.createObject(11,"li4",22));
    }

    public static void testSpecialMethodRef()
    {
        SpecialMethodRef<String> smf = String :: compareTo;
        System.out.println(smf.myCompare("a", "b"));

        smf = (a,b) -> a.compareTo(b);
        System.out.println(smf.myCompare("a", "b"));
    }

    public static void testNormalMethodRef()
    {
        NormalMethodRef<String> nmr = "atguigu" :: toUpperCase;
        System.out.println(nmr.toUpper());
        nmr = ()-> new String("atguigu").toUpperCase();
        System.out.println(nmr.toUpper());
    }

    //静态方法引用
    public static void testStaticMethodRef()
    {
        StaticMethodRef<String,Integer> smf = String::valueOf;
        System.out.println(smf.transfer(1122)+"\t"+(smf.transfer(1122) instanceof String));
        smf = (a) -> ""+a;
        System.out.println(smf.transfer(1122)+"\t"+(smf.transfer(1122) instanceof String));
    }
}
