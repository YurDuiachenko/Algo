package comparator;

import models.Minion;

import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception {

//        common.Minion[] minions = new common.Minion[3];
//
//        System.out.println("Компарация");
//        minions[0] = new common.Minion("Z", 1);
//        minions[1] = new common.Minion("A", 2);
//        minions[1] = new common.Minion("B", 1);

        List<Minion> minions = new ArrayList<>();

        System.out.println("Добавление миньонов");
        minions.add(new Minion("Z", 1, 4));
        minions.add(new Minion("A", 2, 2));
        minions.add(new Minion("B", 3, 1));
        minions.add(new Minion("C", 4, 2));
        minions.add(new Minion("D", 4, 5));
        minions.add(new Minion("E", 5, 7));
        minions.add(new Minion("F", 6, 0));
        minions.add(new Minion("G", 7, 4));

//        Collections.sort();
        minions.sort(new Minion());
        for (Minion l: minions) {
            System.out.println(l);
        }
//        System.out.println(minions);
    }
}
