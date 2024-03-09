/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Presupuestos;
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
public class PresupuestosFacade extends AbstractFacade<Presupuestos> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestosFacade() {
        super(Presupuestos.class);
    }
    public List<Presupuestos> obtenerPresupuestosPorEstado(String estado) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos  where estado=?", Presupuestos.class);
        q.setParameter(1, estado);
        List<Presupuestos> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<Presupuestos>) q.getResultList();
        }
        return result;
    }        
    public Boolean validaNroPresupuestoProveedor(Presupuestos presupuesto) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos  where id_proveedor=?1 and nro_presupuesto=?2");
        q.setParameter(1, presupuesto.getIdProveedor().getIdProveedor());       
        q.setParameter(2, presupuesto.getNroPresupuesto());
        if (!q.getResultList().isEmpty()) {
            return true;
        }
        return false;
    }            

    public Boolean validaPresupuestoProveedor(Presupuestos presupuesto) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos  where id_proveedor=?1 and id_pedido=?2 and estado in('C','A')");
        q.setParameter(1, presupuesto.getIdProveedor().getIdProveedor());    
        q.setParameter(2, presupuesto.getIdPedido().getIdPedido());
        if (!q.getResultList().isEmpty()) {
            return true;
        }
        return false;
    }
    
    public Presupuestos obtenerPresupuestos(Presupuestos id_presupuesto) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos where id_presupuesto =?1", Presupuestos.class);
        q.setParameter(1, id_presupuesto.getIdPresupuesto());
        Presupuestos result = null;
        if (!q.getResultList().isEmpty()) {
            result = (Presupuestos) q.getSingleResult();
        }
        return result;
    }
}
