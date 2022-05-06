package com.atguigu.oop;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.eat();
	}
}

class Person {
	String name;
	int age = 1;
	boolean isMale;

	public void eat() {
		System.out.println("eating");
	}
}