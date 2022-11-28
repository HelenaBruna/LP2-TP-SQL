package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String URL = "jdbc:mysql://localhost:3306/aulaJava";
    private static String USER = "root";
    private static String PWD = "root";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}