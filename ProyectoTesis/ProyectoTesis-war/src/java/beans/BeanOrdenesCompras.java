/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.PedidosDet;
import Entidades.OrdenesCompras;
import Entidades.OrdenesComprasDet;
import Entidades.OrdenesComprasDetPK;
import Entidades.Pedidos;
import Entidades.Presupuestos;
import Entidades.PresupuestosDet;
import Entidades.PresupuestosDetPK;
import Entidades.Stock;
import Facades.PedidosDetFacade;
import Facades.PedidosFacade;
import Facades.OrdenesComprasDetFacade;
import Facades.OrdenesComprasFacade;
import Facades.PresupuestosDetFacade;
import Facades.PresupuestosFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
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
@Named(value = "beanOrdenesCompras")
@SessionScoped
public class BeanOrdenesCompras implements Serializable {

    @EJB
    private OrdenesComprasFacade OrdenesComprasFacade;
    @EJB
    private OrdenesComprasDetFacade OrdenesComprasDetFacade;    
    @EJB
    private PresupuestosFacade PresupuestosFacade;     
    @EJB
    private PresupuestosDetFacade PresupuestosDetFacade;  
    @EJB
    private PedidosFacade PedidosFacade;     
    @EJB
    private PedidosDetFacade PedidosDetFacade; 
    
    private List<OrdenesCompras> listaOrdenesCompras,listaOrdenesComprasPendientes, listaOrdenesComprasAprobadas;
    private List<OrdenesComprasDet> listaOrdenesComprasDet, listaOrdenesComprasDetAux;    
    private List<PedidosDet> listaPedidosDet;    

    private OrdenesCompras ordenescompras, ordenescompras_aux, ordenescompras_rep;
    private OrdenesComprasDet ordenescomprasdet;
    private OrdenesComprasDetPK ordenescomprasdetpk;
    
    public BeanOrdenesCompras() {
        listaOrdenesComprasPendientes = new ArrayList<>();
        listaOrdenesComprasAprobadas = new ArrayList<>();
        listaOrdenesCompras = new ArrayList<>();
        listaOrdenesComprasDet = new ArrayList<>();
        listaOrdenesComprasDetAux = new ArrayList<>();
        listaPedidosDet = new ArrayList<>();
        ordenescompras = new OrdenesCompras();
        ordenescompras_aux = new OrdenesCompras();
        ordenescompras_rep = new OrdenesCompras();
        ordenescomprasdet = new OrdenesComprasDet();
        ordenescomprasdetpk = new OrdenesComprasDetPK();
    }

    public List<OrdenesCompras> listarOrdenesCompras() {
        listaOrdenesCompras = OrdenesComprasFacade.findAll();
        return listaOrdenesCompras;
    }
    
    public List<OrdenesCompras> listarOrdenesComprasPendientes() {
        listaOrdenesComprasPendientes = OrdenesComprasFacade.obtenerOrdenesComprasPorEstado("C");
        return listaOrdenesComprasPendientes;
    }
    public List<OrdenesCompras> listarOrdenesComprasAprobadas() {
        listaOrdenesComprasAprobadas = OrdenesComprasFacade.obtenerOrdenesComprasPorEstado("A");
        return listaOrdenesComprasAprobadas;
    }    

    public List<OrdenesComprasDet> listarOrdenesComprasDet() {
        return listaOrdenesComprasDet;
    }
    
    public List<PedidosDet> listarPedidosDet() {
        return listaPedidosDet;
    }

    public OrdenesCompras getOrdenescompras() {
        return ordenescompras;
    }

    public void setOrdenescompras(OrdenesCompras ordenescompras) {
        this.ordenescompras = ordenescompras;
    }

    public OrdenesCompras getOrdenescompras_aux() {
        return ordenescompras_aux;
    }

    public void setOrdenescompras_aux(OrdenesCompras ordenescompras_aux) {
        this.ordenescompras_aux = ordenescompras_aux;
    }

    public OrdenesComprasDet getOrdenescomprasdet() {
        return ordenescomprasdet;
    }

    public void setOrdenescomprasdet(OrdenesComprasDet ordenescomprasdet) {
        this.ordenescomprasdet = ordenescomprasdet;
    }    
        
    @PostConstruct
    public void RutinaInicial(){
        listaOrdenesComprasPendientes = new ArrayList<>();
        listaOrdenesComprasAprobadas = new ArrayList<>();        
        listaOrdenesCompras = new ArrayList<>();
        listaOrdenesComprasDet = new ArrayList<>();
        listaOrdenesComprasDetAux = new ArrayList<>();
        listaPedidosDet = new ArrayList<>();
        ordenescompras = new OrdenesCompras();
        ordenescompras_aux = new OrdenesCompras();
        ordenescompras_rep = new OrdenesCompras();
        ordenescomprasdet = new OrdenesComprasDet();
        ordenescomprasdetpk = new OrdenesComprasDetPK();  
    }
    
    public void Inicializa() {

    }
    
    public void Reporte() throws IOException, JRException, SQLException {
        JasperPrint jasperPrint;
        String nombreJasper = "Ordenes Compras.jasper";
        String nombrepdf = "Orden de Compra Nro:"+ordenescompras_rep.getIdOrdenCompra()+".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_orden_compra", ordenescompras_rep.getIdOrdenCompra());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }    

    public void Nuevo() throws ParseException {
        listaOrdenesComprasPendientes = new ArrayList<>();
        listaOrdenesComprasAprobadas = new ArrayList<>();
        listaOrdenesCompras = new ArrayList<>();
        listaOrdenesComprasDet = new ArrayList<>();
        listaOrdenesComprasDetAux = new ArrayList<>();
        listaPedidosDet = new ArrayList<>();
        ordenescompras = new OrdenesCompras();
        ordenescompras_aux = new OrdenesCompras();
        ordenescomprasdet = new OrdenesComprasDet();
        ordenescomprasdetpk = new OrdenesComprasDetPK();
        
        Inicializa();
        Metodos.Mensajes("Correcto", "Restablecido con exito");
        RequestContext.getCurrentInstance().update("formOrdenesCompras");
    }
    
    public void CargaDetalle(){
        List<PresupuestosDet> listapresupuestosdet;
        listaOrdenesComprasDet.clear();
        listaPedidosDet.clear();
        if(ordenescompras.getIdPedido()!=null){
            listapresupuestosdet = PresupuestosDetFacade.obtenerPresupuestosDetPedido(ordenescompras.getIdPedido().getIdPedido());
            listaPedidosDet = PedidosDetFacade.obtenerPedidosDet(ordenescompras.getIdPedido().getIdPedido());
          if(listapresupuestosdet!=null){                            
                for (int i = 0; i < listapresupuestosdet.size(); i++) {
                    if(ordenescompras.getIdOrdenCompra()!=null){                    
                        ordenescomprasdet = new OrdenesComprasDet();
                        ordenescomprasdetpk = new OrdenesComprasDetPK();
                        
                        PresupuestosDet presupuestodet = listapresupuestosdet.get(i);
                        PresupuestosDetPK presupuestodetpk = listapresupuestosdet.get(i).getPresupuestosDetPK();
                        presupuestodet.setPresupuestosDetPK(presupuestodetpk);                        
                        
                        ordenescomprasdetpk.setIdDeposito(presupuestodet.getPresupuestosDetPK().getIdDeposito());
                        ordenescomprasdetpk.setIdProducto(presupuestodet.getPresupuestosDetPK().getIdProducto());
                        ordenescomprasdetpk.setIdPresupuesto (presupuestodet.getPresupuestosDetPK().getIdPresupuesto());
                        ordenescomprasdetpk.setIdOrdenCompra(ordenescompras.getIdOrdenCompra());            

                        ordenescomprasdet.setOrdenesComprasDetPK(ordenescomprasdetpk);
                        ordenescomprasdet.setIdPresupuesto(presupuestodet.getPresupuestos());
                        ordenescomprasdet.setCantidad(presupuestodet.getCantidad());
                        ordenescomprasdet.setPorcIva(presupuestodet.getStock().getProductos().getIdImpuesto().getPorcIva());
                        ordenescomprasdet.setPrecioUni(presupuestodet.getStock().getProductos().getPrecioCompra());            
                        listaOrdenesComprasDet.add(ordenescomprasdet);
                        
                    }else{                  
                        ordenescomprasdet = new OrdenesComprasDet();
                        ordenescomprasdetpk = new OrdenesComprasDetPK();
                        PresupuestosDet presupuestodet = listapresupuestosdet.get(i);
                        PresupuestosDetPK presupuestodetpk = listapresupuestosdet.get(i).getPresupuestosDetPK();
                        presupuestodet.setPresupuestosDetPK(presupuestodetpk);
                        
                        ordenescomprasdetpk.setIdDeposito(presupuestodet.getPresupuestosDetPK().getIdDeposito());
                        ordenescomprasdetpk.setIdProducto(presupuestodet.getPresupuestosDetPK().getIdProducto());
                        ordenescomprasdetpk.setIdPresupuesto(presupuestodet.getPresupuestosDetPK().getIdPresupuesto());
                        ordenescomprasdetpk.setIdOrdenCompra(0);
                        
                        ordenescomprasdet.setOrdenesComprasDetPK(ordenescomprasdetpk);
                        ordenescomprasdet.setIdPresupuesto(presupuestodet.getPresupuestos());
                        ordenescomprasdet.setCantidad(presupuestodet.getCantidad());
                        ordenescomprasdet.setPorcIva(presupuestodet.getStock().getProductos().getIdImpuesto().getPorcIva());
                        ordenescomprasdet.setPrecioUni(presupuestodet.getStock().getProductos().getPrecioCompra()); 
                        listaOrdenesComprasDet.add(ordenescomprasdet);      
                        
                    }
                }
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
            Metodos.Mensajes("Correcto", "Presupuestos Aprobados Cargado");
            RequestContext.getCurrentInstance().update("formOrdenesCompras:tbOrdenesComprasDet");                
            }else{
                RequestContext.getCurrentInstance().update("formOrdenesCompras");
                Metodos.Mensajes("Correcto", "Pedido sin Presupuestos Aprobados");
                RequestContext.getCurrentInstance().update("formOrdenesCompras:tbOrdenesComprasDet");                   
            }
        }else{
            listaOrdenesComprasDet.clear();
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar Pedido",""));                
        }
    }
    
    public void EliminarProducto() {
        for (int i = 0; i < listaOrdenesComprasDet.size(); i++) {
            OrdenesComprasDet fila = listaOrdenesComprasDet.get(i);
            if (fila.getIdPresupuesto().equals(ordenescomprasdet.getIdPresupuesto())) {
                listaOrdenesComprasDet.remove(i);
                RequestContext.getCurrentInstance().update("formOrdenesCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                RequestContext.getCurrentInstance().update("formOrdenesCompras:tbOrdenesComprasDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");
            }   
        }
    }

    public void EditarProducto() {
        PresupuestosDet presupuestodet =PresupuestosDetFacade.obtenerPresupuestoDet(ordenescomprasdet.getPresupuestosDet());
        if(ordenescomprasdet.getCantidad().intValue()==0){
            RequestContext.getCurrentInstance().update("formAgregarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
        }else if(ordenescomprasdet.getCantidad().compareTo(presupuestodet.getCantidad())>0){
            RequestContext.getCurrentInstance().update("formAgregarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede pasar la cantidad de "+presupuestodet.getCantidad(),""));           
        }else{
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
            RequestContext.getCurrentInstance().update("formOrdenesCompras:tbOrdenesComprasDet");
            RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");            
        }
    }

    public void Grabar() {
        try {
            Integer v_ban=0, v_ban1=0;
            if(ordenescompras.getIdPedido()!=null){
                System.out.println("Entra la orden de compra 1?");
                List<PedidosDet> listaPedidosDet1 = PedidosDetFacade.obtenerPedidosDet(ordenescompras.getIdPedido().getIdPedido());
                for (int i = 0; i < listaPedidosDet1.size(); i++) {
                    BigInteger v_cant= BigInteger.ZERO;     
                    System.out.println("Entra la orden de compra ciclo 1?");
                    for (int z = 0; z < listaOrdenesComprasDet.size(); z++) {
                        System.out.println("Entra la orden de compra ciclo ?");
                        if(listaOrdenesComprasDet.get(z).equals(listaPedidosDet1.get(i).getStock())){
                            v_cant= v_cant.add(listaOrdenesComprasDet.get(z).getCantidad());
                            System.out.println("Entra la orden de compra ciclo 2?");
                        }     
                     /*   if(Metodos.FormatoFecha(listaOrdenesComprasDet.get(z).getIdPresupuesto().getValidezPresupuesto()).compareTo(Metodos.FormatoFecha(new Date()))<0){
                            v_ban1++;
                             System.out.println("Entra la orden de compra ciclo 3?");
                        }*/
                    }
                    if(listaPedidosDet1.get(i).getCantidad().compareTo(v_cant)<0){
                        v_ban++;
                        System.out.println("Entra la orden de compra ciclo 3?"+v_ban);
                    }
                }  
            }     
            if (listaOrdenesComprasDet.isEmpty()) {
                Metodos.Mensajes("Advertencia", "No puede grabar sin detalle");
                RequestContext.getCurrentInstance().update("formOrdenesCompras");
            }else if(!(ordenescompras.getIdPedido()!=null)){
                 Metodos.Mensajes("Advertencia", "No puede grabar sin detalle");
                RequestContext.getCurrentInstance().update("formOrdenesCompras");
            }else if(v_ban!=0||v_ban1!=0){    
                RequestContext.getCurrentInstance().update("formOrdenesCompras");
                  Metodos.Mensajes("Advertencia", "La cantidad total de los productos supera la del pedido, o la fecha de la validez del presupuesto vencio");
            }else if(ordenescompras.getIdOrdenCompra()!=null){
                System.out.println("Entra la orden de compra 5?");
                ordenescompras.setFechaEmision(new Date());
                ordenescompras.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                OrdenesComprasFacade.edit(ordenescompras);
                
                for (int i = 0; i < listaOrdenesComprasDetAux.size(); i++) {
                    OrdenesComprasDetFacade.remove(listaOrdenesComprasDetAux.get(i));
                }                
                for (int f = 0; f < listaOrdenesComprasDet.size(); f++) {
                    System.out.println("Entra en el detalle?");
                    ordenescomprasdet = new OrdenesComprasDet();
                    ordenescomprasdetpk = new OrdenesComprasDetPK(); 
                    ordenescomprasdet = listaOrdenesComprasDet.get(f);                    
                    ordenescomprasdetpk.setIdDeposito(ordenescomprasdet.getPresupuestosDet().getStock().getDepositos().getIdDeposito());
                    ordenescomprasdetpk.setIdProducto(ordenescomprasdet.getStock().getProductos().getIdProducto());
                    ordenescomprasdetpk.setIdPresupuesto(ordenescomprasdet.getPresupuestosDet().getPresupuestos().getIdPresupuesto());
                    ordenescomprasdetpk.setIdOrdenCompra(ordenescompras.getIdOrdenCompra());
                    ordenescomprasdet.setOrdenesComprasDetPK(ordenescomprasdetpk);
                    ordenescomprasdet.setStock(ordenescomprasdet.getStock());
                    ordenescomprasdet.setOrdenesCompras(ordenescompras);
                    OrdenesComprasDetFacade.create(ordenescomprasdet);    
                }

                RequestContext.getCurrentInstance().update("formOrdenesCompras");
                Metodos.Mensajes("Advertencia", "Editado con Exito. Orden de Compra Nro:" + ordenescompras.getIdOrdenCompra());
                Nuevo();                                                                     
            }else{
                System.out.println("Entra la orden de compra 6?");
                ordenescompras.setEstado("C");
                ordenescompras.setFechaEmision(new Date());
                ordenescompras.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                OrdenesComprasFacade.create(ordenescompras);
                for (int f = 0; f < listaOrdenesComprasDet.size(); f++) {
                    ordenescomprasdet = new OrdenesComprasDet();
                    ordenescomprasdetpk = new OrdenesComprasDetPK();                   
                    ordenescomprasdet = listaOrdenesComprasDet.get(f);                    
                    ordenescomprasdetpk.setIdDeposito(ordenescomprasdet.getPresupuestosDet().getStock().getDepositos().getIdDeposito());
                    ordenescomprasdetpk.setIdProducto(ordenescomprasdet.getPresupuestosDet().getStock().getProductos().getIdProducto());                        
                    ordenescomprasdetpk.setIdPresupuesto(ordenescomprasdet.getPresupuestosDet().getPresupuestos().getIdPresupuesto());
                    ordenescomprasdetpk.setIdOrdenCompra(ordenescompras.getIdOrdenCompra());
                    ordenescomprasdet.setOrdenesComprasDetPK(ordenescomprasdetpk);
                    OrdenesComprasDetFacade.create(ordenescomprasdet);                    
                }
                RequestContext.getCurrentInstance().update("formOrdenesCompras");
            //    Metodos.Mensajes("Correcto", "Grabado con Exito. Orden de Compra Nro: " + ordenescompras.getIdOrdenCompra() );
                Metodos.Mensajes("Correcto", "Grabado con Exito. Presupuesto Nro: ");
                Nuevo();                    
            }
        } catch (ParseException e) {
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar " + e,""));
            Metodos.Mensajes("Error", "Error al grabar"+e);
        }
    }
    public void ObtieneOrdenesComprasDet(){
        
        listaOrdenesComprasDet= OrdenesComprasDetFacade.obtenerOrdenesComprasDet(ordenescompras_aux.getIdOrdenCompra());
        listaOrdenesComprasDetAux = OrdenesComprasDetFacade.obtenerOrdenesComprasDet(ordenescompras_aux.getIdOrdenCompra());
        
        RequestContext.getCurrentInstance().update("formAnularAprobar:tbOrdenesComprasDetalle");
        RequestContext.getCurrentInstance().update("formOrdenesCompras:gOrdenesCompras");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle Obtenido"));
    }
    
    public void Aprobar(){
        try {        
            if(ordenescompras_aux != null){
                Integer v_ban1=0;
                ordenescompras=OrdenesComprasFacade.obtenerOrdenesCompras(ordenescompras_aux);
                List<PedidosDet> listaPedidosDet = PedidosDetFacade.obtenerPedidosDet(ordenescompras.getIdPedido().getIdPedido());
                for (int i = 0; i < listaPedidosDet.size(); i++) {                
                    for (int z = 0; z < listaOrdenesComprasDet.size(); z++) {
                        if(Metodos.FormatoFecha(listaOrdenesComprasDet.get(z).getIdPresupuesto().getValidezPresupuesto()).compareTo(Metodos.FormatoFecha(new Date()))<0){
                            v_ban1++;
                        }
                    }

                }
                
                if(v_ban1==0){
                    Pedidos pedido = ordenescompras.getIdPedido();
                    pedido.setEstado("P");
                    PedidosFacade.edit(pedido);

                  for (int i = 0; i < listaOrdenesComprasDet.size(); i++) {
                       Presupuestos presupuesto = listaOrdenesComprasDet.get(i).getIdPresupuesto();
                        presupuesto.setEstado("P");
                        PresupuestosFacade.edit(presupuesto);
                    }   

                    ordenescompras.setEstado("A");
                    ordenescompras.setFechaEmision(new Date());
                    ordenescompras.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    OrdenesComprasFacade.edit(ordenescompras);      

                    RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                    RequestContext.getCurrentInstance().update("formAnularAprobar");
                    RequestContext.getCurrentInstance().update("formOrdenesCompras");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aprobado con Exito. Orden de Compra Nro: "+ordenescompras.getIdOrdenCompra()));               
                    Nuevo();

                    ordenescompras_rep = new OrdenesCompras();
                    ordenescompras_rep = ordenescompras;           
                    RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()");                        
                }else{
                    Nuevo();
                    RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                    RequestContext.getCurrentInstance().update("formAnularAprobar");                    
                    RequestContext.getCurrentInstance().update("formOrdenesCompras");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La fecha de la validez del presupuesto vencio",""));                               
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aprobacion no realizada",""));                               
                }       
            }else{
                RequestContext.getCurrentInstance().update("formOrdenesCompras:gOrdenesCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe Seleccionar una Orden de Compra para continuar")); 
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Aprobar" + e,""));            
        }                   
    }
    public void Editar(){
        try {            
            if(ordenescompras_aux != null){
                ordenescompras=OrdenesComprasFacade.obtenerOrdenesCompras(ordenescompras_aux);
                listaPedidosDet = PedidosDetFacade.obtenerPedidosDet(ordenescompras_aux.getIdPedido().getIdPedido());            
                RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobar");
                RequestContext.getCurrentInstance().update("formOrdenesCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecciono el ordenescompras Nro: "+ordenescompras.getIdOrdenCompra())); 
            }else{
                RequestContext.getCurrentInstance().update("formOrdenesCompras:gOrdenesCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar una Orden de Compra para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Editar" + e,""));            
        }
    }
    public void Anular(){
        try {            
            if(ordenescompras_aux != null){
                ordenescompras=OrdenesComprasFacade.obtenerOrdenesCompras(ordenescompras_aux);
                ordenescompras.setEstado("X");
                ordenescompras.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                OrdenesComprasFacade.edit(ordenescompras);            

                RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobar");
                RequestContext.getCurrentInstance().update("formOrdenesCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Anulado con Exito. Orden de Compra Nro: "+ordenescompras.getIdOrdenCompra()));   
                Nuevo();
            }else{
                RequestContext.getCurrentInstance().update("formOrdenesCompras:gOrdenesCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar una Orden de Compra para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
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
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
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
            RequestContext.getCurrentInstance().update("formOrdenesCompras");
        }
    }
}
