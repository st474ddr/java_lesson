package web.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo1
 */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		System.out.println(method);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		String queryString = request.getQueryString();
		System.out.println(queryString);
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println(requestURL);
		String protocol = request.getProtocol();
		System.out.println(protocol);
		String remoteAddr = request.getRemoteAddr();
		System.out.println(remoteAddr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
