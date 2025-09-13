package servlets;

import dao.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipoDocumento = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumento");
        String clave = request.getParameter("clave");
        
        UsuarioDAO dao = new UsuarioDAO();
        boolean accesoValido = dao.validarUsuario(tipoDocumento, numeroDocumento, clave);
        
        if (accesoValido) {
        response.sendRedirect("login_exitoso.jsp");
        }
        else {
        response.sendRedirect("index.jsp?error=1");
        }
    }
}
