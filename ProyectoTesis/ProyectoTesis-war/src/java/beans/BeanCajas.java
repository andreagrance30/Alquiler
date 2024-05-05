/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Cajas;
import Facades.CajasFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.context.RequestContext;
import utils.Metodos;

/**
 *
 * @author 
 */
@Named(value = "beanCajas")
@SessionScoped
public class BeanCajas implements Serializable {

    @EJB
    private CajasFacade CajasFacade;

    
    private List<Cajas> listaCajas;
    private List<Cajas> listaCajasCerradas;
    private List<Cajas> listaCajasSucursal;
    
    private Cajas caja;
    private String estado;
    private Integer sucursal_d, sucursal_h;

           
    public BeanCajas() {
        listaCajas=new ArrayList<>();
        listaCajasCerradas=new ArrayList<>();
        listaCajasSucursal=new ArrayList<>();
        caja=new Cajas();
    }
    
    public List<Cajas> listarCajasSucursal(){
        listaCajasSucursal=CajasFacade.obtenerCajasSucursal(BeanAcceso.usuariossucursales.getSucursales().getIdSucursal());
        return listaCajasSucursal;
    }
    
    public List<Cajas> listarCajasCerradas(){
        listaCajasCerradas=CajasFacade.obtenerCajasCerradas(BeanAcceso.usuariossucursales.getSucursales().getIdSucursal());
        return listaCajasCerradas;
    }
    
    public List<Cajas> listarCajas(){
        listaCajas=CajasFacade.findAll();
        return listaCajas;
    }    

    public Cajas getCaja() {
        return caja;
    }

    public void setCaja(Cajas caja) {
        this.caja = caja;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getSucursal_d() {
        return sucursal_d;
    }

    public void setSucursal_d(Integer sucursal_d) {
        this.sucursal_d = sucursal_d;
    }

    public Integer getSucursal_h() {
        return sucursal_h;
    }

    public void setSucursal_h(Integer sucursal_h) {
        this.sucursal_h = sucursal_h;
    }
    
    
    
    public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Cajas.jasper";
        String nombrepdf = "Cajas.pdf";
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_estado", estado);
        parameters.put("p_sucursal_desde", sucursal_d);
        parameters.put("p_sucursal_hasta", sucursal_h);
        //Fin Parametros
        Metodos.impresion_reporte(parameters,nombreJasper,nombrepdf);
    }      
    
    public void Nuevo(){
        caja =new Cajas();        
    }
    public void Grabar(){        
        try {     
            CajasFacade.create(caja);
            RequestContext.getCurrentInstance().update("formCajas");    
            Metodos.Mensajes("Correcto", "Grabado con Exito");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevoCajas').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCajas");
            Metodos.Mensajes("Error", "Error al Grabar"+e);
        }   
    }
   public void Editar(){        
        try {
            CajasFacade.edit(caja);
            RequestContext.getCurrentInstance().update("formCajas");
            Metodos.Mensajes("Correcto", "Editado con Exito");
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrarCajas').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCajas");
            Metodos.Mensajes("Error", "Error al Editar");
        }   
    }
   public void Borrar(){        
        try {
            CajasFacade.remove(caja);
            RequestContext.getCurrentInstance().update("formCajas");
            Metodos.Mensajes("Correcto", "Borrado con Exito");
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrarCajas').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCajas");
            Metodos.Mensajes("Error", "Error al Borrar");
        }   
    }
}    
