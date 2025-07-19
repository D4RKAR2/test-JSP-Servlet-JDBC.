<%-- 
    Document   : registro.jsp
    Created on : Jul 10, 2025, 11:36:06 AM
    Author     : Sebitas webitas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro de Usuario</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    </head>
    <body>
        <!-- Header similar al index -->
        <header class="main-header"> 
            <div class="container">
                <h1 class="title">Empresa de acueducto rural</h1>
                <img src="img/EmpresaLogo.jpeg" alt="Logo de la empresa" class="logo" id="logo-inicio">
            </div>
        </header>

        <!-- Contenedor del formulario de registro -->
        <div class="login-container">
            <button class="btn-volver" onclick="window.location.href='index.jsp'"> ← Volver al Inicio</button>
            <h1 class="form-title">Registro de Usuario</h1>
            
            <form action="RegistroServlet" method="post">
                <div class="form-field">
                    <label for="tipoDocumento"></label>
                    <select id="tipoDocumento" name="tipoDocumento" required>
                        <option value="" disabled selected>Tipo de documento</option>
                        <option value="CC">Cédula de Ciudadanía</option>
                        <option value="TI">Tarjeta de Identidad</option>
                        <option value="CE">Cédula de Extranjería</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="numeroDocumento"></label>
                    <input type="number" id="numeroDocumento" name="numeroDocumento" placeholder="Número de documento" required minlength="5" maxlength="20" pattern="[0-9]+" title="El número de documento debe contener solo números.">
                </div>

                <div class="form-group">
                    <label for="nombre_completo"></label>
                    <input type="text" id="nombre_completo" name="nombre_completo" placeholder="Nombre y apellido" required>
                </div>

                <div class="form-group">
                    <label for="telefono"></label>
                    <input type="text" name="telefono" id="telefono" placeholder="Teléfono" required>
                </div>

                <div class="form-group">
                    <label for="direccion"></label>
                    <input type="text" name="direccion" id="direccion" placeholder="Dirección" required>
                </div>

                <div class="form-group">
                    <label for="correo"></label>
                    <input type="email" id="correo" name="correo" placeholder="Correo electrónico" required>
                </div>

                <div class="form-group">
                    <label for="clave"></label>
                    <input type="password" id="clave" name="clave" placeholder="Contraseña" required minlength="6">
                </div>

                <button class="button" type="submit">
                    <span class="icon">⮞&nbsp;</span>Registrarse
                </button>
            </form>

            <div class="register-button">
                <a href="index.jsp">¿Ya tienes cuenta? Inicia sesión</a>
            </div>
        </div>

        <!-- Footer similar al index -->
        <div class="footer">
            <div class="footer-header">
                <h3>ACUEDUCTO RURAL</h3>
                <img src="img/EmpresaLogo.jpeg" alt="Logo de la empresa" class="logo-footer">
            </div>
        
            <div class="footer-divider"></div>
        
            <div class="footer-body">
                <div class="footer-info">
                    <p>Dirección: Centro de Experiencia Avenida Las Palmas #4-66 - Fusagasugá, Cundinamarca</p>
                    <p>Horario de atención: lunes a viernes de 8AM a 12 y 2PM a 5PM</p>
                    <p>Teléfono Conmutador: 60568225</p>
                    <p>Correo institucional: acueductorural@gmail.com</p>
                </div>
                <div class="chat-bubble">
                    <span>CHAT</span>
                    <span>Asistente virtual</span>
                </div>
            </div>
        
            <div class="footer-links">
                <span class="clickeable-text">Políticas</span>
                <span class="clickeable-text">Mapa del sitio</span>
                <span class="clickeable-text">Estadísticas</span>
            </div>
        </div>
    </body>
</html>