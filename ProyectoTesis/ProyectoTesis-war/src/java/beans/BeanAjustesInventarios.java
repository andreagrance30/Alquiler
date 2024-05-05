/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.AjustesInventarios;
import Entidades.Stock;
import Facades.AjustesInventariosFacade;
import Facades.StockFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author 
 */
@Named(value = "beanAjustesInventarios")
@SessionScoped
public class BeanAjustesInventarios implements Serializable {

    @EJB
    private AjustesInventariosFacade AjustesInventariosFacade;
    @EJB
    private StockFacade StockFacade;
    
    
    private List<AjustesInventarios> listaAjustesInventarios;
    
    private AjustesInventarios ajusteinventario, ajusteinventario_aux;
    private Stock stock;
    private Date fecha;
           
    public BeanAjustesInventarios() {
        listaAjustesInventarios=new ArrayList<>();
        ajusteinventario=new AjustesInventarios();
        ajusteinventario_aux=new AjustesInventarios();
        stock=new Stock();
        fecha = new Date();
    }
    
    public List<AjustesInventarios> listarAjustesInventarios(){
        listaAjustesInventarios=AjustesInventariosFacade.findAll();
        return listaAjustesInventarios;
    }

    public AjustesInventarios getAjusteinventario() {
        return ajusteinventario;
    }

    public void setAjusteinventario(AjustesInventarios ajusteinventario) {
        this.ajusteinventario = ajusteinventario;
    }
    
    public void Nuevo(){
        ajusteinventario =new AjustesInventarios();
        ajusteinventario_aux=new AjustesInventarios();
        stock=new Stock();
    }
    public void Grabar(){        
        try {
            if(AjustesInventariosFacade.validacionAjusteInventario(ajusteinventario.getStock().getProductos().getIdProducto(), ajusteinventario.getStock().getDepositos().getIdDeposito()).equals(true)){
                RequestContext.getCurrentInstance().update("formAjustesInventarios");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede inserta un Ajuste Inventario, tiene uno cargado con los mismos registros, verifique!! ",""));                
            }else{
                ajusteinventario.setExistenciaTeorica(ajusteinventario.getStock().getExistencia());
                ajusteinventario.setUsuariosSucursales(BeanAcceso.usuariossucursales);
             //  ajusteinventario.setEstado("C");
            //    ajusteinventario.setFechaAjuste(fecha);
                AjustesInventariosFacade.create(ajusteinventario);
                RequestContext.getCurrentInstance().update("formAjustesInventarios");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
                RequestContext.getCurrentInstance().execute("PF('digAprobar').show()");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formAjustesInventarios");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar " +e.getMessage(),""));
        }   
    }
 public void Editar(){        
      /*  try {
            if(ajusteinventario.getEstado().equals("C")){
                ajusteinventario.setFechaAjuste(fecha);
                ajusteinventario.setEstado("C");*/
                ajusteinventario.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                AjustesInventariosFacade.edit(ajusteinventario);
                RequestContext.getCurrentInstance().update("formAjustesInventarios");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");   
                RequestContext.getCurrentInstance().execute("PF('digAprobar').show()");                 
       /*     }else{                                  
                RequestContext.getCurrentInstance().update("formAjustesInventarios");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede Editar un Ajuste Inventario Aprobado o Anulado",""));
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()"); 
            }           
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formAjustesInventarios");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Editar "+e,""));
        }   */
    }
   public void Anular(){        
        try {
            ajusteinventario_aux = AjustesInventariosFacade.obtenerAjustesInventarios(ajusteinventario);
        /*    switch (ajusteinventario.getEstado()) {
                case "C":
                    ajusteinventario_aux.setFechaAjuste(fecha);
                    ajusteinventario_aux.setEstado("X");  
                    ajusteinventario_aux.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    AjustesInventariosFacade.edit(ajusteinventario_aux);
                    RequestContext.getCurrentInstance().update("formAjustesInventarios");
                    FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Anulado con Exito"));
                    RequestContext.getCurrentInstance().execute("PF('digAnular').hide()");
                    RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
                    break;
                case "A":
                    RequestContext.getCurrentInstance().update("formAjustesInventarios");
                    FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede Anular un Ajuste Inventario Aprobado",""));
                    RequestContext.getCurrentInstance().execute("PF('digAnular').hide()");
                    RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
                    break;
                default:
                    RequestContext.getCurrentInstance().update("formAjustesInventarios");            
                    FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede Anular un Ajuste Inventario Anulado",""));
                    RequestContext.getCurrentInstance().execute("PF('digAnular').hide()");
                    RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
                    break;
            }*/
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formAjustesInventarios");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Anular",""));
        }   
    }
   public void Aprobar(){
        try {         
            ajusteinventario_aux = AjustesInventariosFacade.obtenerAjustesInventarios(ajusteinventario);            
     /*       if(ajusteinventario.getEstado().equals("C")){            
                                
                stock.setDepositos(ajusteinventario_aux.getStock().getDepositos());
                stock.setProductos(ajusteinventario_aux.getStock().getProductos());
                stock.setStockPK(ajusteinventario_aux.getStock().getStockPK());
                stock.setExistencia(ajusteinventario_aux.getExistenciaFisica());
                StockFacade.edit(stock);   
                
                ajusteinventario_aux.setFechaAjuste(fecha);
                ajusteinventario_aux.setEstado("A");   
                AjustesInventariosFacade.edit(ajusteinventario_aux);                 
                        
                RequestContext.getCurrentInstance().update("formAjustesInventarios");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Aprobado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digAprobar').hide()");
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
            }else{
                RequestContext.getCurrentInstance().update("formAjustesInventarios");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede Aprobar un Ajuste Inventario Anulado o que ya esta Aprobado",""));            
                RequestContext.getCurrentInstance().execute("PF('digAprobar').hide()");
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
            }*/
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formAjustesInventarios");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Aprobar",""));
        }   
   }
   public void Menu(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_WARN,"Error"+ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formAjustesInventarios");
        }
    }
   public void Salir(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        ((HttpSession)ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Acceso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_WARN,"Error"+ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formAjustesInventarios");
        }
    }
}    
