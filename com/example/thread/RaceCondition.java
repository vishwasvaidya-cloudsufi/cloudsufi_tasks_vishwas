package com.example.thread;

class BankAccount {
    private int balance=1000;

    //    public void withdraw(int amount){ // This method without synchronization is causing a Race Condition
//        System.out.println(Thread.currentThread().getName()+" withdrawing "+amount);
//        if(balance>=amount){
//            System.out.println(Thread.currentThread().getName()+" found sufficient balance");
//            try{
//                Thread.sleep(100);
//            }
//            catch(InterruptedException e){
//                System.out.println(Thread.currentThread().getName()+" was interrupted");
//            }
//            balance=balance-amount;
//            System.out.println("New Balance: "+balance);
//        }
//        else {
//            System.out.println("Insufficient Balance!");
//        }
//    }
    public synchronized void withdraw(int amount){ // This method with synchronization is removing a Race Condition
        System.out.println(Thread.currentThread().getName()+" withdrawing "+amount);
        if(balance>=amount){
            System.out.println(Thread.currentThread().getName()+" found sufficient balance");
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                System.out.println(Thread.currentThread().getName()+" was interrupted");
            }
            balance=balance-amount;
            System.out.println("New Balance: "+balance);
        }
        else {
            System.out.println("Insufficient Balance!");
        }
    }
//    Bob withdrawing 700
//    Alice withdrawing 700
//    Bob found sufficient balance
//    Alice found sufficient balance
//    New Balance: -400
//    New Balance: 300
}

public class RaceCondition {
    public static void main(String[] args) {
        BankAccount sharedAccount=new BankAccount();
        Runnable txn = () -> sharedAccount.withdraw(700);
        Thread Alice=new Thread(txn,"Alice");
        Thread Bob=new Thread(txn,"Bob");
        Alice.start();
        Bob.start();
    }
}
