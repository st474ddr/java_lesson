package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 重導向 */

@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 簡單的建議browser encoding
		resp.setContentType("text/html;charset=utf-8");
		
		// 1. 獲取byte output stream
		ServletOutputStream sos = resp.getOutputStream();
		// 2. output data
		sos.write("heelll 你好啊".getBytes("utf-8"));
	}
}
