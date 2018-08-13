package com.atguigu.jdk8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @auther zzyy
 * @create 2018-08-10 17:05
 * 内建函数式接口
 */
public class InnerFunctionalInterfaceDemo
{
    public static void main(String[] args)
    {
        //1.消费型接口（有参无返）
        //public interface Consumer<T>{public void accept(T t);}

        Consumer<String> con= System.out::println;//等价于Consumer<String> con= x -> System.out.println(x);
        con.accept("你好世界");

        //2.供给型接口(无参有返)
        //public interface Supplier<T>{public T get()}
        Supplier<String> t="hello"::toUpperCase;//等价于Supplier<String> t= () -> { return "abc".toUpperCase();};
        System.out.println(t.get());

        //3.断言式函数接口(有参有boolean)
        //public interface Predicate<T>{public boolean test(T t);}
        Predicate<String> pre="##hello"::startsWith;//等价于Predicate<String> pre= (x) -> { return x.startsWith("##");};
        System.out.println(pre.test("##"));

        //4.功能型接口
        //public interface Function<T,R>{public R apply(T t)}
        Function<Integer, String> fun=String::valueOf;//等价于
        //Function<Integer, String> fun=(x) -> {return String.valueOf(x);};
        System.out.println(fun.apply(1234).length());
    }
}
