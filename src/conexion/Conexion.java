package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ezequiel
 */
public class Conexion {
    
    private static final String URL ="jdbc:mysql://localhost:3306/biblioteca_escolar";
 
    private static final String USUARIO = "root";
    private static final String CLAVE = "";
    public static Connection conectar() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    CLAVE
            );

            System.out.println("Conexion exitosa");

        } catch (SQLException e) {

            System.out.println(
                    "Error de conexion: " + e.getMessage()
            );
        }

        return conexion;
    }
}
