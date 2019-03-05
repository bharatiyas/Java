package com.skb.learn.java.lambda;

import com.skb.learn.java.lambda.exercise.Person;

public class TestReferences {

    public static void main(String[] args) {

        Person p1 = new Person("FNOne", "LNOne", 18);
        Person p2 = p1;

        p2.setFirstName("FNTwo");
        System.out.println(p1.getFirstName());

        Person p3 = new Person(p1.getFirstName(), p1.getLastName(), p1.getAge());
        p3.setFirstName("FNThree");
        System.out.println(p1.getFirstName());
    }
}
