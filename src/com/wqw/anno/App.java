package com.wqw.anno;

import java.lang.reflect.Method;

public class App {

    @MethodInfo(date = "2011/12/1")
    public String getAppName() {
        return "jackie";
    }

//    public static void main(String[] args) {
//        try {
//            Class<?> cls = Class.forName("com.wqw.anno.App");
//            for (Method method : cls.getMethods()) {
//                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
//                if (methodInfo != null) {
//                    System.out.println("method name:" + method.getName());
//                    System.out.println("method author:" + methodInfo.author());
//                    System.out.println("method version:" + methodInfo.version());
//                    System.out.println("method date:" + methodInfo.date());
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("com.wqw.anno.MethodInfoProcessor");
            for (Method method : cls.getMethods()) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                if (methodInfo != null) {
                    System.out.println("method name:" + method.getName());
                    System.out.println("method author:" + methodInfo.author());
                    System.out.println("method version:" + methodInfo.version());
                    System.out.println("method date:" + methodInfo.date());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
