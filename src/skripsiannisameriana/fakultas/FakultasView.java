/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.fakultas;

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
public class FakultasView extends javax.swing.JInternalFrame {
    private FakultasImplements fakultasImplements = new FakultasImplements();
    private FakultasTabelModel fakultasTabelModel = new FakultasTabelModel();
    /**
     * Creates new form FakultasView
     */
    public FakultasView() {
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
        txtKodeFakultas = new javax.swing.JTextField();
        txtNamaFakultas = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        panelData = new javax.swing.JPanel();
        ComboBoxCari = new javax.swing.JComboBox();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelFakultas = new javax.swing.JTable();

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

        panelIsi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fakultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        panelIsi.setForeground(new java.awt.Color(255, 255, 255));
        panelIsi.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Kode Fakultas         :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nama Fakultas        :");

        javax.swing.GroupLayout panelIsiLayout = new javax.swing.GroupLayout(panelIsi);
        panelIsi.setLayout(panelIsiLayout);
        panelIsiLayout.setHorizontalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaFakultas))
                    .addGroup(panelIsiLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKodeFakultas)))
                .addContainerGap())
        );
        panelIsiLayout.setVerticalGroup(
            panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIsiLayout.createSequentialGroup()
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIsiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
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

        panelData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Berdasarkan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        panelData.setForeground(new java.awt.Color(204, 204, 204));
        panelData.setOpaque(false);

        ComboBoxCari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComboBoxCari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Fakultas", "Nama Fakultas" }));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Fakultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        tabelFakultas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelFakultas.setOpaque(false);
        jScrollPane1.setViewportView(tabelFakultas);

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addComponent(ComboBoxCari, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
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
                    .addComponent(panelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        buttonTambahkan();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        buttonUbah();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        HapusFakultas();
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

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        setTableModel();
        refresh();
        tableFakultasAction();
 //       loadDatabase();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxCari;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelIsi;
    private javax.swing.JTable tabelFakultas;
    private javax.swing.JTextField txtCari;
    public static javax.swing.JTextField txtKodeFakultas;
    public static javax.swing.JTextField txtNamaFakultas;
    // End of variables declaration//GEN-END:variables

    //Load Database
    public void loadDatabase() {
        try {
            List<Fakultas> list = fakultasImplements.getFakultas();
            fakultasTabelModel.setData(list);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }
    
    public void setTableModel() {
        try {
            tabelFakultas.setModel(fakultasTabelModel);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }
    
    public void refresh() {
        try {
            loadDatabase();
            txtNamaFakultas.setEnabled(true);
            txtKodeFakultas.setEnabled(false);            
            txtKodeFakultas.setText("");
            txtNamaFakultas.setText("");

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
            btnHapus.setEnabled(true);

            tabelFakultas.setEnabled(true);
            btnTambah.requestFocus();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void buttonTambahkan() {
        try {
            switch (btnTambah.getToolTipText()) {
                case "Tambah":
                    disableAndEnableForInsert();
                    break;
                case "Simpan":
                    if (txtKodeFakultas.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Kode Fakultas!");
                        txtKodeFakultas.requestFocus();
                    } else if (txtNamaFakultas.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Nama Fakultas!");
                        txtNamaFakultas.requestFocus();
                    } else {
                        insertFakultas();
                    }
                    break;
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan!");
        }
    }

    public void buttonUbah() {
        try {
            switch (btnUbah.getToolTipText()) {
                case "Ubah":
                    disableAndEnableForUpdate();
                    break;
                case "Simpan":
                    if (txtKodeFakultas.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Id Fakultas!");
                        txtKodeFakultas.requestFocus();
                    } else if (txtNamaFakultas.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Lengkapi Data Nama Fakultas!");
                        txtNamaFakultas.requestFocus();
                    } else {
                        ubahFakultas();
                    }
                    break;
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan!");
        }
    }

    public void buttonTutup() {
        try {
            //HomeView.setEnableDisableMenu(true);
            dispose();
            //Home2.isMenuItemJurusanActive = false;
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan!");
        }
    }

    public void insertFakultas() {
        try {
            Fakultas fakultas = new Fakultas();

            fakultas.setIdFakultas(Integer.parseInt(txtKodeFakultas.getText()));
            fakultas.setNamaFakultas(txtNamaFakultas.getText());

            fakultasImplements.insertFakultas(fakultas);
            JOptionPane.showMessageDialog(null, "Nama Fakultas"+ txtNamaFakultas.getText() + "Berhasil Disimpan!");
            refresh();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan!");
        }
    }

    public void ubahFakultas() {
        try {
            Fakultas fakultas = new Fakultas();
            
            fakultas.setIdFakultas(Integer.parseInt(txtKodeFakultas.getText()));
            fakultas.setNamaFakultas(txtNamaFakultas.getText());

            fakultasImplements.updateFakultas(fakultas);
            JOptionPane.showMessageDialog(null, "Nama Fakultas " + txtNamaFakultas.getText() + " Barhasil Di Ubah !");
            refresh();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void HapusFakultas() {
        try {
            int row = tabelFakultas.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Silahkan seleksi data yang ingin dihapus!");
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "Anda Yakin Mau Menghapus Fakultas "
                        + fakultasTabelModel.get(row).getNamaFakultas()+ "? \n", "Konfirmasi",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                //Periksa Jawaban yang dipilih
                if (confirm == JOptionPane.YES_OPTION) {
                    int idFakultas = fakultasTabelModel.get(row).getIdFakultas();

                    fakultasImplements.deleteFakultas(idFakultas);
                    refresh();
                } else if (confirm == JOptionPane.NO_OPTION) {
                    refresh();
                }
            }
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Terjadi Kesalahan!");
        } catch (Exception error) {
            System.out.println("Terjadi Kesalahan!");
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void disableAndEnableForInsert() {
        try {
            txtKodeFakultas.setEnabled(true);
            txtNamaFakultas.setEnabled(true);
            
            txtKodeFakultas.setText("");
            txtKodeFakultas.setText("");

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

            tabelFakultas.setEnabled(false);
            txtKodeFakultas.requestFocus();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void disableAndEnableForUpdate() {
        try {

            int row = tabelFakultas.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Silahkan seleksi data yang ingin diubah!");
            } else {
                txtKodeFakultas.setEnabled(false);
                txtNamaFakultas.setEnabled(true);

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

                tabelFakultas.setEnabled(false);
                txtNamaFakultas.requestFocus();
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }

    public void tableFakultasAction() {
        tabelFakultas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = tabelFakultas.getSelectedRow();
                //CEK APAKAH BARIS BENAR2 TERSELEKSI
                if (row != -1) {
                    Fakultas fakultas = fakultasTabelModel.get(row);
                    
                    txtKodeFakultas.setText(Integer.toString(fakultas.getIdFakultas()));
                    txtNamaFakultas.setText(fakultas.getNamaFakultas());

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
                sqlParameter = "id_fakultas";
            } else if (ComboBoxCari.getSelectedIndex() == 1) {
                sqlParameter = "fakultas";
            }
            searchParameter = txtCari.getText();
            List<Fakultas> list = fakultasImplements.getFakultasParameter(sqlParameter, searchParameter);
            fakultasTabelModel.setData(list);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan !");
        }
    }
    
    public void buttonPrint() {

        int row = tabelFakultas.getRowCount();
        if (row == 0) {
            JOptionPane.showMessageDialog(this, "Tidak Ada Data Yang Di Cetak !");
        } else {
            try {
                JasperPrint jasperPrint = fakultasImplements.cetakFakultas();
                JasperViewer.viewReport(jasperPrint, false);
            } catch (Exception e) {
            }
        }
    }
}
