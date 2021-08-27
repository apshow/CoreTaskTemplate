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

    User user = new User();

    Util util = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    public void createUsersTable() { //++

        try {
            util = new Util();
            statement = util.getConnection().createStatement();

            String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS user" +
                    "(user_id BIGINT(12) NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(45) NOT NULL," +
                    "last_name VARCHAR(45) NOT NULL," +
                    "age TINYINT(3) NOT NULL," +
                    "PRIMARY KEY (user_id));";
            statement.executeUpdate(sqlCreateUserTable); //++

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (util.getConnection() != null) {
                    util.getConnection().close();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void dropUsersTable() { //++

        util = new Util();

        String sqlDropUsersTable = "DROP TABLE IF EXISTS user;";
        try {
            statement = util.getConnection().createStatement();
            statement.executeUpdate(sqlDropUsersTable);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (util.getConnection() != null) {
                    util.getConnection().close();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if (util.getConnection() != null) {
                        util.getConnection().close();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void saveUser(String name, String lastName, byte age) { //++

        util = new Util();
        String sqlSaveUser = "INSERT INTO user(name, last_name, age) VALUES(?, ?, ?);";

        try {
            preparedStatement = util.getConnection().prepareStatement(sqlSaveUser);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.println("User c именем " + name + " добавлен в базу данных");

           // int rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (util.getConnection() != null) {
                    util.getConnection().close();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO +/-
    public void removeUserById(long id) {
        util = new Util();
        String sqlRemoveUserById = "DELETE FROM user WHERE user_id = " + id + ";";

        try {
            util = new Util();
            statement = util.getConnection().createStatement();
            statement.executeUpdate(sqlRemoveUserById);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() { //++
        List<User> userList = new ArrayList<>();

        String sqlGetAllUsers = "SELECT * FROM user;";
        ResultSet resultSet = null;
        try {
            util = new Util();
            statement = util.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlGetAllUsers);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                userList.add(user);
                //System.out.println(user);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (util.getConnection() != null) {
                    util.getConnection().close();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(userList);
        return userList;
    }

    public void cleanUsersTable() { //++

        String sqlCleanUsersTable = "TRUNCATE TABLE user;";
        try {
            util = new Util();
            statement = util.getConnection().createStatement();
            statement.executeUpdate(sqlCleanUsersTable); //++
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (util.getConnection() != null) {
                    util.getConnection().close();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
