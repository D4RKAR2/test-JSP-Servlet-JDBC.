/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.SolicitudServicioDAO;
import model.SolicitudServicio;
import java.util.Date;

/**
 *
 * @author Sebitas webitas
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Test Hibernate Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            try {
                // Usar Hibernate directamente (sin Spring)
                SolicitudServicioDAO dao = new SolicitudServicioDAO();
                
                // Crear una solicitud de prueba
                SolicitudServicio solicitud = new SolicitudServicio();
                solicitud.setNombreCompleto("Prueba Hibernate - " + new Date());
                solicitud.setDireccion("Dirección de prueba con Hibernate");
                solicitud.setTipoVivienda("Casa");
                solicitud.setFechaSolicitud(new Date());
                
                // Guardar usando Hibernate
                dao.guardarSolicitud(solicitud);
                
                // Mostrar resultado exitoso
                out.println("<h1>¡Hibernate está funcionando!</h1>");
                out.println("<p>Solicitud guardada exitosamente usando Hibernate</p>");
                out.println("<p>ID: " + solicitud.getId() + "</p>");
                out.println("<p>Nombre: " + solicitud.getNombreCompleto() + "</p>");
                out.println("<p>Dirección: " + solicitud.getDireccion() + "</p>");
                out.println("<p>Fecha: " + solicitud.getFechaSolicitud() + "</p>");
                out.println("<p>✅ Hibernate funciona correctamente</p>");
                
            } catch (Exception e) {
                out.println("<h1>Error en Hibernate</h1>");
                out.println("<p><strong>Error:</strong> " + e.getMessage() + "</p>");
                out.println("<p><strong>Tipo de error:</strong> " + e.getClass().getSimpleName() + "</p>");
                out.println("<h2>Stack trace:</h2>");
                out.println("<pre>");
                e.printStackTrace(out);
                out.println("</pre>");
            }
            
            out.println("</body>");
            out.println("</html>");
            
        } catch (Exception e) {
            // Error al obtener el PrintWriter
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
