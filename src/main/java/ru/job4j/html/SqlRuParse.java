package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {

    private final DateTimeParser dateTimeParser;

    public SqlRuParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public static void main(String[] args) {

        SqlRuParse sqP = new SqlRuParse(new SqlRuDateTimeParser());
        sqP.list("https://www.sql.ru/forum/job-offers").forEach(System.out::println);

    }

    @Override
    public List<Post> list(String link) {
        List<Post> listPost = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(link).get();
            for (int i = 1; i < 6; i++) {

                Elements row = doc.select(".postslisttopic");
                for (Element td : row) {
                    Element href = td.child(0);
                    listPost.add(detail(href.attr("href")));
                }

            doc = Jsoup.connect(link + "/" + (i + 1)).get();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPost;
    }

    @Override
    public Post detail(String link) {
        Post post = new Post();
        try {
            Document doc = Jsoup.connect(link).get();

            post.setLink(link);

            Elements titleAll = doc.select("td.messageHeader");
            Element title = titleAll.first();

            post.setTitle(title.text());

            Elements description = doc.select(".msgBody:not(.style)");

            post.setDescription(description.next().text());

            Elements created = doc.select("td.msgFooter");
            String[] rawDate = created.first().text().split(" \\[");
            String dateStr = rawDate[0];

            post.setCreated(dateTimeParser.parse(dateStr));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return post;
    }
}
