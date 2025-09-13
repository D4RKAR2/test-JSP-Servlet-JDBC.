/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import pruebaproyectomysql.dbConnection;

/**
 *
 * @author Sebitas webitas
 */
public class UsuarioDAO {

    public boolean validarUsuario(String tipoDocumento, String numeroDocumento, String clave) {
        String sql = "SELECT * FROM usuarios WHERE tipo_documento=? AND numero_documento=? AND clave=?";
        try (Connection con = dbConnection.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tipoDocumento);
            ps.setString(2, numeroDocumento);
            ps.setString(3, clave);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true si encontró usuario
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registrarUsuario(String tipoDocumento, String numeroDocumento, String nombre_completo, String telefono, String direccion, String correo, String clave) {
    String sql = "INSERT INTO usuarios (tipo_documento, numero_documento, nombre_completo, telefono, direccion, correo, clave) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection con = dbConnection.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, tipoDocumento);
        ps.setString(2, numeroDocumento);
        ps.setString(3, nombre_completo);
        ps.setString(4, telefono);
        ps.setString(5, direccion);
        ps.setString(6, correo);
        ps.setString(7, clave);
        return ps.executeUpdate() > 0;
    } catch (SQLException e){
    e.printStackTrace();
    return false;
    }
    }
}
