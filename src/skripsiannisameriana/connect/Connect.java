/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsiannisameriana.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Annisa
 */
public class Connect {
    
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_spk_uniska";
        String user = "root";
        String password = "";

        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                //System.out.println("Koneksi Tersambung");                
            } catch (ClassNotFoundException | SQLException error) {
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Sambungan !"+error);
                System.exit(0);
            }
        }
        return connection;
    }
    
}
