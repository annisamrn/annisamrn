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
    public void insertCMahasiswa(CMahasiswa cMahasiswa) throws Exception {
        String sqlInsert = "INSERT INTO tb_calon_mhs VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlInsert);

            preparedStatement.setInt(1, cMahasiswa.getIdPendaftar());
            preparedStatement.setString(2, cMahasiswa.getNamaPendaftar());
            preparedStatement.setString(3, cMahasiswa.getAsalSekolah());
            preparedStatement.setString(4, cMahasiswa.getTelepon());
            preparedStatement.setString(5, cMahasiswa.getEmail());
            preparedStatement.setString(6, cMahasiswa.getAlamat());
            preparedStatement.setInt(7, cMahasiswa.getIdFakultas());
            preparedStatement.setInt(8, cMahasiswa.getIdProdi());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("Salah " + err);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Masukkan Data ! ");
        }
    }

    public void updateCMahasiswa(CMahasiswa cMahasiswa) throws Exception {
        String sqlUpdate = "UPDATE tb_calon_mhs SET nama = ?, asal_sekolah = ?,"
                         + "telepon = ?, email = ?, alamat = ?, id_fakultas = ?,"
                         + "id_prodi = ? WHERE id_pendaftar = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlUpdate);

            preparedStatement.setInt(8, cMahasiswa.getIdPendaftar());
            preparedStatement.setString(1, cMahasiswa.getNamaPendaftar());
            preparedStatement.setString(2, cMahasiswa.getAsalSekolah());
            preparedStatement.setString(3, cMahasiswa.getTelepon());
            preparedStatement.setString(4, cMahasiswa.getEmail());
            preparedStatement.setString(5, cMahasiswa.getAlamat());
            preparedStatement.setInt(6, cMahasiswa.getIdFakultas());
            preparedStatement.setInt(7, cMahasiswa.getIdProdi());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \nKarena Data Masih Di Pakai.");
        }
    }

    public void deleteCMahasiswa(int idPendaftar) throws Exception {
        String sqlDelete = "DELETE FROM tb_calon_mhs WHERE id_pendaftar = ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlDelete);
            preparedStatement.setInt(1, idPendaftar);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus Semua!");
        } catch (SQLException | HeadlessException err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \nKarena Data Masih Di Pakai.");
        }
    }

    public List<CMahasiswa> getCMahasiswa() throws SQLException {
        
        String sqlSelect = "SELECT tb_fakultas.*, tb_prodi.*, tb_calon_mhs.* FROM tb_calon_mhs "
                         + "JOIN tb_fakultas ON tb_fakultas.id_fakultas = tb_calon_mhs.id_fakultas"
                         + " JOIN tb_prodi ON tb_prodi.id_prodi = tb_calon_mhs.id_prodi";
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
                cm.setIdFakultas(resultSet.getInt("tb_fakultas.id_fakultas"));
                cm.setNamaFakultas(resultSet.getString("tb_fakultas.fakultas"));
                cm.setIdProdi(resultSet.getInt("tb_prodi.id_prodi"));
                cm.setNamaProdi(resultSet.getString("tb_prodi.nama_prodi"));
                cm.setEmail(resultSet.getString("email"));
                cm.setAlamat(resultSet.getString("alamat"));
                list.add(cm);
            }
            resultSet.close();
            return list;
        } catch (SQLException exception) {
            System.out.println("Terjadi Kesalahan! " + exception);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println("Salah " + exception);
                    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Tampilan Data! ");

                }
            }
        }
    }

    public List<CMahasiswa> getCMahasiswaParameter(String sqlParameter, String searchParameter) throws SQLException {

        String sqlSelect = "SELECT * FROM tb_calon_mhs JOIN tb_fakultas ON tb_fakultas.id_fakultas = tb_calon_mhs.id_fakultas"
                         + "JOIN tb_prodi ON tb_prodi.id_prodi = tb_calon_mhs.id_prodi"
                         + "WHERE " + sqlParameter + " LIKE  '%" + searchParameter + "%' AND id_pendaftar <> '1'";
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
                cm.setIdFakultas(resultSet.getInt("tb_fakultas.id_fakultas"));
                cm.setNamaFakultas(resultSet.getString("tb_fakultas.fakultas"));
                cm.setIdProdi(resultSet.getInt("tb_prodi.id_prodi"));
                cm.setNamaProdi(resultSet.getString("tb_prodi.nama_prodi"));
                cm.setEmail(resultSet.getString("email"));
                cm.setAlamat(resultSet.getString("alamat"));
                list.add(cm);
            }
            resultSet.close();
            return list;
        } catch (SQLException exception) {
            System.out.println("Salah " + exception);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Tampilan Data! ");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println("Terjadi Kesalahan! " + exception);

                }
            }
        }
    }
}
