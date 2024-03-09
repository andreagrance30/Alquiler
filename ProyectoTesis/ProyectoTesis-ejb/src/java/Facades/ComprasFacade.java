/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Compras;
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
public class ComprasFacade extends AbstractFacade<Compras> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

 @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComprasFacade() {
        super(Compras.class);
    }
    public List<Compras> obtenerComprasPorEstado(String estado) {
        Query q = getEntityManager().createNativeQuery("select * from  compras  where estado=?1", Compras.class);
        q.setParameter(1, estado);
        List<Compras> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<Compras>) q.getResultList();
        }
        return result;
    }    
    public Compras obtenerCompras(Compras id_compra) {
        Query q = getEntityManager().createNativeQuery("select * from compras where id_compra=?1", Compras.class);
        q.setParameter(1, id_compra.getIdCompra());
        Compras result = null;
        if (!q.getResultList().isEmpty()) {
            result = (Compras) q.getSingleResult();
        }
        return result;
    }
    
    public Boolean validaNroComrpobanteProveedor(Compras compra) {
        Query q = getEntityManager().createNativeQuery("select * from compras where id_proveedor =?1 and nro_comprobante =?2");
        q.setParameter(1, compra.getIdProveedor().getIdProveedor());       
        q.setParameter(2, compra.getNroComprobante());
        if (!q.getResultList().isEmpty()) {
            return true;
        }
        return false;
    }          
    
}
