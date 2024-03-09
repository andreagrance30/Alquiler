/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.OrdenesCompras;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 
 */
@Stateless
public class OrdenesComprasFacade extends AbstractFacade<OrdenesCompras> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenesComprasFacade() {
        super(OrdenesCompras.class);
    }
    public List<OrdenesCompras> obtenerOrdenesComprasPorEstado(String estado) {
        Query q = getEntityManager().createNativeQuery("select * from ordenes_compras  where estado=?1", OrdenesCompras.class);
        q.setParameter(1, estado);
        List<OrdenesCompras> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<OrdenesCompras>) q.getResultList();
        }
        return result;
    }
    
    public OrdenesCompras obtenerOrdenesCompras(OrdenesCompras id_orden_compra) {
        Query q = getEntityManager().createNativeQuery("select * from ordenes_compras where id_orden_compra = ?1", OrdenesCompras.class);
        q.setParameter(1, id_orden_compra.getIdOrdenCompra());
        OrdenesCompras result = null;
        if (!q.getResultList().isEmpty()) {
            result = (OrdenesCompras) q.getSingleResult();
        }
        return result;
    }    
    public OrdenesCompras obtenerOrdenCompraPedido(OrdenesCompras id_orden_compra) {
        Query q = getEntityManager().createNativeQuery("select * from ordenes_compras where id_pedido = ?1 and estado = 'C'", OrdenesCompras.class);
        q.setParameter(1, id_orden_compra.getIdPedido().getIdPedido());
        OrdenesCompras result = null;
        if (!q.getResultList().isEmpty()) {
            result = (OrdenesCompras) q.getSingleResult();
        }
        return result;
    }      
    
}
