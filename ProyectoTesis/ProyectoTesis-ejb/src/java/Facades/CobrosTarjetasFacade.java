/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.CobrosTarjetas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 
 */
@Stateless
public class CobrosTarjetasFacade extends AbstractFacade<CobrosTarjetas> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CobrosTarjetasFacade() {
        super(CobrosTarjetas.class);
    }
    
    public Boolean verificaNroTicket(Integer nro_ticket){
        Query q= getEntityManager().createNativeQuery("select * from cobros_tarjetas where nro_ticket = ?",CobrosTarjetas.class);
        q.setParameter(1, nro_ticket);
        try {
            if(q.getSingleResult()!=null){
                return true;
            } 
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
