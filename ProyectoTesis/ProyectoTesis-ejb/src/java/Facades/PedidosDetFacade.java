/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.PedidosDet;
import Entidades.Stock;
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
public class PedidosDetFacade extends AbstractFacade<PedidosDet> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidosDetFacade() {
        super(PedidosDet.class);
    }
    public List<PedidosDet> obtenerPedidosDet(Integer id_pedido) {
        System.out.println("el pedido es" + id_pedido);
        Query q = getEntityManager().createNativeQuery("select * from pedidos_det  where id_pedido =?", PedidosDet.class);
        q.setParameter(1, id_pedido);
        List<PedidosDet> result = null;
        System.out.println("el tamaño es" + q.getResultList().size());
        if (!q.getResultList().isEmpty()) {
            result = (List<PedidosDet>) q.getResultList();
        }
        return result;
    }

    public PedidosDet obtenerPedidoDet(Integer id_pedido, Stock id_stock) {
        Query q = getEntityManager().createNativeQuery("select * from pedidos_det  where id_pedido =?1 and id_deposito=?2 and id_producto=?3", PedidosDet.class);
        q.setParameter(1, id_pedido);
        q.setParameter(2, id_stock.getDepositos().getIdDeposito());
        q.setParameter(3, id_stock.getProductos().getIdProducto());
        
        if (!q.getResultList().isEmpty()) {
            return (PedidosDet) q.getSingleResult();
        }
        return null;
    }    
}
