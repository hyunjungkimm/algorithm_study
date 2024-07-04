package src.baekjoon.complexity.data_structure.stackV1;

import java.util.NoSuchElementException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int size;


    public void push(T data) {
        StackNode<T> t = new StackNode<>(data);
        t.next = top;
        top = t;
        size++;
    }

    public T pop() {
        if(top == null) throw new NoSuchElementException();
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if(top == null) throw new NoSuchElementException();
        return top.data;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        stack.pop();

    }
}
