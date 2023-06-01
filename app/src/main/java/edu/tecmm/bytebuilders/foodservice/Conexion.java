package edu.tecmm.bytebuilders.foodservice;
import java.sql.*;

public class Conexion {
    private Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9621802", "sql9621802", "yhM3ulC4DX");
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de acceso al driver de mysql");
        } catch (SQLException ex) {
            System.out.println("Error de conexion con la base de datos");
        }
    }

    public Connection getConexion() {
        return con;
    }

}
