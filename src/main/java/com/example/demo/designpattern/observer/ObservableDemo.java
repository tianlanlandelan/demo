package com.example.demo.designpattern.observer;

import java.util.Observable;

/**
 * 被观察者，继承 java.util.Observable类，该类实现了增加观察者、删除观察者、通知观察者接口，内部维护一个Vector<Observer>
 * @author yangkaile
 * @date 2019-06-08 08:57:35
 */
public class ObservableDemo extends Observable {
    private String data = "";
    public String getData(){
        return data;
    }
    public void setData(String data){
        if(data != null && !this.data.equals(data)){
            this.data = data;
            setChanged();
            notifyObservers();
        }

    }
}
