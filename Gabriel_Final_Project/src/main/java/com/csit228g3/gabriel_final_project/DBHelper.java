/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit228g3.gabriel_final_project;

import com.csit228g3.gabriel_final_project.MySQLConnection.Query;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Juniper Gabriel
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
    
    public void addNewNotes(String title, String date, String tags, String description) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        String values = String.format("NULL, '%s', '%s', '%s', '%s'", title, parsedDate, tags, description);
        query.update("INSERT INTO tblnotes (id, title, date, tags, description) values (" + values + ")");
    }
    
    public ResultSet getNotes() throws SQLException{
        return query.execute("SELECT * FROM tblnotes");
    }
    
    public void close() throws SQLException{
        query.close();
    }
}