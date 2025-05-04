package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
        public static Connection getConnection() {
            Connection c = null;
            try {
            	 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            	 
            	 String url = "jbdc:mySQL://localhost:3306:HotelManagement";
            	 String username = "root";
            	 String password = "Vu24112004";
            	 
            	 c = DriverManager.getConnection(url, username, password);
            }catch(SQLException e)
            {
            	e.printStackTrace();
            }
            
            return c;
        }
    
}

