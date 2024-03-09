/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.CuentasCobrar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 
 */
@Stateless
public class CuentasCobrarFacade extends AbstractFacade<CuentasCobrar> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentasCobrarFacade() {
        super(CuentasCobrar.class);
    }
    public List<CuentasCobrar> listaCuentasClientesCondicon(Integer id_cliente, Integer id_condicion){
        Query q= getEntityManager().createNativeQuery("select c.* from cuentas_cobrar c, ventas v, condiciones con \n" +
                                                      "where v.id_venta=c.id_venta\n" +
                                                      "and con.id_condicion = v.id_condicion\n" +
                                                      "and c.estado = 'A'\n" +
                                                      "and v.id_cliente = ?1\n" +
                                                      "and con.id_condicion = ?2", CuentasCobrar.class);
        q.setParameter(1, id_cliente);
        q.setParameter(2, id_condicion);
        List<CuentasCobrar> lista=null;
        if(!q.getResultList().isEmpty()){
            lista=q.getResultList();}
        return lista;
    }
        
}
