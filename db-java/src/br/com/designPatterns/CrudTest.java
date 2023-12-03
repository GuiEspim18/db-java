package br.com.designPatterns;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class CrudTest {

    public static void main(String[] args) {
        try {
            Connection connection = DbManeger.getConnection();
            System.out.println("Successfully connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
