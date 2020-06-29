package yurt_otomasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author atsar
 */
public class odalarTablo extends javax.swing.JFrame {
Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    String baslik[] = new String[]{ "TC","Adı", "Soyadı", "Cep Telefonu", "Adres Bilgileri", "Kira", "Ödenecek Kira", "Veli İletişim","Oda Numarası" }; 
                    public void baglanti(String odaNo) throws SQLException{
                        try{
                           
                        Class.forName("com.mysql.cj.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost/yurt_otomasyonu?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "tezcan", "1234");
                            st = con.createStatement();
                            String sql = "Select * from ogrenci_listesi where oda_numarasi=\'";
                            sql+=odaNo;
                            sql+="\'";
                            rs=st.executeQuery(sql);
                            rs.last();
                            int i=rs.getRow();
                            rs.beforeFirst();
                            
                            Object data[][] = new Object[i][];
                            int j=0;
                            while(rs.next()){
                                data[j]= new Object[]{
                                    rs.getString("tc"),
                    rs.getString("adi"),  
                    rs.getString("soyadi"),
                    rs.getString("cep_telefonu"),
                    rs.getString("adres_bilgileri"),  
                    rs.getString("kira"),
                    rs.getString("odenecekKira"),
                    rs.getString("veliIletisim"), 
                    rs.getString("oda_numarasi"), 
                                };
                                j++;
                            }
                            con.close();
                            odalar_tablo.setModel(new DefaultTableModel(data,baslik));
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(oda.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

    public odalarTablo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        odalar_tablo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_tc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_oda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        odalar_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tc Kimlik", "Adı", "Soyadı", "Cep Telefonu", "Adres Bilgileri", "Kira", "Ödenecek Kira", "Veli İletişim", "Oda Numarası"
            }
        ));
        jScrollPane2.setViewportView(odalar_tablo);

        jButton1.setText("Çıkış");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("TC No:");

        jLabel2.setText("Yeni Oda No:");

        jButton2.setText("Güncelle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tc, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txt_oda))))
                .addGap(149, 149, 149)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_oda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost/yurt_otomasyonu?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "tezcan", "1234");
        st = con.createStatement();
        String sql = "update ogrenci_listesi set oda_numarasi=? where tc=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, txt_oda.getText());
        ps.setString(2, txt_tc.getText());
        if(ps==null){
            javax.swing.JOptionPane.showMessageDialog(null, "İşlem gerçekleştirilemedi!");
        }
        else{
            ps.executeUpdate();
            con.close();
            baglanti(txt_oda.getText());
        }
    } catch (SQLException ex) {
        Logger.getLogger(odalarTablo.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new odalarTablo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable odalar_tablo;
    private javax.swing.JTextField txt_oda;
    private javax.swing.JTextField txt_tc;
    // End of variables declaration//GEN-END:variables
}
