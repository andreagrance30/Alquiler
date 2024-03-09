/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.TiposCheques;
import Facades.TiposChequesFacade;
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
@Named(value = "beanTiposCheques")
@SessionScoped
public class BeanTiposCheques implements Serializable {

    @EJB
    private TiposChequesFacade TiposChequesFacade;
    
    private List<TiposCheques> listaTiposCheques;
    
    private TiposCheques tipocheque;
    
    public BeanTiposCheques() {
        listaTiposCheques=new ArrayList<>();
        tipocheque=new TiposCheques();
    }
    
    public List<TiposCheques> listarTiposCheques(){
        listaTiposCheques=TiposChequesFacade.findAll();
        return listaTiposCheques;
    }

    public TiposCheques getTipocheque() {
        return tipocheque;
    }

    public void setTipocheque(TiposCheques tipocheque) {
        this.tipocheque = tipocheque;
    }
    public void Nuevo(){
        tipocheque =new TiposCheques();        
    }
    public void Grabar(){        
        try {
            //bancos.setEstado(estado);
            TiposChequesFacade.create(tipocheque);
            RequestContext.getCurrentInstance().update("formTiposCheques");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposCheques");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            //bancos.setEstado(estado);
            TiposChequesFacade.edit(tipocheque);
            RequestContext.getCurrentInstance().update("formTiposCheques");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposCheques");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {
            //bancos.setEstado(estado);
            TiposChequesFacade.remove(tipocheque);
            RequestContext.getCurrentInstance().update("formTiposCheques");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTiposCheques");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
    public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "TiposCheques.jasper";
        String nombrepdf = "TiposCheques.pdf";
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
            RequestContext.getCurrentInstance().update("formTiposCheques");
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
            RequestContext.getCurrentInstance().update("formTiposCheques");
        }
    }
}    
