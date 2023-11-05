package stack;

import paterns.Iter;
import models.Minion;

public class Main1 {
    public static void main(String[] args) throws Exception {
        Stack<Minion> minions = new Stack<>();

        System.out.println("Добавление миньонов");
        minions.add(new Minion("Z", 1));
        minions.add(new Minion("A", 2));
        minions.add(new Minion("B", 1));
        minions.add(new Minion("C", 4));
        minions.add(new Minion("D", 9));
        minions.add(new Minion("E", 9));
        minions.print();

        System.out.println("Удаление миньонов");
        System.out.println(minions.pop());
        System.out.println(minions.pop());
        System.out.println();
        minions.print();
        System.out.println();

        System.out.println("Последний элемент стэка миньонов");
        System.out.println(minions.peek());
        System.out.println();

        Iter<Minion> iter = minions;
        System.out.println("Итератор миньонов");
        while (iter.hasNext()){
            try {
                System.out.println(iter.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
