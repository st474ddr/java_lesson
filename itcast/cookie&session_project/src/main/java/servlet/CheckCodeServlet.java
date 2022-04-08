package servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 重導向 */

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int width = 100;
		int height = 50;

		// 1. 建立物件，在memory中產生圖片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 2. 美化圖片
		// 2.1 填充背景色
		Graphics g = image.getGraphics(); // 畫筆物件
		g.setColor(Color.PINK);
		g.fillRect(0, 0, width, height);

		// 2.2 畫邊框
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width - 1, height - 1);

		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		// 生成隨機
		Random ran = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int index = ran.nextInt(str.length());
			// 獲取char
			char ch = str.charAt(index);
			sb.append(ch);
			// 2.3 寫驗證碼
			g.drawString(ch + "", width / 5 * i, height / 2);
		}
		String checkCode_session = sb.toString();
		req.getSession().setAttribute("checkCode_session", checkCode_session);

		// 2.4 畫干擾線
		g.setColor(Color.GREEN);
		// 隨機座標點
		for (int i = 0; i < 10; i++) {
			int x1 = ran.nextInt(width);
			int x2 = ran.nextInt(width);
			int y1 = ran.nextInt(height);
			int y2 = ran.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}

		// 3. 將圖片輸出顯示
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}
}
