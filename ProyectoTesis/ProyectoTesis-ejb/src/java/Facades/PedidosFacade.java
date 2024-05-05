/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;
import Entidades.Pedidos;
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
public class PedidosFacade extends AbstractFacade<Pedidos> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidosFacade() {
        super(Pedidos.class);
    }
    
    public List<Pedidos> obtenerPedidosPorEstado(String estado) {
        Query q = getEntityManager().createNativeQuery("select * from pedidos  where estado=?", Pedidos.class);
        q.setParameter(1, estado);
        List<Pedidos> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<Pedidos>) q.getResultList();
        }
        return result;
    }    
    
    
    
}
