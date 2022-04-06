package web.download;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 獲取參數=>檔案名稱
		String filename = request.getParameter("filename");

		// 2.使用byte stream讀檔
		ServletContext servletContext = this.getServletContext();
		String realPath = servletContext.getRealPath("img/" + filename);
		FileInputStream fis = new FileInputStream(realPath);

		// 3.設定response header
		// 3.1設定類型
		String mimeType = servletContext.getMimeType(filename);
		response.setHeader("content-type", mimeType);
		// 3.2設定打開方式
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		// 4.將data輸出
		ServletOutputStream sos = response.getOutputStream();
		byte[] buff = new byte[1024 * 8];
		int len = 0;
		while ((len = fis.read(buff)) != -1) {
			sos.write(buff, 0, len);
		}
		fis.close();
	}

}
