/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.Stock;
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
public class StockFacade extends AbstractFacade<Stock> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }
    
        public List<Stock> listaStockDeposito(Integer id_sucursal){
        Query q= getEntityManager().createNativeQuery("select * from stock where id_deposito in (select id_deposito from depositos where id_sucursal=?1)", Stock.class);
        q.setParameter(1, id_sucursal);
        List<Stock> lista=null;
        if(q.getResultList().size()>0){
            lista=q.getResultList();}
        return lista;
    }
    
}
