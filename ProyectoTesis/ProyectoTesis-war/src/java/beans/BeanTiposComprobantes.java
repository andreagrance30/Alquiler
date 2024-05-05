/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.TiposComprobantes;
import Facades.TiposComprobantesFacade;
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
@Named(value = "beanTiposComprobantes")
@SessionScoped
public class BeanTiposComprobantes implements Serializable {

    @EJB
    private TiposComprobantesFacade TiposComprobantesFacade;
    
    private List<TiposComprobantes> listaTiposComprobantes;
    
    private TiposComprobantes tipoComprobante;
    
    public BeanTiposComprobantes() {
        listaTiposComprobantes=new ArrayList<>();
        tipoComprobante=new TiposComprobantes();
    }
    
    public List<TiposComprobantes> listarTiposComprobantes(){
        listaTiposComprobantes=TiposComprobantesFacade.findAll();
        return listaTiposComprobantes;
    }

    public TiposComprobantes getTipoComprobante() {
        return tipoComprobante;
    } 

    public void setTipoComprobante(TiposComprobantes tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }
    
    public void Nuevo(){
        tipoComprobante =new TiposComprobantes();        
    }
    public void Grabar(){        
        try {
            //bancos.setEstado(estado);
            TiposComprobantesFacade.create(tipoComprobante);
            RequestContext.getCurrentInstance().update("formTiposComprobantes");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposComprobantes");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            //bancos.setEstado(estado);
            TiposComprobantesFacade.edit(tipoComprobante);
            RequestContext.getCurrentInstance().update("formTiposComprobantes");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposComprobantes");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {
            //bancos.setEstado(estado);
            TiposComprobantesFacade.remove(tipoComprobante);
            RequestContext.getCurrentInstance().update("formTiposComprobantes");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposComprobantes");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
      public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "TiposComprobantes.jasper";
        String nombrepdf = "TiposComprobantes.pdf";
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
            RequestContext.getCurrentInstance().update("formTiposComprobantes");
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
            RequestContext.getCurrentInstance().update("formTiposComprobantes");
        }
    }
}    
