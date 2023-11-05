package stack;

import paterns.Iter;

public class Stack<T> implements Iter<T> {

    int top = 0;
    T[] list;
    int size = 5;
    int capacity;

    public Stack(int size) {
        this.size = size;
        capacity();
    }

    public Stack() {
        this.size = 5;
        this.top = 0;
        capacity();
        this.list = (T[]) new Object[this.size];
    }

    private void capacity(){
        this.capacity = (int) Math.round(this.size*1.5);
    }

    private boolean isEmpty(){
        return (top == 0) ? true : false;
    }

    private void resize(){
        size = capacity;
        capacity();
        T[] newList = (T[]) new Object[this.size];
        for (int i = 0; i < top; i++) {
            newList[i] = list[i];
        }
        this.list = newList;
    }

    public void add(T el){
        if (top >= size){
            resize();
        }
        list[top] = el;
        top++;
        if (top == 1) t = list[0];
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            System.out.println("Exception - stack.Stack is empty");
            throw new Exception("Exception - stack.Stack is empty");
        }
        top--;
        T del = list[top];
        list[top] = null;
        return del;
    }

    public T peek(){
        if (isEmpty()) {
            System.out.println("Exception - stack.Stack is empty");
            return null;
        }
        return list[top-1];
    }

    public void print(){
        for (int i = top-1; i >= 0; i--) {
            System.out.println(list[i]);
        }
        System.out.println();
    }

    private T t;
    @Override
    public boolean hasNext() {
        return !isEmpty();
    }

    @Override
    public T next() throws Exception {
        if (!hasNext()) throw new Exception("stack.Stack is empty");
        return pop();
    }
}
