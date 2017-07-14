/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.soal;

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
public class SoalImplements {
    public void insertSoal(Soal soal) throws Exception {
        String sqlInsert = "INSERT INTO tb_calon_mhs VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlInsert);

            preparedStatement.setInt(1, soal.getIdSoal());
            preparedStatement.setString(2, soal.getSoal());
            preparedStatement.setInt(3, soal.getNilai());
            preparedStatement.setInt(4, soal.getIdFakultas());
            preparedStatement.setInt(5, soal.getIdProdi());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("Salah " + err);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Masukkan Data! ");
        }
    }

    public void updateSoal(Soal soal) throws Exception {
        String sqlUpdate = "UPDATE tb_soal SET soal = ?, nilai = ?,"
                         + "id_fakultas = ?, id_prodi = ? WHERE id_soal = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlUpdate);

            preparedStatement.setInt(5, soal.getIdSoal());
            preparedStatement.setString(1, soal.getSoal());
            preparedStatement.setInt(2, soal.getNilai());
            preparedStatement.setInt(3, soal.getIdFakultas());
            preparedStatement.setInt(4, soal.getIdProdi());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \nKarena Data Masih Di Pakai.");
        }
    }

    public void deleteSoal(int idSoal) throws Exception {
        String sqlDelete = "DELETE FROM tb_soal WHERE id_soal = ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlDelete);
            preparedStatement.setInt(1, idSoal);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus Semua!");
        } catch (SQLException | HeadlessException err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \nKarena Data Masih Di Pakai.");
        }
    }

    public List<Soal> getSoal() throws SQLException {
        
        String sqlSelect = "SELECT tb_fakultas.*, tb_prodi.*, tb_soal.* FROM tb_soal "
                         + "JOIN tb_fakultas ON tb_fakultas.id_fakultas = tb_soal.id_fakultas"
                         + " JOIN tb_prodi ON tb_prodi.id_prodi = tb_soal.id_prodi";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            List<Soal> list = new ArrayList<>();

            while (resultSet.next()) {
                Soal soal = new Soal();
                soal.setIdSoal(resultSet.getInt("id_soal"));
                soal.setSoal(resultSet.getString("soal"));
                soal.setNilai(resultSet.getInt("nilai"));
                soal.setNamaFakultas(resultSet.getString("tb_fakultas.fakultas"));
                soal.setNamaProdi(resultSet.getString("nama_prodi"));
                list.add(soal);
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

    public List<Soal> getSoalParameter(String sqlParameter, String searchParameter) throws SQLException {

        String sqlSelect = "SELECT * FROM tb_soal JOIN tb_fakultas ON tb_fakultas.id_fakultas = tb_soal.id_fakultas"
                         + "JOIN tb_prodi ON tb_prodi.id_prodi = tb_soal.id_prodi"
                         + "WHERE " + sqlParameter + " LIKE  '%" + searchParameter + "%' AND id_soal <> '1'";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            List<Soal> list = new ArrayList<>();

            while (resultSet.next()) {
                Soal soal = new Soal();
                soal.setIdSoal(resultSet.getInt("id_soal"));
                soal.setSoal(resultSet.getString("soal"));
                soal.setNilai(resultSet.getInt("nilai"));
                soal.setNamaFakultas(resultSet.getString("tb_fakultas.fakultas"));
                soal.setNamaProdi(resultSet.getString("nama_prodi"));
                list.add(soal);
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
