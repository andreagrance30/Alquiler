
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;


import Entidades.PedidosDet;
import Entidades.Presupuestos;
import Entidades.PresupuestosDet;
import Entidades.PresupuestosDetPK;
import Facades.PedidosDetFacade;
import Facades.PresupuestosDetFacade;
import Facades.PresupuestosFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
@Named(value = "beanPresupuestos")
@SessionScoped
public class BeanPresupuestos implements Serializable {

    @EJB
    private PresupuestosFacade PresupuestosFacade;
    @EJB
    private PresupuestosDetFacade PresupuestosDetFacade;
    @EJB
    private PedidosDetFacade PedidosDetFacade;   

    private List<Presupuestos> listaPresupuestos,listaPresupuestosPendientes;
    private List<PresupuestosDet> listaPresupuestosDet, listaPresupuestosDetAux;    

    private Presupuestos presupuesto, presupuesto_aux, presupuesto_rep;
    private PresupuestosDet presupuestodet;
    private PresupuestosDetPK presupuestodetpk;
    
    public BeanPresupuestos() {
        listaPresupuestosPendientes = new ArrayList<>();
        listaPresupuestos = new ArrayList<>();
        listaPresupuestosDet = new ArrayList<>();
        listaPresupuestosDetAux = new ArrayList<>();
        presupuesto = new Presupuestos();
        presupuesto_aux = new Presupuestos();
        presupuesto_rep = new Presupuestos();
        presupuestodet = new PresupuestosDet();
        presupuestodetpk = new PresupuestosDetPK();
    }

    public List<Presupuestos> listarPresupuestos() {
        listaPresupuestos = PresupuestosFacade.findAll();
        return listaPresupuestos;
    }
    
    public List<Presupuestos> listarPresupuestosPendientes() {
        listaPresupuestosPendientes = PresupuestosFacade.obtenerPresupuestosPorEstado("C");
        return listaPresupuestosPendientes;
    }

    public List<PresupuestosDet> listarPresupuestosDet() {
        return listaPresupuestosDet;
    }

    public Presupuestos getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuestos presupuesto) {
        this.presupuesto = presupuesto;
    }

    public PresupuestosDet getPresupuestodet() {
        return presupuestodet;
    }

    public void setPresupuestodet(PresupuestosDet presupuestodet) {
        this.presupuestodet = presupuestodet;
    }

    public Presupuestos getPresupuesto_aux() {
        return presupuesto_aux;
    }

    public void setPresupuesto_aux(Presupuestos presupuesto_aux) {
        this.presupuesto_aux = presupuesto_aux;
    }
        

    @PostConstruct
    public void RutinaInicial(){
        listaPresupuestosPendientes = new ArrayList<>();
        listaPresupuestos = new ArrayList<>();
        listaPresupuestosDet = new ArrayList<>();
        listaPresupuestosDetAux = new ArrayList<>();
        presupuesto = new Presupuestos();
        presupuesto_aux = new Presupuestos();
        presupuesto_rep = new Presupuestos();
        presupuestodet = new PresupuestosDet();
        presupuestodetpk = new PresupuestosDetPK();  
    }
    
    public void Inicializa() {
        presupuesto.setNroPresupuesto(BigDecimal.ZERO);   
        presupuesto.setFechaPresupuesto(new Date());
        presupuesto.setValidezPresupuesto(new Date());
    }
    
    public void Reporte() throws IOException, JRException, SQLException {
        JasperPrint jasperPrint;
        String nombreJasper = "Presupuestos.jasper";
        String nombrepdf = "Presupuesto Nro:"+presupuesto_rep.getIdPresupuesto()+".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_presupuesto", presupuesto_rep.getIdPresupuesto());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }    

    public void Nuevo() throws ParseException {
        listaPresupuestosPendientes = new ArrayList<>();
        listaPresupuestos = new ArrayList<>();
        listaPresupuestosDet = new ArrayList<>();
        listaPresupuestosDetAux = new ArrayList<>();
        presupuesto = new Presupuestos();
        presupuesto_aux = new Presupuestos();
        presupuestodet = new PresupuestosDet();
        presupuestodetpk = new PresupuestosDetPK();
        
        Inicializa();
        RequestContext.getCurrentInstance().execute("PF('wtbPresupuestosCabecera').unselectAllRows()");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Restablecido con exito"));
        RequestContext.getCurrentInstance().update("formPresupuestos");
    }
    
    public void CargaDetalle(){
        List<PedidosDet> listapedidosdet;
        listaPresupuestosDet.clear();
        if(presupuesto.getIdPedido()!=null){
            listapedidosdet= PedidosDetFacade.obtenerPedidosDet(presupuesto.getIdPedido().getIdPedido());
            for (int i = 0; i < listapedidosdet.size(); i++) {
                if(presupuesto.getIdPresupuesto()!=null){                    
                    presupuestodet = new PresupuestosDet();
                    presupuestodetpk = new PresupuestosDetPK();
                    
                    presupuestodetpk.setIdDeposito(listapedidosdet.get(i).getStock().getDepositos().getIdDeposito());
                    presupuestodetpk.setIdProducto(listapedidosdet.get(i).getStock().getProductos().getIdProducto());
                    presupuestodetpk.setIdPresupuesto(presupuesto.getIdPresupuesto());            

                    presupuestodet.setPresupuestosDetPK(presupuestodetpk);
                    presupuestodet.setStock(listapedidosdet.get(i).getStock());
                    presupuestodet.setCantidad(listapedidosdet.get(i).getCantidad()/*.subtract(PresupuestosDetFacade.totalCantidadProductoAprobado(presupuesto.getIdPedido(),presupuestodet.getStock()))*/);
                    presupuestodet.setPorcIva(listapedidosdet.get(i).getStock().getProductos().getIdImpuesto().getPorcIva());
                    presupuestodet.setPrecioUni(listapedidosdet.get(i).getStock().getProductos().getPrecioCompra());            
                    listaPresupuestosDet.add(presupuestodet);
                }else{                    
                    presupuestodet = new PresupuestosDet();
                    presupuestodetpk = new PresupuestosDetPK();
                    
                    presupuestodetpk.setIdDeposito(listapedidosdet.get(i).getStock().getDepositos().getIdDeposito());
                    presupuestodetpk.setIdProducto(listapedidosdet.get(i).getStock().getProductos().getIdProducto());
                    presupuestodetpk.setIdPresupuesto(0);

                    presupuestodet.setPresupuestosDetPK(presupuestodetpk);
                    presupuestodet.setStock(listapedidosdet.get(i).getStock());
                    presupuestodet.setCantidad(listapedidosdet.get(i).getCantidad()/*.subtract(PresupuestosDetFacade.totalCantidadProductoAprobado(presupuesto.getIdPedido(),presupuestodet.getStock()))*/);
                    presupuestodet.setPorcIva(listapedidosdet.get(i).getStock().getProductos().getIdImpuesto().getPorcIva());
                    presupuestodet.setPrecioUni(listapedidosdet.get(i).getStock().getProductos().getPrecioCompra());            
                    listaPresupuestosDet.add(presupuestodet);                
                }
            }
            RequestContext.getCurrentInstance().update("formPresupuestos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle de Pedido Cargado"));
            RequestContext.getCurrentInstance().update("formPresupuestos:tbPresupuestosDet");
        }else{
            listaPresupuestosDet.clear();
            RequestContext.getCurrentInstance().update("formPresupuestos:tbPresupuestosDet");
            RequestContext.getCurrentInstance().update("formPresupuestos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar Pedido",""));                
        }
    }
    
    public void EliminarProducto() {
        for (int i = 0; i < listaPresupuestosDet.size(); i++) {
            PresupuestosDet fila = listaPresupuestosDet.get(i);
            if (fila.getStock().getProductos().getIdProducto() == presupuestodet.getStock().getProductos().getIdProducto()) {
                listaPresupuestosDet.remove(i);
                RequestContext.getCurrentInstance().update("formPresupuestos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                RequestContext.getCurrentInstance().update("formPresupuestos:tbPresupuestosDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");
            }
        }
    }

    public void EditarProducto() {
        PedidosDet pedidodet =PedidosDetFacade.obtenerPedidoDet(presupuesto.getIdPedido().getIdPedido(),presupuestodet.getStock());
        if(presupuestodet.getCantidad().intValue()==0){
            RequestContext.getCurrentInstance().update("formAgregarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
        }else if(presupuestodet.getPrecioUni().intValue()==0){
            RequestContext.getCurrentInstance().update("formAgregarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));           
        }else if(presupuestodet.getCantidad().compareTo(pedidodet.getCantidad()/*.subtract(PresupuestosDetFacade.totalCantidadProductoAprobado(presupuesto.getIdPedido(),presupuestodet.getStock()))*/)>0){
            RequestContext.getCurrentInstance().update("formAgregarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede pasar la cantidad de "+pedidodet.getCantidad()/*.subtract(PresupuestosDetFacade.totalCantidadProductoAprobado(presupuesto.getIdPedido(),presupuestodet.getStock()))*/,""));           
        }else{
            RequestContext.getCurrentInstance().update("formPresupuestos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
            RequestContext.getCurrentInstance().update("formPresupuestos:tbPresupuestosDet");
            RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");            
        }
    }

    public void Grabar() {
        try {
            if (listaPresupuestosDet.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede grabar sin detalle",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");
            }else if(!(presupuesto.getIdPedido()!=null)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede grabar sin pedido",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");
            }else if(presupuesto.getNroPresupuesto().compareTo(BigDecimal.ZERO)==0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Agregar Nro Presupuesto",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");
            }else if((presupuesto.getIdPresupuesto()!=null)&&(Metodos.FormatoFecha(presupuesto.getFechaPresupuesto()).compareTo(Metodos.FormatoFecha(presupuesto_aux.getFechaPresupuesto()))<0)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Fecha Presupuesto no puede ser menor que que la fecha ya ingresada",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");
            }else if(Metodos.FormatoFecha(presupuesto.getFechaPresupuesto()).compareTo(Metodos.FormatoFecha(presupuesto.getValidezPresupuesto()))>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Fecha Validez no pude ser menor que Fecha Presupuesto",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");
            }else if((presupuesto.getIdPresupuesto()!=null)&&(!presupuesto_aux.getNroPresupuesto().equals(presupuesto.getNroPresupuesto()))&&(PresupuestosFacade.validaNroPresupuestoProveedor(presupuesto).equals(true))){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Nro Presupuesto de proveedor ya existente",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");            
            }else if(PresupuestosFacade.validaPresupuestoProveedor(presupuesto).equals(true)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Existe un presupuesto Aprobado o Cargado del mismo proveedor y pedido, verifique",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");            
            }else if(presupuesto.getIdPresupuesto()!=null){                
                    presupuesto.setFechaCarga(new Date());
                    presupuesto.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    PresupuestosFacade.edit(presupuesto);
                    for (int i = 0; i < listaPresupuestosDetAux.size(); i++) {
                        PresupuestosDetFacade.remove(listaPresupuestosDetAux.get(i));
                    }                
                    for (int f = 0; f < listaPresupuestosDet.size(); f++) {
                        presupuestodet = new PresupuestosDet();
                        presupuestodetpk = new PresupuestosDetPK(); 

                        presupuestodet = listaPresupuestosDet.get(f);                               
                        presupuestodetpk.setIdDeposito(presupuestodet.getStock().getDepositos().getIdDeposito());
                        presupuestodetpk.setIdProducto(presupuestodet.getStock().getProductos().getIdProducto());
                        presupuestodetpk.setIdPresupuesto(presupuesto.getIdPresupuesto());
                        presupuestodet.setPresupuestosDetPK(presupuestodetpk);
                        presupuestodet.setStock(presupuestodet.getStock());
                        presupuestodet.setPresupuestos(presupuesto);
                        PresupuestosDetFacade.create(presupuestodet);                    
                    }

                    RequestContext.getCurrentInstance().update("formPresupuestos");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Editado con Exito. Presupuesto Nro: "+presupuesto.getIdPresupuesto()));       
                    Nuevo();                             
            }else if(PresupuestosFacade.validaNroPresupuestoProveedor(presupuesto).equals(true)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Nro Presupuesto de proveedor ya existente",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");         
            }else if(Metodos.FormatoFecha(presupuesto.getFechaPresupuesto()).compareTo(Metodos.FormatoFecha(new Date()))<0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Fecha Presupuesto no puede ser menor que que la fecha del dia",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");
            }else if(Metodos.FormatoFecha(presupuesto.getFechaPresupuesto()).compareTo(Metodos.FormatoFecha(presupuesto.getValidezPresupuesto()))>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Fecha Validez no pude ser menor que Fecha Presupuesto",""));
                RequestContext.getCurrentInstance().update("formPresupuestos");
            }else{
                    presupuesto.setEstado("C");
                    presupuesto.setFechaCarga(new Date());
                    presupuesto.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    PresupuestosFacade.create(presupuesto);
                    for (int f = 0; f < listaPresupuestosDet.size(); f++) {
                        presupuestodet = new PresupuestosDet();
                        presupuestodetpk = new PresupuestosDetPK();                   
                        presupuestodet = listaPresupuestosDet.get(f);                    
                        presupuestodetpk.setIdDeposito(presupuestodet.getStock().getDepositos().getIdDeposito());
                        presupuestodetpk.setIdProducto(presupuestodet.getStock().getProductos().getIdProducto());
                        presupuestodetpk.setIdPresupuesto(presupuesto.getIdPresupuesto());
                        presupuestodet.setStock(presupuestodet.getStock());
                        presupuestodet.setPresupuestos(presupuesto);                        
                        presupuestodet.setPresupuestosDetPK(presupuestodetpk);
                        PresupuestosDetFacade.create(presupuestodet);                    
                    }

                    RequestContext.getCurrentInstance().update("formPresupuestos");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito. Presupuesto Nro: "+presupuesto.getIdPresupuesto()));       
                    Nuevo();     
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPresupuestos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar " + e,""));
        }
    }
    public void ObtienePresupuestoDet(){
        listaPresupuestosDet=PresupuestosDetFacade.obtenerPresupuestosDet(presupuesto_aux.getIdPresupuesto());
        listaPresupuestosDetAux = PresupuestosDetFacade.obtenerPresupuestosDet(presupuesto_aux.getIdPresupuesto());
        RequestContext.getCurrentInstance().update("formAnularAprobar:tbPresupuestosDetalle");
        RequestContext.getCurrentInstance().update("formPresupuestos:gPresupuestos");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle Obtenido"));
    }
    
    public void Aprobar(){
        try {        
            if(presupuesto_aux != null){                
                presupuesto=PresupuestosFacade.obtenerPresupuestos(presupuesto_aux);
                if(!presupuesto.getIdPedido().getEstado().equals("P")){
                    presupuesto.setEstado("A");
                    presupuesto.setFechaCarga(new Date());
                    presupuesto.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    PresupuestosFacade.edit(presupuesto);      

                    RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                    RequestContext.getCurrentInstance().update("formAnularAprobar");
                    RequestContext.getCurrentInstance().update("formPresupuestos");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aprobado con Exito. Presupuesto Nro: "+presupuesto.getIdPresupuesto()));               
                    Nuevo();

                    presupuesto_rep = new Presupuestos();
                    presupuesto_rep = presupuesto;           
                    RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()");                   
                }else{
                    Nuevo();
                    RequestContext.getCurrentInstance().update("formAnularAprobar");
                    RequestContext.getCurrentInstance().update("formPresupuestos:gPresupuestos");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El pedido ya esta procesado",""));      
                }                 
                         
            }else{
                RequestContext.getCurrentInstance().update("formPresupuestos:gPresupuestos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe Seleccionar un Presupuesto para continuar")); 
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPresupuestos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Aprobar" + e,""));            
        }                   
    }
    public void Editar(){
        try {            
            if(presupuesto_aux != null){
                presupuesto=PresupuestosFacade.obtenerPresupuestos(presupuesto_aux);
                if(!presupuesto.getIdPedido().getEstado().equals("P")){
                    RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                    RequestContext.getCurrentInstance().update("formAnularAprobar");
                    RequestContext.getCurrentInstance().update("formPresupuestos");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecciono el Presupuesto Nro: "+presupuesto.getIdPresupuesto()));                     
                }else{
                    Nuevo();
                    RequestContext.getCurrentInstance().update("formAnularAprobar");
                    RequestContext.getCurrentInstance().update("formPresupuestos:gPresupuestos");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El pedido ya esta procesado",""));      
                } 
            }else{
                RequestContext.getCurrentInstance().update("formPresupuestos:gPresupuestos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Presupuesto para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPresupuestos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Editar" + e,""));            
        }
    }
    public void Anular(){
        try {            
            if(presupuesto_aux != null){
                presupuesto=PresupuestosFacade.obtenerPresupuestos(presupuesto_aux);
                presupuesto.setEstado("X");
                presupuesto.setFechaCarga(new Date());
                presupuesto.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                PresupuestosFacade.edit(presupuesto);            

                RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobar");
                RequestContext.getCurrentInstance().update("formPresupuestos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Anulado con Exito. Presupuesto Nro: "+presupuesto.getIdPresupuesto()));   
                Nuevo();
            }else{
                RequestContext.getCurrentInstance().update("formPresupuestos:gPresupuestos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Presupuesto para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPresupuestos");
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
            RequestContext.getCurrentInstance().update("formPresupuestos");
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
            RequestContext.getCurrentInstance().update("formPresupuestos");
        }
    }
}
