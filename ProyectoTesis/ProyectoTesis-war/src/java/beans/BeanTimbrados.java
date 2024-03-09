/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Timbrados;
import Facades.TimbradosFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
@Named(value = "beanTimbrados")
@SessionScoped
public class BeanTimbrados implements Serializable {

    @EJB
    private TimbradosFacade TimbradosFacade;

    
    private List<Timbrados> listaTimbrados;
    private Timbrados timbrado;
    private Date fecha;
    

           
    public BeanTimbrados() {
        listaTimbrados=new ArrayList<>();
        timbrado=new Timbrados();
        fecha= new Date();
    }
    
    public List<Timbrados> listarTimbrados(){
        listaTimbrados=TimbradosFacade.findAll();
        return listaTimbrados;
    }

    public Timbrados getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(Timbrados timbrado) {
        this.timbrado = timbrado;
    }
    
    public void Nuevo(){
        timbrado =new Timbrados();        
    }
    public void Grabar(){        
        try {
            if(timbrado.getNroTimbrado().toString().length()<8){
                RequestContext.getCurrentInstance().update("formTimbrados");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("El Nro timbrado debe ser de 8 digitos")); 
            }else if(TimbradosFacade.verificaTimbrado(timbrado.getNroTimbrado(), timbrado.getIdCaja().getIdCaja(), timbrado.getIdTipoComprobante().getIdTipoComprobante())){
                RequestContext.getCurrentInstance().update("formTimbrados");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Ya hay registro con Nro timbrado, Caja y Tipo Comprobante"));                   
            }else if (timbrado.getFechaFin().compareTo(timbrado.getFechaInicio())< 0||timbrado.getFechaFin().compareTo(fecha)==0){
                RequestContext.getCurrentInstance().update("formTimbrados");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Debe Ingresar las fechas correctamentes"));             
            }else{
                timbrado.setFechaCarga(fecha);
                TimbradosFacade.create(timbrado);
                RequestContext.getCurrentInstance().update("formTimbrados");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");                
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTimbrados");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            if (timbrado.getFechaFin().compareTo(timbrado.getFechaInicio())> 0||timbrado.getFechaFin().compareTo(fecha)==0){
                TimbradosFacade.edit(timbrado);
                RequestContext.getCurrentInstance().update("formTimbrados");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");                
            }else{
                RequestContext.getCurrentInstance().update("formTimbrados");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Debe Ingresar las fechas correctamentes"));
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTimbrados");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {            
            TimbradosFacade.remove(timbrado);
            RequestContext.getCurrentInstance().update("formTimbrados");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTimbrados");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
    public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Timbrados.jasper";
        String nombrepdf = "Timbrados.pdf";
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
            RequestContext.getCurrentInstance().update("formTimbrados");
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
            RequestContext.getCurrentInstance().update("formTimbrados");
        }
    }
}    
