package com.example.demo.object;

import com.example.demo.ClassSourceCode;
import com.example.demo.Utils;

import java.util.*;

public class SetTest {
    public static void main(String[] args){
        hashSetTest();
    }
    @ClassSourceCode(packageName = "java.util",
            extend = "java.util.AbstractSet",
            implement = {"java.util.Set","java.lang.Cloneable","java.io.Serializable"},
            description = "底层存储使用HashMap<E,Object>，key上存储实际的值，value是一个固定的Object(Object PRESENT = new Object())," +
                    "使用new HashSet(Collection<? extends E> c)初始化时，HashMap的大小为 Math.max((int) (c.size()/.75f) + 1, 16)",
            comparableClass = "TreeSet")
    public static void hashSetTest(){
        Utils.print("hashSetTest");
        Set<String> hashSet = new HashSet<>(16);
        hashSet.add("A");
        hashSet.add("B");
        hashSet.remove("A");
        Utils.print("hashSet.size()",hashSet.size());
        hashSet.add("A");
        hashSet.add("C");
        hashSet.add("D");
        Iterator<String> iterator = hashSet.iterator();
        Utils.print("element");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
    public static void treeSetTest(){
        TreeSet<String> treeSet = new TreeSet<>();

    }


}
