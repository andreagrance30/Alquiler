/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import Entidades.Productos;
import Facades.ProductosFacade;
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
@Named(value = "beanProductos")
@SessionScoped
public class BeanProductos implements Serializable {

    @EJB
    private ProductosFacade productosFacade;
    private List<Productos> listaProductos;
    private Productos producto;
    /**
     * Creates a new instance of 
     */
    public BeanProductos() {
        listaProductos=new ArrayList<>();
        producto=new Productos();
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    
    public List<Productos> listarProductos(){
        listaProductos=productosFacade.findAll();
        return listaProductos;
    }
    public void Nuevo(){
        producto =new Productos();        
    }
    public void Grabar(){        
        try {
            productosFacade.create(producto);
            RequestContext.getCurrentInstance().update("formProducto");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formProducto");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            productosFacade.edit(producto);
            RequestContext.getCurrentInstance().update("formProducto");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formProducto");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {
            productosFacade.remove(producto);
            RequestContext.getCurrentInstance().update("formProducto");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formProducto");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
   public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Productos.jasper";
        String nombrepdf = "Productos.pdf";
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
            RequestContext.getCurrentInstance().update("formProducto");
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
            RequestContext.getCurrentInstance().update("formProducto");
        }
    }
}
