package chainlist;

import paterns.Iter;
import models.Minion;

public class Main {
    public static void main(String[] args) {
        DoubleChainedList<Minion> minions = new DoubleChainedList<>();

        System.out.println("Добавление миньонов");
        minions.addLast(new Minion("Z", 1));
        minions.addLast(new Minion("A", 2));
        minions.addLast(new Minion("B", 1));
        minions.addLast(new Minion("C", 4));

        minions.addFirst(new Minion("D", 9));
        minions.addFirst(new Minion("E", 9));
        minions.print();

        System.out.println("Удаление всеми способами");
        minions.deleteFirst();
        minions.deleteLast();
        minions.delete(new Minion("B", 1));
        minions.delete(1);
        minions.print();

        System.out.println("Изменение миньона");
        minions.change(new Minion("A", 2), "R", 3);
        minions.print();

        minions.normalized();

        Iter<Chain<Minion>> it = minions;
        System.out.println("Итератор миньонов");
        while (it.hasNext()){
            try {
                System.out.println(it.next().o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();

        System.out.println("Индексатор миньонов");
        System.out.println(minions.get(1).o);
    }
}