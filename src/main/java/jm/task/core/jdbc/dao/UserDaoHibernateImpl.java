package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "user")
public class UserDaoHibernateImpl implements UserDao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column (name = "name")
    private String name;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "age")
    private Byte age;



    public Long getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Byte getAge() {
        return age;
    }

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
