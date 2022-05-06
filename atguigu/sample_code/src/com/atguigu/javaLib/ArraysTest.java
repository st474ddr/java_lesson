package com.atguigu.javaLib;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {

		// Arrays.equals
		int[] arr1 = new int[] { 1, 3, 2, 4 };
		int[] arr2 = new int[] { 1, 2, 4, 3 };
		boolean isEquals = Arrays.equals(arr1, arr2);
		System.out.println(isEquals);

		// Arrays.toString
		System.out.println(Arrays.toString(arr1));

		// Arrays.fill
		Arrays.fill(arr1, 10);
		System.out.println(Arrays.toString(arr1));

		// Arrays.sort
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));

		// Arrays.binarySearch
		int[] arr3 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 20, 50 };
		int index = Arrays.binarySearch(arr3, 20);
		System.out.println(index);

	}
}