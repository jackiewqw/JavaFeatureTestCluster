package com.wqw.generic;

import com.wqw.generic.GenericTest.OnListener;

public class GenericTest {

    interface OnListener<T>{
        void onReceive(T t);
    }
    
    public static void main(String[] args) {
        
        OnListener<Integer> l = new OnListener<Integer>(){

            @Override
            public void onReceive(Integer t) {
            }
            
        };
        
        check(l);
        
        OnListener<String> lS = new OnListener<String>(){

            @Override
            public void onReceive(String t) {
            }
            
        };
        
        check(lS);
    }
    
    public static void check(OnListener listener){
        
        
    }
}
