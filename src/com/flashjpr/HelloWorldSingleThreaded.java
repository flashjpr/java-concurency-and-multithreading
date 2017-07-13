package com.flashjpr;

import java.util.Arrays;

/**
 * Created by PC on 12/07/2017.
 */
public class HelloWorldSingleThreaded {

    public static void main(String[] args) {

        String[] countries = {"India", "Germany", "France", "USA", "UK"};
        Arrays.stream(countries)
                .forEach(country -> System.out.println("Hi, " + country));


    }
}
