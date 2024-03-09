/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Proveedores;
import Entidades.Personas;
import Facades.ProveedoresFacade;
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
@Named(value = "beanProveedores")
@SessionScoped
public class BeanProveedores implements Serializable {

    @EJB
    private ProveedoresFacade ProveedoresFacade;
    @EJB
    private PersonasFacade PersonasFacade;

    private List<Proveedores> listaProveedores;

    private Proveedores proveedor;
    private Personas idPersona;

    public BeanProveedores() {
        listaProveedores = new ArrayList<>();
        proveedor = new Proveedores();
    }

    public List<Proveedores> listarProveedores() {
        listaProveedores = ProveedoresFacade.findAll();
        return listaProveedores;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public Personas getPersonas() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public void Nuevo() {
        proveedor = new Proveedores();
        idPersona = new Personas();
        idPersona.setCedulaIdentidad("NO");
        idPersona.setRuc("NO");
    }

    public void Grabar() {
        try {
            if (idPersona.getIdTipoPersona().getIdTipoPersona() == 2 && idPersona.getRuc().equals("NO")) {
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Proveedor Juridico y agregar Nro de Cedula"));
            } else if (idPersona.getIdTipoPersona().getIdTipoPersona() == 1 && idPersona.getCedulaIdentidad().equals("NO")) {
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Proveedor Fisico y no agregar Nro de Cedula"));
            } else if (idPersona.getRuc().equals(idPersona.getCedulaIdentidad())) {
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ruc y Cedula no pueden ser iguales"));
            } else if (PersonasFacade.validacionRucCi(idPersona.getRuc(), idPersona.getCedulaIdentidad(), idPersona.getIdPersona()).equals(true)) {
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ya existe ruc o cedula de identidad registrada"));
            } else {
                PersonasFacade.create(idPersona);
                proveedor.setPersonas(idPersona);
                proveedor.setIdProveedor(idPersona.getIdPersona());
                ProveedoresFacade.create(proveedor);
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formProveedores");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al grabar" + e));
        }
    }

    public void Editar() {
        try {
            if (proveedor.getPersonas().getIdTipoPersona().getIdTipoPersona() == 2 && proveedor.getPersonas().getRuc().equals("NO")) {
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Proveedor Juridico y agregar Nro de Cedula"));
            } else if (proveedor.getPersonas().getIdTipoPersona().getIdTipoPersona() == 1 && proveedor.getPersonas().getCedulaIdentidad().equals("NO")) {
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Proveedor Fisico y no agregar Nro de Cedula"));
            } else if (proveedor.getPersonas().getRuc().equals(proveedor.getPersonas().getCedulaIdentidad())) {
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ruc y Cedula no pueden ser iguales"));
            } else if (PersonasFacade.validacionRucCi(proveedor.getPersonas().getRuc(), proveedor.getPersonas().getCedulaIdentidad(), proveedor.getPersonas().getIdPersona()).equals(true)) {
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ya existe ruc o cedula de identidad registrada"));
            } else {
                idPersona = proveedor.getPersonas();
                PersonasFacade.edit(idPersona);
                ProveedoresFacade.edit(proveedor);
                RequestContext.getCurrentInstance().update("formProveedores");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Editado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formProveedores");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Editar"));
        }
    }

    public void AgregarProveedor() {
        try {
            if (idPersona == null) {
                RequestContext.getCurrentInstance().update("formPersonas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe seleccionar una Persona para agregarla como Proveedor"));
            }  else {
                proveedor.setPersonas(idPersona);
                proveedor.setEstado("A");
                proveedor.setIdProveedor(idPersona.getIdPersona());
                ProveedoresFacade.create(proveedor);
                RequestContext.getCurrentInstance().update("formProveedores");
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
            ProveedoresFacade.remove(proveedor);
            RequestContext.getCurrentInstance().update("formProveedores");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formProveedores");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Borrar"));
        }
    }
    
     public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Proveedores.jasper";
        String nombrepdf = "Proveedores.pdf";
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
            RequestContext.getCurrentInstance().update("formProveedores");
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
            RequestContext.getCurrentInstance().update("formProveedores");
        }
    }
}
