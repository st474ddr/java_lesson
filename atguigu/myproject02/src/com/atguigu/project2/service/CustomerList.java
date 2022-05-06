package com.atguigu.project2.service;

import com.atguigu.project2.bean.Customer;

public class CustomerList {
	private Customer[] customers;
	private int customerCount = 0;

	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	public boolean addCustomer(Customer customer) {
		if (customerCount > customers.length) {
			return false;
		}
		customers[customerCount++] = customer;
		return true;
	}

	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= customerCount) {
			return false;
		}
		customers[index] = cust;
		return true;
	}

	public boolean deleteCustmer(int index) {
		if (index < 0 || index >= customerCount) {
			return false;
		}
		for (int i = index; i < customerCount - 1; i++) {
			customers[i] = customers[i + 1];
		}
		customers[--customerCount] = null;
		return true;
	}

	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[customerCount];
		for (int i = 0; i < customerCount; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}

	public Customer getCustomer(int index) {
		if (index < 0 || index >= customerCount) {
			return null;
		}
		return customers[index];
	}

	public int getTotal() {
		return customerCount;
	}
}
