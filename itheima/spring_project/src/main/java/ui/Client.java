package ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import service.IAccountService;

/*
 * 模擬表現層 用於調用業務層
 */

public class Client {

	/*
	 * 獲取spring的Ioc核心容器，並根據id獲取object
	 */
	public static void main(String[] args) {

		// ApplicationContext
		/*
		 * // 1. 獲取核心容器object // ApplicationContext ac = new
		 * ClassPathXmlApplicationContext("bean.xml"); ApplicationContext ac = new
		 * FileSystemXmlApplicationContext("src/main/resources/bean.xml"); // 2.
		 * 根據id獲取bean object IAccountService as = (IAccountService)
		 * ac.getBean("accountService"); IAccountDao adao = ac.getBean("accountDao",
		 * IAccountDao.class); // 強制轉型另外的寫法
		 * 
		 * System.out.println(as); System.out.println(adao); // as.saveAccount();
		 */
		// BeanFactory
		Resource resouce = new ClassPathResource("bean.xml");
		BeanFactory factory = new XmlBeanFactory(resouce);
		IAccountService as = (IAccountService) factory.getBean("accountService");
		System.out.println("as");
	}
}
