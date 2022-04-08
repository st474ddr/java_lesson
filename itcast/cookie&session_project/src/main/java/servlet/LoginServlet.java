package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkCode");
		// 先判斷驗證碼是否正確
		HttpSession session = request.getSession();
		String checkCode_session = (String) session.getAttribute("checkCode_session");
		session.removeAttribute("checkCode_session");
		if (checkCode_session != null && checkCode_session.equals(checkCode)) {

			// 比對帳號密碼
			if ("admin".equals(username) && "123".equals(password)) {
				session.setAttribute("user", username);
				response.sendRedirect(request.getContextPath() + "/success.jsp");
			} else {
				request.setAttribute("login_error", "帳號或密碼錯誤");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("cc_error", "驗證碼錯誤");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
