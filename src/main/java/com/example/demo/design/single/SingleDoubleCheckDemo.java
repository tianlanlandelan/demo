package com.example.demo.design.single;

/**
 * 使用双重检查锁模式实现单例
 * 延迟加载
 * 对于静态变量instance初始值赋予null，确保系统启动时没有额外的负载
 * getInstance()工厂方法必须是同步的，避免在多线程环境下创建多个实例
 * 因为synchronized关键字的使用，在多线程环境下耗时高，降低系统性能
 * @author yangkaile
 * @date 2019-06-07 12:17:26
 */
public class SingleDoubleCheckDemo {
    private SingleDoubleCheckDemo(){
        System.out.println("SingleDoubleCheckDemo is created");
    }
    private static SingleDoubleCheckDemo instance = null;
    public static SingleDoubleCheckDemo getInstance(){
        if(instance == null){
            synchronized (SingleDoubleCheckDemo.class){
                if(instance == null){
                    instance = new SingleDoubleCheckDemo();
                }
            }
        }
        return instance;
    }

}
