/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facades;

import Entidades.AperturaCierreCaja;
import Entidades.UsuariosSucursales;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrea Salinas
 */
@Stateless
public class AperturaCierreCajaFacade extends AbstractFacade<AperturaCierreCaja> {

    @PersistenceContext(unitName = "ProyectoTesis-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AperturaCierreCajaFacade() {
        super(AperturaCierreCaja.class);
    }
    
    public AperturaCierreCaja obtenerAperturaAbierta(UsuariosSucursales id_usuarios_sucursales) {
        Query q = getEntityManager().createNativeQuery("select * \n"
                + "from apertura_cierre_caja s\n"
                + "where id_caja = (select id_caja \n"  
                + "	from cajas \n"
                + "	where estado ='A' \n"
                + "	and id_sucursal = ?1)"
                + "and id_usuario= ?2 \n"
                + "and s.monto_tarjeta_cierre is null\n" 
                + "and s.monto_cheque_cierre is null\n" 
                + "and s.monto_efectivo_cierre is null", AperturaCierreCaja.class);
        q.setParameter(1, id_usuarios_sucursales.getSucursales().getIdSucursal());
        q.setParameter(2, id_usuarios_sucursales.getUsuarios().getIdUsuario());
        AperturaCierreCaja result = null;
        if (!q.getResultList().isEmpty()) {
            result = (AperturaCierreCaja) q.getSingleResult();
}
        return result;
    }
}
