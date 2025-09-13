package servlets;

/**
 * Clase simple para probar Spring
 */
public class MensajeService {
    
    private String mensaje;
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public String obtenerMensaje() {
        return "Mensaje desde Spring: " + mensaje;
    }
} 