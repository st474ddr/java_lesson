package web.servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 重導向 */

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServlet獲取
		ServletContext context = this.getServletContext();

		// 定義文件名
		String filename = "a.jpg";

		// 獲取MIME類型
		String mimeType = context.getMimeType(filename);
		System.out.println(mimeType);

	}
}
