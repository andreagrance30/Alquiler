/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entidades.EntidadesEmisoras;
import Entidades.Tarjetas;
import Facades.EntidadesEmisorasFacade;
import Facades.TarjetasFacade;
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
@Named(value = "beanTarjetas")
@SessionScoped
public class BeanTarjetas implements Serializable {

    @EJB
    private EntidadesEmisorasFacade entidadesFacade;

    @EJB
    private TarjetasFacade tarjetasFacade;
    
    private List<Tarjetas> listaTarjetas;
    private Tarjetas tarjetas;
    private Integer entidad;

    public Tarjetas getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(Tarjetas tarjetas) {
        this.tarjetas = tarjetas;
    }

    public Integer getEntidades() {
        return entidad;
    }

    public void setEntidades(Integer entidad) {
        this.entidad = entidad;
    }


    public BeanTarjetas() {
        listaTarjetas=new ArrayList<>();
        tarjetas=new Tarjetas();
    }
    public List<Tarjetas> listarTarjetas(){
        listaTarjetas=tarjetasFacade.findAll();
        return listaTarjetas;
    }
    
    public void Nuevo(){
        tarjetas =new Tarjetas();        
    }
    public void Grabar(){        
        try {
            EntidadesEmisoras cla= entidadesFacade.find(entidad);
            tarjetas.setIdEntidadEmisora(cla);
            tarjetasFacade.create(tarjetas);
            RequestContext.getCurrentInstance().update("formTarjetas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTarjetas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            EntidadesEmisoras cla= entidadesFacade.find(entidad);
            tarjetas.setIdEntidadEmisora(cla);
            tarjetasFacade.edit(tarjetas);
            RequestContext.getCurrentInstance().update("formTarjetas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTarjetas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {
            EntidadesEmisoras cla= entidadesFacade.find(entidad);
            tarjetas.setIdEntidadEmisora(cla);
            tarjetasFacade.remove(tarjetas);
            RequestContext.getCurrentInstance().update("formTarjetas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formTarjetas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
     public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Tarjetas.jasper";
        String nombrepdf = "Tarjetas.pdf";
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
            RequestContext.getCurrentInstance().update("formTarjetas");
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
            RequestContext.getCurrentInstance().update("formTarjetas");
        }
    }
}
