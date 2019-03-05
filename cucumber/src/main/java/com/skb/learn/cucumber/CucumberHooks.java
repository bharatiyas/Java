package com.skb.learn.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;

// Hooks run before and after any test case. They are similar to setUp and tearDown methods in Junit
public class CucumberHooks {

    @Before(order = 2)
    public void beforeHookOne() {
        System.out.println("Initialize DB connections");
    }

    @Before(order = 1)
    public void beforeHookTwo() {
        System.out.println("Load external providers");
    }

    @After
    public void afterHook() {
        System.out.println("Close DB connections");
        System.out.println("Shutdown external providers");
    }
}
