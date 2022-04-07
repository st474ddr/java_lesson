package dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import domain.User;
import util.JDBCUtils;

public class UserDao {
	// JDBCTemplate object共用
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	/**
	 * 登入方法
	 * 
	 * @param loginUser 只有帳號和密碼
	 * @return user全部數據
	 */
	public User login(User loginUser) {

		try {// 1. 撰寫sql
			String sql = "select * from user where username = ? and password = ?";
			// 2. 呼叫query方法
			User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
					loginUser.getUsername(), loginUser.getPassword());

			return user;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}
