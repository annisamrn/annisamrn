/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Annisa
 */
public class Connect {

    private static Connection connection;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/db_spk_uniska";
    private static String user = "root";
    private static String password = "";
    private Statement st = null;

    public static Connection getConnection() throws SQLException {

        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                //System.out.println("Koneksi Tersambung");                
            } catch (ClassNotFoundException | SQLException error) {
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Sambungan !" + error);
                System.exit(0);
            }
        }
        return connection;
    }

    public void executesql(String sql) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stt = conn.createStatement();
        stt.executeUpdate(sql);
        stt.close();
        conn.close();
    }

    public ResultSet select(String sql) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

}
