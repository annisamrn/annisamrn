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
        String sqlInsert = "INSERT INTO tb_soal VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlInsert);

            preparedStatement.setInt(1, soal.getIdSoal());
            preparedStatement.setString(2, soal.getSoal());
            preparedStatement.setString(3, soal.getA());
            preparedStatement.setString(4, soal.getB());
            preparedStatement.setString(5, soal.getC());
            preparedStatement.setString(6, soal.getD());
            preparedStatement.setInt(7, soal.getNilaiA());
            preparedStatement.setInt(8, soal.getNilaiB());
            preparedStatement.setInt(9, soal.getNilaiC());
            preparedStatement.setInt(10, soal.getNilaiD());
            preparedStatement.setInt(11, soal.getIdFakultas());
            preparedStatement.setInt(12, soal.getIdProdi());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("Salah " + err);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Masukkan Data! ");
        }
    }

    public void updateSoal(Soal soal) throws Exception {
        String sqlUpdate = "UPDATE tb_soal SET soal = ?, a = ?, b = ?, c = ?, d = ?, nilai_a = ?, nilai_b = ?"
                         + "nilai_c = ?, nilai_d = ?, id_fakultas = ?, id_prodi = ? WHERE id_soal = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlUpdate);

            preparedStatement.setInt(12, soal.getIdSoal());
            preparedStatement.setString(1, soal.getSoal());
            preparedStatement.setString(2, soal.getA());
            preparedStatement.setString(3, soal.getB());
            preparedStatement.setString(4, soal.getC());
            preparedStatement.setString(5, soal.getD());            
            preparedStatement.setInt(6, soal.getNilaiA());            
            preparedStatement.setInt(7, soal.getNilaiB());            
            preparedStatement.setInt(8, soal.getNilaiC());            
            preparedStatement.setInt(9, soal.getNilaiD());
            preparedStatement.setInt(10, soal.getIdFakultas());
            preparedStatement.setInt(11, soal.getIdProdi());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \n Karena Data Masih Di Pakai.");
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
                soal.setA(resultSet.getString("a"));
                soal.setB(resultSet.getString("b"));
                soal.setC(resultSet.getString("c"));
                soal.setD(resultSet.getString("d"));
                soal.setNilaiA(resultSet.getInt("nilai_a"));
                soal.setNilaiB(resultSet.getInt("nilai_b"));
                soal.setNilaiC(resultSet.getInt("nilai_c"));
                soal.setNilaiD(resultSet.getInt("nilai_d"));
                soal.setIdFakultas(resultSet.getInt("tb_fakultas.id_fakultas"));
                soal.setNamaFakultas(resultSet.getString("tb_fakultas.fakultas"));
                soal.setIdProdi(resultSet.getInt("tb_prodi.id_prodi"));
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
                soal.setA(resultSet.getString("a"));
                soal.setB(resultSet.getString("b"));
                soal.setC(resultSet.getString("c"));
                soal.setD(resultSet.getString("d"));
                soal.setNilaiA(resultSet.getInt("nilai_a"));
                soal.setNilaiB(resultSet.getInt("nilai_b"));
                soal.setNilaiC(resultSet.getInt("nilai_c"));
                soal.setNilaiD(resultSet.getInt("nilai_d"));
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
