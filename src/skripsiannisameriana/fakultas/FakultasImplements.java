/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.fakultas;

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
public class FakultasImplements {
    public void insertFakultas(Fakultas fakultas) throws Exception {
        String sqlInsert = "INSERT INTO tb_fakultas VALUES (?, ?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlInsert);

            preparedStatement.setInt(1, fakultas.getIdFakultas());
            preparedStatement.setString(2, fakultas.getNamaFakultas());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("Salah " + err);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Masukkan Data ! ");
        }
    }
    
    public void updateFakultas(Fakultas fakultas) throws Exception {
        String sqlUpdate = "UPDATE tb_fakultas SET fakultas = ? WHERE id_fakultas = ?";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = Connect.getConnection().prepareStatement(sqlUpdate);

            preparedStatement.setInt(2, fakultas.getIdFakultas());
            preparedStatement.setString(1, fakultas.getNamaFakultas());
            preparedStatement.executeUpdate();

        } catch (Exception err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \nKarena Data Masih Di Pakai.");
        }
    }
    
    public void deleteFakultas(int idFakultas) throws Exception {
        String sqlDelete = "DELETE FROM tb_fakultas WHERE id_fakultas = ? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connect.getConnection().prepareStatement(sqlDelete);

            preparedStatement.setInt(1, idFakultas);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus Semua !");
        } catch (SQLException | HeadlessException err) {
            System.out.println("salah : " + err);
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Di Hapus, \nKarena Data Masih Di Pakai.");
        }
    }
    
    public List<Fakultas> getFakultas() throws SQLException {
        String sqlSelect = "SELECT * FROM tb_fakultas WHERE id_fakultas <> '1'";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            List<Fakultas> list = new ArrayList<>();

            while (resultSet.next()) {
                Fakultas fakultas = new Fakultas();
                fakultas.setIdFakultas(resultSet.getInt("id_fakultas"));
                fakultas.setNamaFakultas(resultSet.getString("fakultas"));
                list.add(fakultas);
            }
            resultSet.close();
            return list;
        } catch (SQLException exception) {
            System.out.println("Terjadi Kesalahan ! " + exception);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println("Salah " + exception);
                    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Tampilan Data ! ");

                }
            }
        }
    }
    
    public List<Fakultas> getFakultasParameter(String sqlParameter, String searchParameter) throws SQLException {
        String sqlSelect = "SELECT * FROM tb_fakultas WHERE " + sqlParameter + " LIKE  '%" + searchParameter + "%' AND id_fakultas <> '1'";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            List<Fakultas> list = new ArrayList<>();

            while (resultSet.next()) {
                Fakultas fakultas = new Fakultas();
                fakultas.setIdFakultas(resultSet.getInt("id_fakultas"));
                fakultas.setNamaFakultas(resultSet.getString("fakultas"));
                list.add(fakultas);
            }
            resultSet.close();
            return list;
        } catch (SQLException exception) {
            System.out.println("Salah " + exception);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Tampilan Data ! ");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println("Terjadi Kesalahan ! " + exception);

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
