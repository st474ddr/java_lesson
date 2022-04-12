package factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * 建立Bean object的 factory
 * 
 * Bean: 有可重用plugin的意義
 * JavaBean: 用java撰寫的可重用plugin
 * 
 * 用來建立service和dao object
 * 
 * 1. 需要配置文件配置service和dao
 * 2. 通過讀取配置文件，用reflection 建立 object
 */

public class BeanFactory {
	// 定義properties object
	private static Properties props;

	// 定義map 用來存放建立的object => 容器
	private static Map<String, Object> beans;

	// 使用static block 為 Properties object 給值
	static {
		try {
			props = new Properties();
			InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
			props.load(in);
			// 實作容器
			beans = new HashMap<String, Object>();
			// 取出配置文件的所有key
			Enumeration keys = props.keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement().toString();
				String beanPath = props.getProperty(key);
				// reflection object
				Object value = Class.forName(beanPath).newInstance();
				// 把key和value存在容器中
				beans.put(key, value);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("initial failed");
		}
	}

	/**
	 * 根據Bean名稱獲取bean object (多例)
	 * 
	 * @param beanName
	 * @return
	 */
	/*
	 * public static Object getBean(String beanName) { Object bean = null; try {
	 * String beanPath = props.getProperty(beanName); //
	 * System.out.println(beanPath); bean = Class.forName(beanPath).newInstance();
	 * // 每次都會重建一個object => 多例
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return bean; }
	 */

	/**
	 * 根據Bean名稱獲取bean object (單例)
	 * 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		return beans.get(beanName);
	}
}
