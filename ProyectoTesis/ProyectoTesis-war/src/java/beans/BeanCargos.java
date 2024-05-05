/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Cargos;
import Facades.CargosFacade;
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
@Named(value = "beanCargos")
@SessionScoped
public class BeanCargos implements Serializable {

    @EJB
    private CargosFacade CargosFacade;
    
    private List<Cargos> listarCargos;
    
    private Cargos cargo;
    
    public BeanCargos() {
        listarCargos=new ArrayList<>();
        cargo=new Cargos();
    }
    
    public List<Cargos> listarCargos(){
        listarCargos=CargosFacade.findAll();
        return listarCargos;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }
    
    
    
    public void Nuevo(){
        cargo =new Cargos();        
    }
     public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Cargos.jasper";
        String nombrepdf = "Cargos.pdf";
        HashMap parameters = new HashMap();
        //Inicio Parametros
        //Fin Parametros
        Metodos.impresion_reporte(parameters,nombreJasper,nombrepdf);
    }    
    public void Grabar(){        
        try {
            //bancos.setEstado(estado);
            CargosFacade.create(cargo);
            RequestContext.getCurrentInstance().update("formCargos");
            Metodos.Mensajes("Correcto", "Grabado con Exito");
            RequestContext.getCurrentInstance().execute("PF('digNuevoCargos').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCargos");
            Metodos.Mensajes("Error", "Error al grabar"+e);
        }   
    }
   public void Editar(){        
        try {
            //bancos.setEstado(estado);
            CargosFacade.edit(cargo);
            RequestContext.getCurrentInstance().update("formCargos");
            Metodos.Mensajes("Correcto", "Editado con Exito");
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrarCargos').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCargos");
            Metodos.Mensajes("Error", "Error al Editar");
        }   
    }
   public void Borrar(){        
        try {
            //bancos.setEstado(estado);
            CargosFacade.remove(cargo);
            RequestContext.getCurrentInstance().update("formCargos");
            Metodos.Mensajes("Correcto", "Borrado con Exito");
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrarCargos').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCargos");
            Metodos.Mensajes("Error", "Error al Borrar");
        }   
    }
    public void Menu(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update("formCargos");
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
            RequestContext.getCurrentInstance().update("formCargos");
        }
    }
}    
