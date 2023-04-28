/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit228g3.gabriel_final_project;
import java.sql.*;
/**
 *
 * @author Juniper Gabriel
 */
public class MySQLConnection {
    private static final String DB_URL = "jdbc:mysql://localhost/dbnotes"; // replace with your database URL
    private static final String USER = "root"; // replace with your username
    private static final String PASS = ""; // replace with your password

    public static Connection getConnection() throws SQLException {
        // Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        // Open a connection
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }

    public static class Query {
        private Connection conn;

        public Query() throws SQLException {
            conn = MySQLConnection.getConnection();
        }

        public ResultSet execute(String sql) throws SQLException {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }
        
        public ResultSet getById(String sql, int id) throws SQLException{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            return result;
        }

        public int update(String sql) throws SQLException {
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            return result;
        }

        public void close() throws SQLException {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
