package com.skb.learn.java.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaChallenge2 {

    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
            "amelia",
            "olivia",
            "emily",
            "Isla",
            "ava",
            "Oliver",
            "Jack",
            "charlie",
            "harry",
            "Jacob"
        );

        topNames2015.stream()
                .map(name -> name.subSequence(0,1).toString().toUpperCase().concat(name.substring(1)))
                .sorted()
                .forEach(System.out::println);

        int startingWithA = topNames2015.stream()
                .mapToInt(name -> {
                    if (name.charAt(0) == 'a' || name.charAt(0) == 'A')
                        return 1;
                    else
                        return 0;
                })
                .sum();

        System.out.println("startingWithA = " + startingWithA);

        long startingWithA2 = topNames2015.stream()
                .filter(name -> (name.charAt(0) == 'a' || name.charAt(0) == 'A'))
                .count();

        System.out.println("startingWithA2 = " + startingWithA2);

    }
}
