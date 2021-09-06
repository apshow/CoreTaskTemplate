package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "rootroot";
    private static Util instance;

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private Util() {
    }

    public static synchronized Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }
}
