package com.flashjpr.sleepy.bartender;

import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 13/07/2017.
 */
public class Bartender implements Runnable{

    @Override
    public void run() {

        // as default goes to sleep
        System.out.println("Bartender: Nobody here... What a great time for a nap ...");

        while (true) {
            // interrupted() checks the thread is interrupted and clears the interrupt
            if (Thread.interrupted()) {
                System.out.println("Bartender: Zzzzzz. Yes please, what shall I pour you?");
            }

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
