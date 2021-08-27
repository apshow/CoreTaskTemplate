package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 33);
        userService.saveUser("Petr", "Petrov", (byte) 55);
        userService.saveUser("Mike", "Sidorov", (byte) 76);
        userService.saveUser("Tom", "Ivanoff", (byte) 82);

        userService.getAllUsers();

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }

}


