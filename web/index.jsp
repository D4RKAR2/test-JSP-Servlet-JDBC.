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
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de sesión</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
  <%@ include file="menu.jsp" %>

    <!-- Contenedor sitio principal de la web -->
    <div class="main-container">
        <div class="main-text">
            <h2>¡BIENVENIDOS!</h2>
            <p class="parrafo-mision">Nuestra Misión es proveer agua potable segura y de calidad, promoviendo el desarrollo y el bienestar de nuestra comunidad rural.</p>
            <p class="parrafo-frase">CUIDAR EL AGUA ES ASEGURAR LA VIDA</p>
        </div>
        <img src="img/imagen reemplazada.jpg" alt="Imagen de fondo" class="background-image">

        <!-- Información como captaciones, plantas de tratamiento, etc. -->
        <div class="main-info">
            <div class="info-item">
                <img src="img/capatacion.jpg" alt="captaciones">
                <h3>Captaciones</h3>
            </div>
            <div class="info-item">
                <img src="img/planta.jpg" alt="planta de tratamiento">
                <h3>Plantas de Tratamiento</h3>
            </div>
            <div class="info-item">
                <img src="img/redes.jpeg" alt="redes de distribución">
                <h3>Redes de Distribución</h3>
            </div>
            <div class="info-item">
                <img src="img/comunidad.jpeg" alt="comunidad"> 
                <h3>Trabajamos con la comunidad</h3>
            </div>
        </div>

        <!-- Contenedor de noticias -->
        <div class="news-container">
            <div class="noticia-imagen-izq">
                <img src="img/fhidr.webp" alt="noticias">
            </div>

            <div class="noticia-texto-der">
                <h3>Noticias informativas a la comunidad</h3>
                <ul>
                    <li>Cortes programados para las fechas de 1 de abril del 2025 por mantenimiento por alta turbiedad por las lluvias.</li>
                    <li>No olvide que en la empresa se ofrecen de aseo y lavado de pozos sépticos.</li>
                    <li>Acuerdate que estar en mes de mora llevará a la suspensión del servicio.</li>
                </ul>
            </div>

            <div class="noticia-texto-izq">
                <h3>¿Quieres pertenecer a nuestra comunidad?</h3>
                <ul>
                    <p>¿Sabes cuáles son los requisitos?</p>
                    <li>Debes hacer una viabilidad de tus servicios.</li>
                    <li>Pregunta que documentos se necesitan.</li>
                    <li>El trámite se desarrolla en tan solo 15 días hábiles.</li>
                    <p>No te quedes con las ganas de obtener un servicio de calidad y eficiente.</p>
                </ul>
            </div>
            
            <div class="noticia-imagen-der">
                <img src="img/manos agua.jpg" alt="noticias">
            </div>
        </div>
        
        <!-- Footer de la página web -->

  <%@ include file="footer.jsp" %>

    <!-- Contenedor o formulario de inicio de sesión -->
    <div class="login-container">
        <button class="btn-volver" onclick="showMainContainer()"> ← Volver al Inicio</button>
        <h1 class="form-title">Iniciar Sesión</h1>
        <form action="LoginServlet" method="POST">
            <div class="form-field">
                <label for="user-role"></label>
                <select id="user-role" name="tipoDocumento" required>
                    <option value="" disabled selected>Tipo de documento</option>
                    <option value="CC">Cédula de Ciudadanía</option>
                    <option value="TI">Tarjeta de Identidad</option>
                    <option value="CE">Cédula de Extranjería</option>
                </select>
            </div>

            <div class="form-group">
                <label for="username"></label>
                <input type="number" id="username" name="numeroDocumento" placeholder="Número de documento" required minlength="5" maxlength="20"
                pattern="[0-9]+" title="El número de documento debe contener solo números.">
            </div>

            <div class="form-group">
                <label for="password"></label>
                <input type="password" id="password" name="clave" placeholder="Contraseña" required minlength="6">
            </div>

            <div class="clickeable">
                <p>¿Has olvidado la contraseña?</p>
            </div>

            <button class="button" type="submit">
                <span class="icon">⮞&nbsp;</span>Iniciar sesión
            </button>
            
            <p class="register-text">Registrar usuario nuevo</p>
        </form>

        <div class="register-button">
            <a href="registro.jsp">Registrar</a>
        </div>
    </div>

    <!-- Contenedor de los servicios -->
    <section id="solicitud" style="display: none;" class="servicios">
        <button class="btn-volver" onclick="showMainContainer()"> ← Volver al Inicio</button>
        <h2 class="form-title">Solicitud de Servicios</h2>

        <button class="button-servicios" id="btn-agua-potable" type="button">
            Agua potable
        </button>

        <button class="button-servicios" id="btn-expansión-acueducto" type="button">
            Expansión de acueducto
        </button>

        <button class="button-servicios" id="btn-mantenimiento-redes" type="button">
            Mantenimiento de redes
        </button>
    </section>

    <!-- Sección formulario de solicitud de servicio -->
    <form style="display: none;" id="formulario" action="SolicitudServicioServlet" method="POST">
        <section id="agua-potable" class="form-section">
            <button class="btn-volver" onclick="showMainContainer()"> ← Volver al Inicio</button>
            <h3 class="form-title">Formulario de solicitud de Servicio</h3>
            
            <div class="información">
                <div class="form-group">
                    <label for="nombreCompleto">Nombres y apellidos completos</label>
                    <input type="text" id="nombreCompleto" name="nombreCompleto" placeholder="Digite sus nombres y apellidos" required>
                </div>

                <div class="form-group">
                    <label for="direccion">Dirección</label>
                    <input type="text" id="direccion" name="direccion" placeholder="Digite dirección de hogar" required>
                </div>

                <div class="form-group">
                    <label for="tipoVivienda">Tipo de vivienda</label>
                    <input type="text" id="tipoVivienda" name="tipoVivienda" placeholder="El tipo de vivienda" required>
                </div>
            </div>

            <!-- Sección de lista de chequeo -->
            <div class="document-list">
                <label class="list-verification">
                    Licencia de construcción <input class="check" name="licenciaConstruccion" type="checkbox">
                </label>
            </div>

            <div class="document-list">
                <label class="list-verification">
                    Impuesto predial <input class="check" name="impuestoPredial" type="checkbox">
                </label>
            </div>

            <div class="document-list">
                <label class="list-verification">
                    Certificado de tradición <input class="check" name="certificadoTradicion" type="checkbox">
                </label>
            </div>

            <button class="button button2" type="submit">
                Enviar formulario
            </button>
        </section>
    </form>

    <script src="JavaScript.js"></script>
</body>
</html>
