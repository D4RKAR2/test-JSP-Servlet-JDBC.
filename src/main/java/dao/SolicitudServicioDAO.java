/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.SolicitudServicio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SolicitudServicioDAO {

    public void guardarSolicitud(SolicitudServicio solicitud) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Hibernate 6 recomienda usar persist() en lugar de save()
            session.persist(solicitud);

            transaction.commit();
            System.out.println("✅ Solicitud guardada exitosamente con Hibernate 6!");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("❌ Error al guardar solicitud: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

