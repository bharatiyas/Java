package com.skb.learn.java.lambda.optionals;

import com.skb.learn.java.lambda.exercise.Person;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalsBasic {

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-empty Optional:: " + gender);
        System.out.println("Non-empty Optional: Gender value: " + gender.get());
        System.out.println("Empty Optional :" + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional:: " + Optional.ofNullable(answer1));

        OptionalsBasic obj = new OptionalsBasic();

        obj.printSize(gender);
        obj.printSize(Optional.of(answer1));
        // Passing null to Optional.of() will result in NullPointerException. Therefore, we need to use
        // Optional.ofNullable
        // Optional.of() method will throw a NullPointerException if you pass it a null value as an argument
        // Since we’re not completely rid of the NullPointerException. Therefore, only use of() when you are sure the
        // object being passed is not null.
        try {
            System.out.println("Optional.of(null) throws NullPointerException:: ");
            Optional.of(null);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        // If the object can be both null or not-null, then you should instead choose the ofNullable() method
        Random random = new Random();

        if((random.nextInt(10) % 2) == 1) {
            obj.printSize(Optional.ofNullable(UUID.randomUUID().toString()));
        } else {
            System.out.println("Sending null");
            obj.printSize(Optional.ofNullable(null));
        }
        //obj.printSize(answer2);

        Optional<Person> p1 = Optional.empty();

        try {
            System.out.println("Printing Optional.empty().get() :: ");
            System.out.println(p1.get()); // Will throw java.util.NoSuchElementException since p1 does not hold any object of type Person
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }

        System.out.println("Getting default values using Optional:::::");
        System.out.println(obj.returnDefaultUsingOrElse().getFirstName());
        System.out.println(obj.returnDefaultUsingOrElseGet().getFirstName());

        try {
            System.out.println(obj.returnPersonOfThrowException().getLastName());
        } catch (IllegalArgumentException ile) {
            ile.printStackTrace();
        }

        // One very useful use-case of the Optional class is combining it with streams or other methods that return an
        // Optional value to build fluent APIs.

        /*List<Person> persons = new ArrayList<>();
        Person person = persons.stream()
                .findFirst().orElse(new Person("DefautlFN", "DefautlLN"));
*/
    }

    private void printSize(Optional<String> str) {
        // Following line will throw an exception if str is null
        System.out.println("Optional String received: " + str.get());

        // str.isPresent() == (str == null)
        if(str.isPresent()) {
            System.out.println("Used str.isPresent()");
            //map() applies the Function argument to the value, then returns the result wrapped in an Optional.
            // This makes it possible to apply and chain further operations on the response – such orElse() here.
            System.out.println(str.map(s -> "map received: ".concat(s)));

            // flatMap() also takes a Function argument that is applied to an Optional value, and then returns the
            // result directly.
            System.out.println(str.flatMap(s -> Optional.of("flatMap received: ".concat(s))));
        }

        // Following line is only executed if the user object is not null.
        str.ifPresent(s -> System.out.println("Length of String: " + s.length()));
    }

    // Ways for returning the value of the object or a default value if the object is empty.
    // Way#1 - Using orElse(). orElse() returns the value if it’s present, or the argument it receives if not

    private Person returnDefaultUsingOrElse() {

        Random random = new Random();
        Person p1 = null;
        if((random.nextInt(20) % 2) == 1) {
            p1 = new Person("Sachin", "Tendulkar", 24);
        }

        // orElse() is always executed, even if p1 is not null. This difference (with orElseGet()) can have a
        // significant effect on performance if the operation executed involves more intensive calls,
        // such as a web service call or a database query.
        return Optional.ofNullable(p1).orElse(personSupplier());
    }

    // Way#2 - Using orElseGet()

    private Person returnDefaultUsingOrElseGet() {

        Random random = new Random();
        Person p1 = null;
        if((random.nextInt(10) % 2) == 1) {
            p1 = new Person("Mahendra", "Dhoni", 24);
        }

        // orElseGet() is only executed when p1 is null
        return Optional.ofNullable(p1).orElseGet(() -> personSupplier());
    }

    private Person personSupplier() {

        System.out.println("Person Supplier called.....");
        return new Person("DefaultFN", "DefaultLN", -1);

    }

    private Person returnPersonOfThrowException() throws IllegalArgumentException {

        Random random = new Random();
        Person p1 = null;
        if((random.nextInt(10) % 2) == 1) {
            p1 = new Person("Virat", "Kohli", 24);
        }

        return Optional.ofNullable(p1).orElseThrow(() -> new IllegalArgumentException("Person object is null"));
    }

    private void getFirstNameUsingStream(Person p) {
        // Following line will work with JDK 9 and above
        // String firstName = Optional.ofNullable(p).stream()
        //                        .filter(p -> p.getFirstName().startsWith("S"))
        //                        .collect(Collectors.toList())
        //                        .get(0)
    }
}
