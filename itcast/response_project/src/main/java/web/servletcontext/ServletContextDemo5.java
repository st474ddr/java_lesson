package web.servletcontext;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 重導向 */

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServlet獲取
		ServletContext context = this.getServletContext();

		// 獲取文件的server path
		String realPath = context.getRealPath("/b.txt"); // webapp下資源
		System.out.println(realPath);
		File file = new File(realPath);

		String c = context.getRealPath("/WEB-INF/c.txt"); // WEB-INF下資源
		System.out.println(c);

		String a = context.getRealPath("/WEB-INF/classes/a.txt"); // src下資源
		System.out.println(a);
	}
}
