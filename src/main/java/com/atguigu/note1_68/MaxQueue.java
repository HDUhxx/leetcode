package com.atguigu.note1_68;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        if (deque.peekFirst().equals(queue.peek())){
            deque.pollFirst();
        }
        return queue.poll();
    }
}
