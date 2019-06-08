package com.example.demo.designpattern.observer;

/**
 * 观察者模式测试
 */
public class ObserverTest {
    public static void main(String[] args){
        //实例化一个被观察者（信息发布者）
        ObservableDemo publish = new ObservableDemo();

        //实例化两个观察者，同时关联被观察者
        ObserverDemo sub1 = new ObserverDemo("小明",publish);
        ObserverDemo sub2 = new ObserverDemo("小红",publish);

        //被观察者发布信息
        publish.setData("你好");
    }
}
