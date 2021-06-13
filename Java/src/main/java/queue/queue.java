package queue;

public interface queue<T> {
    public void offer(T item);
    public T poll();
    public int size();
    public T peek();
    public boolean isEmpty();
}
