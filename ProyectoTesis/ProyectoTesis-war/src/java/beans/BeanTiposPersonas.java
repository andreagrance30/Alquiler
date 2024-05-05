/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.TiposPersonas;
import Facades.TiposPersonasFacade;
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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.context.RequestContext;
import utils.Metodos;

/**
 *
 * @author 
 */
@Named(value = "beanTiposPersonas")
@SessionScoped
public class BeanTiposPersonas implements Serializable {

    @EJB
    private TiposPersonasFacade TiposPersonasFacade;
    
    private List<TiposPersonas> listaTiposPersonas;
    
    private TiposPersonas tipopersona;
    
    public BeanTiposPersonas() {
        listaTiposPersonas=new ArrayList<>();
        tipopersona=new TiposPersonas();
    }
    
    public List<TiposPersonas> listarTiposPersonas(){
        listaTiposPersonas=TiposPersonasFacade.findAll();
        return listaTiposPersonas;
    }

    public TiposPersonas getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(TiposPersonas tipopersona) {
        this.tipopersona = tipopersona;
    }
    
    public void Nuevo(){
        tipopersona =new TiposPersonas();        
    }
    public void Grabar(){        
        try {
            //bancos.setEstado(estado);
            TiposPersonasFacade.create(tipopersona);
            RequestContext.getCurrentInstance().update("formTiposPersonas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposPersonas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            //bancos.setEstado(estado);
            TiposPersonasFacade.edit(tipopersona);
            RequestContext.getCurrentInstance().update("formTiposPersonas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposPersonas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {
            //bancos.setEstado(estado);
            TiposPersonasFacade.remove(tipopersona);
            RequestContext.getCurrentInstance().update("formTiposPersonas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposPersonas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
       public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "TiposPersonas.jasper";
        String nombrepdf = "TiposPersonas.pdf";
        HashMap parameters = new HashMap();
        //Inicio Parametros
        //Fin Parametros
        Metodos.impresion_reporte(parameters,nombreJasper,nombrepdf);
    }
       
   public void Menu(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update("formTiposPersonas");
        }
    }
   public void Salir(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        ((HttpSession)ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Acceso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update("formTiposPersonas");
        }
    }
}    
