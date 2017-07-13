package com.flashjpr.sleepy.bartender;

import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 13/07/2017.
 */
public class Main {

    // this class acts like a driver to the sleepy bartender demo
    public static void main(String[] args) {

        Bartender bartender = new Bartender();
        Thread bartenderThread = new Thread(bartender, "Bartender");

        bartenderThread.start();

        // take the bartender to sleep and wake up if the bell rings (client clicks the bell)
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // this can be ignored
        }

        int numberOfCustomers = 5;

        // take for ex 5 customers: create a new thread for each customer and server them
        for (int i = 0; i < numberOfCustomers; i++) {
            String customerName = "Custotmer " + i;
            Customer customer = new Customer(bartenderThread, customerName, (int) Math.random() * 10);

            new Thread(customer, customerName).start();
        }
    }
}
