/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.webapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
   private Connection conn;

    public Database() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tienda",
                    "root",
                    "Admin$1234");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    } 
}
