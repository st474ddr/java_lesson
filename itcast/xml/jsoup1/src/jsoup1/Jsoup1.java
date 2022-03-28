package jsoup1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Jsoup1 {

	public static void main(String[] args) throws IOException {
		String path = Jsoup1.class.getClassLoader().getResource("student.xml").getPath();
		Document document = Jsoup.parse(new File(path), "utf-8");
		Elements elements = document.getElementsByTag("name");
		System.out.println(elements.size());
	}

}
