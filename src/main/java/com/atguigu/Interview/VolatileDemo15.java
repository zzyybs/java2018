package com.atguigu.Interview;



import java.util.concurrent.atomic.AtomicInteger;

class MyResource
{
    //一句话，对volatile修饰的变量所做的写操作立即能反映到其它线程中
    volatile int number = 0;

    /**
     * @Description 这里面就有一个误区了，volatile关键字能保证可见性没有错，但是上面的程序错在没能保证原子性。
     *      * 可见性只能保证每次读取的是最新的值，但是volatile没办法保证对变量的操作的原子性。
     *      *
     *      * 在前面已经提到过，自增操作是不具备原子性的，它包括读取变量的原始值、进行加1操作、写入工作内存。
     *      * 那么就是说自增操作的三个子操作可能会分割开执行，就有可能导致下面这种情况出现：
     *      *
     *      * 假如某个时刻变量inc的值为10，
     *      *
     *      * 线程1对变量进行自增操作，线程1先读取了变量inc的原始值，然后线程1被阻塞了；
     *      *
     *      * 然后线程2对变量进行自增操作，线程2也去读取变量inc的原始值，由于线程1只是对变量inc进行读取操作，
     *      * 而没有对变量进行修改操作，所以不会导致线程2的工作内存中缓存变量inc的缓存行无效，所以线程2会直接去主存读取inc的值，
     *      * 发现inc的值时10，然后进行加1操作，并把11写入工作内存，最后写入主存。
     *      *
     *      * 然后线程1接着进行加1操作，由于已经读取了inc的值，注意此时在线程1的工作内存中inc的值仍然为10，
     *      * 所以线程1对inc进行加1操作后inc的值为11，然后将11写入工作内存，最后写入主存。
     *      *
     *      * 那么两个线程分别进行了一次自增操作后，inc只增加了1。
     *      *
     *      * 解释到这里，可能有朋友会有疑问，不对啊，前面不是保证一个变量在修改volatile变量时，会让缓存行无效吗？
     *      * 然后其他线程去读就会读到新的值，对，这个没错。这个就是上面的happens-before规则中的volatile变量规则，但是要注意，
     *      * 线程1对变量进行读取操作之后，被阻塞了的话，并没有对inc值进行修改。然后虽然volatile能保证线程2对变量inc的值读取是
     *      * 从主物理内存中读取的，但是线程1没有进行修改，所以线程2根本就不会看到修改的值。
     *      *
     *      * 根源就在这里，自增操作不是原子性操作，而且volatile也无法保证对变量的任何操作都是原子性的
     */
    public void increment()
    {
        number++;
    }
}


class MyResource2
{
    AtomicInteger number = new AtomicInteger();

    public void increment()
    {
        number.getAndIncrement();
    }

}
/**
 * @auther zzyy
 * @create 2018-10-28 9:56
 *
 */
public class VolatileDemo15
{
    public static void main(String[] args)
    {
        MyResource resource = new MyResource();

        for (int i = 1; i <=50; i++)
        {
            new Thread(() -> {
                for (int j = 1; j <=100; j++)
                {
                    resource.increment();
                }
            },String.valueOf(i)).start();
        }

        try { Thread.sleep( 1000 ); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(Thread.currentThread().getName()+"\t"+resource.number);

        System.out.println("************************************");

        MyResource2 resource2 = new MyResource2();

        for (int i = 1; i <=50; i++)
        {
            new Thread(() -> {
                for (int j = 1; j <=100; j++)
                {
                    resource2.increment();
                }
            },String.valueOf(i)).start();
        }

        try { Thread.sleep( 1000 ); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(Thread.currentThread().getName()+"\t"+resource2.number);

    }
}
