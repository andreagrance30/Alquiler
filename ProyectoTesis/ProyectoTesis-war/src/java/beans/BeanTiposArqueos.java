/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.TiposArqueos;
import Facades.TiposArqueosFacade;
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
@Named(value = "beanTiposArqueos")
@SessionScoped
public class BeanTiposArqueos implements Serializable {

    @EJB
    private TiposArqueosFacade TiposArqueosFacade;
    
    private List<TiposArqueos> listaTiposArqueos;
    
    private TiposArqueos tipoarqueo;
    
    public BeanTiposArqueos() {
        listaTiposArqueos=new ArrayList<>();
        tipoarqueo=new TiposArqueos();
    }
    
    public List<TiposArqueos> listarTiposArqueos(){
        listaTiposArqueos=TiposArqueosFacade.findAll();
        return listaTiposArqueos;
    }

    public TiposArqueos getTipoarqueo() {
        return tipoarqueo;
    }

    public void setTipoarqueo(TiposArqueos tipoarqueo) {
        this.tipoarqueo = tipoarqueo;
    }

    
    public void Nuevo(){
        tipoarqueo =new TiposArqueos();        
    }
    public void Grabar(){        
        try {
            //bancos.setEstado(estado);
            TiposArqueosFacade.create(tipoarqueo);
            RequestContext.getCurrentInstance().update("formTiposArqueos");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposArqueos");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            //bancos.setEstado(estado);
            TiposArqueosFacade.edit(tipoarqueo);
            RequestContext.getCurrentInstance().update("formTiposArqueos");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposArqueos");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {
            //bancos.setEstado(estado);
            TiposArqueosFacade.remove(tipoarqueo);
            RequestContext.getCurrentInstance().update("formTiposArqueos");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposArqueos");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
      public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "TiposArqueos.jasper";
        String nombrepdf = "TiposArqueos.pdf";
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
            RequestContext.getCurrentInstance().update("formTiposArqueos");
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
            RequestContext.getCurrentInstance().update("formTiposArqueos");
        }
    }
}    
