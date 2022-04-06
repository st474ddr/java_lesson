package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 重導向 */

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 設置 default encoding
		resp.setCharacterEncoding("UTF-8");
		
		// 建議 browser encoding
		//resp.setHeader("content-type", "text/html;charset=utf-8");
		
		// 簡單的建議browser encoding
		resp.setContentType("text/html;charset=utf-8");
		
		// 1. 獲取string output stream
		PrintWriter pw = resp.getWriter();
		// 2. output data
		pw.write("你好 heelll");
	}
}
