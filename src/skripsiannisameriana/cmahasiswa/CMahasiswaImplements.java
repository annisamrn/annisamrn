/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.cmahasiswa;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import skripsiannisameriana.connect.Connect;

/**
 *
 * @author USER
 */
public class CMahasiswaImplements {
    public void insertPeserta(CMahasiswa cm) throws Exception {
        String sqlInsert = "INSERT INTO tb_calon_mhs VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlInsert);

            preparedStatement.setInt(1, cm.getIdPendaftar());
            preparedStatement.setString(2, cm.getNamaPendaftar());
            preparedStatement.setString(3, cm.getAsalSekolah());
            preparedStatement.setString(4, cm.getTelepon());
            preparedStatement.setString(5, cm.getEmail());
            preparedStatement.setString(6, cm.getAlamat());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("Salah cyin" + err);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Saat Menginput Data! ");
        }
    }
    
    public void updatePendaftar(CMahasiswa cm) throws Exception {
        String sqlUpdate = "UPDATE tb_calon_mhs SET nama = ?, asal_sekolah = ?, telepon = ?, email = ?, alamat = ? WHERE id_pendaftar = ?";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = Connect.getConnection().prepareStatement(sqlUpdate);

            preparedStatement.setString(1, cm.getNamaPendaftar());
            preparedStatement.setString(2, cm.getAsalSekolah());
            preparedStatement.setString(3, cm.getTelepon());
            preparedStatement.setString(4, cm.getEmail());
            preparedStatement.setString(5, cm.getAlamat());
            preparedStatement.setInt(6, cm.getIdPendaftar());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("salah say: " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Ubah, \n Karena Data Masih Di Pakai.");
        }
    }
    
    public void deletePendaftar(int idPendaftar) throws Exception {
        String sqlDelete = "DELETE FROM tb_calon_mhs WHERE id_pendaftar = ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlDelete);

            preparedStatement.setInt(1, idPendaftar);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus Semua !");
        } catch (SQLException | HeadlessException err) {
            System.out.println("salah tuh: " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \n Karena Data Masih Di Pakai.");
        }
    }
    
    // database Tabel
    public List<CMahasiswa> getPendaftar() throws SQLException {
        String sqlSelect = "SELECT * FROM tb_calon_mhs";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            List<CMahasiswa> list = new ArrayList<>();

            while (resultSet.next()) {
                CMahasiswa cm = new CMahasiswa();
                cm.setIdPendaftar(resultSet.getInt("id_pendaftar"));
                cm.setNamaPendaftar(resultSet.getString("nama"));
                cm.setAsalSekolah(resultSet.getString("asal_sekolah"));
                cm.setTelepon(resultSet.getString("telepon"));
                cm.setEmail(resultSet.getString("email"));
                cm.setAlamat(resultSet.getString("alamat"));
                list.add(cm);
            }
            resultSet.close();
            return list;
        } catch (SQLException exception) {
            System.out.println("Terjadi Kesalahan lah! " + exception);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println("Salah nang" + exception);
                    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Tampilan Data ! ");

                }
            }
        }
    }
    
    public List<CMahasiswa> getPendaftarParameter(String sqlParameter, String searchParameter) throws SQLException {
        String sqlSelect = "SELECT * FROM tb_calon_mhs WHERE " + sqlParameter + " LIKE  '%" + searchParameter + "%' AND id_pendaftar <> '1'";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            List<CMahasiswa> list = new ArrayList<>();

            while (resultSet.next()) {
                CMahasiswa cm = new CMahasiswa();
                cm.setIdPendaftar(resultSet.getInt("id_pendaftar"));
                cm.setNamaPendaftar(resultSet.getString("nama"));
                cm.setAsalSekolah(resultSet.getString("asal_sekolah"));
                cm.setTelepon(resultSet.getString("telepon"));
                cm.setEmail(resultSet.getString("email"));
                cm.setAlamat(resultSet.getString("alamat"));
                list.add(cm);
            }
            resultSet.close();
            return list;
        } catch (SQLException exception) {
            System.out.println("Salah cil" + exception);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Tampilan Data ! ");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println("Terjadi Kesalahan ya! " + exception);

                }
            }
        }
    }
    
    /*public JasperPrint cetakFakultas() {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream("/Laporan/Jurusan.jasper"), null, Connect.getConnection());
            return jasperPrint;
        } catch (JRException exception) {
            System.out.println("Terjadi Kesalahan Cetak : " + exception);
            return null;
        } catch (Exception exception) {
            System.out.println("Terjadi Kesalahan Cetak 1 : " + exception);
            return null;
        }
    }*/
}