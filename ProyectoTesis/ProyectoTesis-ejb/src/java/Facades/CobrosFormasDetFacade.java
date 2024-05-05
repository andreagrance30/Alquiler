/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.AperturaCierreCaja;
import Entidades.CobrosFormasDet;
import Entidades.TransaccionesComerciales;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea Salinas
 */
@Stateless
public class CobrosFormasDetFacade extends AbstractFacade<CobrosFormasDet> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CobrosFormasDetFacade() {
        super(CobrosFormasDet.class);
    }
   
    public BigDecimal totalesTransacciones(TransaccionesComerciales id_transaccion, AperturaCierreCaja id_apertura_cierre){
        Query q= getEntityManager().createNativeQuery("select COALESCE(sum(monto_det),0)  from cobros c, cobros_formas_det cd\n" +
                                                      "where c.estado ='C' \n" +
                                                      "and cd.id_cobro = c.id_cobro\n" +
                                                      "and cd.id_transaccion_comercial= ?1\n" +
                                                     "and c.id_apertura_cierre_caja =?2 ");
        q.setParameter(1, id_transaccion.getIdTransaccionComercial());
        q.setParameter(2, id_apertura_cierre.getIdAperturaCierreCaja());
        if(!q.getResultList().isEmpty()){
            return ((BigDecimal) q.getSingleResult())/*.toBigInteger()*/;
        }
        return BigDecimal.ZERO;
    }
}
