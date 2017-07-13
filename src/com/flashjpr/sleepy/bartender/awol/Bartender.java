package com.flashjpr.sleepy.bartender.awol;

import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 13/07/2017.
 */
public class Bartender implements Runnable{

    @Override
    public void run() {

        // as default goes to sleep
        System.out.println("Bartender: Nobody here... What a great time for a nap ...");

        int timesWoken = 0;

        while (true) {

            if (Thread.interrupted()) {
                System.out.println("Bartender: Zzzzzz. Yes please, what shall I pour you?");
            }

            if (timesWoken > 2)
                break; // go home

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                timesWoken++;
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Bartender: I have been woken up 2 times already. I'll go home.");
    }
}
