package service.impl;

import dao.IAccountDao;
import factory.BeanFactory;
import service.IAccountService;

/*
 * 業務層 implements class
 */

public class AccountServiceImpl implements IAccountService {
	// private IAccountDao accountDao = new AccountDaoImpl();
	// 工廠模式解耦↓
	private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

	public void saveAccount() {
		accountDao.saveAccount();
	}
}
