/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.AperturaCierreCaja;
import Facades.AperturaCierreCajaFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author
 */
@Named(value = "beanPrincipal")
@SessionScoped
public class BeanPrincipal implements Serializable {

    @EJB
    private AperturaCierreCajaFacade AperturaCierreCajaFacade;
    private AperturaCierreCaja aperturacierrecaja;
    private String usuario;
    private String sucursal;

    public BeanPrincipal() {
        usuario = BeanAcceso.usuariossucursales.getUsuarios().getIdUsuario();
        sucursal = BeanAcceso.usuariossucursales.getSucursales().getIdSucursal().toString() + "-" + BeanAcceso.usuariossucursales.getSucursales().getDescripcion();

    }

     public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
  
    public void Salir() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        externalContext.redirect(((HttpServletRequest) externalContext.getRequest()).getRequestURI());
    }

    public void Inicializa() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + BeanAcceso.usuariossucursales.getUsuarios().getIdEmpleado().getPersonas().getPrimerNombre() + " " + BeanAcceso.usuariossucursales.getUsuarios().getIdEmpleado().getPersonas().getPrimerApellido()));
        RequestContext.getCurrentInstance().update("formPrincipal:gPrincipal");
    }

    public void ObtenerApertura(String pagina) {
        aperturacierrecaja = AperturaCierreCajaFacade.obtenerAperturaAbierta(BeanAcceso.usuariossucursales);
        if (aperturacierrecaja == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Se debe realizar la apertura", ""));
            RequestContext.getCurrentInstance().update("formPrincipal:gPrincipal");
        } else {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
            try {
                ctx.redirect(ctxPath + "/faces/formularios/" + pagina + ".xhtml");
            } catch (IOException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error" + ex.getMessage(), ""));
                RequestContext.getCurrentInstance().update("formPrincipal");
            }
        }

    }
}
