/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;


import Entidades.SolicitudesPedidos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea Salinas
 */
@Stateless
public class SolicitudesPedidosFacade extends AbstractFacade<SolicitudesPedidos> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudesPedidosFacade() {
        super(SolicitudesPedidos.class);
    }
    
     public List<SolicitudesPedidos> obtenerSolicitudesPorEstado(String estado) {
        Query q = getEntityManager().createNativeQuery("select * from solicitudes_pedidos  where estado=?", SolicitudesPedidos.class);
        q.setParameter(1, estado);
        List<SolicitudesPedidos> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<SolicitudesPedidos>) q.getResultList();
        }
        return result;
    }  
    
}
