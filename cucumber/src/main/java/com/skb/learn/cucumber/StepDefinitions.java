package com.skb.learn.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// Step definition file contains the methods implementing each of the steps (Given, When, And, Then) we mention in the feature file
public class StepDefinitions {

    @Given("^User has opened the login page$")
    public void user_has_opened_the_login_page() throws Throwable {
        System.out.println("User has opened the login page");
    }

    // Following regular expressions and input parameters have been generated because in the When statement we
    // mentioned username (bharatiyas) and password (password!23) in "".
    @When("^The user enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void the_user_enters_username_as_and_password_as(String username, String password) throws Throwable {
        System.out.println("User enters" + username + " and " + password);
    }

    @When("^The user submits the login page$")
    public void the_user_submits_the_login_page() throws Throwable {
        System.out.println("User submits the login page");
    }

    @Then("^The user is redirected to the home page$")
    public void the_user_is_redirected_to_the_home_page() throws Throwable {
        System.out.println("Verify that current page is user home page");
    }

    @Then("^The user remains on login page$")
    public void the_user_remains_on_login_page() throws Throwable {
        System.out.println("The user is still on login page");
    }

    @Then("^An could not login error message is displayed$")
    public void an_could_not_login_error_message_is_displayed() throws Throwable {
        System.out.println("Invalid username/password message displayed");
    }
}
