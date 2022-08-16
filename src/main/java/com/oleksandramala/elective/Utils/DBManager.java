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
    private static final String SQL_SELECT_USERS_BY_LOGIN_PASS = "SELECT * FROM users WHERE login=? AND password=?";


    public static synchronized DBManager getInstance() {
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    public DBManager() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/elective");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }








}
