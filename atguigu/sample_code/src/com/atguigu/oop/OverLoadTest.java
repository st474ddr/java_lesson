package com.atguigu.oop;

public class OverLoadTest {
	public static void main(String[] args) {
		OverLoadTest olt = new OverLoadTest();
		olt.getSum(1, 2);
		olt.getSum(1.5, 3.2);
		olt.show(1, 2, 3, 4, 5, 6);
	}

	public void getSum(int i, int j) {
		System.out.println(i + j);
	}

	public void getSum(double d1, double d2) {
		System.out.println(d1 + d2);
	}

	// 和傳入同type array會衝突
	public void show(int... numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
