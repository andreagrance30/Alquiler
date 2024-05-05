/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Cobros;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author
 */
@Stateless
public class CobrosFacade extends AbstractFacade<Cobros> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CobrosFacade() {
        super(Cobros.class);
    }
    
    public Integer obtenerNroRecibo(){
        Query q= getEntityManager().createNativeQuery("select max(nro_recibo) from cobros");
        Integer lista=null;
        if(q.getSingleResult()!=null){
            lista= ((Integer) q.getSingleResult())+1;
        }else{
            lista=1;
        }
        return lista;
    }
}
