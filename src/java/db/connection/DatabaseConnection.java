/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connection;
/**
 *
 * @author Roshan Raj
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author doodl
 */
public class DatabaseConnection {
    public Connection con=null;
    public DatabaseConnection() throws ClassNotFoundException, SQLException
    {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
    }  
}
