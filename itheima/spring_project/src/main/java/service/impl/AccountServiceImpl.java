package service.impl;

import dao.IAccountDao;
import dao.impl.AccountDaoImpl;
import service.IAccountService;

/*
 * 業務層 implements class
 */

public class AccountServiceImpl implements IAccountService {
	private IAccountDao accountDao = new AccountDaoImpl();

	public AccountServiceImpl() {
		System.out.println("account service object created");
	}

	public void saveAccount() {
		accountDao.saveAccount();
	}
}
