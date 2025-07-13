/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaproyectomysql;

/**
 *
 * @author Sebitas webitas
 */
public class PruebaProyectoMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        dbConnection dbc=new dbConnection();
        dbc.conectar();
        
        crud operaciones=new crud();
        //operaciones.insertarDato(6,"Ernesto Cruz", 32875958, "Calle 98", "ernesto.cruz@gmail.com");
        
        //operaciones.leerDatos();
        
        //operaciones.actualizarDato(1, "Juan Romero", "1230987", "calle 125", "juan.romero@gmail.com");
        
        //operaciones.eliminarDato(7);
        
    }
    
}
