package stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class listStack<T> implements Iterable<T>, stack<T> {

    private LinkedList<T> list = new LinkedList<T>();

    public listStack(){}

    public listStack(T element){
        list.push(element);
    }
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public void push(T element) {
        list.addLast(element);
    }
    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list.removeLast();
    }
    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list.peekLast();
    }
    public int search(T element){
        return list.lastIndexOf(element);
    }
}
