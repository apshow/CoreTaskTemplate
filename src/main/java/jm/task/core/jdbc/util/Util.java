package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    // реализуйте настройку соеденения с БД

    private final String URL = "jdbc:mysql://localhost:3306/test";
    private final String USER_NAME = "root";
    private final String PASSWORD = "rootroot";
    //private final String DRIVER = "com.mysql.cj.jdbc.Driver";


    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        //Class.forName(DRIVER);

        connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        //System.out.println("connection + ");
        return connection;
    }

}
