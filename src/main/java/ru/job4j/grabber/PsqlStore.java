package ru.job4j.grabber;

import ru.job4j.grabber.utils.Post;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    public PsqlStore(Properties cfg) {
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
            cnn = DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Post resultSetToPost(ResultSet resultSet) throws SQLException {
        return new Post(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getString("link"),
                resultSet.getString("description"),
                resultSet.getTimestamp("created").toLocalDateTime()
        );
    }

    @Override
    public void save(Post post) {
        try (PreparedStatement statement =
                     cnn.prepareStatement("insert into post(title, created, description, link)"
                                     + " values (?, ?, ?, ?) on conflict (link) do nothing",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, post.getTitle());
            Timestamp timestampFromLDT = Timestamp.valueOf(post.getCreated());
            statement.setTimestamp(2, timestampFromLDT);
            statement.setString(3, post.getDescription());
            statement.setString(4, post.getLink());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    post.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try (PreparedStatement statement = cnn.prepareStatement("select * from post")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    posts.add(resultSetToPost(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post findById(int id) {
        Post rsl = null;
        try (PreparedStatement statement =
                     cnn.prepareStatement("select * from post where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    rsl = resultSetToPost(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }

    public static void main(String[] args) {
        Properties cfg = new Properties();
        try {
            InputStream in = PsqlStore.class.getClassLoader()
                    .getResourceAsStream("app.properties");
            cfg.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        PsqlStore psqlS = new PsqlStore(cfg);

        psqlS.save(new Post("q", "www.q.qq", "qqq", LocalDateTime.now().minusDays(2)));
        psqlS.save(new Post("a", "www.a.aa", "aaa", LocalDateTime.now().minusDays(3)));
        psqlS.save(new Post("z", "www.z.zz", "zzz", LocalDateTime.now().minusDays(5)));
        psqlS.save(new Post("w", "www.w.ww", "www", LocalDateTime.now().minusDays(23)));
        psqlS.save(new Post("s", "www.s.ss", "sss", LocalDateTime.now().minusDays(32)));
        psqlS.save(new Post("x", "www.x.xx", "xxx", LocalDateTime.now().minusDays(12)));

        System.out.println(psqlS.getAll());

        System.out.println(psqlS.findById(5));
    }
}
