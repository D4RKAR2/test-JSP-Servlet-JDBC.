/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaproyectomysql;

import java.sql.*;

/**
 *
 * @author Sebitas webitas
 */
public class dbConnection {
    static String url="jdbc:mysql://127.0.0.1:3306/plataforma_acueducto";
    static String user="root";
    static String pass="elpepe123";
            
    public static Connection conectar()
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de MySQL");
            e.printStackTrace();
        }
        try
        {
        con=DriverManager.getConnection(url,user,pass);
           System.out.println("Conexion exitosa");
        }catch(SQLException e)
        {
         e.printStackTrace();
        }
        
        return con;
    }
            
}
