
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marius
 */

public class add extends javax.swing.JFrame {
Boolean ok=true;
Boolean ok2=true;
    Object [][]data=null;
String [] columnNames = new String [6];

    Statement st=null;
    /**
     * Creates new form add
     */
    Conectare c = new Conectare("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:BD");
    public add() {
        initComponents();
        try{
        st = c.connect().createStatement();
        System.out.println(c.connect().toString());
        }
        catch (Exception ex){
            
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cod_med = new javax.swing.JTextField();
        nume_med = new javax.swing.JTextField();
        pret_med = new javax.swing.JTextField();
        stoc_med = new javax.swing.JTextField();
        data_exp = new javax.swing.JTextField();
        compensat = new javax.swing.JComboBox();
        cmd_save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelMed = new javax.swing.JTable();
        actualizare = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        test = new javax.swing.JTextField();
        cod_sterge = new javax.swing.JTextField();
        nume_sterge = new javax.swing.JTextField();
        stergere = new javax.swing.JButton();
        actualizare_pret = new javax.swing.JTextField();
        actualizare_stoc = new javax.swing.JTextField();
        cod_actualizare = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        refreshtabel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cod_sim_med = new javax.swing.JTextField();
        cod_categ_med = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("COD MEDICAMENT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 14, -1, -1));

        jLabel2.setText("NUME MEDICAMENT");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 52, -1, -1));

        jLabel3.setText("PRET MEDICAMENT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 20));

        jLabel4.setText("STOC MEDICAMENT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel5.setText("DATA EXPIRARII");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 20));

        jLabel6.setText("COMPENSARE ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 20));
        getContentPane().add(cod_med, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 165, -1));
        getContentPane().add(nume_med, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 165, -1));
        getContentPane().add(pret_med, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 165, -1));
        getContentPane().add(stoc_med, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 165, -1));

        data_exp.setToolTipText("(Exemplu data: YYYY-MM-DD)");
        getContentPane().add(data_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 165, -1));

        compensat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DA", "NU" }));
        compensat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compensatActionPerformed(evt);
            }
        });
        getContentPane().add(compensat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 165, -1));

        cmd_save.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marius\\Documents\\NetBeansProjects\\Licenta\\pills-pot-icon (1).png")); // NOI18N
        cmd_save.setText("    Add medicament       ");
        cmd_save.setAutoscrolls(true);
        cmd_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_saveActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 290, -1));

        TabelMed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", "", ""},
                {null, null, null, null, "", null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "COD ", "NUME", "PRET", "STOC", "DATA EXP", "COMPENSAT"
            }
        ));
        jScrollPane1.setViewportView(TabelMed);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 510, 540));

        actualizare.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marius\\Documents\\NetBeansProjects\\Licenta\\Other-Update-Metro-icon.png")); // NOI18N
        actualizare.setText("     Actualizare                ");
        actualizare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizareActionPerformed(evt);
            }
        });
        getContentPane().add(actualizare, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 190, 40));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marius\\Documents\\NetBeansProjects\\Licenta\\Places-folder-open-icon.png")); // NOI18N
        jButton2.setText("Deschide prospect        ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 190, 40));
        getContentPane().add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, 190, -1));

        cod_sterge.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        cod_sterge.setForeground(new java.awt.Color(192, 192, 192));
        cod_sterge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cod_stergeMouseClicked(evt);
            }
        });
        cod_sterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod_stergeActionPerformed(evt);
            }
        });
        getContentPane().add(cod_sterge, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 190, -1));

        nume_sterge.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        nume_sterge.setForeground(new java.awt.Color(192, 192, 192));
        nume_sterge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nume_stergeMouseClicked(evt);
            }
        });
        getContentPane().add(nume_sterge, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 190, -1));

        stergere.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marius\\Documents\\NetBeansProjects\\Licenta\\Delete-icon (1).png")); // NOI18N
        stergere.setText("Sterge medicament          ");
        stergere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergereActionPerformed(evt);
            }
        });
        getContentPane().add(stergere, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 190, 40));

        actualizare_pret.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        actualizare_pret.setForeground(new java.awt.Color(180, 180, 180));
        getContentPane().add(actualizare_pret, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, 190, -1));

        actualizare_stoc.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        actualizare_stoc.setForeground(new java.awt.Color(180, 180, 180));
        actualizare_stoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizare_stocActionPerformed(evt);
            }
        });
        getContentPane().add(actualizare_stoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 260, 190, -1));

        cod_actualizare.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        cod_actualizare.setForeground(new java.awt.Color(180, 180, 180));
        getContentPane().add(cod_actualizare, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 190, -1));

        jButton1.setText("Afiseaza produse care expira curand");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 290, 50));

        jButton3.setText("Sterge produsele expirate ");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 290, 50));

        jLabel7.setText("Cod");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, -1, -1));

        jLabel8.setText("Pret");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 230, -1, -1));

        jLabel9.setText("Stoc");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, -1, -1));

        jLabel11.setText("Cod");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, -1, -1));

        jLabel12.setText("Nume");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, -1, -1));

        refreshtabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marius\\Documents\\NetBeansProjects\\Licenta\\carte2.png")); // NOI18N
        refreshtabel.setText("Refresh la baza de date");
        refreshtabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshtabelActionPerformed(evt);
            }
        });
        getContentPane().add(refreshtabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 290, -1));

        jPanel1.setBackground(new java.awt.Color(180, 180, 180));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, null));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 260, 540));

        jLabel10.setText("COD SIMPTOME");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel13.setText("COD CATEG. VARSTA");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));
        getContentPane().add(cod_sim_med, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 165, -1));
        getContentPane().add(cod_categ_med, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 165, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compensatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compensatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compensatActionPerformed

    private void cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_saveActionPerformed
        try{
            String sql="Insert into MEDICAMENT (COD_MEDICAMENT,DENUMIRE_MEDICAMENT,COD_SIMPTOME,NR_UNITATI,COD_CATEGORII_VARSTA,PRET_MEDICAMENT,DATA_EXP,COMPENSARE) values('"+cod_med.getText()+"','"+nume_med.getText()+"','"+cod_sim_med.getText()+"','"+stoc_med.getText()+"','"+cod_categ_med.getText()+"','"+pret_med.getText()+"','"+data_exp.getText()+"','"+compensat.getSelectedItem()+"')";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
             JOptionPane.showMessageDialog(null, "Datele au fost salvate!");
            if(compensat.getSelectedItem()=="DA"){
                System.out.println("Ai mai multevariante!");
            }
            System.out.println(sql);
          //  ResultSet rs = st.executeQuery(sql);
            System.out.println("resultset la insert"+rs);
            JOptionPane.showMessageDialog(null, "Datele au fost salvate!");

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Medicamentul s-a adaugat cu succes!");

        }
        
        if(ok==true)
        {
            columnNames= new String[] {"Cod","Nume","Pret","Stoc","Data exp","Compensat","Cod_Simptome","Cod_Categ_Varsta"};
            data = new Object[1][8];
            data[0][0]= cod_med.getText();
            data[0][1]= nume_med.getText();
            data[0][2]= pret_med.getText();
            data[0][3]= stoc_med.getText();
            data[0][4]= data_exp.getText();
            data[0][5]= compensat.getSelectedItem();
            data[0][6]=cod_sim_med.getText();
            data[0][7]=cod_categ_med.getText();
            TabelMed.setModel(new DefaultTableModel(data, columnNames));
            cod_med.setText(null);
            nume_med.setText(null);
            pret_med.setText(null);
            stoc_med.setText(null);
            data_exp.setText(null);
            cod_sim_med.setText(null);
            cod_categ_med.setText(null);
            ok=false;
        }
        else
        {
            Object [][]temp= new Object[data.length+1][8];
            for(int i=0; i<data.length;i++)
            {
                for(int j=0;j<8;j++)
                {
                    temp[i][j]=data[i][j];
                }
            }
            temp[data.length][0]= cod_med.getText();
            temp[data.length][1]= nume_med.getText();
            temp[data.length][2]= pret_med.getText();
            temp[data.length][3]= stoc_med.getText();
            temp[data.length][4]= data_exp.getText();
            temp[data.length][5]= compensat.getSelectedItem();
            temp[data.length][6]=cod_sim_med.getText();
            temp[data.length][7]=cod_categ_med.getText();
            data=temp;
            TabelMed.setModel(new DefaultTableModel(data, columnNames));

            cod_med.setText(null);
            nume_med.setText(null);
            pret_med.setText(null);
            stoc_med.setText(null);
            data_exp.setText(null);
            cod_sim_med.setText(null);
            cod_categ_med.setText(null);

        }

        // TODO add your handling code here:
     System.out.println( cod_med.getText().toString());
         //   jLabel1.setForeground(Color.BLUE);
        
        //System.out.println("Textul"+cod_med.getText()+"a fost!");
//      if(  cod_med.getText().isEmpty()) {
//        jLabel1.setForeground(Color.red);
//      } else{
//      jLabel1.setForeground(Color.green);
//      }
//         jLabel2.setForeground(Color.red);
//          jLabel3.setForeground(Color.red);
//           jLabel4.setForeground(Color.red);
//            jLabel5.setForeground(Color.red);
//      
      
    }//GEN-LAST:event_cmd_saveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        try
        {
       Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Users\\Marius\\Downloads\\"+test.getText()+".pdf");
      
        }
        catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null,"Nu se deschide!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void actualizareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizareActionPerformed
 try{
        String sql= "SELECT * FROM MEDICAMENT WHERE COD_MEDICAMENT ='"+cod_actualizare.getText()+"'"; 
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
         JOptionPane.showMessageDialog(null,"Codul medicamentului introdus este corect!");
         }
         else
         {
         //JOptionPane.showMessageDialog(null,"Medicamentul nu se afla in baza de date!");
        JOptionPane.showMessageDialog(this, "Codul introdus nu este asociat niciunui medicament!", "Atentie! Cod incorect!", JOptionPane.ERROR_MESSAGE);
       
         }
             
         
        }
        catch(Exception ex)
        {
        
        }
 
        
        if (actualizare_pret.getText().trim().length()!=0){
        try{
           String sql = "update MEDICAMENT set PRET_MEDICAMENT='"+actualizare_pret.getText()+"' where COD_MEDICAMENT='"+cod_actualizare.getText()+"'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            
            System.out.println("resultset la insert"+rs);
            JOptionPane.showMessageDialog(this, "Pretul nu a fost actualizat!");

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Pretul a fost actualizat !");

        }
        }
        
        
        if (actualizare_stoc.getText().trim().length()!=0){
        try{
           String sql = "update MEDICAMENT set NR_UNITATI='"+actualizare_stoc.getText()+"' where COD_MEDICAMENT='"+cod_actualizare.getText()+"'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            
            System.out.println("resultset la insert"+rs);
            JOptionPane.showMessageDialog(this, "Stocul nu a fost actualizat!");

        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Stocul a fost actualizat !");

        }
        }
        
        
        
//         cod_actualizare.setText("cod medicament");
//         denumire_med.setText("denumire medicament");
//         actualizare_pret.setText("actualizare pret");
//         actualizare_stoc.setText("actualizare de stoc");
//        
    }//GEN-LAST:event_actualizareActionPerformed

    private void stergereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergereActionPerformed
      
        try{
        String sql= "SELECT * FROM MEDICAMENT WHERE COD_MEDICAMENT ='"+cod_sterge.getText()+"'and DENUMIRE_MEDICAMENT='"+nume_sterge.getText()+"'";
         ResultSet rs = st.executeQuery(sql);
         if(rs.next()){
         
         }
         else
         {
         //JOptionPane.showMessageDialog(null,"Medicamentul nu se afla in baza de date!");
        JOptionPane.showMessageDialog(this, "Campurile nu au fost completate corect. Verificati din nou codul si numele medicamentului!", "Atentie!", JOptionPane.ERROR_MESSAGE);
        ok2=false;
         }
             
         
        }
        catch(Exception ex)
        {
        
        } 
        
        if(cod_sterge.getText().trim().length()!=0 && nume_sterge.getText().trim().length()!=0)
        {
        try{
            String sql="Delete from MEDICAMENT where COD_MEDICAMENT='"+cod_sterge.getText()+"'and DENUMIRE_MEDICAMENT='"+nume_sterge.getText()+"'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            System.out.println("resultset la insert"+rs);
            JOptionPane.showMessageDialog(this, "Datele au fost salvate!");

            }
        catch(Exception ex)
            {
             if(ok2==true)
             {   
            JOptionPane.showMessageDialog(this, "Medicamentul a fost sters!");
          
             }
            }
        }
       
        else
        {
          //JOptionPane.showMessageDialog(this, "Campurile nu sunt completate!");
          JOptionPane.showMessageDialog(this, "Campurile nu au fost completate!", "Atentie!", JOptionPane.ERROR_MESSAGE);
     
        }
        
        
       
        
        
        //      try{
//      
//        String sql="Insert into Medicament (cod,nume) values('"+cod_sterge.getText()+"','"+nume_sterge.getText()+"')";
//          System.out.println("marius uita-te aici!!!"+sql);
//      ResultSet rs = st.executeQuery(sql);
//      System.out.println("a mers si randu de mai sus");
//      if(rs.next()){
//      
//           JOptionPane.showMessageDialog(null,"Medicamentul a fost sters!");
//          
//      }else
//      {
//      JOptionPane.showMessageDialog(null,"Medicamentul nu a fost gasit!");
//      }
//         
//      }
//      catch(Exception ex)
//      {
//      JOptionPane.showMessageDialog(null,"gresit!");
//      }
    }//GEN-LAST:event_stergereActionPerformed

    private void cod_stergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod_stergeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_stergeActionPerformed

    private void cod_stergeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cod_stergeMouseClicked
        cod_sterge.setText(null);
       // System.out.println(getCursorLocation());
        
    }//GEN-LAST:event_cod_stergeMouseClicked

    private void nume_stergeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nume_stergeMouseClicked
        nume_sterge.setText(null);
    }//GEN-LAST:event_nume_stergeMouseClicked

    private void actualizare_stocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizare_stocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizare_stocActionPerformed

    private void refreshtabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshtabelActionPerformed
        // TODO add your handling code here:
        try{
        String sql = "Select COD_MEDICAMENT,DENUMIRE_MEDICAMENT,COD_SIMPTOME,NR_UNITATI,COD_CATEGORII_VARSTA,PRET_MEDICAMENT,DATA_EXP,COMPENSARE from  MEDICAMENT";
         ResultSet rs = st.executeQuery(sql);
         TabelMed.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception ex)
        {
        
        }
    }//GEN-LAST:event_refreshtabelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelMed;
    private javax.swing.JButton actualizare;
    private javax.swing.JTextField actualizare_pret;
    private javax.swing.JTextField actualizare_stoc;
    private javax.swing.JButton cmd_save;
    private javax.swing.JTextField cod_actualizare;
    private javax.swing.JTextField cod_categ_med;
    private javax.swing.JTextField cod_med;
    private javax.swing.JTextField cod_sim_med;
    private javax.swing.JTextField cod_sterge;
    private javax.swing.JComboBox compensat;
    private javax.swing.JTextField data_exp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nume_med;
    private javax.swing.JTextField nume_sterge;
    private javax.swing.JTextField pret_med;
    private javax.swing.JButton refreshtabel;
    private javax.swing.JButton stergere;
    private javax.swing.JTextField stoc_med;
    private javax.swing.JTextField test;
    // End of variables declaration//GEN-END:variables
}
