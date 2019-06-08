package com.example.demo.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者，实现 java.util.Observer接口
 * @author yangkaile
 * @date 2019-06-08 09:13:06
 */
public class ObserverDemo implements Observer {

    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObserverDemo(String name,Observable observable){
        this.name = name;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg){
        System.out.println(name + "收到通知：" + ((ObservableDemo)o).getData());
    }

    @Override
    public String toString() {
        return "ObserverDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
