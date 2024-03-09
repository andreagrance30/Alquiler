/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Personas;
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
public class PersonasFacade extends AbstractFacade<Personas> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonasFacade() {
        super(Personas.class);
    }
    
    public List<Personas> PersonasNoClientes() {
        Query q = getEntityManager().createNativeQuery("select p.* from personas p where p.id_persona not in(select c.id_cliente from clientes c);", Personas.class);
        List<Personas> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<Personas>) q.getResultList();
}
        return result;
    }

    public List<Personas> PersonasNoProveedores() {
        Query q = getEntityManager().createNativeQuery("select p.* from personas p where p.id_persona not in(select c.id_proveedor from proveedores c);", Personas.class);
        List<Personas> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<Personas>) q.getResultList();
        }
        return result;
    }
    
    public List<Personas> PersonasNoEmpleados() {
        Query q = getEntityManager().createNativeQuery("select p.* from personas p where p.id_persona not in(select c.id_empleado from empleados c);", Personas.class);
        List<Personas> result = null;
        if (!q.getResultList().isEmpty()) {
            result = (List<Personas>) q.getResultList();
        }
        return result;
    }    

    public Boolean validacionRucCi(String ruc, String cedula_identidad, Integer id_persona) {
        if (id_persona != null) {
            Query q2 = getEntityManager().createNativeQuery("SELECT * FROM PERSONAS \n"
                    + "WHERE RUC <> 'NO'\n"
                    + "AND RUC = ?1\n"
                    + "AND id_persona <> ?3\n"
                    + "UNION\n"
                    + "SELECT * FROM PERSONAS \n"
                    + "WHERE CEDULA_IDENTIDAD <> 'NO'\n"
                    + "AND CEDULA_IDENTIDAD = ?2\n"
                    + "AND id_persona <> ?3", Personas.class);
            q2.setParameter(1, ruc);
            q2.setParameter(2, cedula_identidad);
            q2.setParameter(3, id_persona);
            if (!q2.getResultList().isEmpty()) {
                return true;
            }
            return false;

        } else {
            Query q = getEntityManager().createNativeQuery("SELECT * FROM PERSONAS \n"
                    + "WHERE RUC <> 'NO'\n"
                    + "AND RUC = ?1\n"
                    + "UNION\n"
                    + "SELECT * FROM PERSONAS \n"
                    + "WHERE CEDULA_IDENTIDAD <> 'NO'\n"
                    + "AND CEDULA_IDENTIDAD = ?2", Personas.class);
            q.setParameter(1, ruc);
            q.setParameter(2, cedula_identidad);
            if (!q.getResultList().isEmpty()) {
                return true;
            }
            return false;
        }
    }
}
