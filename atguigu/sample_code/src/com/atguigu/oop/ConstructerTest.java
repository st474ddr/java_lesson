package com.atguigu.oop;

public class ConstructerTest {
	public static void main(String[] args) {
		Person1 p1 = new Person1("小", 30);
	}
}

// 同一個package下，不能命名同名的interface, class。
class Person1 {
	private String name;
	private int age;

	public Person1() {
		System.out.println("initial");
	}

	public Person1(String name, int age) {
		this();
		System.out.println("para");
		this.name = name;
		this.age = age;
	}

}