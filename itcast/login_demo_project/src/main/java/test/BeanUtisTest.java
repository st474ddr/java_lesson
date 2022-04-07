package test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import domain.User;

public class BeanUtisTest {
	@Test
	public void test() {
		User user = new User();
		try {
			BeanUtils.setProperty(user, "genderProperty", "GG");
			System.out.println(user);

			String gender = BeanUtils.getProperty(user, "genderProperty");
			System.out.println(gender);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}
}
