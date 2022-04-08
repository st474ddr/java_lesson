package cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 設置response格式和編碼
		response.setContentType("text/html;charset=utf-8");
		// 1. 獲取所有cookie
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		// 2. 遍歷
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				// 3. 獲取cookie名稱
				String name = cookie.getName();
				// 4. 判斷名稱是否是:lastTime
				if ("lastTime".equals(name)) {
					flag = true;
					Date date = new Date(0);
					SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
					String str_date = sdFormat.format(date);
					// url編碼 (不然SsimpleDdateFformat不支援空格會報錯)
					str_date = URLEncoder.encode(str_date, "utf-8");
					cookie.setValue(str_date);
					cookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(cookie);
					String value = cookie.getValue();
					// url解碼
					value = URLDecoder.decode(value, "utf-8");

					response.getWriter().write("<h1>歡迎，上次登入時間為:" + value + "</h1>");
					break;
				}
			}
		}

		if (cookies == null || cookies.length == 0 || flag == false) {
			Date date = new Date();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			String str_date = sdFormat.format(date);
			str_date = URLEncoder.encode(str_date, "utf-8");
			Cookie cookie = new Cookie("lastTime", str_date);
			cookie.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cookie);
			response.getWriter().write("<h1>首次訪問</h1>");
		}
	}

}
