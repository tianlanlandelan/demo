package com.example.demo.designpattern.decorator;

/**
 * @author yangkaile
 * @date 2019-06-07 21:16:00
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {
    public PacketHTTPHeaderCreator(PacketDecorator packetDecorator){
        super(packetDecorator);
    }

    @Override
    public String handleContent(String content){
        StringBuffer buffer = new StringBuffer();
        buffer.append("Cache-Control:no-cache\n")
                .append("Date:Mon,31Dec201204:25:57GMT\n")
                .append(component.handleContent(content));
        return buffer.toString();
    }
}
