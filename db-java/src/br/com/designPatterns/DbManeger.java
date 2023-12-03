package br.com.designPatterns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbManeger {

    public static Connection getConnection() {
        Connection connection = null;
        Properties props = new Properties();



        try {
            InputStream input = new FileInputStream("src/resources/config.properties");
            props.load(input);
            final String url = props.getProperty("db.url");
            final String user = props.getProperty("db.user");
            final String password = props.getProperty("db.password");
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}
