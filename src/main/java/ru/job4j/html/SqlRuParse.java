package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers").get();

        Elements pages = doc.select("td:contains(страницы)");

        for (int i = 1; i < 6; i++) {

            Elements row = doc.select(".postslisttopic");

            for (Element td : row) {
                Element href = td.child(0);
                System.out.println(href.attr("href"));
                System.out.println(href.text());
                System.out.println(td.parent().child(5).text());
            }

            doc = Jsoup.connect(pages.first().child(i).attr("href")).get();
            System.out.println(System.lineSeparator());

        }
    }
}
