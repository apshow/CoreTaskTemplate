package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
//
        userService.saveUser("Ivan", "Ivanov", (byte) 33);
        userService.saveUser("Petr", "Petrov", (byte) 55);
        userService.saveUser("Mike", "Sidorov", (byte) 76);
        userService.saveUser("Tom", "Ivanoff", (byte) 82);

        userService.getAllUsers();
        userService.removeUserById(1);

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}

//   1++ public Connection getConnection() throws ClassNotFoundException, SQLException {
//        души исключения прям здесь (в рантайм или в лог и забыл)
//
//        public List&lt;User&gt; getAllUsers() {
//            userDaoJDBC.getAllUsers();
//            return null;
//            задание воообще рабочеее???
//
//            public class UserDaoJDBCImpl implements UserDao {
//                public UserDaoJDBCImpl() {
//                }
//
//                User user = new User();
//

//                Util util = null;
//                Statement statement = null;
//                PreparedStatement preparedStatement = null;
//                в каждом методе данные ссылки индивидуальны для метода
//              3. ++  испоьзуй трай с ресурсами

//       4.++     util = new Util();
//                Каждый раз не надо создавать бесполезный класс утил
//                он должен быть синглтоном
//

