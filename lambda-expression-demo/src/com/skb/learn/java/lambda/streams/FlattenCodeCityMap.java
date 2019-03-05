package com.skb.learn.java.lambda.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FlattenCodeCityMap {

    public static void main(String[] args) {
        new FlattenCodeCityMap().dummyMethod();
    }

    private void dummyMethod() {


        Map<String, String> codeCityMap = new HashMap<>();

        codeCityMap.put("BNE", "Brisbane");
        codeCityMap.put("SYD", "Sydney");
        codeCityMap.put("MEL", "Melbourne");
        codeCityMap.put("PER", "Perth");

        System.out.println("Flattened Map using map:: ");
        codeCityMap.keySet().stream()
                .map(key -> key + " " + codeCityMap.get(key))
                .forEach(System.out::println);

        // Demonstrating Stream<String[]> -> flatMap -> Stream<String>
        System.out.println("\n\nPriting Cities of country using flatMap:: ");


        Map<String, String[]> countryCities = new HashMap<>();

        countryCities.put("AU", new String[]{"Brisbane", "Sydney", "Melbourne"});
        countryCities.put("IN", new String[]{"New Delhi", "Kolkata", "Mumbai", "Chennai"});
        countryCities.put("US", new String[]{"New York", "Boston", "Las Vegas", "Los Angeles"});
        countryCities.put("CA", new String[]{"Toronto", "Calgery", "Montreal", "Quebec"});


        countryCities.values().stream()
                .flatMap(val -> Stream.of(val))
                .forEach(System.out::println);

        // Demonstrating Stream<List<String>> -> flatMap -> Stream<String>

        List<CityAndPlacesToVisit> codeCityList = Arrays.asList(
            new CityAndPlacesToVisit("Kolkata", Arrays.asList("Echo Park", "Victoria")),
                new CityAndPlacesToVisit("Chennai", Arrays.asList("Zoo", "Marina")),
                new CityAndPlacesToVisit("Mumbai", Arrays.asList("Zuhu", "Marina")),
                new CityAndPlacesToVisit("New Delhi", Arrays.asList("Lal-quila", "Qutub-minar"))
        );

        System.out.println("\n\nPriting Places to visit using flatMap:: ");
        codeCityList.stream()
                .flatMap(ccp -> ccp.getPlacesToVisit().stream())
                .forEach(System.out::println);
    }
}

class CityAndPlacesToVisit {

    private String cityName;
    private List<String> placesToVisit;

    public CityAndPlacesToVisit(String cityName, List<String> placesToVisit) {
        this.placesToVisit = placesToVisit;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public List<String> getPlacesToVisit() {
        return placesToVisit;
    }
}
