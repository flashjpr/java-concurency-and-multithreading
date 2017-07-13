package com.flashjpr;

import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 12/07/2017.
 */
public class HelloWorldRunnable {

    public static void main(String[] args) {
        String[] countries = {"India", "Germany", "France", "USA", "UK"};
        for (String country : countries) {
            Greeter greeter = new Greeter(country);
            new Thread(greeter,country + " thread").start();
        }
    }

    public static class Greeter implements Runnable{
        private String country;

        public Greeter (String country) {
            this.country = country;
        }

        @Override
        public void run() {
            long id = Thread.currentThread().getId();

            try {
                System.out.println("Sleeping for : " + 1 + " seconds");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // safe to ignore it
            }
            System.out.println(id + ": Hello, " + country + " !");
        }
    }
}
