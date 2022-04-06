package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 重導向 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("demo1");
		
		// 跳轉/responseDemo2
		//resp.setStatus(302);
		//resp.setHeader("location", "./responseDemo2");
		
		// 動態獲取路徑
		String contextPath = req.getContextPath();
		
		req.setAttribute("msg", "response");
		// 簡單的重新導向
		resp.sendRedirect(contextPath+"/responseDemo2");
	}
}
