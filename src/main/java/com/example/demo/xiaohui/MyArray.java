package com.example.demo.xiaohui;

import java.util.logging.Logger;

/**
 * @author yangkaile
 * @date 2019-05-28 10:08:50
 */
public class MyArray {
    Logger logger = Logger.getLogger(MyArray.class.getName());
    /**
     * 数组
     */
    private int[] array;
    /**
     * 数组实际大小
     */
    private int size;

    public MyArray(int capacity){
        array = new int[capacity];
        size = 0;
    }

    /**
     * 向指定位置插入数据，并将其后的所有数据后移
     * @param element 实际数据
     * @param index 指定插入的位置
     */
    public void insert(int element,int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        //如果实际元素数量超过数组容量，进行扩容
        if(size >= array.length){
            resize();
        }
        //将指定位置的元素依次后移
        for(int i = size ; i > index ; i --){
            array[i] = array[i-1];
        }
        array[index] = element;
        size ++;
    }

    public int delete(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        int deletedElement = array[index];
        for(int i = index; i < size ; i ++){
            array[i] = array[i+1];
        }
        size --;
        return deletedElement;
    }

    public void  resize(){
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }

    public void output(){
        for(int element:array){
            System.out.println(element);
        }
    }
    public static void main(String[] args){
        MyArray myArray = new MyArray(2);
        myArray.insert(1,0);
        myArray.insert(2,1);
        myArray.insert(3,1);
        myArray.insert(4,1);
        myArray.insert(5,1);
        myArray.output();
        System.out.println("====delete====");
        myArray.delete(3);
        myArray.output();
    }

}
