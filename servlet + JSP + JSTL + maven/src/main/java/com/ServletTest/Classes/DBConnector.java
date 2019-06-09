package com.ServletTest.Classes;

import java.sql.*;

public class DBConnector {

    /*
    * CREATE TABLE Java_user (
    * Id SERIAL PRIMARY KEY,
    * Username varchar(45) NOT NULL,
    * Password varchar(45) NOT NULL
    * );*/


    //private final String ADDITIONAL_ARGS = "?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";

    //private final String HOST_NAME = "localhost";
    //private final String DB_PORT = "3306";
    //private final String DB_NAME = "default_java_db";

    //private final String USERNAME = "ilya";
    //private final String PASSWORD = "password";
    //private final String CONNECTION_URI = "jdbc:mysql://" + HOST_NAME + ":" + DB_PORT + "/" + DB_NAME + ADDITIONAL_ARGS;

    private final String ADDITIONAL_ARGS = "?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";

    private final String HOST_NAME = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "laaabs";

    private final String USERNAME = "root";
    private final String PASSWORD = "DeWWsh123";
    //private final String CONNECTION_URI = "jdbc:mysql://" + HOST_NAME + ":" + DB_PORT + "/" + DB_NAME + ADDITIONAL_ARGS;

    private final String CONNECTION_URI = "jdbc:mysql://localhost:3306/laaabs?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";


    public static final String USERNAME_COLUMN = "Username";
    public static final String PASSWORD_COLUMN = "Password";

    private final String SELECT_QUERY = "SELECT Id, Username, Password FROM Users ";
    private final String INSERT_QUERY = "INSERT INTO Users (Username, Password) values (?, ?)";


    private String usernameField;
    private String passwordField;

    public DBConnector(String username, String password){
        usernameField = username;
        passwordField = password;
    }


    public void RegisterUser(Connection connection) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        statement.setString(1, usernameField);
        statement.setString(2, passwordField);
        statement.execute();
    }

    public Connection GetConnection() throws SQLException{
        return DriverManager.getConnection(CONNECTION_URI, USERNAME, PASSWORD);
    }

    public ResultSet GetUsers(Connection connection) throws SQLException{
        return connection.createStatement().executeQuery(SELECT_QUERY + "WHERE Username='" + usernameField + "' AND Password='" + passwordField + "'");
    }
}
