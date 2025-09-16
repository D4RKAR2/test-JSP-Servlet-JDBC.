<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
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

</body>
</html>