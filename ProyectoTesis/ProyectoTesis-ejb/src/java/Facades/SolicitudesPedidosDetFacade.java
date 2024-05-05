/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.SolicitudesPedidosDet;
import Entidades.Stock;
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
public class SolicitudesPedidosDetFacade extends AbstractFacade<SolicitudesPedidosDet> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudesPedidosDetFacade() {
        super(SolicitudesPedidosDet.class);
    }
    
     public List<SolicitudesPedidosDet> obtenerSolicitudesPedidosDet(Integer id_solicitud_pedido) {
       // System.out.println("el pedido es" + id_pedido);
        Query q = getEntityManager().createNativeQuery("select * from solicitudes_pedidos_det  where id_solicitud_pedido =?", SolicitudesPedidosDet.class);
        q.setParameter(1, id_solicitud_pedido);
        List<SolicitudesPedidosDet> result = null;
      //  System.out.println("el tamaño es" + q.getResultList().size());
        if (!q.getResultList().isEmpty()) {
            result = (List<SolicitudesPedidosDet>) q.getResultList();
        }
        return result;
    }

    public SolicitudesPedidosDet obtenerPedidoDet(Integer id_solicitud_pedido, Stock id_stock) {
        Query q = getEntityManager().createNativeQuery("select * from solicitudes_pedidos_det  where id_pedido =?1 and id_deposito=?2 and id_producto=?3", SolicitudesPedidosDet.class);
        q.setParameter(1, id_solicitud_pedido);
        q.setParameter(2, id_stock.getDepositos().getIdDeposito());
        q.setParameter(3, id_stock.getProductos().getIdProducto());
        
        if (!q.getResultList().isEmpty()) {
            return (SolicitudesPedidosDet) q.getSingleResult();
        }
        return null;
    }   
}
