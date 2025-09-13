package servlets;

import dao.SolicitudServicioDAO;
import java.io.IOException;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SolicitudServicio;

/**
 *
 * @author Sebitas webitas
 */
@WebServlet("/SolicitudServicioServlet")
public class SolicitudServicioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (java.io.PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SolicitudServicioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Este servlet solo acepta peticiones POST</h1>");
            out.println("<p>Use el formulario para enviar datos.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreCompleto = request.getParameter("nombreCompleto");
        String direccion = request.getParameter("direccion");
        String tipoVivienda = request.getParameter("tipoVivienda");
        
        //Este para la vaina de los ckeckboxes del formulario si no estan marcados
        String licenciaConstruccionStr = request.getParameter("licenciaConstruccion");
        String impuestoPredialStr = request.getParameter("impuestoPredial");
        String certificadoTradicionStr = request.getParameter("certificadoTradicion");
        
        // Convertimos a boolean, por lo que true si esta marcado o false si no
        Boolean licenciaConstruccion = licenciaConstruccionStr != null;
        Boolean impuestoPredial = impuestoPredialStr != null;
        Boolean certificadoTradicion = certificadoTradicionStr != null;
        
    SolicitudServicio solicitud = new SolicitudServicio();
    
    //aca asigno valores que obtenga del formulario
    solicitud.setNombreCompleto(nombreCompleto);
    solicitud.setDireccion(direccion);
    solicitud.setTipoVivienda(tipoVivienda);
    solicitud.setLicenciaConstruccion(licenciaConstruccion);
    solicitud.setImpuestoPredial(impuestoPredial);
    solicitud.setCertificadoTradicion(certificadoTradicion);
    solicitud.setFechaSolicitud(new Date());
    
    SolicitudServicioDAO solicitudDAO = new SolicitudServicioDAO();
    boolean guardadoExitoso = false;
    
    try {
        solicitudDAO.guardarSolicitud(solicitud);
        guardadoExitoso = true;
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    // Esto tiene que mostrar al usuario
    response.setContentType("text/html;charset=UTF-8");
    try (java.io.PrintWriter out = response.getWriter()) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Resultado de Solicitud de Servicio</title>");
    out.println("</head>");
    out.println("<body>");
    if (guardadoExitoso) {
        out.println("<h1>¡Solicitud de Servicio Enviada Exitosamente!</h1>");
        out.println("<p>Su solicitud ha sido registrada en nuestro sistema.</p>");
    } else {
        out.println("<h1>Error al Procesar la Solicitud</h1>");
        out.println("<p>Lo sentimos, hubo un error al procesar su solicitud. Por favor, inténtelo de nuevo.</p>");
    }
    out.println("<a href='index.jsp'>Volver al Inicio</a>");
    out.println("</body>");
    out.println("</html>");
        
    }
    
    }
    

}