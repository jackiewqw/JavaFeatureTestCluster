package com.wqw.runnable;

public class RunnableTest {

    public static int index=0;
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            
            @Override
            public void run() {
                System.out.println("run, "+index);
                ++index;
            }
        };
        
        for(int i=0; i<20; ++i){
            new Thread(run).start();
        }
    }
}
