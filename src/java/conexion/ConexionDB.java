/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Juan
 */
public class ConexionDB {
    
    static Connection con;
    private static Connection ConectarDB() {
        
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");
        String url = "jdbc:mysql://localhost/ligasemillitas1?serverTimezone=America/Guayaquil";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, properties);
            System.out.println("Conexión Satisfactoria\n");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error de conexion" + e);
        }
        return con;
        
    }

    public Connection getConnection() {
        return ConectarDB();
    }
    
    
}
