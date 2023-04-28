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
    
    public void editNotes(int id, String title, String date, String tags, String description) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        String sql = String.format("UPDATE tblnotes SET title = '%s', date = '%s', tags = '%s', description = '%s' WHERE id = %d",
                title, parsedDate, tags, description, id);
        query.update(sql);
    }
    
    public void addNewNotes(String title, String date, String tags, String description) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        String values = String.format("NULL, '%s', '%s', '%s', '%s'", title, parsedDate, tags, description);
        query.update("INSERT INTO tblnotes (id, title, date, tags, description) values (" + values + ")");
    }
    
    public void deleteNoteById(int id) throws SQLException{
        query.update("DELETE FROM tblnotes WHERE id = " + id);
    }
    
    public ResultSet getNotes() throws SQLException{
        return query.execute("SELECT * FROM tblnotes");
    }
    
    public ResultSet getNotesById(int id) throws SQLException{
        return query.execute("SELECT * FROM tblnotes WHERE id = " + id);
    }
    
    public ResultSet getNotesByTag(String tag) throws SQLException{
        return query.execute("SELECT * FROM tblnotes WHERE tags = " + tag);
    }
    
    public void close() throws SQLException{
        query.close();
    }
}