package com.example.demo.designpattern.decorator;

public class PacketBodyCreator implements PackerCreator {
    @Override
    public String handleContent(String content){
        //构造核心数据，但不包含格式
        return content;
    }
}
