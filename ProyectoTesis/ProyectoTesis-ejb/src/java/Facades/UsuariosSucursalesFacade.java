/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.UsuariosSucursales;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea Salinas
 */
@Stateless
public class UsuariosSucursalesFacade extends AbstractFacade<UsuariosSucursales> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosSucursalesFacade() {
        super(UsuariosSucursales.class);
    }
    public UsuariosSucursales obtenerUsuarioSucursal(String usuario, Integer sucursal){
        Query q = getEntityManager().createNativeQuery("SELECT id_sucursal, id_usuario, estado\n" +
                                                      "  FROM usuarios_sucursales\n" +
                                                      "WHERE	id_usuario = ?\n" +
                                                      "AND	id_sucursal = ?\n" +
                                                      "AND	estado = 'A'", UsuariosSucursales.class);
       q.setParameter(1,usuario);
       q.setParameter(2,sucursal);
       UsuariosSucursales result=null;
        if(!q.getResultList().isEmpty()){
            result=(UsuariosSucursales) q.getSingleResult();            
        }
        return result;
    }    
    
}
