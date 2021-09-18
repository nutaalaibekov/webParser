package com.nutaalaibekov.dao.impl;

import java.sql.*;

public abstract class BaseDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    protected Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    protected void properlyCloseResoures(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
