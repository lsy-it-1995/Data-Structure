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

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T element) {
        list.addLast(element);
    }

    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

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
