package com.cybertek.library.utilities;

public class SomeRandomClass extends Thread {
    public void run(){
       try {
           System.out.println("Thread "+
                   Thread.currentThread().getId());
           System.out.println("hello");
           Thread.sleep(1000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}
