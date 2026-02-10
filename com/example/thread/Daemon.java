package com.example.thread;

public class Daemon { // This class demonstrates the implementation of a Daemon Thread
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Daemon Thread Running!");
            }
        });
        thread.setDaemon(true);
        thread.start();
        try{
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
