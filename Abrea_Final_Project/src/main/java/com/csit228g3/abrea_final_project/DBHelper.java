/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit228g3.abrea_final_project;

import com.csit228g3.abrea_final_project.MySQLConnection.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karin
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
    
    public void addBuyer(String name, String gender, String nationality, String mop) throws SQLException {
        String values = String.format("NULL, '%s', '%s', '%s', '%s'"
                , name, gender, nationality, mop);
        query.update("INSERT INTO tblbuyer (id, name, gender, nationality, mop) values (" + values + ")");
    }
    
    public ResultSet getBuyers() throws SQLException{
        return query.execute("SELECT * FROM tblbuyer");
    }
    
    
    public void close() throws SQLException{
        query.close();
    }
  
    
}

