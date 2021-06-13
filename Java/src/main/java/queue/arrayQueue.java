package queue;

public class arrayQueue<T> implements queue<T>{
    private Object[] data;
    private int front, rear;

    public arrayQueue(int size){
        data = new Object[size + 1];
        front = 0;
        rear = 0;
    }
    @Override
    public void offer(T item) {
        if(isFull()){
            throw new RuntimeException();
        }
        data[rear++] = item;
        rear = adjustIndex(rear, data.length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T poll() {
        if(isEmpty()){
            throw new RuntimeException();
        }
        front = adjustIndex(front, data.length);
        return (T)data[front++];
    }

    @Override
    public int size() {
        return adjustIndex(rear + data.length - front, data.length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        front = adjustIndex(rear + data.length - rear, data.length);
        return (T) data[front];
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }
    public boolean isFull(){
        return (front+ data.length - rear) % data.length == 1;
    }

    public int adjustIndex(int index, int size){
        return index>=size? index-size: index;
    }
}
