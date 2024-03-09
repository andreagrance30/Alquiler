/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Roles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrea Salinas
 */
@Stateless
public class RolesFacade extends AbstractFacade<Roles> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesFacade() {
        super(Roles.class);
    }
    
}
