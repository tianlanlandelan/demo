package com.example.demo.xiaohui;

/**
 * @author yangkaile
 * @2019-05-28 14:45:00
 */
public class MyLinkedList {

    private Node head;
    private Node last;
    private int size = 0;

    public void insert(int data,int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertedNode = new Node(data);
        //链表为空时
        if(size == 0){
            head = insertedNode;
            last = insertedNode;
         //头部插入
        }else if(index == 0){
            insertedNode.next = head;
            head = insertedNode;
        //尾部插入
        }else if(size == index){
            last.next = insertedNode;
            last = insertedNode;
        //中间插入
        }else {
            Node prevNode = get(index -1);
            Node nextNode = prevNode.next;
            prevNode.next = insertedNode;
            insertedNode.next = nextNode;
        }
        size ++;
    }

    public Node get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node temp = head;
        for(int i = 0 ; i < index ; i ++){
            temp = temp.next;
        }
        return temp;
    }

    public Node remove(int index){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node removedNode = null;
        if(index == 0){
            removedNode = head;
            head = head.next;
        }else if(index == size -1){
            Node prevNode = get(index -1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            Node prevNode = get(index -1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size --;
        return removedNode;
    }


    public void output(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data = data;
        }

    }


    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insert(1,0);
        linkedList.insert(2,0);
        linkedList.insert(3,0);
        linkedList.insert(4,3);
        linkedList.insert(5,2);
        linkedList.output();
        System.out.println("===remove====");
        linkedList.remove(1);
        linkedList.output();
        System.out.println("===remove====");
        linkedList.remove(0);
        linkedList.output();
        System.out.println("===remove====");
        linkedList.remove(2);
        linkedList.output();

    }
}
