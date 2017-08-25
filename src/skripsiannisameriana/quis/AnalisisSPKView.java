/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.quis;

import java.math.BigDecimal;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import skripsiannisameriana.connect.Connect;

/**
 *
 * @author phantom
 */
public class AnalisisSPKView extends javax.swing.JDialog {

    /**
     * Creates new form AnalisisSPKView
     */
    Connect k = new Connect();
    ResultSet rs = null;
    String[] alternatif;
    String[] id_alternatif;
    String[] kriteria;
    String[] id_kriteria;
    String[] costbenefit;
    double[] kepentingan;
    double[][] alternatifkriteria;

    public AnalisisSPKView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            int c = -1;
            rs = k.select("select * from tb_prodi");
            int jml_alternatif = 0;
            while (rs.next()) {
                jml_alternatif++;
            }
            alternatif = new String[jml_alternatif];
            id_alternatif = new String[jml_alternatif];
            rs = k.select("select * from tb_prodi");
            c = -1;
            while (rs.next()) {
                c++;
                alternatif[c] = rs.getString("nama_prodi");
                id_alternatif[c] = rs.getString("id_prodi");
            }

            rs = k.select("select * from tb_pilihan");
            int jml_kriteria = 0;
            while (rs.next()) {
                jml_kriteria++;
            }

            kriteria = new String[jml_kriteria];
            id_kriteria = new String[jml_kriteria];
            costbenefit = new String[jml_kriteria];
            kepentingan = new double[jml_kriteria];
            rs = k.select("select * from tb_pilihan");
            c = -1;
            while (rs.next()) {
                c++;
                kriteria[c] = rs.getString("id_prodi");
                id_kriteria[c] = rs.getString("prioritas");
                //costbenefit[c] = rs.getString("costbenefit");
                kepentingan[c] = rs.getDouble("prioritas");
            }
            
            
            int[] coba = {1,2,3,4,5,6,7,8,9,10,11,12,13};
            alternatifkriteria = new double[jml_alternatif][jml_kriteria];
            for (int i = 0; i < alternatif.length; i++) {
                for (int j = 0; j < kriteria.length; j++) {
                    //rs = k.select("select * from tb_hasil where id_prodi = '" + id_alternatif[i] + "' and id_soal = '" + id_kriteria[j] + "'");
                    rs = k.select("select * from tb_hasil where id_prodi = '" + id_alternatif[i] + "'and id_urut = '" + id_kriteria[j] + "'");
                    while (rs.next()) {
                        alternatifkriteria[i][j] = rs.getDouble("hasil");
                    }
                }
            }
        } catch (Exception e) {

        }

        double[] pembagi = new double[kriteria.length];

        for (int i = 0; i < kriteria.length; i++) {
            pembagi[i] = 0.0D;
            for (int j = 0; j < alternatif.length; j++) {
                pembagi[i] += alternatifkriteria[j][i] * alternatifkriteria[j][i];
            }
            pembagi[i] = Math.sqrt(pembagi[i]);
        }

        double[][] normalisasi = new double[alternatif.length][kriteria.length];
        
        for (int i = 0; i < alternatif.length; i++) {
            for (int j = 0; j < kriteria.length; j++) {
                normalisasi[i][j] = (alternatifkriteria[i][j] / pembagi[j]);
                
            }
        }

        double[][] terbobot = new double[alternatif.length][kriteria.length];

        for (int i = 0; i < alternatif.length; i++) {
            for (int j = 0; j < kriteria.length; j++) {
                terbobot[i][j] = normalisasi[i][j] * kepentingan[j];
            }
        }

        double[] aplus = new double[kriteria.length];

        for (int i = 0; i < kriteria.length; i++) {
            for (int j = 0; j < alternatif.length; j++) {
                if (j == 0) {
                    aplus[i] = terbobot[j][i];

                } else if (aplus[i] < terbobot[j][i]) {
                    aplus[i] = terbobot[j][i];
                }
            }
        }

        double[] amin = new double[kriteria.length];

        for (int i = 0; i < kriteria.length; i++) {
            for (int j = 0; j < alternatif.length; j++) {
                if (j == 0) {
                    amin[i] = terbobot[j][i];

                } else if (amin[i] > terbobot[j][i]) {
                    amin[i] = terbobot[j][i];
                }
            }
        }
        
        double[] dplus = new double[alternatif.length];

        for (int i = 0; i < alternatif.length; i++) {
            dplus[i] = 0.0D;
            for (int j = 0; j < kriteria.length; j++) {
                dplus[i] += (aplus[j] - terbobot[i][j]) * (aplus[j] - terbobot[i][j]);
            }
            dplus[i] = Math.sqrt(dplus[i]);
        }
        
        double[] dmin = new double[alternatif.length];

        for (int i = 0; i < alternatif.length; i++) {
            dmin[i] = 0.0D;
            for (int j = 0; j < kriteria.length; j++) {
                dmin[i] += (terbobot[i][j] - amin[j]) * (terbobot[i][j] - amin[j]);
            }
            dmin[i] = Math.sqrt(dmin[i]);
        }
        
        //error
        double[] hasil = new double[alternatif.length];

        for (int i = 0; i < alternatif.length; i++) {
            hasil[i] = (dmin[i] + dplus[i])  ;
        }
        
        String[] alternatifrangking = new String[alternatif.length];
        double[] hasilrangking = new double[alternatif.length];

        for (int i = 0; i < alternatif.length; i++) {
            hasilrangking[i] = hasil[i];
            alternatifrangking[i] = alternatif[i];
        }

        for (int i = 0; i < alternatif.length; i++) {
            for (int j = i; j < alternatif.length; j++) {
                if (hasilrangking[j] > hasilrangking[i]) {
                    double tmphasil = hasilrangking[i];
                    String tmpalternatif = alternatifrangking[i];
                    hasilrangking[i] = hasilrangking[j];
                    alternatifrangking[i] = alternatifrangking[j];
                    hasilrangking[j] = tmphasil;
                    alternatifrangking[j] = tmpalternatif;
                }
            }
        }
        
        DefaultTableModel model = null;

        String[] kolom = {"Alternatif", "Nilai"};

        model = new DefaultTableModel((Object[][]) null, kolom);
        tabelHasilRangking.setModel(model);
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        for (int i = 0; i < alternatifrangking.length; i++) {
            String[] row = new String[2];
            row[0] = alternatifrangking[i];
            row[1] = BigDecimal.valueOf(hasilrangking[i]).toPlainString();
            model.addRow(row);
        }
        
        labelAlternatifTerbaik.setText(alternatifrangking[0]);
        labelNilaiTerbesar.setText(BigDecimal.valueOf(hasilrangking[0]).toPlainString());

        tabelAlternatif.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelKriteria.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelKepentingan.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelAlternatifKriteria.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelPembagi.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelNormalisasi.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelTerbobot.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelAPlus.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelAMinimal.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelDPlus.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelDMin.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelHasil.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelHasilRanking.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        tabelAlternatifRanking.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));

        tampilbaris(tabelAlternatif, alternatif);
        tampilbaris(tabelKriteria, kriteria);
        tampilbaris1(tabelKepentingan, kepentingan);
        tampiltabel(tabelAlternatifKriteria, alternatifkriteria);
        tampilbaris1(tabelPembagi, pembagi);
        tampiltabel(tabelNormalisasi, normalisasi);
        tampiltabel(tabelTerbobot, terbobot);
        tampilbaris1(tabelAPlus, aplus);
        tampilbaris1(tabelAMinimal, amin);
        tampilkolom(tabelDPlus, dplus);
        tampilkolom(tabelDMin, dmin);
        tampilkolom(tabelHasil, hasil);
        tampilkolom(tabelHasilRanking, hasilrangking);
        tampilkolom1(tabelAlternatifRanking, alternatifrangking);

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
        btnTutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelHasilRangking = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelAlternatifTerbaik = new javax.swing.JLabel();
        labelNilaiTerbesar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelAlternatif = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelKriteria = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelPembagi = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelKepentingan = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelAlternatifKriteria = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelNormalisasi = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelTerbobot = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabelAPlus = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabelAMinimal = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabelDPlus = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tabelDMin = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tabelHasil = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tabelHasilRanking = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        tabelAlternatifRanking = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setText("Hasil Ranking");

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        tabelHasilRangking.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelHasilRangking);

        jLabel2.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        jLabel2.setText("Alternatif Terbaik        :");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        jLabel3.setText("Nilai Terbesar              :");

        labelAlternatifTerbaik.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        labelAlternatifTerbaik.setText("jLabel4");

        labelNilaiTerbesar.setFont(new java.awt.Font("Noto Sans", 3, 12)); // NOI18N
        labelNilaiTerbesar.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setText("Alternatif");

        tabelAlternatif.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelAlternatif);

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setText("Kriteria");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tabelKriteria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelKriteria);

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setText("Pembagi");

        tabelPembagi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabelPembagi);

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setText("Kepentingan");

        tabelKepentingan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tabelKepentingan);

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setText("Alternatif Kriteria");

        tabelAlternatifKriteria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tabelAlternatifKriteria);

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setText("Normalisasi");

        tabelNormalisasi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tabelNormalisasi);

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setText("Terbobot");

        tabelTerbobot.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tabelTerbobot);

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel13.setText("A+");

        tabelAPlus.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(tabelAPlus);

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel14.setText("A-");

        tabelAMinimal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(tabelAMinimal);

        jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel15.setText("D+");

        tabelDPlus.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(tabelDPlus);

        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel16.setText("D-");

        tabelDMin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(tabelDMin);

        jLabel17.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel17.setText("Hasil");

        tabelHasil.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(tabelHasil);

        jLabel18.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel18.setText("Hasil Ranking");

        tabelHasilRanking.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(tabelHasilRanking);

        tabelAlternatifRanking.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(tabelAlternatifRanking);

        jLabel19.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel19.setText("Alternatif Ranking");

        jButton1.setText("Cetak Hasil");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTutup))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelAlternatifTerbaik))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelNilaiTerbesar))
                                    .addComponent(jLabel6))
                                .addComponent(jLabel7)))
                        .addComponent(jLabel8)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(jLabel10))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(jLabel14)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(jLabel12))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(jLabel16))))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addComponent(jLabel17))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addComponent(jLabel18))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addComponent(jButton1))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnTutup))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(labelAlternatifTerbaik))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(labelNilaiTerbesar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            //(txtNamaPendaftar.getText().isEmpty())
                String path1 = "src/laporan/Hasil.jasper";
                JasperPrint print = JasperFillManager.fillReport(path1, null, Connect.getConnection());

                JasperViewer.viewReport(print, false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Dokumen Tidak Ada " + ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

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
            java.util.logging.Logger.getLogger(AnalisisSPKView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalisisSPKView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalisisSPKView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalisisSPKView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnalisisSPKView dialog = new AnalisisSPKView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labelAlternatifTerbaik;
    private javax.swing.JLabel labelNilaiTerbesar;
    private javax.swing.JTable tabelAMinimal;
    private javax.swing.JTable tabelAPlus;
    private javax.swing.JTable tabelAlternatif;
    private javax.swing.JTable tabelAlternatifKriteria;
    private javax.swing.JTable tabelAlternatifRanking;
    private javax.swing.JTable tabelDMin;
    private javax.swing.JTable tabelDPlus;
    private javax.swing.JTable tabelHasil;
    private javax.swing.JTable tabelHasilRangking;
    private javax.swing.JTable tabelHasilRanking;
    private javax.swing.JTable tabelKepentingan;
    private javax.swing.JTable tabelKriteria;
    private javax.swing.JTable tabelNormalisasi;
    private javax.swing.JTable tabelPembagi;
    private javax.swing.JTable tabelTerbobot;
    // End of variables declaration//GEN-END:variables

    public void tampilbaris(JTable tbl, String[] data) {
        DefaultTableModel model = null;

        String[] kolom = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            kolom[i] = "";
        }

        model = new DefaultTableModel((Object[][]) null, kolom);
        tbl.setModel(model);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        String[] row = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            row[i] = data[i];
        }
        model.addRow(row);
    }

    public void tampilbaris1(JTable tbl, double[] data) {
        DefaultTableModel model = null;

        String[] kolom = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            kolom[i] = "";
        }

        model = new DefaultTableModel((Object[][]) null, kolom);
        tbl.setModel(model);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        String[] row = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            row[i] = BigDecimal.valueOf(data[i]).toPlainString();
        }
        model.addRow(row);
    }

    public void tampiltabel(JTable tbl, double[][] data) {
        DefaultTableModel model = null;

        String[] kolom = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            kolom[i] = "";
        }

        model = new DefaultTableModel((Object[][]) null, kolom);
        tbl.setModel(model);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        for (int i = 0; i < data.length; i++) {
            String[] row = new String[data[0].length];
            for (int j = 0; j < data[0].length; j++) {
                row[j] = BigDecimal.valueOf(data[i][j]).toPlainString();
            }
            model.addRow(row);
        }
    }
    
    public void tampilkolom(JTable tbl, double[] data) {
        DefaultTableModel model = null;

        String[] kolom = new String[1];
        kolom[0] = "";

        model = new DefaultTableModel((Object[][]) null, kolom);
        tbl.setModel(model);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        for (int i = 0; i < data.length; i++) {
            String[] row = new String[1];
            row[0] = BigDecimal.valueOf(data[i]).toPlainString();
            model.addRow(row);
        }
    }
    
    public void tampilkolom1(JTable tbl, String[] data) {
        DefaultTableModel model = null;

        String[] kolom = new String[2];
        kolom[0] = "Prodi";
        kolom[1] = "Rank";

        model = new DefaultTableModel((Object[][]) null, kolom);
        tbl.setModel(model);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        for (int i = 0, r = 1; i < data.length; i++, r++) {
            String[] row = new String[2];
            row[0] = data[i];
            row[1] = Integer.toString(r);
            model.addRow(row);
        }
    }
}
