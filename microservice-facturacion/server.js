// se importan las librerias que se instalaron
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

// creo la instancia para la aplicacion Express, luego el puerto del servidor
const app = express();
const PORT = 3000;

// Configurar middlewares
app.use(cors());
app.use(bodyParser.json());

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
    console.log('Datos recibidos', req.body); //Esto muestra el mensaje en consola con los datos recibidos

    //Acá para devolver como respuesta el mensaje y los datos recibidos
    res.json({
        mensaje: 'Solicitud recibida',
        datos: req.body // el req.body es el contenido de lo que llega, en este caso se devuelve los datos solicitados
    });

});

// iniciar el servidor 
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});