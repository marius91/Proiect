
import java.sql.DriverManager;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marius
 */
public class Conectare {
    
    protected String driver;
    protected String db;
    protected Connection con;
    
    public Conectare(String driver, String db){
        this.driver = driver;
        this.db = db;
        this.con = null;
    }
    
    public String getDriver(){
        return this.driver;
    }
    
    public String getDb(){
        return this.db;
    }
    
    public Connection connect(){
        try{
            Class.forName(this.getDriver());
            return this.con = DriverManager.getConnection(this.getDb());
           // return st = this.con.createStatement();
        }
            catch(Exception ex){
            return this.con;
            }
    }
    
}
