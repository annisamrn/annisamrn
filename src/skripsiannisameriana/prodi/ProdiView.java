/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.prodi;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class ProdiView extends javax.swing.JInternalFrame {
    
    ProdiImplements prodiImplements = new ProdiImplements();
    ProdiTabelModel prodiTabelModel = new ProdiTabelModel();

    /**
     * Creates new form ProdiView
     */
    public ProdiView() {
        initComponents();
        setSize(800, 519);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButton = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        panelIsi = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKodeProdi = new javax.swing.JTextField();
        txtKodeFakultas = new javax.swing.JTextField();
        txtNamaProdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNamaFakultas = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        panelData = new javax.swing.JPanel();
        ComboBoxCari = new javax.swing.JComboBox();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelProdi = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
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

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/skripsiannisameriana/picture/delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        panelButton.add(btnHapus);

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

        panelIsi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Program Studi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        panelIsi.setForeground(new java.awt.Color(255, 255, 255));
        panelIsi.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Kode Program Studi   :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Fakultas                        :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nama Program Studi :");

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/skripsiannisameriana/picture/search.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIsiLayout = new javax.swing.GroupLayout(panelIsi);
        panelIsi.setLayout(panelIsiLayout);
        panelIsiLayout.setHorizontalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKodeFakultas, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(txtKodeProdi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addComponent(txtNamaFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaProdi)))
                .addContainerGap())
        );
        panelIsiLayout.setVerticalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamaProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Berdasarkan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelData.setForeground(new java.awt.Color(204, 204, 204));
        panelData.setOpaque(false);

        ComboBoxCari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComboBoxCari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Program Studi", "Nama Program Studi" }));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Program Studi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        tabelProdi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelProdi.setOpaque(false);
        jScrollPane1.setViewportView(tabelProdi);

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addComponent(ComboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari)))
                .addContainerGap())
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIsi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelIsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        buttonTambah();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        buttonUbah();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        deleteProdi();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        refresh();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        buttonPrint();
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        buttonTutup();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        searchPeremeter();
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        btnCariFakultas();
    }//GEN-LAST:event_btnCariActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        setTableModel();
        refresh();
        loadDatabase();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxCari;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JTable tabelProdi;
    private javax.swing.JTextField txtCari;
    public static javax.swing.JTextField txtKodeFakultas;
    public static javax.swing.JTextField txtKodeProdi;
    public static javax.swing.JTextField txtNamaFakultas;
    public static javax.swing.JTextField txtNamaProdi;
    // End of variables declaration//GEN-END:variables

    public void setTableModel() {
        try {
            tabelProdi.setModel(prodiTabelModel);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void loadDatabase() {
        try {
            List<Prodi> list = prodiImplements.getProdi();
            prodiTabelModel.setData(list);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void refresh() {
        try {
            loadDatabase();
                   
            btnCari.setEnabled(false);

            txtKodeProdi.setText("");
            txtKodeFakultas.setText("");
            txtNamaFakultas.setText("");
            txtNamaProdi.setText("");

            btnBatal.setEnabled(true);
            btnBatal.setText("Bersihkan");
            btnBatal.setToolTipText("Bersihkan");

            btnTambah.setEnabled(true);
            btnTambah.setText("Baru");
            btnTambah.setToolTipText("Baru");

            btnCetak.setEnabled(true);
            btnTutup.setEnabled(true);

            txtCari.setEnabled(true);
            ComboBoxCari.setEnabled(true);
            txtCari.setText("");
            ComboBoxCari.setSelectedIndex(0);

            //btnUbah.setEnabled(false);
            //btnHapus.setEnabled(false);

            tabelProdi.setEnabled(true);
            btnTambah.requestFocus();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan!");
        }
    }

    public void buttonTambah() {
        try {
            switch (btnTambah.getToolTipText()) {
                case "Baru":
                    disableAndEnableForInsert();
                    break;
                case "Simpan":
                    if (txtKodeProdi.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Kode Program Studi!");
                        txtKodeProdi.requestFocus();
                    } else if (txtNamaProdi.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Nama Program Studi!");
                        txtNamaProdi.requestFocus();
                    } else if (txtNamaFakultas.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Fakultas!");
                        btnCari.doClick();
                    } else {
                        insertProdi();
                    }
                    break;
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void buttonUbah() {
        try {
            switch (btnUbah.getToolTipText()) {
                case "Ubah":
                    disableAndEnableForUpdate();
                    break;
                case "Simpan":
                    if (txtKodeProdi.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Kode Program Studi!");
                        txtKodeProdi.requestFocus();
                    } else if (txtNamaProdi.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Nama Program Studi!");
                        txtNamaProdi.requestFocus();
                    } else if (txtNamaFakultas.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Fakultas!");
                        btnCari.doClick();
                    } else {
                        updateProdi();
                    }
                    break;
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void buttonTutup() {
        try {
            //Home2.setEnableDisableMenu(true);
            dispose();
            //Home2.isMenuItemKelasActive = false;
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void insertProdi() {
        try {
            Prodi prodi = new Prodi();

            prodi.setIdProdi(Integer.parseInt(txtKodeProdi.getText()));
            prodi.setNamaProdi(txtNamaProdi.getText());
            prodi.setIdFakultas(Integer.parseInt(txtKodeFakultas.getText()));

            prodiImplements.insertProdi(prodi);
            JOptionPane.showMessageDialog(null, "Program Studi " + txtNamaProdi.getText() + " Berhasil Di Simpan!");
            refresh();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void updateProdi() {
        try {
            Prodi prodi = new Prodi();
            
            prodi.setIdProdi(Integer.parseInt(txtKodeProdi.getText()));
            prodi.setNamaProdi(txtNamaProdi.getText());
            prodi.setIdFakultas(Integer.parseInt(txtKodeFakultas.getText()));

            prodiImplements.updateProdi(prodi);
            JOptionPane.showMessageDialog(null, "Program Studi " + txtNamaProdi.getText() + " Berhasil Di Ubah!");
            refresh();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan!");
        }
    }

    public void deleteProdi() {
        try {
            int row = tabelProdi.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Silahkan seleksi data yang ingin dihapus!");
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "Anda Yakin Mau Menghapus Program Studi "
                        + prodiTabelModel.get(row).getNamaProdi()+ "? \n", "Konfirmasi",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                //Periksa Jawaban yang dipilih
                if (confirm == JOptionPane.YES_OPTION) {
                    int idProdi = prodiTabelModel.get(row).getIdProdi();

                    prodiImplements.deleteProdi(idProdi);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus Semua!");
                    refresh();
                } else if (confirm == JOptionPane.NO_OPTION) {
                    refresh();
                }
            }
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Terjadi Kesalahan!");
        } catch (Exception error) {
            System.out.println("Terjadi Kesalahan!");
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan!");
        }
    }

    public void disableAndEnableForInsert() {
        try {
            txtKodeProdi.setEnabled(true);
            txtNamaProdi.setEnabled(true);
            
            btnCari.setEnabled(true);
            
            txtKodeProdi.setText("");
            txtNamaProdi.setText("");
            txtKodeFakultas.setText("");
            txtNamaFakultas.setText("");

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

            tabelProdi.setEnabled(false);
            txtKodeProdi.requestFocus();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void disableAndEnableForUpdate() {
        try {

            int row = tabelProdi.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Silahkan seleksi data yang ingin diubah!");
            } else {
                txtKodeProdi.setEnabled(false);
                txtNamaProdi.setEnabled(true);
                
                btnCari.setEnabled(true);

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

                tabelProdi.setEnabled(false);
                txtNamaProdi.requestFocus();
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan!");
        }
    }

    public void tableProdiAction() {
        tabelProdi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tabelProdi.getSelectedRow();
                //CEK APAKAH BARIS BENAR2 TERSELEKSI
                if (row != -1) {
                    Prodi prodi = prodiTabelModel.get(row);
                    
                    txtKodeProdi.setText(Integer.toString(prodi.getIdProdi()));
                    txtNamaProdi.setText(prodi.getNamaProdi());
                    txtKodeFakultas.setText(Integer.toString(prodi.getIdFakultas()));
                    txtNamaFakultas.setText(prodi.getNamaFakultas());

                    btnUbah.setEnabled(true);
                    btnUbah.setText("Ubah");
                    btnUbah.setToolTipText("Ubah");
                    btnHapus.setEnabled(true);
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
                sqlParameter = "id_prodi";
            } else if (ComboBoxCari.getSelectedIndex() == 1) {
                sqlParameter = "prodi";
            }
            searchParameter = txtCari.getText();
            List<Prodi> list = prodiImplements.getProdiParameter(sqlParameter, searchParameter);
            prodiTabelModel.setData(list);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void buttonPrint() {

        int row = tabelProdi.getRowCount();
        if (row == 0) {
            JOptionPane.showMessageDialog(this, "Tidak Ada Data Yang Di Cetak !");
        } else {
            try {
                JasperPrint jasperPrint = prodiImplements.cetakProdi();
                JasperViewer.viewReport(jasperPrint, false);
            } catch (Exception e) {
            }
        }
    }

    public void btnCariFakultas() {
        try {
            CariFakultasView cariFakultasView = new CariFakultasView(null, true);
            cariFakultasView.setVisible(true);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }
}
