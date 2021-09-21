package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static final String DATABASENAME = "root";
    private static final String DATABASEPASS = "cj123456";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shopingol?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    public Conn(){}

    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection( DB_URL,DATABASENAME, DATABASEPASS);
    }
}
