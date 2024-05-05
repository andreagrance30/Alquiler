
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;


import Entidades.SolicitudesPedidosDet;
import Entidades.PresupuestosClientes;
import Entidades.PresupuestosClientesDet;
import Entidades.PresupuestosClientesDetPK;
import Facades.SolicitudesPedidosDetFacade;
import Facades.PresupuestosClientesDetFacade;
import Facades.PresupuestosClientesFacade;
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
import utils.Metodos;

/**
 *
 * @author 
 */
@Named(value = "beanPresupuestosClientes")
@SessionScoped
public class BeanPresupuestosClientes implements Serializable {

    @EJB
    private PresupuestosClientesFacade PresupuestosClientesFacade;
    @EJB
    private PresupuestosClientesDetFacade PresupuestosClientesDetFacade;
    @EJB
    private SolicitudesPedidosDetFacade SolicitudesPedidosDetFacade;   

    private List<PresupuestosClientes> listaPresupuestosClientes,listaPresupuestosClientesPendientes;
    private List<PresupuestosClientesDet> listaPresupuestosClientesDet, listaPresupuestosClientesDetAux;    

    private PresupuestosClientes presupuesto, presupuesto_aux, presupuesto_rep;
    private PresupuestosClientesDet presupuestodet;
    private PresupuestosClientesDetPK presupuestodetpk;
    
    public BeanPresupuestosClientes() {
        listaPresupuestosClientesPendientes = new ArrayList<>();
        listaPresupuestosClientes = new ArrayList<>();
        listaPresupuestosClientesDet = new ArrayList<>();
        listaPresupuestosClientesDetAux = new ArrayList<>();
        presupuesto = new PresupuestosClientes();
        presupuesto_aux = new PresupuestosClientes();
        presupuesto_rep = new PresupuestosClientes();
        presupuestodet = new PresupuestosClientesDet();
        presupuestodetpk = new PresupuestosClientesDetPK();
    }

    public List<PresupuestosClientes> listarPresupuestosClientes() {
        listaPresupuestosClientes = PresupuestosClientesFacade.findAll();
        return listaPresupuestosClientes;
    }
    
    public List<PresupuestosClientes> listarPresupuestosClientesPendientes() {
        listaPresupuestosClientesPendientes = PresupuestosClientesFacade.obtenerPresupuestosClientesPorEstado("C");
        return listaPresupuestosClientesPendientes;
    }

    public List<PresupuestosClientesDet> listarPresupuestosClientesDet() {
        return listaPresupuestosClientesDet;
    }

    public PresupuestosClientes getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(PresupuestosClientes presupuesto) {
        this.presupuesto = presupuesto;
    }

    public PresupuestosClientesDet getPresupuestodet() {
        return presupuestodet;
    }

    public void setPresupuestodet(PresupuestosClientesDet presupuestodet) {
        this.presupuestodet = presupuestodet;
    }

    public PresupuestosClientes getPresupuesto_aux() {
        return presupuesto_aux;
    }

    public void setPresupuesto_aux(PresupuestosClientes presupuesto_aux) {
        this.presupuesto_aux = presupuesto_aux;
    }
        

    @PostConstruct
    public void RutinaInicial(){
        listaPresupuestosClientesPendientes = new ArrayList<>();
        listaPresupuestosClientes = new ArrayList<>();
        listaPresupuestosClientesDet = new ArrayList<>();
        listaPresupuestosClientesDetAux = new ArrayList<>();
        presupuesto = new PresupuestosClientes();
        presupuesto_aux = new PresupuestosClientes();
        presupuesto_rep = new PresupuestosClientes();
        presupuestodet = new PresupuestosClientesDet();
        presupuestodetpk = new PresupuestosClientesDetPK();  
    }
    
    public void Inicializa() {
  //     presupuesto.setIdPresupuestoCliente(BigInteger.ZERO);   
        presupuesto.setFechaPresupuesto(new Date());
    //    presupuesto.setValidezPresupuesto(new Date());
    }
    
    public void Reporte() throws IOException, JRException, SQLException {
        JasperPrint jasperPrint;
        String nombreJasper = "PresupuestosClientes.jasper";
        String nombrepdf = "Presupuesto Nro:"+presupuesto_rep.getIdPresupuestoCliente()+".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_presupuesto", presupuesto_rep.getIdPresupuestoCliente());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }    

    public void Nuevo() throws ParseException {
        listaPresupuestosClientesPendientes = new ArrayList<>();
        listaPresupuestosClientes = new ArrayList<>();
        listaPresupuestosClientesDet = new ArrayList<>();
        listaPresupuestosClientesDetAux = new ArrayList<>();
        presupuesto = new PresupuestosClientes();
        presupuesto_aux = new PresupuestosClientes();
        presupuestodet = new PresupuestosClientesDet();
        presupuestodetpk = new PresupuestosClientesDetPK();
        
        Inicializa();
         Metodos.Mensajes("Correcto", "Restablecido con Exito");
         RequestContext.getCurrentInstance().update("formPresupuestosClientes");
    }
    
    public void CargaDetalle(){
        List<SolicitudesPedidosDet> listapedidosdet;
        listaPresupuestosClientesDet.clear();
        if(presupuesto.getIdSolicitudPedido()!=null){
            listapedidosdet= SolicitudesPedidosDetFacade.obtenerSolicitudesPedidosDet(presupuesto.getIdSolicitudPedido().getIdSolicitudPedido());
            for (int i = 0; i < listapedidosdet.size(); i++) {
                if(presupuesto.getIdPresupuestoCliente()!=null){                    
                    presupuestodet = new PresupuestosClientesDet();
                    presupuestodetpk = new PresupuestosClientesDetPK();
                    
                    presupuestodetpk.setIdDeposito(listapedidosdet.get(i).getStock().getDepositos().getIdDeposito());
                    presupuestodetpk.setIdProducto(listapedidosdet.get(i).getStock().getProductos().getIdProducto());
                    presupuestodetpk.setIdPresupuestoCliente(presupuesto.getIdPresupuestoCliente());            

                    presupuestodet.setPresupuestosClientesDetPK(presupuestodetpk);
                    presupuestodet.setStock(listapedidosdet.get(i).getStock());
                    presupuestodet.setCantidad(listapedidosdet.get(i).getCantidad()/*.subtract(PresupuestosClientesDetFacade.totalCantidadProductoAprobado(presupuesto.getIdPedido(),presupuestodet.getStock()))*/);
                    presupuestodet.setPorcIva(listapedidosdet.get(i).getStock().getProductos().getIdImpuesto().getPorcIva());
                    presupuestodet.setPrecioUni(listapedidosdet.get(i).getStock().getProductos().getPrecioCompra());            
                    listaPresupuestosClientesDet.add(presupuestodet);
                }else{                    
                    presupuestodet = new PresupuestosClientesDet();
                    presupuestodetpk = new PresupuestosClientesDetPK();
                    
                    presupuestodetpk.setIdDeposito(listapedidosdet.get(i).getStock().getDepositos().getIdDeposito());
                    presupuestodetpk.setIdProducto(listapedidosdet.get(i).getStock().getProductos().getIdProducto());
                    presupuestodetpk.setIdPresupuestoCliente(0);

                    presupuestodet.setPresupuestosClientesDetPK(presupuestodetpk);
                    presupuestodet.setStock(listapedidosdet.get(i).getStock());
                    presupuestodet.setCantidad(listapedidosdet.get(i).getCantidad()/*.subtract(PresupuestosClientesDetFacade.totalCantidadProductoAprobado(presupuesto.getIdPedido(),presupuestodet.getStock()))*/);
                    presupuestodet.setPorcIva(listapedidosdet.get(i).getStock().getProductos().getIdImpuesto().getPorcIva());
                    presupuestodet.setPrecioUni(listapedidosdet.get(i).getStock().getProductos().getPrecioCompra());            
                    listaPresupuestosClientesDet.add(presupuestodet);                
                }
            }
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
       //     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle de Pedido Cargado"));
            Metodos.Mensajes("Correcto", "Detalle de Pedido Cargado");
            RequestContext.getCurrentInstance().update("formPresupuestosClientes:tbPresupuestosClientesDet");
        }else{
            listaPresupuestosClientesDet.clear();
            RequestContext.getCurrentInstance().update("formPresupuestosClientes:tbPresupuestosClientesDet");
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
             Metodos.Mensajes("Advertencia", "Debe Seleccionar Pedido");
         //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar Pedido",""));                
        }
    }
    
    public void EliminarProducto() {
        for (int i = 0; i < listaPresupuestosClientesDet.size(); i++) {
            PresupuestosClientesDet fila = listaPresupuestosClientesDet.get(i);
            if (Objects.equals(presupuestodet.getStock().getProductos().getIdProducto(), fila.getStock().getProductos().getIdProducto())) {
                listaPresupuestosClientesDet.remove(i);
                RequestContext.getCurrentInstance().update("formPresupuestosClientes");
          //      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                
                RequestContext.getCurrentInstance().update("formPresupuestosClientes:tbPresupuestosClientesDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");
            }
        }
    }

    public void EditarProducto() {
       SolicitudesPedidosDet pedidodet =SolicitudesPedidosDetFacade.obtenerPedidoDet(presupuesto.getIdSolicitudPedido().getIdSolicitudPedido(),presupuestodet.getStock());
        if(presupuestodet.getCantidad().intValue()==0){
            RequestContext.getCurrentInstance().update("formEditarProductoPresuCli");
      //      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0","")); 
             Metodos.Mensajes("Advertencia", "La cantidad no puede ser 0");
        }else if(presupuestodet.getPrecioUni().intValue()==0){
            RequestContext.getCurrentInstance().update("formEditarProductoPresuCli");
        //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));       
            Metodos.Mensajes("Advertencia", "La cantidad no puede ser 0");
        }else if(presupuestodet.getCantidad().compareTo(pedidodet.getCantidad().subtract(PresupuestosClientesDetFacade.totalCantidadProductoAprobado(presupuesto.getIdSolicitudPedido(),presupuestodet.getStock())))>0){
            RequestContext.getCurrentInstance().update("formEditarProductoPresuCli");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede pasar la cantidad de "+pedidodet.getCantidad().subtract(PresupuestosClientesDetFacade.totalCantidadProductoAprobado(presupuesto.getIdSolicitudPedido(),presupuestodet.getStock())),""));           
        }else{
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
        //    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
            Metodos.Mensajes("Correcto", "Producto Editado");
            RequestContext.getCurrentInstance().update("formPresupuestosClientes:tbPresupuestosClientesDet");
            RequestContext.getCurrentInstance().execute("PF('digEditarProductoPresuCli').hide()");            
        }
    }

    public void Grabar() {
        try {
            if (listaPresupuestosClientesDet.isEmpty()) {
                //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede grabar sin detalle",""));
                Metodos.Mensajes("Advertencia", "No puede grabar sin detalle");
                RequestContext.getCurrentInstance().update("formPresupuestosClientes");
            }else if(!(presupuesto.getIdSolicitudPedido()!=null)){
              //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede grabar sin pedido",""));
                Metodos.Mensajes("Advertencia", "No puede grabar sin  Solicitud Pedido");
                RequestContext.getCurrentInstance().update("formPresupuestosClientes");
            }else if((presupuesto.getIdPresupuestoCliente()!=null)&&(Metodos.FormatoFecha(presupuesto.getFechaPresupuesto()).compareTo(Metodos.FormatoFecha(presupuesto_aux.getFechaPresupuesto()))<0)){
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Fecha Presupuesto no puede ser menor que que la fecha ya ingresada",""));
                Metodos.Mensajes("Advertencia", "Fecha Presupuesto no puede ser menor que que la fecha ya ingresada");
                RequestContext.getCurrentInstance().update("formPresupuestosClientes");
            }else if(presupuesto.getIdPresupuestoCliente()!=null){                
                    presupuesto.setFechaPresupuesto(new Date());
                    presupuesto.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    PresupuestosClientesFacade.edit(presupuesto);
                    for (int i = 0; i < listaPresupuestosClientesDetAux.size(); i++) {
                        PresupuestosClientesDetFacade.remove(listaPresupuestosClientesDetAux.get(i));
                    }                
                    for (int f = 0; f < listaPresupuestosClientesDet.size(); f++) {
                        presupuestodet = new PresupuestosClientesDet(); 
                        presupuestodetpk = new PresupuestosClientesDetPK(); 
                        presupuestodet = listaPresupuestosClientesDet.get(f);                               
                         presupuestodetpk.setIdDeposito(presupuestodet.getStock().getDepositos().getIdDeposito());
                        presupuestodetpk.setIdProducto(presupuestodet.getStock().getProductos().getIdProducto());
                        presupuestodetpk.setIdPresupuestoCliente(presupuesto.getIdPresupuestoCliente());
                        presupuestodet.setPresupuestosClientesDetPK(presupuestodetpk);
                        presupuestodet.setStock(presupuestodet.getStock());
                        presupuestodet.setPresupuestosClientes(presupuesto);
                        PresupuestosClientesDetFacade.create(presupuestodet);                    
                    }

                    RequestContext.getCurrentInstance().update("formPresupuestosClientes");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Editado con Exito. Presupuesto Nro: "+presupuesto.getIdPresupuestoCliente())); 
                    Metodos.Mensajes("Correcto", "Editado con Exito. Presupuesto Nro: "+ presupuesto.getIdPresupuestoCliente());
                    Nuevo();                             
            }else if(Metodos.FormatoFecha(presupuesto.getFechaPresupuesto()).compareTo(Metodos.FormatoFecha(new Date()))<0){
              //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Fecha Presupuesto no puede ser menor que que la fecha del dia",""));
                Metodos.Mensajes("Advertencia", "Fecha Presupuesto no puede ser menor que que la fecha del dia");
                RequestContext.getCurrentInstance().update("formPresupuestosClientes");
            }else{
                    presupuesto.setEstado("C");
                    presupuesto.setFechaPresupuesto(new Date());
                    presupuesto.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    PresupuestosClientesFacade.create(presupuesto);
                    for (int f = 0; f < listaPresupuestosClientesDet.size(); f++) {
                        presupuestodet = new PresupuestosClientesDet();
                        presupuestodetpk = new PresupuestosClientesDetPK();                   
                        presupuestodet = listaPresupuestosClientesDet.get(f);                    
                        presupuestodetpk.setIdDeposito(presupuestodet.getStock().getDepositos().getIdDeposito());
                        presupuestodetpk.setIdProducto(presupuestodet.getStock().getProductos().getIdProducto());
                        presupuestodetpk.setIdPresupuestoCliente(presupuesto.getIdPresupuestoCliente());
                        presupuestodet.setStock(presupuestodet.getStock());
                        presupuestodet.setPresupuestosClientes(presupuesto);                        
                        presupuestodet.setPresupuestosClientesDetPK(presupuestodetpk);
                        PresupuestosClientesDetFacade.create(presupuestodet);                    
                    }

                    RequestContext.getCurrentInstance().update("formPresupuestosClientes");
                 //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito. Presupuesto Nro: "+presupuesto.getIdPresupuestoCliente()));       
                    Metodos.Mensajes("Correcto", "Grabado con Exito. Presupuesto Nro: "+ presupuesto.getIdPresupuestoCliente());
                    Nuevo();     
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
      //      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar " + e,""));
            Metodos.Mensajes("Error", "Error al grabar"+e);
        }
    }
    public void ObtienePresupuestoDet(){
        listaPresupuestosClientesDet=PresupuestosClientesDetFacade.obtenerPresupuestosClientesDet(presupuesto_aux.getIdPresupuestoCliente());
        listaPresupuestosClientesDetAux = PresupuestosClientesDetFacade.obtenerPresupuestosClientesDet(presupuesto_aux.getIdPresupuestoCliente());
        RequestContext.getCurrentInstance().update("formAnularAprobarPresuCli:tbPresupuestosClientesDetalle");
        RequestContext.getCurrentInstance().update("formPresupuestosClientes:gPresupuestosClientes");
    //    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle Obtenido"));
        Metodos.Mensajes("Correcto", "Detalle Obtenido");
    }
    
    public void Aprobar(){
        try {        
            if(presupuesto_aux != null){                
                presupuesto=PresupuestosClientesFacade.obtenerPresupuestosClientes(presupuesto_aux);
                if(!presupuesto.getIdSolicitudPedido().getEstado().equals("P")){
                    presupuesto.setEstado("A");
              //      presupuesto.setFechaCarga(new Date());
                    presupuesto.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    PresupuestosClientesFacade.edit(presupuesto);      

                    RequestContext.getCurrentInstance().execute("PF('digAnularAprobarPresuCli').hide()");
                    RequestContext.getCurrentInstance().update("formAnularAprobarPresuCli");
                    RequestContext.getCurrentInstance().update("formPresupuestosClientes");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aprobado con Exito. Presupuesto Nro: "+presupuesto.getIdPresupuestoCliente()));  
                    Metodos.Mensajes("Correcto", "Aprobado con Exito. Presupuesto Nro:" +presupuesto.getIdPresupuestoCliente());
                    Nuevo();

                    presupuesto_rep = new PresupuestosClientes();
                    presupuesto_rep = presupuesto;           
                    RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()");                   
                }else{
                    Nuevo();
                    RequestContext.getCurrentInstance().update("formAnularAprobar");
                    RequestContext.getCurrentInstance().update("formPresupuestosClientes:gPresupuestosClientes");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El pedido ya esta procesado",""));
                    Metodos.Mensajes("Advertencia", "El pedido ya esta procesado");
                }                 
                         
            }else{
                RequestContext.getCurrentInstance().update("formPresupuestosClientes:gPresupuestosClientes");
               // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe Seleccionar un Presupuesto para continuar")); 
                Metodos.Mensajes("Advertencia", "Debe Seleccionar un Presupuesto para continuar");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Aprobar" + e,""));            
        }                   
    }
    public void Editar(){
        try {            
            if(presupuesto_aux != null){
                presupuesto=PresupuestosClientesFacade.obtenerPresupuestosClientes(presupuesto_aux);
                if(!presupuesto.getIdSolicitudPedido().getEstado().equals("P")){
                    RequestContext.getCurrentInstance().execute("PF('digAnularAprobarPresuCli').hide()");
                    RequestContext.getCurrentInstance().update("formAnularAprobarPresuCli");
                    RequestContext.getCurrentInstance().update("formPresupuestosClientes");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecciono el Presupuesto Nro: "+presupuesto.getIdPresupuestoCliente()));                     
                }else{
                    Nuevo();
                    RequestContext.getCurrentInstance().update("formAnularAprobar");
                    RequestContext.getCurrentInstance().update("formPresupuestosClientes:gPresupuestosClientes");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El pedido ya esta procesado",""));      
                } 
            }else{
                RequestContext.getCurrentInstance().update("formPresupuestosClientes:gPresupuestosClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Presupuesto para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Editar" + e,""));            
        }
    }
    public void Anular(){
        try {            
            if(presupuesto_aux != null){
                presupuesto=PresupuestosClientesFacade.obtenerPresupuestosClientes(presupuesto_aux);
                presupuesto.setEstado("X");
              //  presupuesto.setFechaCarga(new Date());
                presupuesto.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                PresupuestosClientesFacade.edit(presupuesto);            

                RequestContext.getCurrentInstance().execute("PF('digAnularAprobarPresuCli').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobarPresuCli");
                RequestContext.getCurrentInstance().update("formPresupuestosClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Anulado con Exito. Presupuesto Nro: "+presupuesto.getIdPresupuestoCliente()));   
                Nuevo();
            }else{
                RequestContext.getCurrentInstance().update("formPresupuestosClientes:gPresupuestosClientes");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Presupuesto para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
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
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
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
            RequestContext.getCurrentInstance().update("formPresupuestosClientes");
        }
    }
}
