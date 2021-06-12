package stack;

import java.util.EmptyStackException;

public class intStack implements stack<Integer> {

    private int[] arr;
    private int pos;

    public intStack(int size){
        arr = new int[size];
        pos = 0;
    }

    @Override
    public int size() {
        return pos;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(Integer element) {
        arr[pos++] = element;
    }

    @Override
    public Integer pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return arr[--pos];
    }

    @Override
    public Integer peek() {
        return arr[size() - 1];
    }
}
