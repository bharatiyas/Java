package com.skb.learn.java.lambda.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FareRuleMain {

    public static void main(String[] args) {

        FareRuleMain thisObj = new FareRuleMain();

        FareRuleResponse resp =  thisObj.createFareRuleResponse();

        // Step#1 - In this step we:
        //                      Step1.1 - Make a Map<number, List of FareRuleEntries having that number>
        //                      Step1.2 - Make second Map<number, String - joined by \n>
        Map<String, String> someMap =
                resp.getRules().stream()
                .collect(Collectors.groupingBy(fareRuleEntry -> fareRuleEntry.getNumber())) // Step1.1
                .entrySet()
                .stream()
                .collect(Collectors.toMap(o -> o.getKey(), o -> o.getValue().stream().map(fareRuleEntry -> fareRuleEntry.getText()).collect(Collectors.joining("\n"))));  // Step2.1

        System.out.println("\nPriting desired result:: ");
        someMap.entrySet().forEach(stringListEntry -> System.out.println(stringListEntry.getKey() + ":: " + stringListEntry.getValue()));

        FareRulesResponse frr =  new FareRulesResponse();

        // Step#2 - In this step we extract each entry from the map and populate Rules in FareRulesResponse object
        frr.setRules(
                someMap.entrySet().stream()
                        .map(es -> {
                            return new FareRuleEntry(es.getKey(), es.getValue());
                        }).collect(Collectors.toList())
        );

        // We can combine above 2 steps in one:
        frr.setRules(
                resp.getRules().stream()
                        .collect(Collectors.groupingBy(fareRuleEntry -> fareRuleEntry.getNumber()))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(fareRuleEntrySet -> fareRuleEntrySet.getKey(),
                                fareRuleEntrySet -> fareRuleEntrySet.getValue().stream().map(fareRuleEntry -> fareRuleEntry.getText())
                                        .collect(Collectors.joining("\n"))))
                        .entrySet().stream()
                        .map(es -> new FareRuleEntry(es.getKey(), es.getValue()))
                        .collect(Collectors.toList())
        );

    }

    public Function<FareRuleEntry, String> groupFareRuleEntriesByNumber =
            fareRuleEntry -> fareRuleEntry.getNumber();

    private FareRuleResponse createFareRuleResponse() {

        List<FareRuleEntry> fareRuleEntryList = Arrays.asList(
                new FareRuleEntry("1", "R11"),
                new FareRuleEntry("2", "R21"),
                new FareRuleEntry("2", "R22"),
                new FareRuleEntry("3", "R31"),
                new FareRuleEntry("3", "R32"),
                new FareRuleEntry("3", "R33"),
                new FareRuleEntry("4", "R41"),
                new FareRuleEntry("4", "R42"),
                new FareRuleEntry("4", "R43"),
                new FareRuleEntry("4", "R44")
        );

        FareRuleResponse fareRuleResponse = new FareRuleResponse();
        fareRuleResponse.setRules(fareRuleEntryList);
        return fareRuleResponse;
    }
}
