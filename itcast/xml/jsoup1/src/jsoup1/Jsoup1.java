package jsoup1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Jsoup1 {

	public static void main(String[] args) throws IOException {
		// student.xml path
		String path = Jsoup1.class.getClassLoader().getResource("student.xml").getPath();
		// parse
		Document document = Jsoup.parse(new File(path), "utf-8");
		Elements elements = document.getElementsByTag("name");
		Element element = elements.get(0);
		String name = element.text();
		System.out.println(name);
	}

}
