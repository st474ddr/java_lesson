package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 建立Cookie object
		Cookie c1 = new Cookie("msg1", "setMaxAge1");
		Cookie c2 = new Cookie("msg2", "setMaxAge2");
		Cookie c3 = new Cookie("msg3", "setMaxAge3");
		// 2.1 設置存活時間
		c1.setMaxAge(30);
		// 2.2 設置預設
		c2.setMaxAge(-1);
		// 2.3 刪除信息
		c3.setMaxAge(300);
		c3.setMaxAge(0);
		// 3. 發送Cookie
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
	}

}
