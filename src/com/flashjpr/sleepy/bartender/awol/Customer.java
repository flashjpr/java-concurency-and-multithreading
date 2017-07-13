package com.flashjpr.sleepy.bartender.awol;

import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 13/07/2017.
 */
public class Customer implements Runnable{

    private Thread bartenderThread;
    private String name;
    private int waitTime;

    public Customer(Thread bartenderThread, String name, int waitTime) {
        this.name = name;
        this.waitTime = waitTime;
        this.bartenderThread = bartenderThread;
    }

    @Override
    public void run() {
        System.out.println(name + ": anyone serving at the bar? I'll wait a moment.");

        try {
            TimeUnit.SECONDS.sleep(waitTime);
        } catch (InterruptedException e) {
            System.out.println(name + ": Hey! Is that bartender leaving?");
            return;
        }

        System.out.println("Found the bell. Can anyone serve me please?");

        //  call the bell (interrupt the bartender!)
        bartenderThread.interrupt();
    }
}
