package com.oleksandramala.elective.Utils;



import com.oleksandramala.elective.entities.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBManager {
    private static DBManager instance;
    private DataSource dataSource;

    private static final String SQL_SELECT_USERS_WHERE_LOGIN = "SELECT * FROM users WHERE login=?";
    private static final String SQL_SELECT_USERS_BY_LOGIN_PASS= "SELECT * FROM users WHERE login=? AND password=?";


    public static synchronized DBManager getInstance(){
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    public DBManager() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/elective");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection con = null;
        ResultSet resultSet;
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = dataSource.getConnection();
            resultSet = statement.executeQuery();
            statement = con.prepareStatement("SELECT * FROM user WHERE id = (?)");
            String byName = "username is : "  + resultSet.getString("username");
            System.out.println(byName);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }


    public User getUser() {
        PreparedStatement statement = null;
        ResultSet resultSet;
        String byName = null;
        try (Connection connection = getConnection()){
            resultSet = statement.executeQuery();
            statement = connection.prepareStatement("SELECT * FROM user WHERE id = (?)");
            byName = "username is : "  + resultSet.getString("username");
            System.out.println(byName);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


//        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE id = (?)")){
//            statement.setInt(1, 1);
//            final ResultSet resultSet = statement.executeQuery();
//
//            if(resultSet.next()){
//                String byName = "username is : "  + resultSet.getString("username");
//                System.out.println(byName);
//            }
//        } finally {
//            connection.close();
//        } {
//        };
//    }



    public static void main(String[] args) throws SQLException {
        final String user = "Cimba";
        final String password = "lion";
        final String url = "jdbc:mysql://localhost:3306/elective";

        DBManager dbManager = new DBManager();
        dbManager.getConnection();

    }
}
