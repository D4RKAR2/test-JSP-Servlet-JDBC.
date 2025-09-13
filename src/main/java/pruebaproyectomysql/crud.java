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
public class crud {
    
    public void insertarDato(int id, String Nombre, int Teléfono, String Dirección, String Correo)
    {
     String query="insert into usuarios (id_usuario, Nombre, Teléfono, Dirección, Correo) values(?,?,?,?,?)";
     try
     {
      Connection con=dbConnection.conectar();
      PreparedStatement ps=con.prepareStatement(query);
      ps.setInt(1,id);
      ps. setString(2, Nombre);
      ps. setInt(3, Teléfono);
      ps. setString(4, Dirección);
      ps. setString(5, Correo);
      
      ps.executeUpdate();
         System.out.println("Dato insertado con éxito");
     }
     catch(SQLException ex)
     {
         System.out.println("Error al insertar dato");
         ex.printStackTrace();
     }
    }
    
    /*public void leerDatos()
    {
        String query="select * from nombres";
        try {
            Connection con=dbConnection.conectar();
      PreparedStatement ps=con.prepareStatement(query);
      
      ResultSet rs=ps.executeQuery();
      
      while(rs.next())   
      {
          int id=rs.getInt("")
      }
        }
        catch(SQLException ex)
     {
         System.out.println("Error al insertar dato");
         ex.printStackTrace();
     }
    }

*/

    public void leerDatos() {
    String query = "SELECT * FROM usuarios";

    try {
        Connection con = dbConnection.conectar();
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id_usuario");
            String nombre = rs.getString("Nombre");
            String telefono = rs.getString("Teléfono");
            String direccion = rs.getString("Dirección");
            String correo = rs.getString("Correo");

            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Dirección: " + direccion);
            System.out.println("Correo: " + correo);
            System.out.println("---------------------------");
        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException ex) {
        System.out.println("Error al leer los datos");
        ex.printStackTrace();
    }
}

    //------------------
    
    public void actualizarDato(int id, String nombre, String telefono, String direccion, String correo) {
    String query = "UPDATE usuarios SET Nombre = ?, Teléfono = ?, Dirección = ?, Correo = ? WHERE id_usuario = ?";

    try {
        Connection con = dbConnection.conectar();
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, nombre);
        ps.setString(2, telefono);
        ps.setString(3, direccion);
        ps.setString(4, correo);
        ps.setInt(5, id);  // El ID va al final porque está en el WHERE

        int filasAfectadas = ps.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Dato actualizado con éxito");
        } else {
            System.out.println("No se encontró ningún registro con ese ID");
        }

        ps.close();
        con.close();
    } catch (SQLException ex) {
        System.out.println("Error al actualizar el dato");
        ex.printStackTrace();
    }
}
    
    //----------------------------------
    
    public void eliminarDato(int id) {
    String query = "DELETE FROM usuarios WHERE id_usuario = ?";

    try {
        Connection con = dbConnection.conectar();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Dato eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún usuario con ese ID.");
        }

        ps.close();
        con.close();
    } catch (SQLException ex) {
        System.out.println("Error al eliminar el dato.");
        ex.printStackTrace();
    }
}

    
}
