import javax.swing.SwingUtilities;
import java.sql.Connection;

import UI.LoginUI.LoginUI;
import DAO.MySQLConnection; 

public class Main {
    public static void main(String[] args) {
        System.out.println("Dang chay main");
        Connection conn = MySQLConnection.getConnection();
        if (conn != null) {
            System.out.println("Ket noi database thanh cong!");
            SwingUtilities.invokeLater(() -> {
                new LoginUI().setVisible(true);
            });
        } else {
            System.out.println("Ket noi database that bai!");
        }
    }
}

