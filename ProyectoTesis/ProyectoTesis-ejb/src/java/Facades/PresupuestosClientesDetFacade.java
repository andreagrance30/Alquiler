/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.PresupuestosClientesDet;
import Entidades.PresupuestosClientesDetPK;
import Entidades.SolicitudesPedidos;
import Entidades.Stock;
import java.math.BigInteger;
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
public class PresupuestosClientesDetFacade extends AbstractFacade<PresupuestosClientesDet> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestosClientesDetFacade() {
        super(PresupuestosClientesDet.class);
    }
    
      public List<PresupuestosClientesDet> obtenerPresupuestosClientesDet(Integer id_presupuesto_cliente) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos_clientes_det where id_presupuesto_cliente =?", PresupuestosClientesDet.class);
        q.setParameter(1, id_presupuesto_cliente);
        List<PresupuestosClientesDet> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<PresupuestosClientesDet>) q.getResultList();
        }
        return result;
    }
      
      
       public BigInteger totalCantidadProductoAprobado(SolicitudesPedidos id_solicitud_pedido, Stock id_stock) {
        Query q = getEntityManager().createNativeQuery("select COALESCE(sum(pd.cantidad),0) from presupuestos_clientes p, presupuestos_clientes_det pd \n"
                + "where p.estado ='A'\n"
                + "and pd.id_presupuesto_cliente = p.id_presupuesto_cliente\n"
                + "and pd.id_producto = ?1\n"
                + "and pd.id_deposito =  ?2\n"
                + "and p.id_solicitud_pedido = ?3");
        q.setParameter(1, id_stock.getProductos().getIdProducto());
        q.setParameter(2, id_stock.getDepositos().getIdDeposito());
        
        q.setParameter(3, id_solicitud_pedido.getIdSolicitudPedido());
        if (!q.getResultList().isEmpty()) {
            return ((BigInteger) q.getSingleResult())/*.toBigInteger()*/;
        }
        return BigInteger.ZERO;
    }
        
     public List<PresupuestosClientesDet> obtenerPresupuestosClientesDetPedido(Integer id_pedido) {
        Query q = getEntityManager().createNativeQuery("select pr.* from presupuestos_clientes p,presupuestos_clientes_det pr\n"
                + "where pr.id_presupuesto_cliente = p.id_presupuesto_cliente\n"
                + "and p.estado ='A'\n"
                + "and p.id_solicitud_pedido=?", PresupuestosClientesDet.class);
        q.setParameter(1, id_pedido);
        List<PresupuestosClientesDet> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<PresupuestosClientesDet>) q.getResultList();
        }
        return result;
    }  
     
      public PresupuestosClientesDet obtenerPresupuestoClientesDet(PresupuestosClientesDet id_presupuesto_cliente_det) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos_clientes_det  where id_presupuesto_cliente =?1 and id_deposito=?2 and id_producto=?3", PresupuestosClientesDet.class);
        q.setParameter(1, id_presupuesto_cliente_det.getPresupuestosClientes().getIdPresupuestoCliente());
        q.setParameter(2, id_presupuesto_cliente_det.getStock().getDepositos().getIdDeposito());
        q.setParameter(3, id_presupuesto_cliente_det.getStock().getProductos().getIdProducto());
        
        if (!q.getResultList().isEmpty()) {
            return (PresupuestosClientesDet) q.getSingleResult();
        }
        return null;
    }
    
}
