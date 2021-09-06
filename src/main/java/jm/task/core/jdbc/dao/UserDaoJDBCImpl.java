package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {

        String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS user" +
                "(user_id BIGINT(12) NOT NULL AUTO_INCREMENT," +
                "name VARCHAR(45) NOT NULL," +
                "last_name VARCHAR(45) NOT NULL," +
                "age TINYINT(3) NOT NULL," +
                "PRIMARY KEY (user_id));";


        try (
        PreparedStatement preparedStatement = Util.getInstance().getConnection().prepareStatement(sqlCreateUserTable)) {
            preparedStatement.executeUpdate();
            System.out.println("таблицу сделал");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sqlDropUsersTable = "DROP TABLE IF EXISTS user;";
        try (Statement statement = Util.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(sqlDropUsersTable);
            System.out.println("таблицу удалил");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //todo
    public void saveUser(String name, String lastName, byte age) {


        String sqlSaveUser = "INSERT INTO user(name, last_name, age) VALUES(?, ?, ?);";

        try (PreparedStatement preparedStatement = Util.getInstance().getConnection().prepareStatement(sqlSaveUser)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.println("User c именем " + name + " добавлен в базу данных");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlRemoveUserById = "DELETE FROM user WHERE user_id = " + id + ";";

        try (Statement statement = Util.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(sqlRemoveUserById);
            System.out.println("пользователя с ID" + id + " удалил");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //todo
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        String sqlGetAllUsers = "SELECT * FROM user;";
        ResultSet resultSet = null;
        try (Statement statement = Util.getInstance().getConnection().createStatement()) {
            resultSet = statement.executeQuery(sqlGetAllUsers);
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(userList);
        return userList;
    }

    //todo
    public void cleanUsersTable() {

        String sqlCleanUsersTable = "TRUNCATE TABLE user;";

        try (Statement statement = Util.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(sqlCleanUsersTable);
            System.out.println("таблицу очистил");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
