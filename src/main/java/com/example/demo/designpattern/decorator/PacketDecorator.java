package com.example.demo.designpattern.decorator;

public abstract class PacketDecorator implements PackerCreator {
    PackerCreator component;
    public PacketDecorator(PackerCreator packerCreator){
        component = packerCreator;
    }
}
