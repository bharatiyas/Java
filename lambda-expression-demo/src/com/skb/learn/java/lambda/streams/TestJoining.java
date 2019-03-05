package com.skb.learn.java.lambda.streams;

import static java.util.Collections.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJoining {

    public static void main(String[] args) {

        List<SimpleBean> beans = Arrays.asList(

                new SimpleBean("1", "Bean-11"),
                new SimpleBean("1", "Bean-12"),
                new SimpleBean("1", "Bean-13"),
                new SimpleBean("1", "Bean-14"),
                new SimpleBean("2", "Bean-21"),
                new SimpleBean("3", "Bean-31"),
                new SimpleBean("3", "Bean-32"),
                new SimpleBean("2", "Bean-22"),
                new SimpleBean("2", "Bean-23"),
                new SimpleBean("1", "Bean-15")
        );

        // Map<PassengerType, Long> counts = availabilityRequest.getPreferences().getPassengerTypes().stream().collect(
        //                            Collectors.groupingBy(Function.identity(), counting()));

        //((List) beans).stream().collect(Collectors.groupingBy(SimpleBean::getKey));

        List<SimpleBean> singletonBean = Collections.singletonList(new SimpleBean("1", "Singleton bean"));

        //singletonBean.add(new SimpleBean("t", "test"));

        //singletonBean.remove(0);

        singletonBean.forEach( sb -> System.out.println(sb.getKey()));

        Something something = new Something();
        // Provides an implementation of the Converter FI using method references
        // An implementation of an abstract method of a FI can be given by using Method References
        Converter<String, String> converterStringToStr = something::startsWith;
        String converted = converterStringToStr.convert("Java");

        // Provides another implementation of Converter FI using Lambda. Since this is an implementation of Converter FI
        // therefore the compiler understands the type of m as Map<String, String>. Also since convert(F, T) return the Type
        // T therefore there is return mapEntries
        Converter<Map<String, String>, List<String>> converterMapToList = (m) -> {
            List<String> mapEntries = new ArrayList<>();
            m.entrySet().forEach( es -> {
                mapEntries.add(es.getKey());
                mapEntries.add(es.getValue());
            });
            return mapEntries;
        };

        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("BNE", "Brisbane");
        inputMap.put("SYD", "Sydney");
        converterMapToList.convert(inputMap).forEach( (i) -> System.out.println(i + " "));

        System.out.println("\n\n");

        // Here we provide the implementation of apply() of Function<T, R> using Lambda expression after '='
        Function<List<SimpleBean>, Map<String, String>> simpleBeanToMapFunction = sbs -> {
            Map<String, String> beanMap = new HashMap<>();
            sbs.forEach( b -> beanMap.put(b.getKey(), b.getValue()));
            return beanMap;
        };

        simpleBeanToMapFunction.apply(beans).entrySet().forEach( es -> System.out.println(es.getKey() + " - " + es.getValue()));


    }


}
