package com.wqw.test;

public class TestString {

    public static void main(String[] args) {
        String str = "abM1,123";
        int cntU = 0;
        int cntL = 0;
        int cntOther = 0;
        int i;
        for (i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                cntU++;
            } else if (Character.isLowerCase(ch)) {
                cntL++;
            } else {
                cntOther++;
            }
        }

        System.out.printf("��д��ĸ����Ϊ:%d\n", cntU);
        System.out.printf("Сд��ĸ����Ϊ:%d\n", cntL);
        System.out.printf("��д��ĸ����Ϊ:%d\n", cntOther);
    }
}
