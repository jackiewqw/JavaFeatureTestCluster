package com.wqw.test;

public class StaticTest {

    private static String msg = new String("你好");
    
    static{
        System.out.println(msg);
    }
    
    public static void main(String[] args) {
        
    }
}
