package com.flashjpr;

import java.util.Arrays;

/**
 * Created by PC on 12/07/2017.
 */
public class HelloWorldMultiThreaded {

    public static void main(String[] args) {
        String[] countries = {"India", "Germany", "France", "USA", "UK"};
        for (String country : countries) {
            new Greeter(country).start();
        }
    }

    public static class Greeter extends Thread {
        private String country;

        public Greeter (String country) {
            super(country + "thread");
            this.country = country;
        }

        public void run() {
            long id = Thread.currentThread().getId();
            System.out.println(id + ": Hello, " + country + " !");
        }
    }
}
