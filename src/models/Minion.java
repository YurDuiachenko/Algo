package models;

import java.util.Comparator;
import java.util.Objects;

public class Minion implements Comparator<Minion> {
    String name;
    int age;
    int weight;

    public Minion(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Minion() {
    }

    public Minion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(Minion o1, Minion o2) {
        int result =(o1.age+o1.weight)-(o2.age+o2.weight);
        if(result==0){
            return o1.name.compareTo(o2.name);
        }
        return result;
    }

//    @Override
//    public int compare(common.Minion o1, common.Minion o2) {
//        int result =o1.name.compareTo(o2.name);
//        if(result==0){
//            return (o1.age+o1.weight)-(o2.age+o2.weight);
//        }
//        return result;
//    }

//    @Override
//    public int compareTo(common.Minion o) {
//        return this.name.compareTo(o.name);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minion minion = (Minion) o;
        return age == minion.age && Objects.equals(name, minion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "common.Minion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}