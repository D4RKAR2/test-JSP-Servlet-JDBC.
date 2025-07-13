<%-- 
    Document   : index
    Created on : Jul 10, 2025, 9:00:02 AM
    Author     : Sebitas webitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="pruebaproyectomysql.dbConnection" %>
<%
    dbConnection conexion = new dbConnection();
    conexion.conectar();  // Este método debería lanzar algo en consola si tiene System.out.println()
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

                <div class = "login-container">
        <button class="btn-volver" onclick="showMainContainer()"> ← Volver al Inicio</button>
        <h1 class="form-title">Iniciar Sesión</h1>
        <form action="LoginServlet" method="POST">
            <div class = "form-field">
                <!-- Crea una etiqueta donde se usa el atributo for y se conecta con id,
                 cuando se hace click en "Usuario", el cursor se posiciona en el 
                 campo para digitar texto. Aparte, el atributo type ayuda a definir qué
                 tipo de datos aceptará el campo-->
                <label for = "user-role"></label>
                <select id = "user-role" name="tipoDocumento" required><!-- El atributo required indica que el campo es obligatorio -->
                    <option value="" disabled selected> Tipo de documento</option>
                    <option value="CC">Cédula de Ciudadanía</option>
                    <option value="TI">Tarjeta de Identidad</option>
                    <option value="CE">Cédula de Extranjería</option>
                </select>
            </div>

            <div class="form-group">
                <label for="username"> </label>
                <input type="number" id="username" name="numeroDocumento" placeholder="Número de documento" required minlength="5" maxlength="20"
                pattern="[0-9]+" title="El número de documento debe contener solo números.">
            </div>

            <div class = "form-group">
                <label for="password"> </label>
                <input type="password" id="password" name="clave" placeholder="Contraseña" required minlength="6">
            </div>

            <div class="clickeable">
                <p>¿Has olvidado la contraseña?</p>
            </div>

             <button class="button" type="submit">
                <span class="icon">⮞&nbsp;</span>  Iniciar sesión
            </button>

            
                <p class="register-text">Registrar usuario nuevo</p>
        </form>

        <div class="register-button">
           
            <a href="registro.jsp">Registrar</a>
            
        </div>
        </div>
        
    </body>
</html>
