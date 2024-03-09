/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.AjustesInventarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea Salinas
 */
@Stateless
public class AjustesInventariosFacade extends AbstractFacade<AjustesInventarios> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AjustesInventariosFacade() {
        super(AjustesInventarios.class);
    }
    public Boolean validacionAjusteInventario(Integer id_producto,  Integer id_deposito) {
            Query q2 = getEntityManager().createNativeQuery("select * \n" +
                                                            "from ajustes_inventarios \n" +
                                                            "where id_producto = ?1 \n" +
                                                            "and id_deposito = ?2 \n" /*+
                                                            "and estado ='C'"*/, AjustesInventarios.class);
            q2.setParameter(1, id_producto);
            q2.setParameter(2, id_deposito);
            if (!q2.getResultList().isEmpty()) {
                return true;
            }
            return false;    
            
    }
    public AjustesInventarios obtenerAjustesInventarios(AjustesInventarios id_ajuste) {
        Query q = getEntityManager().createNativeQuery("select * from ajustes_inventarios where id_ajuste_inventario =?1", AjustesInventarios.class);
        q.setParameter(1, id_ajuste.getIdAjusteInventario());
        AjustesInventarios result = null;
        if (!q.getResultList().isEmpty()) {
            result = (AjustesInventarios) q.getSingleResult();
        }
        return result;
    }    
}
 
