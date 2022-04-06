package web.servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 重導向 */

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 通過request object
		ServletContext context1 = req.getServletContext();
		// 通過HttpServlet object
		ServletContext context2 = this.getServletContext();

		System.out.println(context1);
		System.out.println(context2);

	}
}
