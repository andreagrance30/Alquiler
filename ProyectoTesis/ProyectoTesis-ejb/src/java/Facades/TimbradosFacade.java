/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Timbrados;
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
public class TimbradosFacade extends AbstractFacade<Timbrados> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TimbradosFacade() {
        super(Timbrados.class);
    }
    
    public Boolean verificaTimbrado(BigDecimal timbrado, Integer caja, Integer tipo_comprobante){
       Query q = getEntityManager().createNativeQuery("SELECT s.*\n" +
                                                      "  FROM timbrados s\n" +
                                                      "WHERE  s.nro_timbrado = ?\n" +
                                                      "UNION\n" +
                                                      "SELECT s.*\n" +
                                                      "  FROM timbrados s\n" +
                                                      "WHERE  s.id_caja = ?\n" +
                                                      "AND    s.id_tipo_comprobante=?", Timbrados.class);
       q.setParameter(1,timbrado);
       q.setParameter(2,caja);
       q.setParameter(3,tipo_comprobante);
        if(!q.getResultList().isEmpty()){
            return true;         
}
        return false;
    }
    public Timbrados obtenerTimbrado(Integer id_caja, Integer comprobante){
       Query q = getEntityManager().createNativeQuery("select * from timbrados where id_caja = ?1 and estado = 'A' and id_tipo_comprobante =?2", Timbrados.class);
       q.setParameter(1,id_caja);
       q.setParameter(2,comprobante);
       
       Timbrados result=null;
        if(!q.getResultList().isEmpty()){
            result=(Timbrados) q.getSingleResult();            
        }
        return result;
    } 
    
}
