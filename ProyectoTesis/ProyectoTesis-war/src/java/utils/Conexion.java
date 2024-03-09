/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 */

public class Conexion {
    private static Connection con;
    private static String v_usuario ="postgres";
    private static String v_pass="admin";
    
    public static Connection  retornaconexion(){
        try{
             Class.forName("org.postgresql.Driver");
             con =(Connection)DriverManager.getConnection("jdbc:postgresql://localhost:5432/alquiler", v_usuario, v_pass);
        }catch(ClassNotFoundException | SQLException ex){
             System.out.println("Error Conexion"+ex.getMessage());
        }
        return con;
    }
}

