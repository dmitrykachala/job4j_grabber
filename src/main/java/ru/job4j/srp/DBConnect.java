package ru.job4j.srp;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public interface DBConnect {

    Connection connect(Properties properties);

    void doQuery(Statement statement);

}
