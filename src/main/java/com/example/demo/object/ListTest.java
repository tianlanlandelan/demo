package com.example.demo.object;

import com.example.demo.ClassSourceCode;
import com.example.demo.Utils;

import java.util.*;

public class ListTest {
    public static void main(String[] args){
        arrayListTest();
        linkedListTest();
        vectorTest();
        stackTest();
    }
    @ClassSourceCode(packageName = "java.util",
            extend = "java.util.AbstractList",
            implement = {"java.util.List","java.util.RandomAccess","java.lang.Cloneable","java.io.Serializable"},
            description = "默认大小是10，底层采用动态数组存储（Object[] elementData），",
            comparableClass = "LinkedList")
    public static void arrayListTest(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.contains("A");

    }
    @ClassSourceCode(packageName = "java.util",
            extend = "java.util.AbstractSequentialList",
            implement = {"java.util.List","java.util.Deque","java.lang.Cloneable","java.io.Serializable"},
            description = "",
            comparableClass = "ArrayList")
    public static void linkedListTest(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.contains("A");


    }

    @ClassSourceCode(packageName = "java.util",
            extend = "java.util.AbstractList",
            implement = {"java.util.List","java.util.RandomAccess","java.lang.Cloneable","java.io.Serializable"},
            description = "默认大小是10，",
            comparableClass = "TreeSet")
    public static void vectorTest(){
        Utils.print("vectorTest");
        Vector<String> vector = new Vector<>(16);
        vector.add("A");
        vector.add("B");
        Utils.print("elements");
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement()+ " ");
        }
        Utils.print("get",vector.get(0));


    }
    public static void stackTest(){
        Utils.print("stackTest");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        Utils.print("search",stack.search("B"));
        Utils.print("pop",stack.pop());
        Utils.print("search",stack.search("B"));


    }

}
