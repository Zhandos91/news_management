package com.epam.suleimenov.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    private static String dbPath;
    private static String dbUser;
    private static String dbPassword;
    private static String dbDriver;

    static {
        Properties props = new Properties();
        try(InputStream input = new FileInputStream("src/main/resources/properties/database.properties")) {
            props.load(input);
            dbDriver = props.getProperty("db_driver");
            dbPath = props.getProperty("db_path");
            dbUser = props.getProperty("db_user");
            dbPassword = props.getProperty("db_password");

        } catch (IOException e) {
            System.out.println("Property file is not set or found");
            e.printStackTrace();
        }

        try
        {
            Class.forName(dbDriver);
        } catch (
                ClassNotFoundException e)
        {

            System.out.println("Oracle JDBC Driver is not found");
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbPath, dbUser, dbPassword);
    }

    public void closeConnection(Connection connection) {
        if(connection == null)
            return;
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
