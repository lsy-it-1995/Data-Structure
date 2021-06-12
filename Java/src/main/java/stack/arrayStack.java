package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class arrayStack<T> implements stack<T>{

    private int size, capacity;
    private Object[] arr;

    public arrayStack(){
        size = 0;
        capacity = 16;
        arr = new Object[capacity];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T element) {
        if(size == capacity){
            increaseCapacity();
        }
        arr[size++] = element;
    }
    public void increaseCapacity(){
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T element = (T) arr[--size];
        arr[size] = null;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return (T)arr[size - 1];
    }
}
