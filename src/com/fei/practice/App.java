package com.fei.practice;

/**
 * Lambda例子
 */
public class App {
    public static void main(String[] args){
        LambdaDemo lambdaDemo = (n) -> System.out.println(n);
        /*LambdaDemo lambdaDemo1 = new LambdaDemo() {
            @Override
            public void demo(String n) {
                System.out.println(n);
            }
        }*/
        lambdaDemo.demo("aaa");
    }
}
