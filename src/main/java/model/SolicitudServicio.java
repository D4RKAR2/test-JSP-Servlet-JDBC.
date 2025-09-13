/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author Sebitas webitas
 */
@Entity
@Table(name = "solicitud_servicio") /* Con esta línea, le indicamos a Hibernate que esta clase tiene que mapear una tabla específica con el nombre */
public class SolicitudServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* Este campo ayuda a que Hibernate entienda que el id 
                                                        no se lo daremos sino que se lo dará la base de datos */
    private Long id;
    /* Cada @Column sirve para definir cómo debe comportarse cada columna, por ejemplo, nombre, si puede ser nula, longitud, tipo, etc. */

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "tipo_vivienda", nullable = false)
    private String tipoVivienda;

    @Column(name = "licencia_construccion")
    private Boolean licenciaConstruccion;

    @Column(name = "impuesto_predial")
    private Boolean impuestoPredial;

    @Column(name = "certificado_tradicion")
    private Boolean certificadoTradicion;

    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public Boolean getLicenciaConstruccion() {
        return licenciaConstruccion;
    }

    public void setLicenciaConstruccion(Boolean licenciaConstruccion) {
        this.licenciaConstruccion = licenciaConstruccion;
    }

    public Boolean getImpuestoPredial() {
        return impuestoPredial;
    }

    public void setImpuestoPredial(Boolean impuestoPredial) {
        this.impuestoPredial = impuestoPredial;
    }

    public Boolean getCertificadoTradicion() {
        return certificadoTradicion;
    }

    public void setCertificadoTradicion(Boolean certificadoTradicion) {
        this.certificadoTradicion = certificadoTradicion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}