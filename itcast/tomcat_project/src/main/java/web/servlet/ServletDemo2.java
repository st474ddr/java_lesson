package web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 implements Servlet {

	// Servlet創建實執行，只會執行一次
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init...");
	}
	
	// 獲取Servlet 配置對象
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 每一次Servlet被訪問實執行，可以執行多次
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service...");
	}

	// 獲取Servlet一些信息，版本、作者...等
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	// 在Server正常關閉時執行，只會執行一次
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy...");
	}

}
