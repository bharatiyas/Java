package com.skb.learn.java.lambda.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AdvanceStreamTrials {

  List<Person> persons = Arrays.asList(
          new Person("Max", 18),
          new Person("Peter", 23),
          new Person("Pamela", 23),
          new Person("David", 29),
          new Person("David", 18)
  );

  public static void main(String[] args) {

    AdvanceStreamTrials trials = new AdvanceStreamTrials();

    // 1. Collect
    // It is a terminal operations.
    // It transforms the elements of the stream into a different kind of result, e.g. a List, Set or Map.
    // Easy to use - To convert to list use Collector.toList(), to a set Collector.toSet()

    List<Person> pPersons = trials.persons.stream()
        .filter(p -> p.getName().startsWith("P"))
        .collect(Collectors.toList());

    pPersons.forEach( p -> System.out.println( p.getName()));

    System.out.println("-----------------------------------------------");
    Set<Person> nonPPersons = trials.persons.stream()
        .filter(p -> !p.getName().startsWith("P"))
        .collect(Collectors.toSet());

    nonPPersons.forEach( p -> System.out.println( p.getName()));

    // Grouping persons by age

    Map<Integer, List<Person>> personsByAge = trials.persons.stream()
                                                .collect(Collectors.groupingBy(p -> p.getAge()));

    personsByAge.forEach((age, p) -> System.out.println("age: " + age + "  " + p ));
  }
}

class Person {
  private String name;
  private int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return name;
  }


}

