
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marius
 */

public class table extends JFrame {
    JTable table;
    
    public table()
    {
    setLayout(new FlowLayout());
    String[] numeColoane={"Cod","Nume","Pret","Stoc","Data Expirarii","Compenasare"};
    
    Object [][] data =
    {
        {"sa","ceai","10","10","Da"},
            {"da","sampon","100","1000","Nu"}
    };
    
    }
    
}
