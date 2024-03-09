/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import Entidades.Sucursales;
import Facades.SucursalesFacade;
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
@Named(value = "beanSucursales")
@SessionScoped
public class BeanSucursales implements Serializable {

    @EJB
    private SucursalesFacade sucursalesFacade;
    private List<Sucursales> listaSucursales;
    private Sucursales sucursal;
    /**
     * Creates a new instance of 
     */
    public BeanSucursales() {
        listaSucursales=new ArrayList<>();
        sucursal=new Sucursales();
    }

    public Sucursales getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
    }
    
    public List<Sucursales> listarSucursales(){
        listaSucursales=sucursalesFacade.findAll();
        return listaSucursales;
    }
    public void Nuevo(){
        sucursal =new Sucursales();        
    }
    public void Grabar(){        
        try {
            sucursalesFacade.create(sucursal);
            RequestContext.getCurrentInstance().update("formSucursal");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formSucursal");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            sucursalesFacade.edit(sucursal);
            RequestContext.getCurrentInstance().update("formSucursal");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formSucursal");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {
            sucursalesFacade.remove(sucursal);
            RequestContext.getCurrentInstance().update("formSucursal");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formSucursal");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
       public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Sucursales.jasper";
        String nombrepdf = "Sucursales.pdf";
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
            RequestContext.getCurrentInstance().update("formSucursal");
        }
    }
   public void Salir(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        ((HttpSession)ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Acesso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update("formSucursal");
        }
    }
}
