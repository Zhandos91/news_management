package com.epam.suleimenov.database;

import org.apache.commons.dbcp.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionPool {

    private static BasicDataSource connectionPool;

    static {
        Context initialContext = null;
        try {
            initialContext = new InitialContext();
            connectionPool = (BasicDataSource) initialContext.lookup("java:/comp/env/jdbc/news");

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
