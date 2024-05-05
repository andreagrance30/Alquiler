/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Empleados;
import Entidades.Personas;
import Facades.EmpleadosFacade;
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
@Named(value = "beanEmpleados")
@SessionScoped
public class BeanEmpleados implements Serializable {

    @EJB
    private EmpleadosFacade EmpleadosFacade;
    @EJB
    private PersonasFacade PersonasFacade;

    private List<Empleados> listaEmpleados;

    private Empleados empleado;
    private Personas idPersona;

    public BeanEmpleados() {
        listaEmpleados = new ArrayList<>();
        empleado = new Empleados();
    }

    public List<Empleados> listarEmpleados() {
        listaEmpleados = EmpleadosFacade.findAll();
        return listaEmpleados;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Personas getPersonas() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public void Nuevo() {
        empleado = new Empleados();
        idPersona = new Personas();
        idPersona.setCedulaIdentidad("NO");
        idPersona.setRuc("NO");
    }

    public void Grabar() {
        try {
            if (idPersona.getIdTipoPersona().getIdTipoPersona() == 2 && idPersona.getRuc().equals("NO")) {
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Empleado Juridico y agregar Nro de Cedula"));
            } else if (idPersona.getIdTipoPersona().getIdTipoPersona() == 1 && idPersona.getCedulaIdentidad().equals("NO")) {
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Empleado Fisico y no agregar Nro de Cedula"));
            } else if (idPersona.getRuc().equals(idPersona.getCedulaIdentidad())) {
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ruc y Cedula no pueden ser iguales"));
            } else if (PersonasFacade.validacionRucCi(idPersona.getRuc(), idPersona.getCedulaIdentidad(), idPersona.getIdPersona()).equals(true)) {
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ya existe ruc o cedula de identidad registrada"));
            } else {
                PersonasFacade.create(idPersona);
                empleado.setPersonas(idPersona);
                empleado.setIdEmpleado(idPersona.getIdPersona());
                EmpleadosFacade.create(empleado);
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formEmpleados");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al grabar" + e));
        }
    }

    public void Editar() {
        try {
            if (empleado.getPersonas().getIdTipoPersona().getIdTipoPersona() == 2 && empleado.getPersonas().getRuc().equals("NO")) {
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Empleado Juridico y agregar Nro de Cedula"));
            } else if (empleado.getPersonas().getIdTipoPersona().getIdTipoPersona() == 1 && empleado.getPersonas().getCedulaIdentidad().equals("NO")) {
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Empleado Fisico y no agregar Nro de Cedula"));
            } else if (empleado.getPersonas().getRuc().equals(empleado.getPersonas().getCedulaIdentidad())) {
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ruc y Cedula no pueden ser iguales"));
            } else if (PersonasFacade.validacionRucCi(empleado.getPersonas().getRuc(), empleado.getPersonas().getCedulaIdentidad(), empleado.getPersonas().getIdPersona()).equals(true)) {
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ya existe ruc o cedula de identidad registrada"));
            } else {
                idPersona = empleado.getPersonas();
                PersonasFacade.edit(idPersona);
                EmpleadosFacade.edit(empleado);
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Editado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formEmpleados");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Editar"));
        }
    }

    public void AgregarEmpleado() {
        try {
            if (idPersona == null) {
                RequestContext.getCurrentInstance().update("formPersonas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe seleccionar una Persona para agregarla como Empleado"));
            }  else {
                empleado.setPersonas(idPersona);
                empleado.setEstado("A");
                empleado.setIdEmpleado(idPersona.getIdPersona());
                EmpleadosFacade.create(empleado);
                RequestContext.getCurrentInstance().update("formEmpleados");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digPersonas').hide()");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPersonas");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Agregar Persona"));
        }
    }

    public void Borrar() {
        try {
            EmpleadosFacade.remove(empleado);
            RequestContext.getCurrentInstance().update("formEmpleados");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formEmpleados");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Borrar"));
        }
    }
   public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Empleados.jasper";
        String nombrepdf = "Empleados.pdf";
        HashMap parameters = new HashMap();
        //Inicio Parametros
        //Fin Parametros
        Metodos.impresion_reporte(parameters,nombreJasper,nombrepdf);
    }  
    public void Menu() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath + "/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error" + ex.getMessage()));
            RequestContext.getCurrentInstance().update("formEmpleados");
        }
    }

    public void Salir() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        ((HttpSession) ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath + "/faces/formularios/Acceso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error" + ex.getMessage()));
            RequestContext.getCurrentInstance().update("formEmpleados");
        }
    }
}
