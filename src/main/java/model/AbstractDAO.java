/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tran Nguyen Nam Thuan CE171497
 * @param <T>
 */
public abstract class AbstractDAO<T> {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=Stiktify;encrypt=true;trustServerCertificate=true";
    String user = "sa";
    String password = "1234";
    Connection con;

      public AbstractDAO() {
        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException sqle) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract List<T> readAll();

    public abstract void create(T object);

//    public abstract void update(T object);

    public abstract void delete(String id);
    
    public abstract T findByID(String id);
}
