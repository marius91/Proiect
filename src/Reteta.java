
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marius
 */
public class Reteta extends javax.swing.JFrame {
Boolean ok=true;
Boolean ok2=true;
Connection con=null;
Statement st=null;
ResultSet rs5,rss,rsss,rs,rs2=null;
//boolean ok=true;
String y,s;
int x=0;
int nr=1,aux;
Object [][] data=null;
String[] columnNames = new String[3];
    /**
     * Creates new form Reteta
     */
Conectare c = new Conectare("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:BD");
    public Reteta() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_reteta = new javax.swing.JTable();
        adauga_medReteta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        printare = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        denu = new javax.swing.JTextField();
        nr_unitati_reteta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pret_final = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NU", "25%", "50%", "75%", "100%" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Procent compensare");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Reteta");

        tabel_reteta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabel_reteta);
        tabel_reteta.getColumnModel().getColumn(0).setPreferredWidth(200);

        adauga_medReteta.setText("Adauga medicament");
        adauga_medReteta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adauga_medRetetaActionPerformed(evt);
            }
        });

        jLabel4.setText("Pret total :");

        jLabel5.setText("    /lei");

        printare.setText("Print");
        printare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printareActionPerformed(evt);
            }
        });

        jLabel6.setText("Farmacist:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Denumire medicament");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Numar unitati");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pret_final.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(pret_final)
                .addGap(44, 44, 44)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(denu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nr_unitati_reteta, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(adauga_medReteta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(printare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(198, 198, 198))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(denu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nr_unitati_reteta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adauga_medReteta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printare, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(pret_final))
                .addGap(105, 105, 105))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printareActionPerformed
       nr++;
        MessageFormat header= new MessageFormat("Reteta Nr "+nr);
        MessageFormat footer= new MessageFormat("Va multumim ca ne-ati ales!");
        try
        {
        tabel_reteta.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch(Exception ex)
        {
        System.out.println("nu a mers!");
        }
    }//GEN-LAST:event_printareActionPerformed

    private void adauga_medRetetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adauga_medRetetaActionPerformed
        try
        {
            String medicament=denu.getText();
            System.out.println("Uite aici---->"+medicament);
        String sql="SELECT DENUMIRE_MEDICAMENT FROM MEDICAMENT WHERE DENUMIRE_MEDICAMENT='"+medicament+"'";
       System.out.println(sql);
      ResultSet rs = st.executeQuery(sql);
       System.out.println(denu.getText());
       //rs= st.executeQuery(sql);
       
       if(rs.next())
            {
                System.out.println("S-a gasit medicamentul cautat!");
                
            }   
        else{
         System.out.println("Nu s-au gasit medicamentul cautat!");
            }
        
//        catch(Exception ex)
//        {
//        
//        }
        
        
        
        
        
            
          //  String sql2 = "update Medicament2 set stoc='"+numar_produse.getText()+"' where cod='"+Tabel_Listare.getSelectedRow()+"'";
         String sqlll= "SELECT PRET_MEDICAMENT FROM MEDICAMENT WHERE DENUMIRE_MEDICAMENT='"+denu.getText()+"'";
         rss = st.executeQuery(sqlll);
System.out.println("Marius a facut asta azi--->"+rss);
         while(rss.next())
         {
             x=rss.getInt(WIDTH);
         System.out.println("Test========>"+x);
         
         
//             String sqll= "SELECT COMPENSARE FROM MEDICAMENT WHERE DENUMIRE_MEDICAMENT='"+denu.getText()+"'";
//         rs5 = st.executeQuery(sqlll);
//System.out.println("Marius a facut asta azi--->"+rs5);
//         while(rs5.next())
//         {
//            y=rs5.getString(1);
//         System.out.println("Test========>"+y);
//         
//         }   
          String sqql= "SELECT COMPENSARE FROM MEDICAMENT WHERE DENUMIRE_MEDICAMENT='"+denu.getText()+"'";
         rss = st.executeQuery(sqql);
System.out.println("Marius a facut asta azi--->"+rss);
         while(rss.next())
         {
             y=rss.getString(1);
         System.out.println("Test========>"+y);
         
         }
            /////////////////////////////////////////////////////////
//        String sql2="SELECT COMPENSARE FROM MEDICAMENT WHERE DENUMIRE_MEDICAMENT='"+denu.getText()+"'";
//         ResultSet rs2 = st.executeQuery(sql2);
//         System.out.println(rs2);
//        String sql3="SELECT PRET_MEDICAMENT FROM MEDICAMENT WHERE DENUMIRE_MEDICAMENT='"+denu.getText()+"'";
//        ResultSet rs3 = st.executeQuery(sql3);
//        System.out.println(rs3);
     
  
        
        if(ok==true)
        {
            columnNames= new String[] {"Denumire medicament","Compensare","Unitati","Pret/Unitate"};
            data = new Object[1][4];
            data[0][0]= denu.getText();
            data[0][1]= y;
            data[0][2]= nr_unitati_reteta.getText();
            data[0][3]= x;
//                    while(rs3.next())
//         {
//             x=rs.getInt(WIDTH);
//         System.out.println("Test========>"+x);
//         
//         }
         
       
            tabel_reteta.setModel(new DefaultTableModel(data, columnNames));
            denu.setText(null);
            nr_unitati_reteta.setText(null);
     
            ok=false;
        }
        else
        {
            Object [][]temp= new Object[data.length+1][4];
            for(int i=0; i<data.length;i++)
            {
                for(int j=0;j<4;j++)
                {
                    temp[i][j]=data[i][j];
                }
            }
            temp[data.length][0]= denu.getText();
            temp[data.length][1]= y;
            temp[data.length][2]= nr_unitati_reteta.getText();
            temp[data.length][3]= x;
            
        
            data=temp;
            tabel_reteta.setModel(new DefaultTableModel(data, columnNames));

            denu.setText(null);
            nr_unitati_reteta.setText(null);
            
        }
  }
    }
        catch(Exception ex){}
        // TODO add your handling code here:
     //System.out.println( den_med_reteta.getText().toString());
        
        //       addMedReteta adaugaMed = new addMedReteta();
//       adaugaMed.setVisible(rootPaneCheckingEnabled);
//      
//        columnNames = new String[] {"Denumire","Unitati","Pret/Unitate"};
//        if(ok==true){
//        data= new Object[1][2];
//        data[0][0]= JOptionPane.showInputDialog("Scrie numele medicamentului");
//        data[0][1]= JOptionPane.showInputDialog("Scrie numarul de unitati");
//        tabel_reteta.setModel(new DefaultTableModel(data,columnNames));
//        ok=false;
//        }
//        else{
//       
//        
//        Object[][] temp = new Object [data.length+1][2];
//        for(int i=0;i<data.length;i++)
//        {
//        for(int j=0;j<2;j++){
//        temp[i][j]= data[i][j];
//        }
//        }
//        temp[data.length][0]= JOptionPane.showInputDialog("Scrieti numele medicamentului");
//        temp[data.length][1]= JOptionPane.showInputDialog("Scrieti numarul de unitati");
//        data=temp;
//        jTable1.setModel(new DefaultTableModel(data, columnNames));}
        
        
        try
        {
         String sqlll= "SELECT PRET_MEDICAMENT FROM MEDICAMENT WHERE DENUMIRE_MEDICAMENT='"+denu.getText()+"'";
         rss = st.executeQuery(sqlll);
System.out.println("Marius a facut asta azi--->"+rss);
         while(rss.next())
         {
             x=rss.getInt(WIDTH);
         System.out.println("Test========>"+x);
        }
        }
        catch(Exception ex)
        {
        
        }
        
        
        
        
        
        ///////////////////////
   
        
    }//GEN-LAST:event_adauga_medRetetaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try{
     String slq= "SELECT PRET_MEDICAMENT FROM MEDICAMENT WHERE DENUMIRE_MEDICAMENT='"+denu.getText()+"'";
         rsss = st.executeQuery(slq);
System.out.println("Marius a facut asta acasddhd adioay sdyzi--->"+rsss);
         while(rsss.next())
         {
             x=rsss.getInt(WIDTH);
         System.out.println("Test========>"+x);
         aux=x*Integer.parseInt(nr_unitati_reteta.getText());
         pret_final.setText(Integer.toString(aux));
//Tabel_Listare.setModel(DbUtils.resultSetToTableModel(rs));
        }
 }
       catch(Exception ex)
       {
       
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(Reteta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reteta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reteta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reteta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reteta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adauga_medReteta;
    private javax.swing.JTextField denu;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nr_unitati_reteta;
    private javax.swing.JLabel pret_final;
    private javax.swing.JButton printare;
    public javax.swing.JTable tabel_reteta;
    // End of variables declaration//GEN-END:variables
}
