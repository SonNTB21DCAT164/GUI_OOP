package view;

import controller.IOFile;
import controller.TrongExceptrion;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BanDoc;
import model.QLMuon;
import model.Sach;

public class FormQLMuon extends javax.swing.JPanel {
    DefaultTableModel tm;
    private String fqlMuon;
    private List<QLMuon> lqlMuon;
    private String fsach;
    private List<Sach> lsach;
    public FormQLMuon() {
        initComponents();
        setSize(750, 550); // set size cho vua voi size ben Main
        String[] cols={"Ma ban doc", "Ho ten", "Ma sach", "Ten sach", "So luong", 
        "Tinh trang "};// 6 cot
        tm=new DefaultTableModel(cols, 0);
        jTable1.setModel(tm);
        fqlMuon="src/controller/qlmuon.txt";
        fsach="src/controller/sach.txt";
        loadData(); 
        load2Ma(); // lua chon ma tu combo box
        cbSapXep.addActionListener(e -> {
             // sap xep theo ten
       if (cbSapXep.getSelectedIndex()==1){
           lqlMuon.sort(new Comparator<QLMuon>(){
               @Override
               public int compare(QLMuon o1, QLMuon o2) {
                   String [] ten1=o1.getBandoc().getTen().split("\\s+");
                   String [] ten2=o2.getBandoc().getTen().split("\\s+");
                   // ten giong nhau thi sap xep theo ho tang dan
                   if (ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                       return o1.getBandoc().getTen().compareToIgnoreCase(o2.getBandoc().getTen());
                   }else{
                       return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
                   }
               }
                
           });
       }
       // sap xep theo so luong
       if (cbSapXep.getSelectedIndex()==2){
           lqlMuon.sort(new Comparator<QLMuon>(){
               @Override
               public int compare(QLMuon o1, QLMuon o2) {
                   return Integer.compare(o1.getSoLuong(), o2.getSoLuong());
               }
               
           });
       }
       tm.setRowCount(0); // xoa het di roi set lai
       for (QLMuon i:lqlMuon){
           tm.addRow(i.toObjects());
       }
        });
    }

     private void loadData(){
        File f=new File(fqlMuon);
        if (f.exists())
            lqlMuon=IOFile.doc(fqlMuon);
        else
            lqlMuon=new ArrayList<>();
        File fs=new File(fsach);
        if (fs.exists())
            lsach=IOFile.doc(fsach);
        else
            lsach=new ArrayList<>();
    }
     
     private void load2Ma(){
         cbMaBD.removeAllItems();
         cbMaSach.removeAllItems();
         String fbandoc="src/controller/bandoc.txt";
         List<BanDoc> l1=IOFile.doc(fbandoc);
         if (l1!=null)
         for (BanDoc i:l1){
             cbMaBD.addItem(i.getMa()+"");
         }
          for (Sach i:lsach){
             cbMaSach.addItem(i.getMa()+"");
         }  
     }
     
    // cung 1 loai ban doc voi 1 dau sach thi k the xuat hien 2 lan trong bang
    private boolean trung2Ma(int mabandoc, int masach){
        for (QLMuon i:lqlMuon){
            if (i.getBandoc().getMa()==mabandoc && i.getSach().getMa()==masach)
                return true;
        }
        return false;
    }
    
    // khong qua 5 dau sach
    private int demDauSach(int mabandoc){
        int cnt=0;
        for (QLMuon i:lqlMuon){
            if (i.getBandoc().getMa()==mabandoc)
                cnt++;
        }
        return cnt;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbSapXep = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbMaBD = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbMaSach = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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

        jButton2.setText("Them moi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hien thi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Luu vao file");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----Lua chon sap xep-----", "Ho ten ban doc", "So luong sach muon" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(64, 64, 64)
                .addComponent(jButton3)
                .addGap(75, 75, 75)
                .addComponent(jButton4)
                .addGap(85, 85, 85)
                .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel1.setText("Ma ban doc");

        cbMaBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Ma sach");

        cbMaSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("So luong muon");

        jLabel4.setText("Tinh trang muon");

        jButton1.setText("Refresh ma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(42, 42, 42)
                                    .addComponent(cbMaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(23, 23, 23)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbMaSach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbMaBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // refresh ma
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        load2Ma();
    }//GEN-LAST:event_jButton1ActionPerformed

    private Sach getSachByMa(int ma){
        for (Sach i:lsach){
            if (i.getMa()==ma)
                return i;
        }
        return null; 
    }
    
    private BanDoc getBanDocByMa(int ma){
        String fbandoc="src/controller/bandoc.txt";
        List<BanDoc> l1=IOFile.doc(fbandoc);
        if (l1!=null){
            for (BanDoc i:l1){
                if (i.getMa()==ma)
                    return i;
            }
        }
        return null; 
    }
    
    // them moi
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int mabandoc=Integer.parseInt(cbMaBD.getSelectedItem().toString());
        int masach=Integer.parseInt(cbMaSach.getSelectedItem().toString());
        if (trung2Ma(mabandoc, masach)){
            JOptionPane.showMessageDialog(this, "Trung 2 ma!");
            cbMaBD.requestFocus();
            return; 
        }
        int soLuong=0; // kiem tra so luong co du cho muon khong
        int soLuongThuVien=getSachByMa(masach).getSoLuong();
        try{
            soLuong=Integer.parseInt(jTextField1.getText());
            if (soLuong>soLuongThuVien){
                JOptionPane.showMessageDialog(this, "Khong du sach!");
                jTextField1.requestFocus();
                return;
            }
            String tinhTrang=jTextField2.getText();
            QLMuon ql=new QLMuon(getBanDocByMa(mabandoc), getSachByMa(masach), soLuong, 
                    tinhTrang);
            tm.addRow(ql.toObjects());
            lqlMuon.add(ql);
            getSachByMa(masach).setSoLuong(soLuongThuVien-soLuong);
            IOFile.viet(fsach, lsach);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Nhap so!");
            jTextField1.requestFocus();
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // hien thi
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        File f=new File(fqlMuon);
        if (f.exists()){
            lqlMuon=IOFile.doc(fqlMuon);
            tm.setRowCount(0);
            for (QLMuon i:lqlMuon)
                tm.addRow(i.toObjects());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // luu vao file
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        IOFile.viet(fqlMuon, lqlMuon);
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMaBD;
    private javax.swing.JComboBox<String> cbMaSach;
    private javax.swing.JComboBox<String> cbSapXep;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
