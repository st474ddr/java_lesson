package eesy_01jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
	public static void main(String[] args) throws Exception {
		// 1. 註冊驅動
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// 解耦↓ (但還存在更換來源問題 => 設定配置文件解決)
		Class.forName("com.mysql.jdbc.Driver");
		// 2. 獲取連接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db1?serverTimezone=UTC", "root", "");
		// 3. 獲取DB的prepared object
		PreparedStatement pstm = conn.prepareStatement("select * from account");
		// 4. 執行Sql 獲得結果
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("name"));
		}
		rs.close();
		pstm.close();
		conn.close();
	}
}
