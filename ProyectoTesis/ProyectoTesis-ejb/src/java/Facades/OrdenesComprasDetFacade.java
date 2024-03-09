/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.OrdenesCompras;
import Entidades.OrdenesComprasDet;
import Entidades.Proveedores;
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
public class OrdenesComprasDetFacade extends AbstractFacade<OrdenesComprasDet> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenesComprasDetFacade() {
        super(OrdenesComprasDet.class);
    }

    
    public List<OrdenesComprasDet> obtenerOrdenesComprasDet(Integer id_orden_compra) {
        Query q = getEntityManager().createNativeQuery("select * from ordenes_compras_det where id_orden_compra =?", OrdenesComprasDet.class);
        q.setParameter(1, id_orden_compra);
        List<OrdenesComprasDet> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<OrdenesComprasDet>) q.getResultList();
        }
        return result;
    }    

    public List<OrdenesComprasDet> obtenerOrdenesComprasDetProveedorOrdenCompra(Proveedores id_proveedor, OrdenesCompras id_orden_compra) {
        Query q = getEntityManager().createNativeQuery("select od.* from ordenes_compras o,ordenes_compras_det od, presupuestos p\n" +
                                                       "where o.id_orden_compra = od.id_orden_compra\n" +
                                                       "and p.id_presupuesto = od.id_presupuesto\n" +
                                                       "and o.estado ='A'\n" +
                                                       "and p.id_proveedor =?1\n" +
                                                       "and o.id_orden_compra =?2", OrdenesComprasDet.class);
        q.setParameter(1, id_proveedor.getIdProveedor());
        q.setParameter(2, id_orden_compra.getIdOrdenCompra());
        List<OrdenesComprasDet> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<OrdenesComprasDet>) q.getResultList();
        }
        return result;
    }    
 
}
