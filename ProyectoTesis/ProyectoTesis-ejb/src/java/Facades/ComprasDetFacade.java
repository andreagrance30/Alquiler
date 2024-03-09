/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.ComprasDet;
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
public class ComprasDetFacade extends AbstractFacade<ComprasDet> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComprasDetFacade() {
        super(ComprasDet.class);
    }
    public List<ComprasDet> obtenerComprasDet(Integer id_compra){
       Query q = getEntityManager().createNativeQuery("select * from compras_det  where id_compra=?1", ComprasDet.class);
       q.setParameter(1,id_compra);
       List<ComprasDet> result=null;
        if(!q.getResultList().isEmpty()){
            result=(List<ComprasDet>) q.getResultList();            
}
        return result;
    }            
}
