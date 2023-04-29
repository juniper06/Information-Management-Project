/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit228g3.traya_final_project;

import com.csit228g3.traya_final_project.MySQLConnection.Query;
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
    
    public void addMerchant(String name, String description, String address, String email) throws SQLException {
        String values = String.format("NULL, '%s', '%s', '%s', '%s'"
                , name, description, address, email);
        query.update("INSERT INTO tblmerchant (id, name, description, address, email) values (" + values + ")");
    }
    
    public ResultSet getMerchants() throws SQLException{
        return query.execute("SELECT * FROM tblmerchant");
    }
    
    
    public void close() throws SQLException{
        query.close();
    }
  
    
}

