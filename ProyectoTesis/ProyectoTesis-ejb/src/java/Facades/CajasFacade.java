/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Cajas;
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
public class CajasFacade extends AbstractFacade<Cajas> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CajasFacade() {
        super(Cajas.class);
    }
    public List<Cajas> obtenerCajasSucursal(Integer id_sucursal){
       Query q = getEntityManager().createNativeQuery("select * from cajas where id_sucursal = ?", Cajas.class);
       q.setParameter(1,id_sucursal);
       List<Cajas> result=null;
        if(!q.getResultList().isEmpty()){
            result=(List<Cajas>) q.getResultList();            
}
        return result;
    }        
    public List<Cajas> obtenerCajasCerradas(Integer id_sucursal){
       Query q = getEntityManager().createNativeQuery("select * from cajas where estado = 'C' and id_sucursal = ?", Cajas.class);
       q.setParameter(1,id_sucursal);
       List<Cajas> result=null;
        if(!q.getResultList().isEmpty()){
            result=(List<Cajas>) q.getResultList();            
        }
        return result;
    }    
    public Cajas obtenerCaja(Integer id_caja){
       Query q = getEntityManager().createNativeQuery("select * from cajas where id_caja = ? ", Cajas.class);
       q.setParameter(1,id_caja);
       Cajas result=null;
        if(!q.getResultList().isEmpty()){
            result=(Cajas) q.getSingleResult();            
        }
        return result;
    }      
}
