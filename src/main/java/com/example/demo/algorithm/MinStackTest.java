package com.example.demo.algorithm;

import java.util.Stack;

/**
 * 最小栈
 */
public class MinStackTest {

    /**
     * 实现一个栈，带有出栈（pop)、入栈（push）、取最小元素(getMin）三个方法，
     * 要保证这三个方法的时间复杂度都是O(1)
     *
     * 1.设原有的栈叫做栈A,此时创建一个额外的栈B,用于辅助原栈A
     * 2.当第一个元素进入栈A时，让新元素的下标进入栈B,这个唯一的元素是栈A的当前最小值
     * 3.每当新元素进入栈A时，比较新元素和栈A当前最小值的大小，如果小于栈A当前最小值，
     * 则让新元素的下标进入栈B,此时栈B的栈顶元素就是栈A当前最小值的下标
     * 4.每当栈A有元素出栈时，如果出栈元素是栈A当前最小值，则让栈B的栈顶元素也出栈，
     * 此时栈B余下的栈顶元素所指向的，是栈A当中原本第二小的元素，
     * 代替刚才的出栈元素成为了栈A的当前最小值
     * 5.当调用getMin方法时，直接返回栈B的栈顶所指向的栈A对应元素即可
     *
     */
    private Stack<Integer> innerStack;
    private Stack<Integer> minStack;
    public MinStackTest() {
        innerStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        innerStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public Integer pop() {
        if (innerStack.empty()) {
            return null;
        }
        Integer peek = innerStack.pop();
        if (peek.equals(minStack.peek())) {
            minStack.pop();
        }
        return peek;
    }

    public Integer getMin() {
        if (minStack.empty()) {
            return null;
        }
        return minStack.peek();
    }

    public static void main(String[] args){
        int[] array = {9,6,3,4,7,0,7,4,5};
        MinStackTest minStack = new MinStackTest();

        for(int number : array){
            minStack.push(number);
        }

        for(int i = 0 ; i < array.length ; i++){
            System.out.println("pop:" + minStack.pop() + ",min:" + minStack.getMin());
        }
    }
}
