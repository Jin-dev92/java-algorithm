package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Person implements Comparable<Person> {
    private String name;
    private int kor;
    private int en;
    private int math;

    public Person(String name, int kor, int en, int math) {
        this.name = name;
        this.kor = kor;
        this.en = en;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEn() {
        return en;
    }

    public int getMath() {
        return math;
    }

    @Override
    public int compareTo(Person other) {
        if (this.getKor() == other.getKor() && this.getEn() == other.getEn() && this.getMath() == other.getMath()) {
            return this.getName().compareTo(other.getName());

        }
        if (this.getKor() == other.getKor() && this.getEn() == other.getEn()) {
            return Integer.compare(other.getMath(), this.getMath()); // 감소 순
        }
        if (this.getKor() == other.getKor()) {
            return Integer.compare(this.getEn(), other.getEn()); // 증가순
        }
        return Integer.compare(other.getKor(), this.getKor());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", en=" + en +
                ", math=" + math +
                '}';
    }
}

public class Solution23 {
    public static int n;
    public static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            persons.add(new Person(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }
}
