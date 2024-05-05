/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Sucursales;
import Entidades.Terminales;
import Entidades.Usuarios;
import Entidades.UsuariosSucursales;
import Facades.SucursalesFacade;
import Facades.TerminalesFacade;
import Facades.UsuariosFacade;
import Facades.UsuariosSucursalesFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author 
 */
@Named(value = "beanAcceso")
@SessionScoped
public class BeanAcceso implements Serializable {

    @EJB
    private UsuariosSucursalesFacade usuariosSucursalesFacade;

    @EJB
    private UsuariosFacade usuariosFacade;

    @EJB
    private SucursalesFacade sucursalesFacade;

    @EJB
    private TerminalesFacade terminalesFacade;
    
    
    private List<Sucursales> listSucursales;
    
    private Usuarios usuarios;
    private Sucursales sucursales;
    public static UsuariosSucursales usuariossucursales;
    private Terminales terminales;

    private String usuario, password, terminal;    

    public BeanAcceso() {
        listSucursales = new ArrayList<>();
        usuariossucursales = new UsuariosSucursales();
        usuarios = new Usuarios();
        sucursales = new Sucursales();
        obtenerHost();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public List<Sucursales> getListSucursales() {
        return listSucursales;
    }

    public UsuariosSucursales getUsuariossucursales() {
        return usuariossucursales;
    }

    public void setUsuariossucursales(UsuariosSucursales usuariossucursales) {
        BeanAcceso.usuariossucursales = usuariossucursales;
    }

   
    
    public void IngresarMenu() {
        if (sucursales != null) {
            usuariossucursales = usuariosSucursalesFacade.obtenerUsuarioSucursal(usuarios.getIdUsuario(), sucursales.getIdSucursal()); 
            if (usuariossucursales != null) {
                //Se comento porque suele perder el valor si pierde la session
                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuariosucursal", usuariossuc);
                ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
                String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
                try { 
                    ctx.redirect(ctxPath + "/faces/formularios/Menu Principal.xhtml");
                    RequestContext.getCurrentInstance().update("formAcceso");

                } catch (IOException ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error " + ex));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No tiene acceso a esta sucursal",""));
                RequestContext.getCurrentInstance().update("formAcceso");
            }                 
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Debe selecionar una sucursal para ingresar",""));
            RequestContext.getCurrentInstance().update("formAcceso");
        }
    }

    public void Ingresar() {
        if (usuario.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ingrese Usuario",""));
            RequestContext.getCurrentInstance().update("formAcceso");
        } else if (password.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Ingrese Contraseña",""));
            RequestContext.getCurrentInstance().update("formAcceso");
        } else {        
            if(!terminal.isEmpty() ){
                terminales = terminalesFacade.obtenerTerminal(terminal.toUpperCase());                
                if(terminales != null){            
                    usuarios = usuariosFacade.obtenerUsuario(usuario, password);
                        if (usuarios != null) {
                            listSucursales = sucursalesFacade.findAll();
                            RequestContext.getCurrentInstance().execute("PF('digSucursal').show()");
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Selecione Sucursal",""));
                            RequestContext.getCurrentInstance().update("formSucursal");             
                        } else {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Credencial invalida",""));
                            RequestContext.getCurrentInstance().update("formAcceso");
                        }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede acceder de esta terminal",""));
                    RequestContext.getCurrentInstance().update("formAcceso");
                }
           }
        }
    }

    private void obtenerHost() {
        try {
            terminal = InetAddress.getLocalHost().getHostName();
            //Se comento porque falla, suele perder el valor si pierde la session
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("terminal", terminal);
        } catch (UnknownHostException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Terminal error: " + ex));
            RequestContext.getCurrentInstance().update("formAcceso");
        }
    }
    
}
