/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import Entidades.Personas;
import Facades.PersonasFacade;
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
@Named(value = "beanPersonas")
@SessionScoped
public class BeanPersonas implements Serializable {

    @EJB
    private PersonasFacade personasFacade;
    private List<Personas> listaPersonas;
    private Personas persona;
    /**
     * Creates a new instance of 
     */
    public BeanPersonas() {
        listaPersonas=new ArrayList<>();
        persona=new Personas();
    }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
    
    public List<Personas> listarPersonas(){
        listaPersonas=personasFacade.findAll();
        return listaPersonas;
    }
    public void Nuevo(){
        persona =new Personas();        
    }
    public void Grabar(){        
        try {
            personasFacade.create(persona);
            RequestContext.getCurrentInstance().update("formPersona");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPersona");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al grabar" +e));
        }   
    }
   public void Editar(){        
        try {
            personasFacade.edit(persona);
            RequestContext.getCurrentInstance().update("formPersona");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Editado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPersona");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Editar"));
        }   
    }
   public void Borrar(){        
        try {
            personasFacade.remove(persona);
            RequestContext.getCurrentInstance().update("formPersona");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPersona");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al Borrar"));
        }   
    }
   
    public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Personas.jasper";
        String nombrepdf = "Personas.pdf";
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
            RequestContext.getCurrentInstance().update("formPersona");
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
            RequestContext.getCurrentInstance().update("formPersona");
        }
    }
}
