/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Terminales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea Salinas
 */
@Stateless
public class TerminalesFacade extends AbstractFacade<Terminales> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerminalesFacade() {
        super(Terminales.class);
    }
    
    public Terminales obtenerTerminal(String i){
        Query q = getEntityManager().createNativeQuery("SELECT id_terminal, descripcion\n" +
                                                      "  FROM terminales\n" +
                                                      "WHERE descripcion = ? ", Terminales.class);
       q.setParameter(1,i);
       Terminales result=null;
        if(!q.getResultList().isEmpty()){
            result=(Terminales) q.getSingleResult();            
}
        return result;
    }
    
}
