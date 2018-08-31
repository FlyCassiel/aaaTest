package com.fei.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args){
        ThreadTest threadTest = new ThreadTest();

        /**
         * 第一种方式  ：  调用   new MyThread().start();
         */

        MyThread thread1 = threadTest.new MyThread();//new Thread()
        MyThread thread2 = threadTest.new MyThread();
        thread1.start();
        thread2.start();
        /**
         * 第二种方式   ：   调用
         */
        MyRunnable myRunnable = threadTest.new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        //或者
        new Thread(threadTest.new MyRunnable()).start();
        /**
         * 第三种方式   ：   调用
         */

        MyCallable myCallable = threadTest.new MyCallable();
        //1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        new Thread(futureTask).start();

        //2. 接受结果
        try {
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 实现线程三种方式：第一种
     *  1. 定义Thread类的子类，并重写该类的run()方法，该方法的方法体就是线程需要完成的任务，run()方法也称为线程执行体。
     *  2. 创建Thread子类的实例，也就是创建了线程对象
     *  3. 启动线程，即调用线程的start()方法
     *
     * 继承Thread实现类，重写run方法
     */
    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("这是继承Thread线程");
            synchronized (object){
                i++;
                System.out.println("i="+i);

                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }

    /**
     * 实现线程三种方式：第二种
     *  通过实现Runnable接口创建并启动线程一般步骤如下：
     *
     * 1】定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体
     *
     * 2】创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象
     *
     * 3】第三部依然是通过调用线程对象的start()方法来启动线程
     *
     * 继承Thread实现类，重写run方法
     */
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("继承Runnable");
        }
    }
    /**
     * 实现线程三种方式：第二种
     *  通过实现Callable接口创建并启动线程一般步骤如下：
     *
     * 1. 创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例（从java8开始可以直接使用Lambda表达式创建Callable对象）。
     *
     * 2. 使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值
     *
     * 3. 使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）
     *
     * 4. 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
     *
     * 继承Thread实现类，重写run方法
     */
    class MyCallable implements Callable{

        @Override
        public Object call() throws Exception {
            String name = "实现Callable";
            return name;
        }
    }
}
