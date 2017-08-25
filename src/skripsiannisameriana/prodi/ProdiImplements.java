/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.prodi;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import skripsiannisameriana.connect.Connect;

/**
 *
 * @author USER
 */
public class ProdiImplements {
    public void insertProdi(Prodi prodi) throws Exception {
        String sqlInsert = "INSERT INTO tb_prodi VALUES (?, ?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlInsert);

            preparedStatement.setInt(1, prodi.getIdProdi());
            preparedStatement.setString(2, prodi.getNamaProdi());
            preparedStatement.setInt(3, prodi.getIdFakultas());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("Salah " + err);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Masukkan Data ! ");
        }
    }

    public void updateProdi(Prodi prodi) throws Exception {
        String sqlUpdate = "UPDATE tb_prodi SET nama_prodi = ?, id_fakultas = ? WHERE id_prodi = ?";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = Connect.getConnection().prepareStatement(sqlUpdate);

            preparedStatement.setString(1, prodi.getNamaFakultas());
            preparedStatement.setInt(2, prodi.getIdFakultas());
            preparedStatement.setInt(3, prodi.getIdProdi());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \nKarena Data Masih Di Pakai.");
        }
    }

    public void deleteProdi(int idProdi) throws Exception {
        String sqlDelete = "DELETE FROM tb_prodi WHERE id_prodi = ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlDelete);
            preparedStatement.setInt(1, idProdi);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus Semua!");
        } catch (SQLException | HeadlessException err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \nKarena Data Masih Di Pakai.");
        }
    }

    public List<Prodi> getProdi() throws SQLException {
        
        String sqlSelect = "SELECT tb_fakultas.*, tb_prodi.* FROM tb_prodi JOIN tb_fakultas "
                            + "ON tb_fakultas.id_fakultas = tb_prodi.id_fakultas";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            List<Prodi> list = new ArrayList<>();

            while (resultSet.next()) {
                Prodi prodi = new Prodi();
                prodi.setIdProdi(resultSet.getInt("tb_prodi.id_prodi"));
                prodi.setNamaProdi(resultSet.getString("tb_prodi.nama_prodi"));
                prodi.setIdFakultas(resultSet.getInt("tb_fakultas.id_fakultas"));
                prodi.setNamaFakultas(resultSet.getString("tb_fakultas.fakultas"));
                list.add(prodi);
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

    public List<Prodi> getProdiParameter(String sqlParameter, String searchParameter) throws SQLException {

        String sqlSelect = "SELECT * FROM tb_prodi JOIN tb_fakultas ON tb_fakultas.id_fakultas = tb_prodi.id_fakultas WHERE " + sqlParameter + " LIKE  '%" + searchParameter + "%' AND id_prodi <> '1'";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            List<Prodi> list = new ArrayList<>();

            while (resultSet.next()) {
                Prodi prodi = new Prodi();
                prodi.setIdProdi(resultSet.getInt("tb_prodi.id_prodi"));
                prodi.setNamaProdi(resultSet.getString("tb_prodi.nama_prodi"));
                prodi.setIdFakultas(resultSet.getInt("tb_fakultas.id_fakultas"));
                prodi.setNamaFakultas(resultSet.getString("tb_fakultas.fakultas"));
                list.add(prodi);
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
    
    public JasperPrint cetakProdi() {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(getClass().getResourceAsStream("src/laporan/Prodi.jasper"), null, Connect.getConnection());
            return jasperPrint;
        } catch (JRException exception) {
            System.out.println("Terjadi Kesalahan Cetak : " + exception);
            return null;
        } catch (Exception exception) {
            System.out.println("Terjadi Kesalahan Cetak 1 : " + exception);
            return null;
        }
    }
    
}
