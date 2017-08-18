/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skripsiannisameriana.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import skripsiannisameriana.connect.Connect;

/**
 *
 * @author phantom
 */
public class LoginMhsImplements {
    
    public LoginMhs getAdmin(String namaPengguna, String password) {
        String sqlSelect = "SELECT * FROM tb_user WHERE username = '" + namaPengguna + "' AND password = '" + password + "'";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            LoginMhs hakAkses = new LoginMhs();

            if (resultSet.next()) {
                hakAkses.setUsername(resultSet.getString("username"));
                hakAkses.setPassword(resultSet.getString("password"));
            } else {
                hakAkses.setUsername("TIDAK ADA");
            }

            resultSet.close();
            return hakAkses;
        } catch (SQLException exception) {
            System.out.println("Terjadi kesalahan : " + exception);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println("Terjadi kesalahan : " + exception);
                }
            }
        }
    }
    
    public LoginMhs getMhs(String namaPengguna, String password) {
        String sqlSelect = "SELECT * FROM tb_calon_mhs WHERE email = '" + namaPengguna + "' AND password = '" + password + "'";
        Statement statement = null;
        ResultSet resultSet;
        try {
            statement = Connect.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            LoginMhs hakAkses = new LoginMhs();

            if (resultSet.next()) {
                hakAkses.setId_mhs(resultSet.getInt("id_pendaftar"));
                hakAkses.setUsername(resultSet.getString("email"));
                hakAkses.setPassword(resultSet.getString("password"));
            } else {
                hakAkses.setUsername("TIDAK ADA");
            }

            resultSet.close();
            return hakAkses;
        } catch (SQLException exception) {
            System.out.println("Terjadi kesalahan : " + exception);
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println("Terjadi kesalahan : " + exception);
                }
            }
        }
    }
}
