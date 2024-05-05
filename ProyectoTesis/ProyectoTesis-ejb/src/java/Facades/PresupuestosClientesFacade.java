/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.PresupuestosClientes;
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
public class PresupuestosClientesFacade extends AbstractFacade<PresupuestosClientes> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestosClientesFacade() {
        super(PresupuestosClientes.class);
    }
    
    public List<PresupuestosClientes> obtenerPresupuestosClientesPorEstado(String estado) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos_clientes  where estado=?", PresupuestosClientes.class);
        q.setParameter(1, estado);
        List<PresupuestosClientes> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<PresupuestosClientes>) q.getResultList();
        }
        return result;
    }  
    
     public PresupuestosClientes obtenerPresupuestosClientes(PresupuestosClientes id_presupuesto_cliente) {
        Query q = getEntityManager().createNativeQuery("select * from presupuestos_clientes where id_presupuesto_cliente =?1", PresupuestosClientes.class);
        q.setParameter(1, id_presupuesto_cliente.getIdPresupuestoCliente());
        PresupuestosClientes result = null;
        if (!q.getResultList().isEmpty()) {
            result = (PresupuestosClientes) q.getSingleResult();
        }
        return result;
    }
    
}
