package com.skb.learn.java.lambda;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaChallege1 {

    public static void main(String[] args) {

        LambdaChallege1 obj = new LambdaChallege1();

        Thread t1 = new Thread(() -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part : parts)
                System.out.println(part);
        });

        //t1.start();

        String source = "Some Tests on String";
        System.out.println(source.length());
        String charsAtEvenPos =  IntStream.range(0, source.length())
                .peek(System.out::println)
                .filter(value -> value%2 ==1)
                .peek(System.out::println)
                //.sum();
                .mapToObj(evenPos -> source.charAt(evenPos))
                .map(character -> character.toString())
                .collect(Collectors.joining());

        System.out.println(charsAtEvenPos);

        Function<String, String> getCharsAtEvenPosition = s -> {

            StringBuilder charsAtEvenPosition = new StringBuilder();
            for(int i = 0 ; i < s.length() ; i++) {
                if(i%2 == 1)
                    charsAtEvenPosition.append(s.charAt(i));
            }
            return charsAtEvenPosition.toString();
        };

        String numbers = "1234567890";
        System.out.println(getCharsAtEvenPosition.apply(numbers));

        System.out.println(obj.executeGetCharsAtEvenPosition(getCharsAtEvenPosition, "Today is Friday"));

        Supplier<String> stringSupplier = () -> new String("I Love Java!!");

        String iLoveJava = stringSupplier.get();

        System.out.println(iLoveJava);
    }


    private String executeGetCharsAtEvenPosition(Function<String, String> function, String inputString) {
        return function.apply(inputString);
    }

}
