/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Pedidos;
import Entidades.PresupuestosDet;
import Entidades.PresupuestosDetPK;
import Entidades.Stock;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class PresupuestosDetFacade extends AbstractFacade<PresupuestosDet> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestosDetFacade() {
        super(PresupuestosDet.class);
    }
    public List<PresupuestosDet> obtenerPresupuestosDet(Integer id_presupuesto) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos_det where id_presupuesto =?", PresupuestosDet.class);
        q.setParameter(1, id_presupuesto);
        List<PresupuestosDet> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<PresupuestosDet>) q.getResultList();
        }
        return result;
    }    
    public BigInteger totalCantidadProductoAprobado(Pedidos id_pedido, Stock id_stock){
        Query q= getEntityManager().createNativeQuery("select COALESCE(sum(pd.cantidad),0) from presupuestos p, presupuestos_det pd \n" +
                                                      "where p.estado ='A'\n" +
                                                      "and pd.id_presupuesto = p.id_presupuesto\n" +
                                                      "and pd.id_producto = ?1\n" +
                                                      "and pd.id_deposito =  ?2\n" +
                                                      "and p.id_pedido = ?3");
        q.setParameter(1, id_stock.getProductos().getIdProducto());
        q.setParameter(2, id_stock.getDepositos().getIdDeposito());
        q.setParameter(3, id_pedido.getIdPedido());
        if(!q.getResultList().isEmpty()){
            return ((BigDecimal) q.getSingleResult()).toBigInteger();
        }
        return BigInteger.ZERO;
    }    
    public List<PresupuestosDet> obtenerPresupuestosDetPedido(Integer id_pedido) {
        Query q = getEntityManager().createNativeQuery("select pr.* from presupuestos p,presupuestos_det pr\n" +
                                                       "where pr.id_presupuesto = p.id_presupuesto\n" +
                                                       "and p.estado ='A'\n" +
                                                       "and p.id_pedido=?", PresupuestosDet.class);
        q.setParameter(1, id_pedido);
        List<PresupuestosDet> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<PresupuestosDet>) q.getResultList();
        }
        return result;
    }    
    public PresupuestosDet obtenerPresupuestoDet(PresupuestosDet id_presupuesto_det) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos_det  where id_presupuesto =?1 and id_deposito=?2 and id_producto=?3", PresupuestosDet.class);
        q.setParameter(1, id_presupuesto_det.getPresupuestos().getIdPresupuesto());
        q.setParameter(2, id_presupuesto_det.getStock().getDepositos().getIdDeposito());
        q.setParameter(3, id_presupuesto_det.getStock().getProductos().getIdProducto());
        
        if (!q.getResultList().isEmpty()) {
            return (PresupuestosDet) q.getSingleResult();
        }
        return null;
    }     
    
}
