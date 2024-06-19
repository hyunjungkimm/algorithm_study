package src.complexity.data_structure.queue;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        T data;
        QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;
    private int size;

    public void add(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if(last != null) last.next = node;
        last = node;
        if (first == null) first = last;
        size ++;
    }

    public T remove() {
        if(first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first == null) last = null;
        size--;
        return data;
    }

    public T peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);

        System.out.println(myQueue.size());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.size());

        myQueue.remove();
        myQueue.remove();
        myQueue.remove();

        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.size());
        System.out.println(myQueue.peek());

    }
}
