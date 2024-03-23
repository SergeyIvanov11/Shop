package org.example;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread storageThread = new Thread(new Storage());
        Thread orderingAppThread = new Thread(new OrderingApp());
        storageThread.start();
        storageThread.join();
        orderingAppThread.start();
    }
}