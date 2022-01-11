package queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class IntQueue implements queue<Integer> {
    private int[] data;
    private int front, end, size;
    public IntQueue(int maxSize){
         front = end = size = 0;
         data = new int[maxSize];
    }

    @Override
    public void offer(Integer item) {
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }
        data[end++] = item;
        size++;
        end = end % data.length;
    }

    public boolean isFull(){
        return data.length == size;
    }

    @Override
    public Integer poll() {
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        size--;
        front = front % data.length;
        return data[front++];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Integer peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        front = front % data.length;
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

