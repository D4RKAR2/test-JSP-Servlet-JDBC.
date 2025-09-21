// se importan las librerias que se instalaron
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

const fs = require('fs'); // Para manejar archivos
const path = require('path'); // Para rutas de archivos

// creo la instancia para la aplicacion Express, luego el puerto del servidor
const app = express();
const PORT = 3000;

// Configurar middlewares
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true })); // Esta línea sirve para que "bodyParser.urlencoded" entienda datos->
//de formularios HTML, luego "extended: true" permite objetos anidados

// Estos comentarios es para yo poder entender mejor la funcion de abajo, donde se busca guardar una solicitud en un archivo JSON
// donde se asegure que la carpeta "data" exista, sino la crea. Luego se lea el archivo actual para no perder solicitudes
// anteriores. Se agregue una solicitud con un ID unico y fecha, luego se actualice el archivo con las solicitudes.

// Funcion para guardar solicitudes
function guardarSolicitud(solicitud) {
    const archivoSolicitudes = path.join(__dirname, 'data', 'solicitudes.json');

    // Esto crea la carpeta data
    const carpetaData = path.dirname(archivoSolicitudes);
    if (!fs.existsSync(carpetaData)) {
        fs.mkdirSync(carpetaData, {recursive: true});
    }

    // Leer solicitudes existentes o que cree un array vacio
    let solicitudes = [];
    if (fs.existsSync(archivoSolicitudes)) {
        const contenido = fs.readFileSync(archivoSolicitudes, 'utf8');
        solicitudes = JSON.parse(contenido);
    }

    // Agrega ID unico y fecha a la nueva solicitud
    const nuevaSolicitud = {
        id: 'Sol-' + Date.now(), // SOL=Solicitud
        fechaCreacion: new Date().toISOString(),
        estado: 'pendiente',
        ...solicitud
    };

    // Agregar nueva solicitud
    solicitudes.push(nuevaSolicitud);

    // Guardar archivo actualizado
    fs.writeFileSync(archivoSolicitudes, JSON.stringify(solicitudes, null, 2));

    return nuevaSolicitud;
}

// Funcion para identificar el marcado de las checkboxes en las solicitudes
function normalizarDocumentos(solicitud) {
    const documentosRequeridos = [
        'certificadoTradicion',
        'impuestoPredial',
        'planoTopografico',
        'autorizacionServidumbre'
    ];

    // Crear objeto con todos los documentos
    const documentos = {};
    documentosRequeridos.forEach(doc => {
        documentos[doc] = solicitud[doc] === 'on' ? 'Sí' : 'No';
    });

    // Crear nueva solicitud sin los checkboxes originales, para quitar el on
    const solicitudLimpia = {...solicitud};
    documentosRequeridos.forEach(doc => {
        delete solicitudLimpia[doc]; // esto quita los on que aparecian en las solicitudes
    });

    return {
        ...solicitudLimpia,
        documentos: documentos
    };
}

// ruta de prueba //req require - res response
app.get('/', (req, res) => {
    res.json({
        mensaje: "Hola, soy tu microservicio de facturacion",
        estado: "funcionando"
    });
}
);

// ruta para crear solicitudes
app.post('/api/solicitudes', (req, res) => {
    try{
    console.log('Datos recibidos', req.body); //Esto muestra el mensaje en consola con los datos recibidos

    // Normaliza documentos antes de guardar
    console.log('Antes de normalizar:', req.body);
     const solicitudNormalizada = normalizarDocumentos(req.body);
     console.log('Despues de normalizar:', solicitudNormalizada);
     const solicitudGuardada = guardarSolicitud(solicitudNormalizada);

    console.log('Solicitud guardada con la ID', solicitudGuardada)
    // Responde con la solicitud guardada donde incluye la ID y fecha
    res.json({
        mensaje: 'Solicitud guardada exitosamente',
        solicitud: solicitudGuardada
    });
    } catch (error) {
        console.error('Hubo un error intentando guardar la solicitud', error);
        res.status(500).json({
            mensaje: 'Error interno del servidor',
            error: error.message
        });
    }

});

// iniciar el servidor 
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});