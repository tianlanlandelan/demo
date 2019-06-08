package com.example.demo.designpattern.decorator;

/**
 * @author yangkaile
 * @date 2019-06-07 21:12:22
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {
    public PacketHTMLHeaderCreator(PackerCreator packerCreator){
        super(packerCreator);
    }
    @Override
    public String handleContent(String content){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>")
                .append("<body>")
                .append(component.handleContent(content))
                .append("</body>")
                .append("</html>");
        return buffer.toString();
    }

}
