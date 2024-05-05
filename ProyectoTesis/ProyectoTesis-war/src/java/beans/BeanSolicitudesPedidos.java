/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;


import Entidades.SolicitudesPedidos;
import Entidades.SolicitudesPedidosDet;
import Entidades.SolicitudesPedidosDetPK;
import Facades.SolicitudesPedidosDetFacade;
import Facades.SolicitudesPedidosFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.context.RequestContext;
import utils.Conexion;        
import org.primefaces.model.SelectableDataModel;
import utils.Metodos;

/**
 *
 * @author 
 */
@Named(value = "beanSolicitudesPedidos")
@SessionScoped
public class BeanSolicitudesPedidos implements Serializable {

    @EJB
    private SolicitudesPedidosFacade SolicitudesPedidosFacade;
    @EJB
    private SolicitudesPedidosDetFacade SolicitudesPedidosDetFacade;

    private List<SolicitudesPedidos> listaSolicitudesPedidos,listaSolicitudesPedidosPendientes,listaSolicitudesPedidosAprobados;
    private List<SolicitudesPedidosDet> listaSolicitudesPedidosDet, listaSolicitudesPedidosDetAux;    

    private SolicitudesPedidos pedido, pedido_aux, pedido_rep;
    private SolicitudesPedidosDet pedidodet;
    private SolicitudesPedidosDetPK pedidodetpk;
    
    public BeanSolicitudesPedidos() {
        listaSolicitudesPedidosPendientes = new ArrayList<>();
        listaSolicitudesPedidos = new ArrayList<>();
        listaSolicitudesPedidosDet = new ArrayList<>();
        listaSolicitudesPedidosDetAux = new ArrayList<>();
        pedido = new SolicitudesPedidos();
        pedido_aux = new SolicitudesPedidos();
        pedido_rep = new SolicitudesPedidos();
        pedidodet = new SolicitudesPedidosDet();
        pedidodetpk = new SolicitudesPedidosDetPK();
    }

    public List<SolicitudesPedidos> listarSolicitudesPedidos() {
        listaSolicitudesPedidos = SolicitudesPedidosFacade.findAll();
        return listaSolicitudesPedidos;
    }
    
    public List<SolicitudesPedidos> listarSolicitudesPedidosPendientes() {
        listaSolicitudesPedidosPendientes = SolicitudesPedidosFacade.obtenerSolicitudesPorEstado("C");
        return listaSolicitudesPedidosPendientes;
    }
    
    public List<SolicitudesPedidos> listarSolicitudesPedidosAprobados() {
        listaSolicitudesPedidosAprobados = SolicitudesPedidosFacade.obtenerSolicitudesPorEstado("A");
        return listaSolicitudesPedidosAprobados;
    }    

    public List<SolicitudesPedidosDet> listarSolicitudesPedidosDet() {
        return listaSolicitudesPedidosDet;
    }
        

    public SolicitudesPedidos getPedido() {
        return pedido;
    }

    public void setPedido(SolicitudesPedidos pedido) {
        this.pedido = pedido;
    }

    public SolicitudesPedidos getPedido_aux() {
        return pedido_aux;
    }

    public void setPedido_aux(SolicitudesPedidos pedido_aux) {
        this.pedido_aux = pedido_aux;
    }
    

    public SolicitudesPedidosDet getPedidodet() {
        return pedidodet;
    }

    public void setPedidodet(SolicitudesPedidosDet pedidodet) {
        this.pedidodet = pedidodet;
    }

    @PostConstruct
    public void RutinaIncial(){
        listaSolicitudesPedidosPendientes = new ArrayList<>();
        listaSolicitudesPedidos = new ArrayList<>();
        listaSolicitudesPedidosDet = new ArrayList<>();
        listaSolicitudesPedidosDetAux = new ArrayList<>();
        pedido = new SolicitudesPedidos();
        pedido_aux = new SolicitudesPedidos();
        pedido_rep = new SolicitudesPedidos();
        pedidodet = new SolicitudesPedidosDet();
        pedidodetpk = new SolicitudesPedidosDetPK();  
    }
    
    public void Inicializa() {
        
    }
    
    public void Reporte() throws IOException, JRException, SQLException {
        JasperPrint jasperPrint;
        String nombreJasper = "SolicitudesPedidos.jasper";
        String nombrepdf = "Pedido Nro:"+pedido_rep.getIdSolicitudPedido()+".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_pedido", pedido_rep.getIdSolicitudPedido());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }    

    public void Nuevo() throws ParseException {
        listaSolicitudesPedidosPendientes = new ArrayList<>();
        listaSolicitudesPedidos = new ArrayList<>();
        listaSolicitudesPedidosDet = new ArrayList<>();
        listaSolicitudesPedidosDetAux = new ArrayList<>();
        pedido = new SolicitudesPedidos();
        pedido_aux = new SolicitudesPedidos();
        pedidodet = new SolicitudesPedidosDet();
        pedidodetpk = new SolicitudesPedidosDetPK();
        
        Inicializa();
        RequestContext.getCurrentInstance().execute("PF('wtbSolicitudesPedidosCabecera').unselectAllRows()");
        Metodos.Mensajes("Correcto", "Grabado con Exito");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Restablecido con exito"));
        RequestContext.getCurrentInstance().update("formSolicitud");
    }

    public void NuevoProducto() {
        pedidodet = new SolicitudesPedidosDet();
    }

    public void EliminarProducto() {
        for (int i = 0; i < listaSolicitudesPedidosDet.size(); i++) {
            SolicitudesPedidosDet fila = listaSolicitudesPedidosDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), pedidodet.getStock().getProductos().getIdProducto())) {
                listaSolicitudesPedidosDet.remove(i);
                RequestContext.getCurrentInstance().update("formSolicitud");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                RequestContext.getCurrentInstance().update("formSolicitud:tbSolicitudesDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarProductoSolicitudes').hide()");
            }
        }
    }

    public void EditarProducto() {
        if(pedidodet.getCantidad().intValue()==0){
            RequestContext.getCurrentInstance().update("formEditarProductoSolicitudes");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
        }else{
            RequestContext.getCurrentInstance().update("formSolicitud");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
            RequestContext.getCurrentInstance().update("formSolicitud:tbSolicitudesDet");
            RequestContext.getCurrentInstance().execute("PF('digEditarProductoSolicitudes').hide()");            
        }
    }

    public void AgregaProducto() {
       Integer v_bandera = 0;
          for (int i = 0; i < listaSolicitudesPedidosDet.size(); i++) {
            SolicitudesPedidosDet fila = listaSolicitudesPedidosDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), pedidodet.getStock().getProductos().getIdProducto())) {
                RequestContext.getCurrentInstance().update("formAgregarProductoSolicitudes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede agregar registro duplicado",""));
                v_bandera = 1;
            }
        }
        if (v_bandera != 1) {
            if(pedidodet.getCantidad().intValue()==0){
                RequestContext.getCurrentInstance().update("formAgregarProductoSolicitudes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
            } else {
                    SolicitudesPedidosDet fila = new SolicitudesPedidosDet(pedidodetpk, pedidodet.getCantidad());
                    fila.setStock(pedidodet.getStock());
                    listaSolicitudesPedidosDet.add(fila);
                    RequestContext.getCurrentInstance().update("formSolicitud");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Agregado"));
                    RequestContext.getCurrentInstance().update("formSolicitud:tbSolicitudDet");
                    RequestContext.getCurrentInstance().execute("PF('digAgregarProductoSolicitudes').hide()");    
            }
        }
   }

    public void Grabar() {
        try {
            if (listaSolicitudesPedidosDet.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe agregar productos para continuar",""));
                RequestContext.getCurrentInstance().update("formSolicitud");
            }else if(pedido.getIdSolicitudPedido()!=null){
             //   pedido.setFechaPedido(new Date());
            //    pedido.setPresupuestoCliente(pedido.getIdSolicitudPedido());
                pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                SolicitudesPedidosFacade.edit(pedido);
                for (int i = 0; i < listaSolicitudesPedidosDetAux.size(); i++) {
                    SolicitudesPedidosDetFacade.remove(listaSolicitudesPedidosDetAux.get(i));
                }                
                for (int f = 0; f < listaSolicitudesPedidosDet.size(); f++) {
                    pedidodet = new SolicitudesPedidosDet();
                    pedidodetpk = new SolicitudesPedidosDetPK();                   
                    pedidodet = listaSolicitudesPedidosDet.get(f);  
          //          pedidodetpk.(pedidodet.getStock().getDepositos().getIdDeposito());
                    pedidodetpk.setIdProducto(pedidodet.getStock().getProductos().getIdProducto());
                    pedidodetpk.setIdSolicitudPedido(pedido.getIdSolicitudPedido());
                    pedidodet.setSolicitudesPedidosDetPK(pedidodetpk);
                    pedidodet.setSolicitudesPedidos(pedido);
                    pedidodet.setStock(pedidodet.getStock());                    
                    SolicitudesPedidosDetFacade.create(pedidodet);                    
                }
                
                RequestContext.getCurrentInstance().update("formSolicitud");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito. Pedido Nro: "+pedido.getIdSolicitudPedido()));       
                Nuevo();                       
            
            }else{
                pedido.setEstado("C");
            //    pedido.setFechaPedido(new Date());
                pedido.setPresupuestoCliente(pedido.getPresupuestoCliente());
                pedido.setFechaPedido(pedido.getFechaPedido());
                pedido.setFechaEntrega(pedido.getFechaEntrega());
                pedido.setFechaDevolucion(pedido.getFechaDevolucion());
                pedido.setDireccionDevolucion(pedido.getDireccionDevolucion());
                pedido.setDireccionEntrega(pedido.getDireccionEntrega());
                pedido.setObservacion(pedido.getObservacion());
                pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                SolicitudesPedidosFacade.create(pedido);
                for (int f = 0; f < listaSolicitudesPedidosDet.size(); f++) {
                    pedidodet = new SolicitudesPedidosDet();
                    pedidodetpk = new SolicitudesPedidosDetPK();   
                    pedidodet = listaSolicitudesPedidosDet.get(f);                    
             /*       pedidodetpk.setIdDeposito(pedidodet.getStock().getDepositos().getIdDeposito());*/
                    pedidodetpk.setIdProducto(pedidodet.getStock().getProductos().getIdProducto());
                    pedidodetpk.setIdSolicitudPedido(pedido.getIdSolicitudPedido());
                    pedidodet.setSolicitudesPedidosDetPK(pedidodetpk);
                    pedidodet.setSolicitudesPedidos(pedido);
           //         pedidodet.setStock(pedidodet.getStock());
                    SolicitudesPedidosDetFacade.create(pedidodet);
                }
                
                RequestContext.getCurrentInstance().update("formSolicitud");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito. Pedido Nro: "+pedido.getIdSolicitudPedido()));       
                Nuevo();                
            }
        } catch (ParseException e) {
            RequestContext.getCurrentInstance().update("formSolicitud");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar" + e,""));
        }
    }
    public void ObtienePedidoDet(){
        listaSolicitudesPedidosDet=SolicitudesPedidosDetFacade.obtenerSolicitudesPedidosDet(pedido_aux.getIdSolicitudPedido());
        listaSolicitudesPedidosDetAux = SolicitudesPedidosDetFacade.obtenerSolicitudesPedidosDet(pedido_aux.getIdSolicitudPedido());
        RequestContext.getCurrentInstance().update("formAnularAprobarSolicitudes:tbSolicitudDet");
   //     RequestContext.getCurrentInstance().update("formSolicitud:gSolicitudesPedidos");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle Obtenido"));
    }
    
    public void Aprobar(){
        try {        
            if(pedido_aux != null){
                pedido=pedido_aux;
                pedido.setEstado("A");
                pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                SolicitudesPedidosFacade.edit(pedido);            
                RequestContext.getCurrentInstance().execute("PF('digAnularAprobarSolicitudes').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobarSolicitudes");
                RequestContext.getCurrentInstance().update("formSolicitud");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aprobado con Exito. Pedido Nro: "+pedido.getIdSolicitudPedido()));               
                Nuevo();

                pedido_rep = new SolicitudesPedidos();
                pedido_rep = pedido;           
                RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()");           
            }else{
                RequestContext.getCurrentInstance().update("formSolicitud:gSolicitudesPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe Seleccionar un Pedido para continuar")); 
            }
        } catch (ParseException e) {
            RequestContext.getCurrentInstance().update("formSolicitud");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Aprobar" + e,""));            
        }                   
    }
    public void Editar(){
        try {            
            if(pedido_aux != null){
                pedido=pedido_aux;
                RequestContext.getCurrentInstance().update("formAnularAprobarSolicitudes");
                RequestContext.getCurrentInstance().update("formSolicitud");
                Metodos.Mensajes("Correcto", "Editado con Exito");
                RequestContext.getCurrentInstance().execute("PF('digAnularAprobarSolicitudes').hide()");
            /*    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecciono el Pedido Nro: "+pedido.getIdSolicitudPedido())); */
            
            }else{
                RequestContext.getCurrentInstance().update("formSolicitud:gSolicitudesPedidos");
                Metodos.Mensajes("Error", "Error al Editar");
             /*   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Pedido para continuar",""));      */
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formSolicitud");
            Metodos.Mensajes("Error", "Error al Editar");
        /*    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Editar" + e,""));  */          
        }
    }
    public void Anular(){
        try {            
            if(pedido_aux != null){
                pedido=pedido_aux;
                pedido.setEstado("X");
                pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                SolicitudesPedidosFacade.edit(pedido);            

                RequestContext.getCurrentInstance().execute("PF('digAnularAprobarSolicitudes').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobarSolicitudes");
                RequestContext.getCurrentInstance().update("formSolicitude");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Anulado con Exito. Pedido Nro: "+pedido.getIdSolicitudPedido()));   
                Nuevo();
            }else{
                RequestContext.getCurrentInstance().update("formSolicitud:gSolicitudesPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Pedido para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formSolicitud");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Anular" + e,""));            
        }
    }

    public void Menu() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath + "/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error" + ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formSolicitud");
        }
    }

    public void Salir() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        ((HttpSession) ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath + "/faces/formularios/Acceso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error" + ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formSolicitud");
        }
    }
}
