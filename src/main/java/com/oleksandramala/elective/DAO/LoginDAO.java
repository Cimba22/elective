package com.oleksandramala.elective.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.oleksandramala.elective.Utils.DBManager;
import com.oleksandramala.elective.entities.Login;
import com.oleksandramala.elective.entities.Role;
import com.oleksandramala.elective.entities.User;


public class LoginDAO {

    private static final String SQL_SELECT_USERS_WHERE_LOGIN = "SELECT * FROM users WHERE login=?";
    private static final String SQL_SELECT_USERS_BY_LOGIN_PASS = "SELECT * FROM users WHERE login=? AND password=?";

    public boolean validate(Login login) throws ClassNotFoundException {
        boolean status = false;

       // Class.forName("com.mysql.jdbc.Driver");
        DBManager dbManager = DBManager.getInstance();
        try (Connection connection = dbManager.getConnection(); PreparedStatement preparedStatement = connection
                .prepareStatement("select * from user where username = ? and password = ? ")){
            preparedStatement.setString(1, login.getUsername());
//            preparedStatement.setString(2, login.getEmail());
            preparedStatement.setString(2, login.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
    public User getUser(String login, String password){
        PreparedStatement statement;
        ResultSet resultSet;
        DBManager dbManager = DBManager.getInstance();


        try (Connection con = dbManager.getConnection()){
            if("".equals(password)) {
                statement = con.prepareStatement(SQL_SELECT_USERS_WHERE_LOGIN);
                statement.setString(1, login);
            }
            else{
                statement = con.prepareStatement(SQL_SELECT_USERS_BY_LOGIN_PASS);
                statement.setString(1, login);
                statement.setString(2, password);
            }

            resultSet = statement.executeQuery();

            if(resultSet.next())
                return extractUser(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private User extractUser(ResultSet rs){
        User user = User.create();
        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setRole(Role.getFor(rs.getInt("role_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
