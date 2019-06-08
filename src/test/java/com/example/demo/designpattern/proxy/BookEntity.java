package com.example.demo.designpattern.proxy;

/**
 * 用来测试代理模式的Entity层代码
 * @author yangkaile
 * @date 2019-06-07 18:05:39
 */
public class BookEntity {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
