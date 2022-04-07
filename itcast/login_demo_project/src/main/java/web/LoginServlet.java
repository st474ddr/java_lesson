package web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 設定編碼
		request.setCharacterEncoding("utf-8");
		// 2. 獲取參數
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		// 3. 封裝object
//		User loginUser = new User();
//		loginUser.setUsername(username);
//		loginUser.setPassword(password);

		// 2. 獲取所有參數
		Map<String, String[]> map = request.getParameterMap();
		// 3.1 建立User object
		User loginUser = new User();
		// 3.2 使用beanUtil封裝
		try {
			BeanUtils.populate(loginUser, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// 4. 呼叫UserDao的login方法
		UserDao dao = new UserDao();
		User user = dao.login(loginUser);
		// 5. 判斷是否正確
		if (user == null) {
			// 登入失敗
			request.getRequestDispatcher("/failServlet").forward(request, response);
		} else {
			// 登入成功
			// 存儲數據
			request.setAttribute("user", user);
			request.getRequestDispatcher("/successServlet").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
