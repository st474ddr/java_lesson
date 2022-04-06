package web.request;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo1
 */
@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET request queryString
//		String username = request.getParameter("username");
//		System.out.println("get");
//		System.out.println(username);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POST request queryString
		String username = request.getParameter("username");
//		System.out.println("post");
//		System.out.println(username);

		String[] hobbies = request.getParameterValues("hobby");
//		for (String hobby : hobbies) {
//			System.out.println(hobby);
//		}

		Enumeration<String> parameterNames = request.getParameterNames();
//		while (parameterNames.hasMoreElements()) {
//			String name = parameterNames.nextElement();
//			System.out.println(name);
//			String value = request.getParameter(name);
//			System.out.println(value);
//			System.out.println("------");
//		}

		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> keyset = parameterMap.keySet();
		for (String name : keyset) {
			// 獲取key
			String[] values = parameterMap.get(name);
			System.out.println(name);
			for (String value : values) {
				System.out.println(value);
			}
		}
	}

}
