package com.wqw.num;

public class StringToIntTest {

	public static void main(String[] args) {
		
		String s1 = null;
		String s2 = "abc";
		String s3 = "1c";
		String s4 = "23";
		String s5 = "123456789012";
		
		try{
			//int i1 = Integer.valueOf(s1);
			int i2 = Integer.valueOf(s2);
			int i3 = Integer.valueOf(s3);
			int i4 = Integer.valueOf(s4);
			int i5 = Integer.valueOf(s5);
			
			//System.out.println(i1);
			System.out.println(i2);
			System.out.println(i3);
			System.out.println(i4);
			System.out.println(i5);
		}catch( NumberFormatException e){
			e.printStackTrace();
		}
		
		System.out.println("finish");
	}
}
