package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 33);
        userService.saveUser("Petr", "Petrov", (byte) 55);
        userService.saveUser("Mike", "Sidorov", (byte) 76);
        userService.saveUser("Tom", "Ivanoff", (byte) 82);

        userService.getAllUsers();
        userService.removeUserById(1L);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}