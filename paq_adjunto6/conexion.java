package paq_adjunto6;

/*
 * ConeccionBD.java
 *
 * Created on 4 de diciembre de 2006, 12:04 PM
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.*;
/**
 *
 * @author Sistemas Corporativos I
 */

public class conexion
{
    
    public final String CONTROLADOR_JDBC_POSTGRES = "org.postgresql.Driver";
    public final String CONTROLADOR_JDBC_MYSQL = "com.mysql.jdbc.Driver";
    
    
//    private static String usuario=Main.Configure[0][1];
//    private static String contra=Main.Configure[0][2];
//    private static String importancia="1";
//    private String baseActiva=Configure[0][3];

    private static String computadoraResidente = "localhost"; //computadora residente
    private static String usuario="postgres";
    private static String contra= "1234";
    private String baseActiva="bdcomven";
    private static String puerto = "5432"; //
    private static String importancia="1";
    private static String cEmpresa = "1";
    private static String cSucursal = "1";
    /** La conexion con la base de datos */
    
    //private Connection conexion = null;
    public Connection conexion = null;

    Statement stmt;
    ResultSet rs;
    String codigo;
    /**
     * Recibe la base de datos con que se encuentra la conexion
     * @return
     */
    public String getBaseActiva() {
        return baseActiva;
    }
    public String getUsuario()
    {
        return usuario;
    }
    public String getContra()
    {
        return contra;
    }
    public void setUsuario(String usuario)
    {
        this.usuario=usuario;
    }
    public void setContra(String contra)
    {
        this.contra = contra;
    }
    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }
    public String getImportancia() {
        return importancia;
    }
    public static String getPuerto() {
        return puerto;
    }
    public void setPuerto(String puerto)
    {
        this.puerto = puerto;
    }
    public void setBaseActiva(String baseActiva) {
        this.baseActiva = baseActiva;
    }
    public void setComputadoraResidente(String computadoraResidente)
    {
        this.computadoraResidente = computadoraResidente;
    }

    public static String getComputadoraResidente() {
        return computadoraResidente;
    }

    public static String getcEmpresa() {
        return cEmpresa;
    }

    public static String getcSucursal() {
        return cSucursal;
    }

    public void setcEmpresa(String cEmpresa) {
        this.cEmpresa = cEmpresa;
    }

    public void setcSucursal(String cSucursal) {
        this.cSucursal = cSucursal;
    }





    /** Creates a new instance of ConeccionBD */
    public conexion() {
        //estaConectado();
    }

    public boolean estaConectado()
    {
        if (conexion != null)
            return true;
        try
        {
           // Se registra el Driver de MySQL
           // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName( CONTROLADOR_JDBC_POSTGRES ); //del postgres
//            Class.forName( "com.mysql.jdbc.Driver" );

            // Se obtiene una conexion con la base de datos. Hay que
            // cambiar el usuario "usuario" y la clave "" por las
            // adecuadas a la base de datos que estemos usando.
            //conexion  = DriverManager.getConnection("jdbc:postgresql://localhost:5433/"+baseActiva, usuario, contra);
            
            conexion  = DriverManager.getConnection("jdbc:postgresql://"+computadoraResidente+":"+puerto+"/"+baseActiva, usuario, contra);
//            conexion  = DriverManager.getConnection("jdbc:mysql://localhost/bdcyber","root","123");

            //conexion = DriverManager.getConnection(
            // "jdbc:mysql://localhost/supsys","root","");
            // "jdbc:mysql://localhost/rrhh","root","");
            System.out.println("pase conexion..................");
        } catch (Exception e)
        {
            //e.printStackTrace();
            conexion=null;
            return false;
        }
        return true;
    }

    public boolean borrarRegistro(String tabla, String condicion){
        int resultado;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta.
            JOptionPane optionPane=new JOptionPane();
	    Object[] opciones={"Si","No"};
	    //Dialogo modal SI_NO
	    int ret=optionPane.showOptionDialog(null,"Desea Borrar? ","Pregunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
	    //Si la opcion escogida es Si
	    if(ret==JOptionPane.YES_OPTION)
		resultado = s.executeUpdate("delete from "+tabla+" where "+condicion);
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion",
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean borrarRegistroSinPreguntar(String tabla, String condicion){
        int resultado;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            resultado = s.executeUpdate("delete from "+tabla+" where "+condicion);
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean executeQuery(String sql)
    {
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void ExecuteQuery(String sql)
    {
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            s.executeQuery(sql);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Permite insertar en una base de datos a partir de un procedimiento almacenado
     * @param abm_name - Nombre del procedimiento
     * @param valores - Valores. ejemplo: 'a','b'
     * @param modalidad - 1 Insertar, 2 Actualizar, 3 Eliminar
     * @return
     */
    public boolean abmRegistro(String abm_name, String valores, String modalidad){
        int resultado;
        try
        {
            // Se crea un Statement, para realizar la consulta
           Statement s = conexion.createStatement();
           System.out.println("select "+abm_name+"('"+modalidad+"',"+valores+")");
            // Se realiza la consulta.
     	   s.executeQuery("select "+abm_name+"('"+modalidad+"',"+valores+")");
        } catch (SQLException e)
        {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error\n"+e.getMessage() , "Atencion",
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean insertarRegistro(String tabla, String campos, String valores){
        int resultado;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta.
     	   resultado = s.executeUpdate("insert into "+tabla+" ("+campos+") values ("+valores+")");
        } catch (Exception e)
        {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error\n"+e.getMessage() , "Atencion",
            JOptionPane.INFORMATION_MESSAGE);
            System.out.println("insert into "+tabla+" ("+campos+") values ("+valores+")");
            return false;
        }
        return true;
    }

     public boolean actualizarRegistro(String tabla, String campos, String criterio){
        int resultado;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta.
            resultado = s.executeUpdate("update "+tabla+" set "+campos+" where " +criterio);
            System.out.println("update "+tabla+" set "+campos+" where " +criterio);
        } catch (Exception e)
        {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error\n"+e.getMessage() , "Atencion",
            JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
     }

    public ResultSet dameLista(String campos, String tabla, String condicion)
    {
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery("select "+campos+" from "+tabla+" "+condicion);
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion",
            JOptionPane.INFORMATION_MESSAGE);
            System.out.println("select "+campos+" from "+tabla+" "+condicion);
        }
        return rs;
    }

    /**
     * Crea un resultado segun la consulta que hagamos
     * @param sql
     * @return
     */
    public ResultSet dameLista(String sql)
    {
        ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(sql);

        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion",
            JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println(sql);
        return rs;
    }
    /**
     * Carga un conjunto de combox
     * @param sql
     * @param combo
     */
    public void cargarCombo(String sql, JComboBox[]combo)
    {
        for (int i = 0; i < combo.length; i++)
            cargarCombo(sql, combo[i]);
    }
    /**
     * Permite colocar datos previos antes de la consulta sql. Recomendacion rapida: Si queremos usar algo mas rapido podremos declarar: new String[][]{ {"-","-"} }
     * @param datosPrevios
     * @param sql
     * @param combo
     */
    public void cargarCombo(String[][]datosPrevios, String sql, JComboBox combo)
    {
        ResultSet rs = null;
        int contar=0;
        combo.removeAllItems();
        try
        {
            /**
             * Donde agregamos primero los datos que seran antes y luego los que seran segun la consulta sql
             */
            for (int i = 0; i < datosPrevios.length; i++)
            {
                String columnas[] = new String[2];
                columnas[0]=datosPrevios[i][0];
                columnas[1]=datosPrevios[i][1];
                combo.addItem(columnas);
            }
            Statement s = conexion.createStatement();
            rs = s.executeQuery(sql);
            System.out.println(sql);
            while (rs.next())
            {
                String columnas[] = new String[2];
		columnas[0] = rs.getString(1);
		columnas[1] = rs.getString(2);
		combo.addItem (columnas);
                contar++;
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error: "+e.toString() , "Atencion1",
            JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (contar>0)
        {
            combo.setRenderer (new DefaultListCellRenderer()
            {
		  public java.awt.Component getListCellRendererComponent (
		    JList l,Object o,int i,boolean s, boolean f)
		  {
                     try{
		     return new JLabel (((String[])o)[1]);
                     }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion1",
                        JOptionPane.INFORMATION_MESSAGE);
                        return null;
                    }
		  }
		});
        }else
        //variante modificada...
        {
            //en caso de error probar lo siguiente
                //com_horarios.removeAllItems(); puede que no lleve porque siempre se le pasa datos vacios
                //com_horarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"",""}));
            //fin caso de error

            //prototipo de error 1
                combo.addItem(new String[]{"",""});
                combo.setRenderer (new DefaultListCellRenderer()
                {
                      public java.awt.Component getListCellRendererComponent (
                        JList l,Object o,int i,boolean s, boolean f)
                      {
                         try{
                         return new JLabel (((String[])o)[1]);
                         }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion1",
                            JOptionPane.INFORMATION_MESSAGE);
                            return null;
                        }
                      }
                    });
            //prototipo de error 1
        }
        //fin modificacion
    }
    /**
     * Permite colocar datos posteriores despues de la consulta sql. Recomendacion rapida: Si queremos usar algo mas rapido podremos declarar: new String[][]{ {"-","-"} }
     * @param datosPrevios
     * @param sql
     * @param combo
     */
    public void cargarCombo(String sql, String[][]datosPosteriores, JComboBox combo)
    {
        ResultSet rs = null;
        int contar=0;
        combo.removeAllItems();
        try
        {
            Statement s = conexion.createStatement();
            rs = s.executeQuery(sql);
            System.out.println(sql);
            while (rs.next())
            {
                String columnas[] = new String[2];
		columnas[0] = rs.getString(1);
		columnas[1] = rs.getString(2);
		combo.addItem (columnas);
                contar++;
            }
            /**
             * Donde agregamos primero los datos que seran antes y luego los que seran segun la consulta sql
             */
            for (int i = 0; i < datosPosteriores.length; i++)
            {
                String columnas[] = new String[2];
                columnas[0]=datosPosteriores[i][0];
                columnas[1]=datosPosteriores[i][1];
                combo.addItem(columnas);
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error: "+e.toString() , "Atencion1",
            JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (contar>0)
        {
            combo.setRenderer (new DefaultListCellRenderer()
            {
		  public java.awt.Component getListCellRendererComponent (
		    JList l,Object o,int i,boolean s, boolean f)
		  {
                     try{
		     return new JLabel (((String[])o)[1]);
                     }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion1",
                        JOptionPane.INFORMATION_MESSAGE);
                        return null;
                    }
		  }
		});
        }else
        //variante modificada...
        {
            //en caso de error probar lo siguiente
                //com_horarios.removeAllItems(); puede que no lleve porque siempre se le pasa datos vacios
                //com_horarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"",""}));
            //fin caso de error

            //prototipo de error 1
                combo.addItem(new String[]{"",""});
                combo.setRenderer (new DefaultListCellRenderer()
                {
                      public java.awt.Component getListCellRendererComponent (
                        JList l,Object o,int i,boolean s, boolean f)
                      {
                         try{
                         return new JLabel (((String[])o)[1]);
                         }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion1",
                            JOptionPane.INFORMATION_MESSAGE);
                            return null;
                        }
                      }
                    });
            //prototipo de error 1
        }
        //fin modificacion
    }
    /**
     * Carga un combox a partir de la consulta sql
     * @param sql
     * @param combo
     */
    public void cargarCombo(String sql, JComboBox combo)
    {
        ResultSet rs = null;
        int contar=0;
        combo.removeAllItems();
        try{
            Statement s = conexion.createStatement();
            rs = s.executeQuery(sql);
            System.out.println(sql);
            while (rs.next())
            {
                String columnas[] = new String[2];
		columnas[0] = rs.getString(1);
		columnas[1] = rs.getString(2);
		combo.addItem (columnas);
                contar++;
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error: "+e.toString() , "Atencion1",
            JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (contar>0)
        {
            combo.setRenderer (new DefaultListCellRenderer()
            {
		  public java.awt.Component getListCellRendererComponent (
		    JList l,Object o,int i,boolean s, boolean f)
		  {
                     try{
		     return new JLabel (((String[])o)[1]);
                     }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion1",
                        JOptionPane.INFORMATION_MESSAGE);
                        return null;
                    }
		  }
		});
        }else
        //variante modificada...
        {
            //en caso de error probar lo siguiente
                //com_horarios.removeAllItems(); puede que no lleve porque siempre se le pasa datos vacios
                //com_horarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"",""}));
            //fin caso de error
            
            //prototipo de error 1
                combo.addItem(new String[]{"",""});
                combo.setRenderer (new DefaultListCellRenderer()
                {
                      public java.awt.Component getListCellRendererComponent (
                        JList l,Object o,int i,boolean s, boolean f)
                      {
                         try{
                         return new JLabel (((String[])o)[1]);
                         }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion1",
                            JOptionPane.INFORMATION_MESSAGE);
                            return null;
                        }
                      }
                    });
            //prototipo de error 1
        }
        //fin modificacion
        return;
    }
    /**
     * Carga un combox a partir de la consulta sql
     * @param sql
     * @param combo
     */
    public void cargarComboPrototipe(String sql, JComboBox combo){
        ResultSet rs = null;
        int contar=0;
        combo.removeAllItems();
        try{
            Statement s = conexion.createStatement();
            rs = s.executeQuery(sql);
            System.out.println(sql);
            while (rs.next())
            {
                String columnas[] = new String[2];
		columnas[0] = rs.getString(1);
		columnas[1] = rs.getString(2);
		combo.addItem (columnas);
                contar++;
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrio Un error: "+e.toString() , "Atencion1",
            JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (contar>0)
        {
            combo.setRenderer (new DefaultListCellRenderer()
            {
		  public java.awt.Component getListCellRendererComponent (
		    JList l,Object o,int i,boolean s, boolean f)
		  {
                    //l.setPreferredSize(new Dimension (300, 200));
                    
                    l.setFixedCellHeight(20);

                     try{
		     return new JLabel (((String[])o)[1]);
                     }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion1",
                        JOptionPane.INFORMATION_MESSAGE);
                        return null;
                    }
		  }
		});
        }else
        //variante modificada...
        {
            //en caso de error probar lo siguiente
                //com_horarios.removeAllItems(); puede que no lleve porque siempre se le pasa datos vacios
                //com_horarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"",""}));
            //fin caso de error

            //prototipo de error 1
                combo.addItem(new String[]{"",""});
                combo.setRenderer (new DefaultListCellRenderer()
                {
                      public java.awt.Component getListCellRendererComponent (
                        JList l,Object o,int i,boolean s, boolean f)
                      {
                         try{
                         return new JLabel (((String[])o)[1]);
                         }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Ocurrio Un error" , "Atencion1",
                            JOptionPane.INFORMATION_MESSAGE);
                            return null;
                        }
                      }
                    });
            //prototipo de error 1
        }
        //fin modificacion
        return;
    }
    /**
     * Verifica si existe un usuario determinado en la base de datos
     * @param usu
     * @param clave
     * @return
     */
    public boolean existeUsuarioClave(String usu, String clave){
        ResultSet rs = null;
        try{
            System.out.println("select count(1) from usuario where usuario = '"+usu+"' and contra = md5('"+clave+"')");
            Statement s = conexion.createStatement();
            rs = s.executeQuery("select count(1) from usuario where usuario = '"+usu+"' and contra = md5('"+clave+"')");
               
             //rs = s.executeQuery("select count(1) from usuario where usuario = 'usu' and clave = 'clave'");

            rs.next();
            int cantidad = rs.getInt(1);

            if (cantidad == 0)
               return false;
            else
               return true;
        } catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }
    /**
     * Verifica si existe un usuario determinado en la base de datos
     * @param usu
     * @param clave
     * @return
     */
    public boolean existeUsuarioClaveParaRRHH(String usu, String clave)
    {
        ResultSet rs = null;
        try{
            System.out.println("select count(1) from usuario_1 where usu_nombre = '"+usu+"' and usu_contra = md5('"+clave+"')");
            Statement s = conexion.createStatement();
            rs = s.executeQuery("select count(1) from usuario_1 where usu_nombre = '"+usu+"' and usu_contra = md5('"+clave+"')");

             //rs = s.executeQuery("select count(1) from usuario where usuario = 'usu' and clave = 'clave'");

            int cantidad = 0;
            while (rs.next())
            {
                cantidad = rs.getInt(1);
            }
            //rs.next();

            if (cantidad == 0)
               return false;
            else
               return true;
        } catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    /** Cierra la conexion con la base de datos */
    public void cierraConexion()
    {
        try
        {
            conexion.close();
            System.out.println("cierro conexion..........");
        } catch (Exception e)
        {
            //e.printStackTrace();
            System.err.println("dio error en el cierre de la conexion");
        }
    }
    /**
     * Cuenta la cantidad de filas que tiene una consulta sql
     * @param sql
     * @return
     */
    public int countFila(String sql)
    {
        ResultSet rs = null;
        try {
            rs = dameLista(sql);
        } catch (Exception e) {
            return 0;
        }
        int c=0;
        try
        {
            while (rs.next())
            {
              c+=1;
            }
        } catch (Exception e) {
        }
        return c;
    }
    /**
     * Devuelve true si es que encuentra en la primera linea de codigo una fecha, de otro modo retorna false. Solamente evalua la primera columna junto con el primer dato
     * @param sql
     * @return
     */
    public boolean isDateColumn(String sql)
    {
        ResultSet rs = dameLista(sql);
        try
        {
            while (rs.next())
            {
              rs.getDate(1);
              return true;
            }
        } catch (Exception e)
        {
        }
        return false;
    }
    /**
     * Devuelve true si el primer campo pertenece a un campo numerico, en todo caso es false
     * @param sql
     * @return
     */
    public boolean isNumericColumn(String sql)
    {
        ResultSet rs = dameLista(sql);
        try
        {
            while (rs.next())
            {
              rs.getInt(1);
              return true;
            }
        } catch (Exception e)
        {
        }
        return false;
    }
    /**
     * Devuelve true si es que encuentra en la primera linea de codigo una fecha, de otro modo retorna false. Solamente evalua la primera columna junto con el primer dato
     * @param sql
     * @return
     */
    public boolean isDateColumn(String sql, int columnDate)
    {
        ResultSet rs = dameLista(sql);
        try
        {
            while (rs.next())
            {
              rs.getDate(columnDate);
              return true;
            }
        } catch (Exception e)
        {
        }
        return false;
    }
    public boolean existeConsultaCount(String sql){
        //Metodo especial para hacer consultas multiples
        ResultSet rs = null;
        try
        {
            int x=0;
            System.out.println(sql);
            Statement s = conexion.createStatement();
            rs = s.executeQuery(sql);

            while (rs.next()) {
                x+=1;
            }

            if (x == 0)
               return false;
            else
               return true;
        } catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }
    /**
     * Permite preparar para la ejecucion de un sql a la par que la vamos tirando los parametros. 
     * Esto sirve cuando necesitamos de pasarle parametros especiales a la Base de Datos. El metodo en si, 
     * para que no cree error, debe de ser instanciado la conexion previamente. <br>
     * Para que este metodo tenga un buen efecto, su manera correcta de llamada y uso seria:<br>
     * conexion c = new conexion();<br>
     * c.estaConectado();<br>
     * PreparedStatement p = c.preparedExecuteSQL("insert into tabla values(?,?)"); <br>
     * p.setInt(1, 1); //El primer valor es el orden y el segundo es su valor<br>
     * p.setString(2, "valor"); //El primer valor es el orden y el segundo es su valor<br>
     * Obs.: * Los del signo de interrogacion quiere decir el lugar preparado para la insercion segun el tipo de parametro
     * que le arrojemos.<br>
     * Si vamos a realizar una insercion, recordar que debe de coincidir los mismos tipos tanto como le pasamos los parametros como
     * los que se encuentran dentro de la tabla (sus columnas).
     * *Cuando querramos usar la fecha, hay que recordar pasar la conversion del compilador a la forma de la base de datos. Siguiendo el esquema siguiente: <br>
     * java.util.Date today = jDateChooser1.getCalendar().getTime(); //Es la clase de utileria que usamos dentro del compilador<br>
       java.sql.Date sqlToday = new java.sql.Date(today.getTime()); //Esta es la forma de conversion que tendremos para pasar a la BD<br>
       p.setDate(3, sqlToday); //Procedimiento que utilizaremos para la insercion de una fecha
     * @param sql - Asociado para la preparacion de ejecucion.
     * @return
     */
    public PreparedStatement preparedExecuteSQL(String sql)
    {
        PreparedStatement p = null;
        try {
            p = (PreparedStatement) conexion.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}