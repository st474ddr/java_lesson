package web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 implements Servlet {

	// Servlet�Ыع����A�u�|����@��
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init...");
	}
	
	// ���Servlet �t�m��H
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// �C�@��Servlet�Q�X�ݹ����A�i�H����h��
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service...");
	}

	// ���Servlet�@�ǫH���A�����B�@��...��
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	// �bServer���`�����ɰ���A�u�|����@��
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy...");
	}

}
