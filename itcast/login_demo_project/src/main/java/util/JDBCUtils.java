package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * JDBC工具 使用Druid連接pool
 */

public class JDBCUtils {
	private static DataSource ds;

	static {
		try {
			// 1. 載入配置文件
			Properties pro = new Properties();
			// 使用ClassLoader載入，獲取string input steam
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			pro.load(is);

			// 2. 初始化連接pool object
			ds = DruidDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 獲取連結pool object
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * 獲取connection object
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
