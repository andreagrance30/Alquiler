/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Stock;
import Entidades.StockPK;
import Facades.StockFacade;
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
@Named(value = "beanStock")
@SessionScoped
public class BeanStock implements Serializable {

    @EJB
    private StockFacade StockFacade;
    
    private List<Stock> listaStock;
    private List<Stock> listaStockPorDeposito; 
    private Stock stock;
    private StockPK stockpk;
           
    public BeanStock() {
        listaStock=new ArrayList<>();
        stock=new Stock();
        stockpk = new StockPK();
    }
    
    public List<Stock> listarStock(){
        listaStock=StockFacade.findAll();
        return listaStock;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    public void Nuevo(){
        stock =new Stock();
        stockpk=new StockPK();
    }
    
      public List<Stock> listarStockPorDeposito(){
        listaStockPorDeposito =StockFacade.listaStockDeposito(BeanAcceso.usuariossucursales.getSucursales().getIdSucursal());
        return listaStockPorDeposito;
    }  
      
    public void Grabar(){        
        try {
            stockpk.setIdDeposito(stock.getDepositos().getIdDeposito());
            stockpk.setIdProducto(stock.getProductos().getIdProducto());
            stock.setStockPK(stockpk);
            StockFacade.create(stock);
            RequestContext.getCurrentInstance().update("formStock");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formStock");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar " +e.getMessage()));
        }   
    }
   public void Editar(){        
        try {
            stockpk.setIdDeposito(stock.getDepositos().getIdDeposito());
            stockpk.setIdProducto(stock.getProductos().getIdProducto());
            stock.setStockPK(stockpk);            
            StockFacade.edit(stock);
            RequestContext.getCurrentInstance().update("formStock");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formStock");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar "+e.getMessage()));
        }   
    }
   public void Borrar(){        
        try {
            stockpk.setIdDeposito(stock.getDepositos().getIdDeposito());
            stockpk.setIdProducto(stock.getProductos().getIdProducto());
            stock.setStockPK(stockpk);            
            StockFacade.remove(stock);
            RequestContext.getCurrentInstance().update("formStock");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formStock");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
     public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Stock.jasper";
        String nombrepdf = "Stock.pdf";
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
            RequestContext.getCurrentInstance().update("formStock");
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
            RequestContext.getCurrentInstance().update("formStock");
        }
    }
}    
