package queue;

import java.util.Iterator;
import java.util.LinkedList;

public class linkedQueue<T> implements Iterable<T>, queue<T> {
    private LinkedList<T> list;

    public linkedQueue() {
        list = new LinkedList<>();
    }

    @Override
    public void offer(T item) {
        list.addLast(item);
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return list.pollFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return list.peekFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
