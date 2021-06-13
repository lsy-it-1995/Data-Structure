package queue;

public class intQueue implements queue<Integer>{

    private int[] data;
    private int front, end;
    private int size;

    public intQueue(int size) {
        data = new int[size];
        front = end = this.size = 0;
    }

    public boolean isFull(){
        return size == data.length;
    }
    @Override
    public void offer(Integer item) {
        if(isFull()){
            throw new RuntimeException();
        }
        size++;
        data[end++] = item;
        end = end % data.length;
    }

    public Integer poll() {
        if(isEmpty()){
            throw new RuntimeException();
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
            throw new RuntimeException();
        }
        front = front % data.length;
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
//
//        intQueue q = new intQueue(5);
//
//        q.offer(1);
//        q.offer(2);
//        q.offer(3);
//        q.offer(4);
//        q.offer(5);
//
//        System.out.println(q.poll()); // 1
//        System.out.println(q.poll()); // 2
//        System.out.println(q.poll()); // 3
//        System.out.println(q.poll()); // 4
//
//        System.out.println(q.isEmpty()); // false
//
//        q.offer(1);
//        q.offer(2);
//        q.offer(3);
//
//        System.out.println(q.poll()); // 5
//        System.out.println(q.poll()); // 1
//        System.out.println(q.poll()); // 2
//        System.out.println(q.poll()); // 3
//
//        System.out.println(q.isEmpty()); // true

//        benchMarkTest();
        testManually();
    }

    public static void testManually(){
        intQueue q = new intQueue(2);
        q.offer(1);
        q.offer(2);
        System.out.println(q.size());//2
        System.out.println(q.peek());//1
        System.out.println(q.size());//2
        System.out.println(q.poll());//1
        System.out.println(q.size());//1
        System.out.println(q.peek());//2
        System.out.println(q.size());//1
        System.out.println(q.poll());//2
        System.out.println(q.size());//0

    }
    // BenchMark IntQueue vs ArrayDeque.
    private static void benchMarkTest() {

        int n = 10000000;
        intQueue intQ = new intQueue(n);

        // IntQueue times at around 0.0324 seconds
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) intQ.offer(i);
        for (int i = 0; i < n; i++) intQ.poll();
        long end = System.nanoTime();
        System.out.println("IntQueue Time: " + (end - start) / 1e9);

        // ArrayDeque times at around 1.438 seconds
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
        // java.util.ArrayDeque <Integer> arrayDeque = new java.util.ArrayDeque<>(n); // strangely the
        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayDeque.offer(i);
        for (int i = 0; i < n; i++) arrayDeque.poll();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);
    }

}
