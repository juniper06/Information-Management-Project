/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit228g3.melicor_final_project;

import com.csit228g3.melicor_final_project.MySQLConnection.Query;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DBHelper {
    public Query query;
    
    public DBHelper(){
        try {
            query = new MySQLConnection.Query();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addUser(String firstname, String lastname, String username, String password) throws SQLException {
        String values = String.format("NULL, '%s', '%s', '%s', '%s'", firstname, lastname, username, password);
        query.update("INSERT INTO tblaccount (id, firstname, lastname, username, password) values (" + values + ")");
    }
    
    public ResultSet getUsers() throws SQLException{
        return query.execute("SELECT * FROM tblaccount");
    }
    
    public void deleteProduct(int id) throws SQLException{
        query.update("DELETE FROM tblaccount WHERE id = " + id);
    }
    
    public ResultSet getUsersById(int id) throws SQLException{
        return query.execute("SELECT * FROM tblaccount WHERE id = " + id);
    }
    
    public ResultSet getUsersByFirstName(String firstname) throws SQLException{
        return query.execute("SELECT * FROM tblaccount WHERE firstname = '" + firstname + "'");
    }
    public ResultSet getUsersByLastName(String lastname) throws SQLException{
        return query.execute("SELECT * FROM tblaccount WHERE lastname = '" + lastname + "'");
    }
    public ResultSet getUsersByUsername(String username) throws SQLException{
        return query.execute("SELECT * FROM tblaccount WHERE username = '" + username + "'");
    }
    
    
    
    public void close() throws SQLException{
        query.close();
    }
  
    
}
