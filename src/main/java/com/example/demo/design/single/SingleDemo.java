package com.example.demo.design.single;

/**
 * 使用内部类的方式实现单例（静态内部类）
 * 既可以做到延迟加载，也不必使用同步关键字，是一种比较完善的实现
 * 在这个实现中，单例模式使用内部类来维护单例的实例
 * 当SingleDemo被加载时，其内部类并不会被初始化，可以确保延迟加载
 * 当getInstance()方法被调用时，才会加载SingleHolder，从而初始化instance
 * 由于实例的建立是在类加载时完成，天生对线程友好，getInstance()方法也不需要使用synchronized关键字
 * @author yangkaile
 * @date 2019-06-07 11:56:20
 */
public class SingleDemo {
    private SingleDemo(){
        System.out.println("SingleDemo is created");
    }
    private static class SingleHolder{
        private static SingleDemo instance = new SingleDemo();
    }
    public static SingleDemo getInstance(){
        return SingleHolder.instance;
    }


}
