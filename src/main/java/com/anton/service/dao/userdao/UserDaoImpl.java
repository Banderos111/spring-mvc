package com.anton.service.dao.userdao;

import com.anton.service.connector.MySqlConnector;
import com.anton.service.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class UserDaoImpl implements UserDao {
    private static final String ADD_MESSAGE = "INSERT INTO user VALUES (?, ?, ?, ?)";
    private static final String SELECT = "SELECT*FROM user WHERE mail = ? AND password = ? ";

    @Override
    public void addUser(User user) {
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_MESSAGE);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSecondName());
            statement.setString(3, user.getMail());
            statement.setString(4, user.getPassword());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String mail, String password) {
        User user = new User();
        try (Connection connection = MySqlConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setString(1, mail);
            statement.setString(2, password);
            statement.execute();
            user = resultSetToUser(statement.getResultSet());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User resultSetToUser(ResultSet result) {
        User user = new User();
        try {
            while (result.next()) {
                user.setFirstName(result.getString("first_name"));
                user.setSecondName(result.getString("second_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
