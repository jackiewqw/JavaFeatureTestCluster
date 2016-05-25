package com.wqw.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterUtils {
	
	 //这是手机号
    public static String getClickablePhoneSpan(CharSequence charSequence) {
        String phoneStr = null;
        Pattern pattern = Pattern.compile("(\\(86\\))?([0-9])\\d{10,}");
        Matcher matcher = pattern.matcher(charSequence);
        //matcher.matches();
        
        int count = matcher.groupCount();
        System.out.println("group count = " + count);
        
        while(matcher.find()){
        	   System.out.println(matcher.group()+"start="+matcher.start()+"; end="+matcher.end());  
        }
//        for(int i=1; i<count+1; ++i){
//        	String str = matcher.group(i);
//        	System.out.println("group "+i+" is "+str);
//        }
        
        return null;
    }
    
    public static boolean isPackage(String test){
    	String pat = "^com.didi.theonebts.*";
    	Pattern pattern = Pattern.compile(pat);
    	Matcher matcher = pattern.matcher(test);
    	return matcher.matches();
    }
    
    public static void main(String[] args) {
	
    	//String test = "wodg13899170077,ddgeg18766546384";
    	//getClickablePhoneSpan(test);
    	
    	//System.exit(1);
    	
    	String test1= "~com.didi.theonebts.components";
    	String test2="cn.com.didi.theonebts.components";
    	String test3="cn.com.didi.theonebts";
    	String test4 = "com...didi.theonebts";
    	String test5= "com.didi.theonebts.components.nihao";
    	String test6= "com.didibtheonebts.business";
    	
    	System.out.println("test1 is match="+isPackage(test1));
    	System.out.println("test2 is match="+isPackage(test2));

    	System.out.println("test3 is match="+isPackage(test3));
    	System.out.println("test4 is match="+isPackage(test4));
    	
    	System.out.println("test5 is match="+isPackage(test5));
    	System.out.println("test6 is match="+isPackage(test6));

       
	}
    
}
