package com.atguigu.note1_68;

import java.util.LinkedList;
import java.util.Stack;

public class CQueue
{
    LinkedList<Integer> a,b;
    public CQueue() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if (!b.isEmpty()) {
            return b.pop();
        }
        if (a.isEmpty()){
            return -1;
        }
        while (!a.isEmpty()) {
            b.push(a.pop());
        }

        return b.pop();
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println(list.removeFirst());//3
//        System.out.println(list.removeLast());//2
//        System.out.println(list.removeLast());//1
    }

}
