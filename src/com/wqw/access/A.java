package com.wqw.access;

public class A {

	private int p1;
	
	A(int p){
		p1 = p;
	}
	
	//同一个类的对象可以访问对方的私有方法
	public boolean isEqualTo(A anothor){
		return this.p1 == anothor.p1;
	}
}
