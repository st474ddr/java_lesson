package test;

import org.junit.Test;

import dao.UserDao;
import domain.User;

public class UserDaoTest {
	@Test
	public void testLogin() {
		User loginUser = new User();
		loginUser.setUsername("super");
		loginUser.setPassword("123");

		UserDao dao = new UserDao();
		dao.login(loginUser);

		System.out.println(loginUser);
	}
}
