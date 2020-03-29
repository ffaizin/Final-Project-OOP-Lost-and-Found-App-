/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesoop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Benando
 */
public class TabelJadwal extends javax.swing.JFrame {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "SELECT no_ruangan, prodi, angkatan, matkul, tgl_jadwal "
                    + "FROM jadwal "
                    + "INNER JOIN ruangan ON ruangan.id_ruangan = jadwal.id_ruangan "
                    + "INNER JOIN prodi ON prodi.id_prodi = jadwal.id_prodi "
                    + "INNER JOIN matkul ON matkul.id_matkul = jadwal.id_matkul "
                    + "INNER JOIN angkatan ON angkatan.id_angkatan = jadwal.id_angkatan ";
    /**
     * Creates new form TabelJadwal
     */
    public TabelJadwal() {
        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if ("Windows".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {  
        }
        initComponents();
        DbConn DB = new DbConn();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        listed(sql);
        idDataAngkatan();
        idDataProdi();
        idDataRuangan();
    }
    
    private void listed(String sql){
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Ruangan");
        tabel.addColumn("Prodi");
        tabel.addColumn("Angkatan");
        tabel.addColumn("Matkul");
        tabel.addColumn("Jam Kelas");
        
        
        try {
            
            Statement S = con.createStatement();
            ResultSet R = S.executeQuery(sql);
            
            while (R.next()){
                tabel.addRow(new Object[]{
                    R.getString(1),
                    R.getString(2),
                    R.getString(3),
                    R.getString(4),
                    R.getString(5),
                    
                });
            }
        }
        catch (Exception e) {
        }
        TblJadwal.setModel(tabel);
    }
    public void idDataAngkatan(){
        try {
        sql = "SELECT * FROM angkatan";
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            String idB = rs.getString("angkatan");
            CbAngkatan.addItem(idB);
        }
        
    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);
    }
    }
    
    public void idDataProdi(){
        try {
        sql = "SELECT * FROM prodi";
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            String idB = rs.getString("prodi");
            CbProdi.addItem(idB);
        }
        
    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);
    }
    }
    
    public void idDataRuangan(){
        try {
        sql = "SELECT * FROM ruangan";
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            String idB = rs.getString("no_ruangan");
            CbRuangan.addItem(idB);
        }
        
    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);
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
        TblJadwal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CbRuangan = new javax.swing.JComboBox<>();
        CbProdi = new javax.swing.JComboBox<>();
        CbAngkatan = new javax.swing.JComboBox<>();
        BtnCek = new javax.swing.JButton();
        BtnShowall = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TblJadwal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TblJadwal);

        jLabel1.setText("Ruangan");

        jLabel2.setText("Prodi");

        jLabel3.setText("Angkatan");

        BtnCek.setText("Cek");
        BtnCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCekActionPerformed(evt);
            }
        });

        BtnShowall.setText("Show All");
        BtnShowall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnShowallActionPerformed(evt);
            }
        });

        jButton1.setText("Back To Set Status");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnCek, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(CbRuangan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CbProdi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CbAngkatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(BtnShowall)
                .addGap(161, 161, 161)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CbRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CbAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCek)
                    .addComponent(BtnShowall)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCekActionPerformed
        // TODO add your handling code here:
        String Ruangan = CbRuangan.getSelectedItem().toString();
        String Prodi = CbProdi.getSelectedItem().toString();
        String Angkatan = CbAngkatan.getSelectedItem().toString();
        String sql2 = "SELECT no_ruangan, prodi, angkatan, matkul, tgl_jadwal "
                    + "FROM jadwal "
                    + "INNER JOIN ruangan ON ruangan.id_ruangan = jadwal.id_ruangan "
                    + "INNER JOIN prodi ON prodi.id_prodi = jadwal.id_prodi "
                    + "INNER JOIN matkul ON matkul.id_matkul = jadwal.id_matkul "
                    + "INNER JOIN angkatan ON angkatan.id_angkatan = jadwal.id_angkatan "
                + "WHERE ruangan.no_ruangan = '"+ Ruangan +"' "
                + "AND prodi.prodi = '"+ Prodi +"' "
                + "AND angkatan.angkatan = '"+ Angkatan +"'";
        listed(sql2);
    }//GEN-LAST:event_BtnCekActionPerformed

    private void BtnShowallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnShowallActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT no_ruangan, prodi, angkatan, matkul, tgl_jadwal "
                    + "FROM jadwal "
                    + "INNER JOIN ruangan ON ruangan.id_ruangan = jadwal.id_ruangan "
                    + "INNER JOIN prodi ON prodi.id_prodi = jadwal.id_prodi "
                    + "INNER JOIN matkul ON matkul.id_matkul = jadwal.id_matkul "
                    + "INNER JOIN angkatan ON angkatan.id_angkatan = jadwal.id_angkatan ";
        listed(sql);
    }//GEN-LAST:event_BtnShowallActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Status stat = new Status();
        stat.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TabelJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelJadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCek;
    private javax.swing.JButton BtnShowall;
    private javax.swing.JComboBox<String> CbAngkatan;
    private javax.swing.JComboBox<String> CbProdi;
    private javax.swing.JComboBox<String> CbRuangan;
    private javax.swing.JTable TblJadwal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
