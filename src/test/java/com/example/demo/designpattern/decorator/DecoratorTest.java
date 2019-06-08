package com.example.demo.designpattern.decorator;

public class DecoratorTest {
    public static void main(String[] args){
        PackerCreator packerCreator = new PacketHTTPHeaderCreator(
                new PacketHTMLHeaderCreator(
                        new PacketBodyCreator()
                )
        );
        System.out.println(packerCreator.handleContent("大家好，我是周杰伦"));
    }
}
