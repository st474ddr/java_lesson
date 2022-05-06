package com.atguigu.project2.ui;

import com.atguigu.project2.bean.Customer;
import com.atguigu.project2.service.CustomerList;
import com.atguigu.project2.util.CMUtility;

public class CustomerView {
	private CustomerList customerList = new CustomerList(10);

	public CustomerView() {
		Customer customer = new Customer("Qoo", 'M', 32, "0912345678", "test@mail.com");
		customerList.addCustomer(customer);
	}

	public void enterMainMenu() {
		boolean isExit = false;
		while (!isExit) {
			System.out.println("\n----------------Customer data managment----------------\n");
			System.out.println("                 1 add data");
			System.out.println("                 2 modify data");
			System.out.println("                 3 delete data");
			System.out.println("                 4 check list");
			System.out.println("                 5 exit\n");
			System.out.println("                 type(1-5),");

			char menu = CMUtility.readMenuSelection();

			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("exit?(Y/N)");
				char isExitConfirm = CMUtility.readConfirmSeletion();

				if (isExitConfirm == 'Y') {
					isExit = true;
				}
			}
		}
	}

	private void addNewCustomer() {
		System.out.println("\\n----------------adding customer...----------------\\n");
		System.out.println("name: ");
		String name = CMUtility.readString(10);

		System.out.println("gender: ");
		char gender = CMUtility.readChar();

		System.out.println("age: ");
		int age = CMUtility.readInt();

		System.out.println("phone: ");
		String phone = CMUtility.readString(10);

		System.out.println("email: ");
		String email = CMUtility.readString(30);

		Customer customer = new Customer(name, gender, age, phone, email);

		if (customerList.addCustomer(customer)) {
			System.out.println("\n----------------add success...----------------\n");
		} else {
			System.out.println("\n----------------failed. the list is full...----------------\n");
		}

	}

	private void modifyCustomer() {
		System.out.println("\n----------------modifying customer...----------------\n");
		Customer cust;
		int number;
		for (;;) {
			System.out.println("Please type a number of the customer(-1 exit)");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			}

			cust = customerList.getCustomer(number - 1);
			if (cust == null) {
				System.out.println("the customer doesn't exist.");
			} else {
				break;
			}
		}

		System.out.println("name(" + cust.getName() + "):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.println("name(" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.println("name(" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("name(" + cust.getPhone() + "):");
		String phone = CMUtility.readString(10, cust.getPhone());
		System.out.println("name(" + cust.getEmail() + "):");
		String email = CMUtility.readString(30, cust.getEmail());

		Customer modifiedCust = new Customer(name, gender, age, phone, email);
		if (customerList.replaceCustomer(number - 1, modifiedCust)) {
			System.out.println("\n----------------modify success...----------------\n");
		} else {
			System.out.println("\n----------------failed.----------------\n");
		}
	}

	private void deleteCustomer() {
		Customer cust;
		int number;
		for (;;) {
			System.out.println("Please type a number of the customer(-1 exit)");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			}

			cust = customerList.getCustomer(number - 1);
			if (cust == null) {
				System.out.println("the customer doesn't exist.");
			} else {
				break;
			}
		}
		System.out.println("\n----------------deleting customer...----------------\n");
		System.out.println("\n----------------delete?(Y/N)----------------\n");
		char isDeleted = CMUtility.readChar();
		if (isDeleted == 'Y') {
			if (customerList.deleteCustmer(number - 1)) {
				System.out.println("\n----------------delete success...----------------\n");
			} else {
				System.out.println("\n----------------failed.----------------\n");
			}

		} else {
			return;
		}

	}

	private void listAllCustomers() {
		System.out.println("\n----------------Customers list----------------\n");
		if (customerList.getTotal() > 0) {
			System.out.println("no.\tname\tgender\tage\tphone\temail");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; i++) {
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
						+ "\t" + cust.getPhone() + "\t" + cust.getEmail());
			}
		} else {
			System.out.println("empty data");
		}
		System.out.println("\n----------------------------------------------\n");
	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
}
