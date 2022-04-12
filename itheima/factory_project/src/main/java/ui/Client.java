package ui;

import factory.BeanFactory;
import service.IAccountService;

/*
 * 模擬表現層 用於調用業務層
 */

public class Client {
	public static void main(String[] args) {
		// IAccountService as = new AccountServiceImpl();
		for (int i = 0; i < 5; i++) {
			// 工廠模式解耦↓
			IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
			System.out.println(as);
		}

		// as.saveAccount();
	}
}
