package chainlist;

import paterns.Index;
import paterns.Iter;
import models.Minion;
class Chain<T> {
    Chain<T> prev;
    T o;
    Chain<T> next;

    public Chain(Chain<T> prev, T o, Chain<T> next) {
        this.prev = prev;
        this.o = o;
        this.next = next;
    }

    @Override
    public String toString() {
        return "chainlist.Chain{" +
                ", o=" + o +
                '}';
    }
}

public class DoubleChainedList<T> implements Iter<Chain<T>>, Index<Chain<T>> {

    Chain<T> head = null;
    Chain<T> tail = null;
    Chain<T> iter = head;

    public Chain<T> getHead() {
        return head;
    }

    public Chain<T> getTail() {
        return tail;
    }

    public void addLast(T o){
        Chain<T> chain;
        if (head == null){
            chain = new Chain<>(null, o, null);
            tail = chain;
            head = chain;
        }
        else{
            chain = new Chain<>(tail, o, null);
            tail.next = chain;
            tail = chain;
        }
    }

    public void addFirst(T o){
        Chain<T> chain;
        if (tail == null){
            chain = new Chain<>(null, o, null);
            tail = chain;
            head = chain;
        }
        else{
            chain = new Chain<>(null, o, head);
            head.prev = chain;
            head = chain;
        }
    }

    public Chain<T> deleteLast(){
        Chain<T> x = tail;
        tail.prev.next = null;
        tail = tail.prev;
        return x;
    }

    public Chain<T> deleteFirst(){
        Chain<T> x = head;
        head.next.prev = null;
        head = head.next;
        return x;
    }

    public Chain<T> delete(T o){
        Chain<T> iter;
        if (o.equals(head.o)) return deleteFirst();
        if (o.equals(tail.o)) return deleteLast();
        iter = head;
        while (true){
            if (iter.o.equals(o)){
                Chain<T> x = iter;
                iter.prev.next = iter.next;
                iter.next.prev = iter.prev;
                return iter;
            }
            iter = iter.next;
        }
    }
    @Override
    public Chain<T> delete(int index){
        Chain<T> iter;
        if (index == 0) return deleteFirst();
//        if (i == 0) return deleteLast();
        iter = head;
        int i = 0;
        while (true){
            if (iter == tail) return deleteLast();
            if (i == index){
                Chain<T> x = iter;
                iter.prev.next = iter.next;
                iter.next.prev = iter.prev;
                return iter;
            }
            iter = iter.next;
            i++;
        }
    }

    public Chain<T> change(T o, String name, int age){
        Chain<T> iter;
        iter = head;
        while (true){
            if (iter.o.equals(o)){
                Chain<T> x = iter;
                iter.o = (T) new Minion(name, age);
                return iter;
            }
            iter = iter.next;
        }
    }

    public void print(){
        Chain<T> iter;
        iter = head;
        while (true){
            System.out.println(iter.o);
            if (iter == tail){
                break;
            }
            iter = iter.next;
        }
        System.out.println();
    }

    public void normalized(){
        iter = head;
    }

    @Override
    public boolean hasNext() {
        return !(iter==null);
    }

    @Override
    public Chain<T> next() throws Exception {
        if (!hasNext()) {
            throw new Exception("Linked List is done");
        }
        Chain<T> it = iter;
        iter = iter.next;
        return it;
    }


    @Override
    public Chain get(int index) {
        Chain<T> iter;
        if (index == 0) return getHead();
        iter = head;
        int i = 0;
        while (true){
            if (iter == tail) return getTail();
            if (i == index){
                return iter;
            }
            iter = iter.next;
            i++;
        }
    }
}

