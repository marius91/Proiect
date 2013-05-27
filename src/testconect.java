import java.sql.*;
import javax.swing.JOptionPane;

public class testconect {
    
    public static void main(String[] args){
        int pret;
        String nume,prenume;
        String query="SELECT * FROM Medicament2";
        try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
        }
        catch(java.lang.ClassNotFoundException e){
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection("jdbc:odbc:DB");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                nume=rs.getString("nume");
               // prenume=rs.getString("nume");
                pret=rs.getInt("pret");
                System.out.println(nume+" "+pret);
                }
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null,"da");
            }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"nu");
        }
        
    }
    
}
