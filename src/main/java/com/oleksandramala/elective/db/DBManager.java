package com.oleksandramala.elective.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBManager {
    private static DBManager instance;
    private DataSource dataSource;

    public static synchronized DBManager getInstance(){
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    public DBManager() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/elective");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        final String user = "Cimba";
        final String password = "lion";
        final String url = "jdbc:mysql://localhost:3306/elective";

        final Connection connection = DriverManager.getConnection(url, user, password);
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE id = (?)")){
            statement.setInt(1, 1);
            final ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                String byName = "username is : "  + resultSet.getString("username");
                System.out.println(byName);
            }
        } finally {
            connection.close();
        } {
        };
    }
}
