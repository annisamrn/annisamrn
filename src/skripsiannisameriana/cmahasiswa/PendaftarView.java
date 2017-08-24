/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.cmahasiswa;

import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import skripsiannisameriana.connect.Connect;
import static skripsiannisameriana.prodi.ProdiView.txtKodeProdi;

/**
 *
 * @author USER
 */
public class PendaftarView extends javax.swing.JInternalFrame {
    
    CMahasiswaImplements cMahasiswaImplements = new CMahasiswaImplements();
    CMahasiswaTabelModel cMahasiswaTabelModel = new CMahasiswaTabelModel();
    int id;
    /**
     * Creates new form PendaftarView
     */
    public PendaftarView() {
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

        panelIsi = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNamaPendaftar = new javax.swing.JTextField();
        txtAsalSekolah = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaAlamat = new javax.swing.JTextArea();
        txtPassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKkodePendaftar = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        panelData = new javax.swing.JPanel();
        ComboBoxCari = new javax.swing.JComboBox();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPendaftar = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(2147483647, 425));
        setPreferredSize(new java.awt.Dimension(1083, 425));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        panelIsi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pendaftar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        panelIsi.setForeground(new java.awt.Color(255, 255, 255));
        panelIsi.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nama Pendaftar                 :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Asal Sekolah                       :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Telepon                                :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Email                                     :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Alamat                                 :");

        txtAreaAlamat.setColumns(20);
        txtAreaAlamat.setRows(5);
        jScrollPane2.setViewportView(txtAreaAlamat);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Password                             :");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("ID Pendaftar                       :");

        txtKkodePendaftar.setEnabled(false);

        javax.swing.GroupLayout panelIsiLayout = new javax.swing.GroupLayout(panelIsi);
        panelIsi.setLayout(panelIsiLayout);
        panelIsiLayout.setHorizontalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKkodePendaftar))
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAsalSekolah, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                            .addComponent(txtNamaPendaftar)))
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addGroup(panelIsiLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTelepon)))
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword)))
                .addGap(160, 160, 160))
        );
        panelIsiLayout.setVerticalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKkodePendaftar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamaPendaftar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAsalSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        panelButton.setForeground(new java.awt.Color(255, 255, 255));
        panelButton.setOpaque(false);
        panelButton.setLayout(new java.awt.GridLayout(1, 0));

        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/skripsiannisameriana/picture/add.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        panelButton.add(btnTambah);

        btnUbah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/skripsiannisameriana/picture/edit.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        panelButton.add(btnUbah);

        btnBatal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/skripsiannisameriana/picture/cancel.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        panelButton.add(btnBatal);

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/skripsiannisameriana/picture/print.png"))); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });
        panelButton.add(btnCetak);

        btnTutup.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/skripsiannisameriana/picture/c_close.png"))); // NOI18N
        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });
        panelButton.add(btnTutup);

        panelData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Berdasarkan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelData.setForeground(new java.awt.Color(204, 204, 204));
        panelData.setOpaque(false);

        ComboBoxCari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComboBoxCari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nomor Pendaftar", "Nama Pendaftar", "Asal Sekolah" }));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Pendaftar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        tabelPendaftar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPendaftar.setOpaque(false);
        jScrollPane1.setViewportView(tabelPendaftar);

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addComponent(ComboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(122, 122, 122))
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIsi, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelIsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        buttonTambahkan();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        buttonUbah();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        refresh();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        //buttonPrint();
        try {
            if (txtNamaPendaftar.getText().isEmpty()) {
                String path1 = "src/laporan/Daftar.jasper";
                JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            } else {
                HashMap parameter = new HashMap();
                String path = "src/laporan/Pendaftar.jasper";
                //int id = txtKodeFakultas.getText();
                parameter.put("id_jur", Integer.parseInt(txtKkodePendaftar.getText()));

                //JasperPrint print = JasperFillManager.fillReport(path, parameter, Connect.getConnection());
                JasperPrint print = JasperFillManager.fillReport(path, parameter, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        buttonTutup();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        searchPeremeter();
    }//GEN-LAST:event_txtCariKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        setTableModel();
        refresh();
        tablePendaftarAction();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxCari;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JTable tabelPendaftar;
    private javax.swing.JTextArea txtAreaAlamat;
    public static javax.swing.JTextField txtAsalSekolah;
    private javax.swing.JTextField txtCari;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtKkodePendaftar;
    public static javax.swing.JTextField txtNamaPendaftar;
    public static javax.swing.JTextField txtPassword;
    public static javax.swing.JTextField txtTelepon;
    // End of variables declaration//GEN-END:variables

    public void loadDatabase() {
        try {
            List<CMahasiswa> list = cMahasiswaImplements.getPendaftar();
            cMahasiswaTabelModel.setData(list);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 1!");
        }
    }
    
    public void setTableModel() {
        try {
            tabelPendaftar.setModel(cMahasiswaTabelModel);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 2!");
        }
    }
    
    public void refresh() {
        try {
            loadDatabase();
            txtNamaPendaftar.setEnabled(true);
            txtAsalSekolah.setEnabled(true);
            txtTelepon.setEnabled(true);
            txtEmail.setEnabled(true);
            txtAreaAlamat.setEnabled(true);
            txtNamaPendaftar.setText("");
            txtAsalSekolah.setText("");
            txtTelepon.setText("");
            txtEmail.setText("");
            txtPassword.setText("");
            txtAreaAlamat.setText("");

            btnBatal.setEnabled(true);
            btnBatal.setText("Bersihkan");
            btnBatal.setToolTipText("Bersihkan");

            btnTambah.setEnabled(true);
            btnTambah.setText("Tambah");
            btnTambah.setToolTipText("Tambah");

            btnCetak.setEnabled(true);
            btnTutup.setEnabled(true);

            txtCari.setEnabled(true);
            ComboBoxCari.setEnabled(true);
            txtCari.setText("");
            ComboBoxCari.setSelectedIndex(0);

            btnUbah.setEnabled(true);
            //btnHapus.setEnabled(true);

            tabelPendaftar.setEnabled(true);
            btnTambah.requestFocus();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 3!");
        }
    }

    public void buttonTambahkan() {
        try {
            switch (btnTambah.getToolTipText()) {
                case "Tambah":
                    disableAndEnableForInsert();
                    break;
                case "Simpan":
                    if (txtNamaPendaftar.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Nama Pendaftar!");
                        txtNamaPendaftar.requestFocus();
                    } else if (txtAsalSekolah.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi Data Asal Sekolah dengan benar!");
                        txtAsalSekolah.requestFocus();
                    }else if (txtTelepon.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi nomor Telepon dengan benar!");
                        txtTelepon.requestFocus();
                    }else if (txtEmail.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi Data email dengan benar!");
                        txtEmail.requestFocus();
                    }else if (txtPassword.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi Data password dengan benar!");
                        txtPassword.requestFocus();
                    }else if (txtAreaAlamat.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi Data Alamat dengan benar!");
                        txtAreaAlamat.requestFocus();
                    } else {
                        insertPendaftar();
                    }
                    break;
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 4!");
        }
    }

    public void buttonUbah() {
        try {
            switch (btnUbah.getToolTipText()) {
                case "Ubah":
                    disableAndEnableForUpdate();
                    break;
                case "Simpan":
                    if (txtNamaPendaftar.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Nama Pendaftar!");
                        txtNamaPendaftar.requestFocus();
                    } else if (txtAsalSekolah.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi Data Asal Sekolah dengan benar!");
                        txtAsalSekolah.requestFocus();
                    }else if (txtTelepon.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi nomor Telepon dengan benar!");
                        txtTelepon.requestFocus();
                    }else if (txtEmail.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi Data email dengan benar!");
                        txtEmail.requestFocus();
                    }else if (txtPassword.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi Data password dengan benar!");
                        txtPassword.requestFocus();
                    }else if (txtAreaAlamat.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Isi Data Alamat dengan benar!");
                        txtAreaAlamat.requestFocus();
                    } else {
                        ubahPendaftar();
                    }
                    break;
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 5!");
        }
    }

    public void buttonTutup() {
        try {
            //HomeView.setEnableDisableMenu(true);
            dispose();
            //Home2.isMenuItemJurusanActive = false;
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 6!");
        }
    }

    public void insertPendaftar() {
        try {
            CMahasiswa cmhs = new CMahasiswa();
            
            cmhs.setNamaPendaftar(txtNamaPendaftar.getText());
            cmhs.setAsalSekolah(txtAsalSekolah.getText());
            cmhs.setTelepon(txtTelepon.getText());
            cmhs.setEmail(txtEmail.getText());
            cmhs.setPassword(txtPassword.getText());
            cmhs.setAlamat(txtAreaAlamat.getText());
            
            cMahasiswaImplements.insertPeserta(cmhs);
            JOptionPane.showMessageDialog(null, "Nama Pendaftar"+ txtNamaPendaftar.getText() + "Berhasil disimpan");
            refresh();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 7!");
        }
    }

    public void ubahPendaftar() {
        try {
            CMahasiswa cmhs = new CMahasiswa();
            
            cmhs.setNamaPendaftar(txtNamaPendaftar.getText());
            cmhs.setAsalSekolah(txtAsalSekolah.getText());
            cmhs.setTelepon(txtTelepon.getText());
            cmhs.setEmail(txtEmail.getText());
            cmhs.setPassword(txtPassword.getText());
            cmhs.setAlamat(txtAreaAlamat.getText());
            cmhs.setIdPendaftar(id);
            
            cMahasiswaImplements.updatePendaftar(cmhs);
            JOptionPane.showMessageDialog(null, "Nama Pendaftar "+ txtNamaPendaftar.getText() + " Berhasil diubah");
            refresh();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 8!");
        }
    }

    /*public void HapusPendaftar() {
        try {
            int row = tabelPendaftar.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Silahkan seleksi data yang ingin dihapus!");
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "Anda Yakin Mau Menghapus Peserta "
                        + cMahasiswaTabelModel.get(row).getNamaPendaftar()+ "? \n", "Konfirmasi",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                //Periksa Jawaban yang dipilih
                if (confirm == JOptionPane.YES_OPTION) {
                    int idPendaftar = CMahasiswaTabelModel.get(row).getIdPendaftar();

                    CMahasiswaImplements.deleteCMahasiswa(idPendaftar);
                    refresh();
                } else if (confirm == JOptionPane.NO_OPTION) {
                    refresh();
                }
            }
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Terjadi Kesalahan 9!");
        } catch (Exception error) {
            System.out.println("Terjadi Kesalahan 10!");
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 11!");
        }
    }*/

    public void disableAndEnableForInsert() {
        try {
            txtNamaPendaftar.setEnabled(true);
            txtAsalSekolah.setEnabled(true);
            txtTelepon.setEnabled(true);
            txtEmail.setEnabled(true);
            txtAreaAlamat.setEnabled(true);
            txtNamaPendaftar.setText("");
            txtAsalSekolah.setText("");
            txtTelepon.setText("");
            txtEmail.setText("");
            txtPassword.setText("");
            txtAreaAlamat.setText("");

            btnBatal.setEnabled(true);
            btnBatal.setText("Batal");
            btnBatal.setToolTipText("Batal");

            btnTambah.setEnabled(true);
            btnTambah.setText("Simpan");
            btnTambah.setToolTipText("Simpan");

            txtCari.setEnabled(false);
            ComboBoxCari.setEnabled(false);
            txtCari.setText("");
            ComboBoxCari.setSelectedIndex(0);

            tabelPendaftar.setEnabled(false);
            txtNamaPendaftar.requestFocus();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void disableAndEnableForUpdate() {
        try {

            int row = tabelPendaftar.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Silahkan seleksi data yang ingin diubah!");
            } else {
                txtNamaPendaftar.setEnabled(true);
                txtAsalSekolah.setEnabled(true);
                txtTelepon.setEnabled(true);
                txtEmail.setEnabled(true);
                txtPassword.setEnabled(true);
                txtAreaAlamat.setEnabled(true);

                btnBatal.setEnabled(true);
                btnBatal.setText("Batal");
                btnBatal.setToolTipText("Batal");

                btnUbah.setEnabled(true);
                btnUbah.setText("Simpan");
                btnUbah.setToolTipText("Simpan");

                txtCari.setEnabled(false);
                ComboBoxCari.setEnabled(false);
                txtCari.setText("");
                ComboBoxCari.setSelectedIndex(0);

                tabelPendaftar.setEnabled(false);
                txtNamaPendaftar.requestFocus();
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan 12!");
        }
    }

    public void tablePendaftarAction() {
        tabelPendaftar.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tabelPendaftar.getSelectedRow();
                //CEK APAKAH BARIS BENAR2 TERSELEKSI
                if (row != -1) {
                    CMahasiswa cm = cMahasiswaTabelModel.get(row);
                    
                    txtNamaPendaftar.setText(cm.getNamaPendaftar());
                    txtAsalSekolah.setText(cm.getAsalSekolah());
                    txtTelepon.setText(cm.getTelepon());
                    txtEmail.setText(cm.getEmail());
                    txtPassword.setText(cm.getPassword());
                    txtAreaAlamat.setText(cm.getAlamat());
                    txtKkodePendaftar.setText(Integer.toString(cm.getIdPendaftar()));
                    
                    id = cm.getIdPendaftar();

                    btnUbah.setEnabled(true);
                    btnUbah.setText("Ubah");
                    btnUbah.setToolTipText("Ubah");
                    //btnHapus.setEnabled(true);
                    btnUbah.requestFocus();
                }
            }
        });
    }

    public void searchPeremeter() {
        try {
            String sqlParameter = null;
            String searchParameter;
            if (ComboBoxCari.getSelectedIndex() == 0) {
                sqlParameter = "id_pendaftar";
            } else if (ComboBoxCari.getSelectedIndex() == 1) {
                sqlParameter = "nama";
            } else if (ComboBoxCari.getSelectedIndex() == 2) {
                sqlParameter = "asal_sekolah";
            }
            searchParameter = txtCari.getText();
            List<CMahasiswa> list = cMahasiswaImplements.getPendaftarParameter(sqlParameter, searchParameter);
            cMahasiswaTabelModel.setData(list);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }
    
//    public void buttonPrint() {
//
//        try {
//            
//            HashMap parameter = new HashMap();
//            String path="src/laporan/Pendaftar.jasper"; 
//            //int id = txtKodeFakultas.getText();
//            parameter.put("id_jur", Integer.parseInt(txtKodeProdi.getText()));
//            
//            //JasperPrint print = JasperFillManager.fillReport(path, parameter, Connect.getConnection());
//            JasperPrint print = JasperFillManager.fillReport(path, parameter, Connect.getConnection());
//
//            JasperViewer.viewReport(print, false);
//
//        } catch (Exception ex) {
//
//            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
//
//        }
//    }

}
