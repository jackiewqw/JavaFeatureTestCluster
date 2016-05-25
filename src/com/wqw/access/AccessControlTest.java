package com.wqw.access;

/**
 * 访问控制
 * @author wangqiuwei
 *
 */
public class AccessControlTest {

	public static void main(String[] args) {
		A a1 = new A(1);
		A a2 = new A(1);
		A a3 = new A(2);
		
		System.out.println(a1.isEqualTo(a2));
		System.out.println(a1.isEqualTo(a3));
	}
}
