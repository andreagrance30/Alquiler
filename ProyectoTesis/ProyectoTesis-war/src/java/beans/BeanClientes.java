/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Clientes;
import Entidades.Personas;
import Facades.ClientesFacade;
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
@Named(value = "beanClientes")
@SessionScoped
public class BeanClientes implements Serializable {

    @EJB
    private ClientesFacade ClientesFacade;
    @EJB
    private PersonasFacade PersonasFacade;

    private List<Clientes> listaClientes;

    private Clientes cliente;
    private Personas idPersona;

    public BeanClientes() {
        listaClientes = new ArrayList<>();
        cliente = new Clientes();
    }

    public List<Clientes> listarClientes() {
        listaClientes = ClientesFacade.findAll();
        return listaClientes;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Personas getPersonas() {
        return idPersona;
    }

    public void setIdPersona(Personas idPersona) {
        this.idPersona = idPersona;
    }

    public void Nuevo() {
        cliente = new Clientes();
        idPersona = new Personas();
        idPersona.setCedulaIdentidad("NO");
        idPersona.setRuc("NO");
    }

    public void Grabar() {
        try {
            if (idPersona.getIdTipoPersona().getIdTipoPersona() == 2 && idPersona.getRuc().equals("NO")) {
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Cliente Juridico y agregar Nro de Cedula"));
            } else if (idPersona.getIdTipoPersona().getIdTipoPersona() == 1 && idPersona.getCedulaIdentidad().equals("NO")) {
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Cliente Fisico y no agregar Nro de Cedula"));
            } else if (idPersona.getRuc().equals(idPersona.getCedulaIdentidad())) {
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ruc y Cedula no pueden ser iguales"));
            } else if (PersonasFacade.validacionRucCi(idPersona.getRuc(), idPersona.getCedulaIdentidad(), idPersona.getIdPersona()).equals(true)) {
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ya existe ruc o cedula de identidad registrada"));
            } else {
                PersonasFacade.create(idPersona);
                cliente.setPersonas(idPersona);
                cliente.setIdCliente(idPersona.getIdPersona());
                ClientesFacade.create(cliente);
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digNuevo').hide()");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formClientes");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al grabar" + e));
        }
    }

    public void Editar() {
        try {
            if (cliente.getPersonas().getIdTipoPersona().getIdTipoPersona() == 2 && cliente.getPersonas().getRuc().equals("NO")) {
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Cliente Juridico y agregar Nro de Cedula"));
            } else if (cliente.getPersonas().getIdTipoPersona().getIdTipoPersona() == 1 && cliente.getPersonas().getCedulaIdentidad().equals("NO")) {
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede ser un Cliente Fisico y no agregar Nro de Cedula"));
            } else if (cliente.getPersonas().getRuc().equals(cliente.getPersonas().getCedulaIdentidad())) {
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ruc y Cedula no pueden ser iguales"));
            } else if (PersonasFacade.validacionRucCi(cliente.getPersonas().getRuc(), cliente.getPersonas().getCedulaIdentidad(), cliente.getPersonas().getIdPersona()).equals(true)) {
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ya existe ruc o cedula de identidad registrada"));
            } else {
                idPersona = cliente.getPersonas();
                PersonasFacade.edit(idPersona);
                ClientesFacade.edit(cliente);
                RequestContext.getCurrentInstance().update("formClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Editado con Exito"));
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formClientes");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Editar"));
        }
    }

    public void AgregarCliente() {
        try {
            if (idPersona == null) {
                RequestContext.getCurrentInstance().update("formPersonas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe seleccionar una Persona para agregarla como Cliente"));
            }  else {
                cliente.setPersonas(idPersona);
                cliente.setEstado("A");
                cliente.setIdCliente(idPersona.getIdPersona());
                ClientesFacade.create(cliente);
                RequestContext.getCurrentInstance().update("formClientes");
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
            ClientesFacade.remove(cliente);
            RequestContext.getCurrentInstance().update("formClientes");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Borrado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrar').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formClientes");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Borrar"));
        }
    }
    
       public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Clientes.jasper";
        String nombrepdf = "Clientes.pdf";
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
            RequestContext.getCurrentInstance().update("formClientes");
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
            RequestContext.getCurrentInstance().update("formClientes");
        }
    }
}
