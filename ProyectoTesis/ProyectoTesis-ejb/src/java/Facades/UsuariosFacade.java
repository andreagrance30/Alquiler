/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea Salinas
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios obtenerUsuario(String usuario, String pass){
        Query q = getEntityManager().createNativeQuery("SELECT *\n" +
                                                      "  FROM usuarios\n" +
                                                      "WHERE id_usuario = ?\n" +
                                                      "AND  pass =?", Usuarios.class);
       q.setParameter(1,usuario);
       q.setParameter(2,pass);
       Usuarios result=null;
        if(!q.getResultList().isEmpty()){
            result=(Usuarios) q.getSingleResult();            
}
        return result;
    }
    
}
