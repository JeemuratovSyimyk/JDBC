package org.example.dao.daoImpl;

import org.example.config.Config;
import org.example.dao.UserDao;
import org.example.model.User;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void createUserTable() {
    String sql = "create table if not exists users("+
            "id serial primary key,"+
            "first_name varchar,"+
            "last_name varchar,"+
            "age int)";
        try {
            Connection connection = Config.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void saveUser(User user) {
        String sql = "insert into users(" +
                "first_name,last_name,age)" +
                "values (?,?,?)";
        try (
                Connection connection = Config.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.executeUpdate();
            System.out.println("User is saved");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<User> getAllUsers() {
        String sql = "select * from users";
        List<User> users = new ArrayList<>();
        try (
                Connection connection = Config.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }
    @Override
    public User getByUser(Long id) {
        return null;
    }

    @Override
    public void updateUser(Long id, User user) {

    }

    @Override
    public void cleanTable() {

    }

    @Override
    public void dropTable() {

    }
}
