
package db;
import java.sql.*;
import javax.swing.JOptionPane;

public class conectar {  
   public static Connection getConexion(){
       Connection cn = null;
       try {
           //cargar nuestro driver
           Class.forName("com.mysql.jdbc.Driver");
           cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example?autoReconnect=true&useSSL=false","root","80535485xd");
           System.out.println("Conexion establecida");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("Error de conexion "+e);
           JOptionPane.showMessageDialog(null, "Error de conexion "+e);
       }
       return cn;
   }
   
   public static Connection getConexionMySQL57(){
       Connection cn = null;
       try {
           //cargar nuestro driver
           Class.forName("com.mysql.jdbc.Driver");
           cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example?autoReconnect=true&useSSL=false","root","80535485xd");
           System.out.println("conexion establecida");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("Error de conexion "+e);
           JOptionPane.showMessageDialog(null, "Error de conexion "+e);
       }
       return cn;
   }
}
