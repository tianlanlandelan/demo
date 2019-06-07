package com.example.demo;

public class GenericTypeDemo {

    /**
     * 类型转换接口
     * @param <S>
     * @param <T>
     */
    public interface Converter<S,T>{

        T convert(S source);

    }
    class StringConverter implements Converter<Integer,String>{
        @Override
        public String convert(Integer source) {
            return source.toString();
        }
    }

    public static void main(String[] args){
        GenericTypeDemo demo = new GenericTypeDemo();
        demo.convertTest();
    }
    public void convertTest(){
        StringConverter converter = new StringConverter();
        System.out.println(converter.convert(123));

    }
}
