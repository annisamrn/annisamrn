/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.home;

import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import skripsiannisameriana.connect.Connect;
import static skripsiannisameriana.prodi.ProdiView.txtKodeProdi;
import static skripsiannisameriana.soal.SoalView.txtNamaProdi;

/**
 *
 * @author USER
 */
public class Laporan extends javax.swing.JInternalFrame {

    /**
     * Creates new form Laporan
     */
    public Laporan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCetakPendaftar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCetakFakultas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnCetakProdi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCetakSoal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCetakHasilPerorangan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCetakHasilPerprodi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnCetakSoalPerProdi = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnCetakHasilTesPeminatan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CETAK LAPORAN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CETAK LAPORAN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tempus Sans ITC", 1, 18))); // NOI18N

        jLabel1.setText("Laporan Pendaftar");

        btnCetakPendaftar.setText("Cetak");
        btnCetakPendaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakPendaftarActionPerformed(evt);
            }
        });

        jLabel2.setText("Laporan Fakultas");

        btnCetakFakultas.setText("Cetak");
        btnCetakFakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakFakultasActionPerformed(evt);
            }
        });

        jLabel3.setText("Laporan Program Studi");

        btnCetakProdi.setText("Cetak");
        btnCetakProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakProdiActionPerformed(evt);
            }
        });

        jLabel4.setText("Laporan Soal");

        btnCetakSoal.setText("Cetak");
        btnCetakSoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakSoalActionPerformed(evt);
            }
        });

        jLabel5.setText("Laporan Hasil Tes Perorangan");

        btnCetakHasilPerorangan.setText("Cetak");
        btnCetakHasilPerorangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakHasilPeroranganActionPerformed(evt);
            }
        });

        jLabel6.setText("Laporan Hasil Tes Peprodi");

        btnCetakHasilPerprodi.setText("Cetak");
        btnCetakHasilPerprodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakHasilPerprodiActionPerformed(evt);
            }
        });

        jLabel7.setText("Laporan Soal Perprodi");

        btnCetakSoalPerProdi.setText("Cetak");
        btnCetakSoalPerProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakSoalPerProdiActionPerformed(evt);
            }
        });

        jLabel8.setText("Laporan Hasil Tes Peminatan");

        btnCetakHasilTesPeminatan.setText("Cetak");
        btnCetakHasilTesPeminatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakHasilTesPeminatanActionPerformed(evt);
            }
        });

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(btnCetakSoalPerProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCetakHasilPerprodi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCetakHasilPerorangan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addComponent(btnCetakFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnCetakProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCetakSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCetakPendaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(btnCetakHasilTesPeminatan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnCetakFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetakProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetakPendaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnCetakSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnCetakSoalPerProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnCetakHasilPerorangan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnCetakHasilPerprodi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnCetakHasilTesPeminatan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCetakSoalPerProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakSoalPerProdiActionPerformed
        // TODO add your handling code here:
        try {
            //(txtNamaPendaftar.getText().isEmpty())
            String path1 = "src/laporan/SoalProdi.jasper";
            JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

            JasperViewer.viewReport(print, false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakSoalPerProdiActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        try {
            //Home2.setEnableDisableMenu(true);
            dispose();
            //Home2.isMenuItemKelasActive = false;
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }//GEN-LAST:event_btnTutupActionPerformed

    private void btnCetakFakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakFakultasActionPerformed
        // TODO add your handling code here:
        try {
            //if (txtKodeFakultas.getText().isEmpty()) {
                String path1 = "src/laporan/Jurusan.jasper";
                JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakFakultasActionPerformed

    private void btnCetakProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakProdiActionPerformed
        // TODO add your handling code here:
        try {
            //if (txtKodeProdi.getText().isEmpty()) {
                String path1 = "src/laporan/ProdiCetak.jasper";
                JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakProdiActionPerformed

    private void btnCetakPendaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakPendaftarActionPerformed
        // TODO add your handling code here:
        try {
            //if (txtNamaPendaftar.getText().isEmpty()) {
                String path1 = "src/laporan/Daftar.jasper";
                JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakPendaftarActionPerformed

    private void btnCetakSoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakSoalActionPerformed
        // TODO add your handling code here:
        try {
            //(txtNamaPendaftar.getText().isEmpty())
            String path1 = "src/laporan/Soal.jasper";
            JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

            JasperViewer.viewReport(print, false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakSoalActionPerformed

    private void btnCetakHasilPeroranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakHasilPeroranganActionPerformed
        // TODO add your handling code here:
        try {
            //(txtNamaPendaftar.getText().isEmpty())
                String path1 = "src/laporan/Hasil.jasper";
                JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakHasilPeroranganActionPerformed

    private void btnCetakHasilPerprodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakHasilPerprodiActionPerformed
        // TODO add your handling code here:
        try {
            //(txtNamaPendaftar.getText().isEmpty())
                String path1 = "src/laporan/HasilProdi.jasper";
                JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakHasilPerprodiActionPerformed

    private void btnCetakHasilTesPeminatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakHasilTesPeminatanActionPerformed
        // TODO add your handling code here:
        try {
            //(txtNamaPendaftar.getText().isEmpty())
                String path1 = "src/laporan/HasilTes.jasper";
                JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakHasilTesPeminatanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetakFakultas;
    private javax.swing.JButton btnCetakHasilPerorangan;
    private javax.swing.JButton btnCetakHasilPerprodi;
    private javax.swing.JButton btnCetakHasilTesPeminatan;
    private javax.swing.JButton btnCetakPendaftar;
    private javax.swing.JButton btnCetakProdi;
    private javax.swing.JButton btnCetakSoal;
    private javax.swing.JButton btnCetakSoalPerProdi;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
