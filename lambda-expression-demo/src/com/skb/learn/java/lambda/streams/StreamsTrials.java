package com.skb.learn.java.lambda.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTrials {

  public static void main(String[] args) {
    List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b2", "b3", "b4", "c1", "c2", "c3");
    myList.stream()
        .filter(s -> s.startsWith("a"))
        .map(String::toUpperCase)
        .sorted()
        .forEach(System.out::println);

    // We don't have to create collections in order to work with streams.
    // We can use Stream.of() to create a stream from a bunch of object references.
    Long length = Stream.of("a1", "a2", "a3", "b1", "b2", "b3", "b4", "c1", "c2", "c3")
        .filter(s -> s.startsWith("b"))
        .count();

    System.out.println("Length = " + length);

    // Special kinds of streams for working with the primitive data types int, long and double like IntStream, LongStream and DoubleStream
    IntStream.range(1, 4)
        .forEach(System.out::println);

    // All those primitive streams work just like regular object streams with the following differences: Primitive streams use
    // specialized lambda expressions, e.g. IntFunction instead of Function or IntPredicate instead of Predicate.
    // And primitive streams support the additional terminal aggregate operations sum() and average()

    IntStream.of(3,66,232,5454,12)
    .average()
    .ifPresent(System.out::println);

    // We can transform regular object Stream to primitive Stream
    int sum = Stream.of("a1", "b2", "c3", "d5")
        .map(s -> s.substring(1))
        .mapToInt(Integer::parseInt)
        .sum();

    System.out.println("Sum = " + sum);

    // Primitive streams can be transformed to object streams via mapToObj()
    IntStream.of(1,2,3,4,5,6)
        .mapToObj(i -> "a"+i)
        .forEach(System.out::println);

    // Intermediate operations will only be executed when a terminal operation is present.
    // Following will not print anything because there is no terminal operation present
    System.out.println("Nothing is printed......");
    Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(s -> {
          System.out.println("filter: " + s);
          return true;
        });

    // After we add the terminal operation forEach then things get printed.
    // The operations DO NOT move horizontally one after another on all elements of the stream.
    // But instead each element moves along the chain vertically. The first string "d2" passes filter then forEach,
    // only then the second string "a2" is processed.
    Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(s -> {
          System.out.println("filter: " + s);
          return true;
        })
        .forEach(s -> System.out.println("forEach: " + s));

    System.out.println("Tracking down order....");

    // Following will not print after a2 because of anyMatch()
    Stream.of("d2", "a2", "b1", "b3", "c")
        .map(s -> {
          System.out.println("map: " + s);
          return s.toUpperCase();
        })
        .anyMatch(s -> {
          System.out.println("anyMatch: " + s);
          return s.startsWith("A");
        });

    System.out.println("Proper ordering can optimize performance....");
    // We can optimize the performance by reordering the chain
    Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(s -> {
          System.out.println("filter: " + s);
          return s.startsWith("a");
        })
        .sorted((s1, s2) -> {
          System.out.printf("sort: %s; %s\n", s1, s2);
          return s1.compareTo(s2);
        })
        .map(s -> {
          System.out.println("map: " + s);
          return s.toUpperCase();
        })
        .forEach(s -> System.out.println("forEach: " + s));
  }
}
