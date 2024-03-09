/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Compras;
import Entidades.ComprasDet;
import Entidades.ComprasDetPK;
import Entidades.CuentasPagar;
import Entidades.OrdenesComprasDet;
import Entidades.Productos;
import Entidades.Stock;
import Facades.ComprasDetFacade;
import Facades.ComprasFacade;
import Facades.CuentasPagarFacade;
import Facades.OrdenesComprasDetFacade;
import Facades.StockFacade;
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
 * @author Alejandro Duarte
 */
@Named(value = "beanCompras")
@SessionScoped
public class BeanCompras implements Serializable {

    @EJB
    private ComprasFacade ComprasFacade;
    @EJB
    private ComprasDetFacade ComprasDetFacade;    
    @EJB
    private OrdenesComprasDetFacade OrdenesComprasDetFacade;  
    @EJB
    private StockFacade StockFacade;  
    @EJB
    private CuentasPagarFacade CuentasPagarFacade;  
        
    
    
    private List<Compras> listaCompras,listaComprasPendientes;
    private List<ComprasDet> listaComprasDet, listaComprasDetAux;    

    private Compras compras, compras_aux, compras_rep;
    private ComprasDet comprasdet;
    private ComprasDetPK comprasdetpk;
    private BigDecimal totalgrav5, totalgrav10, totalexentas, totaliva5, totaliva10, totaliva, total;    
    
    public BeanCompras() {
        listaComprasPendientes = new ArrayList<>();
        listaCompras = new ArrayList<>();
        listaComprasDet = new ArrayList<>();
        listaComprasDetAux = new ArrayList<>();
        compras = new Compras();
        compras_aux = new Compras();
        compras_rep = new Compras();
        comprasdet = new ComprasDet();
        comprasdetpk = new ComprasDetPK();
        totalgrav5 = BigDecimal.ZERO;
        totalgrav10 = BigDecimal.ZERO;
        totalexentas = BigDecimal.ZERO;
        totaliva5 = BigDecimal.ZERO;
        totaliva10 = BigDecimal.ZERO;
        totaliva = BigDecimal.ZERO;
        total = BigDecimal.ZERO;        
    }

    public List<Compras> listarCompras() {
        listaCompras = ComprasFacade.findAll();
        return listaCompras;
    }
    
    public List<Compras> listarComprasPendientes() {
        listaComprasPendientes = ComprasFacade.obtenerComprasPorEstado("C");
        return listaComprasPendientes;
    }

    public List<ComprasDet> listarComprasDet() {
        return listaComprasDet;
    }
    
    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Compras getCompras_aux() {
        return compras_aux;
    }

    public void setCompras_aux(Compras compras_aux) {
        this.compras_aux = compras_aux;
    }

    public ComprasDet getComprasdet() {
        return comprasdet;
    }

    public void setComprasdet(ComprasDet comprasdet) {
        this.comprasdet = comprasdet;
    }
      //Variables para calculos

    public BigDecimal getTotalgrav5() {
        return totalgrav5;
    }

    public void setTotalgrav5(BigDecimal totalgrav5) {
        this.totalgrav5 = totalgrav5;
    }

    public BigDecimal getTotalgrav10() {
        return totalgrav10;
    }

    public void setTotalgrav10(BigDecimal totalgrav10) {
        this.totalgrav10 = totalgrav10;
    }

    public BigDecimal getTotalexentas() {
        return totalexentas;
    }

    public void setTotalexentas(BigDecimal totalexentas) {
        this.totalexentas = totalexentas;
    }

    public BigDecimal getTotaliva5() {
        return totaliva5;
    }

    public void setTotaliva5(BigDecimal totaliva5) {
        this.totaliva5 = totaliva5;
    }

    public BigDecimal getTotaliva10() {
        return totaliva10;
    }

    public void setTotaliva10(BigDecimal totaliva10) {
        this.totaliva10 = totaliva10;
    }

    public BigDecimal getTotaliva() {
        return totaliva;
    }

    public void setTotaliva(BigDecimal totaliva) {
        this.totaliva = totaliva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
        

    @PostConstruct
    public void RutinaIncial(){
        listaComprasPendientes = new ArrayList<>();
        listaCompras = new ArrayList<>();
        listaComprasDet = new ArrayList<>();
        listaComprasDetAux = new ArrayList<>();
        compras = new Compras();
        compras_aux = new Compras();
        compras_rep = new Compras();
        comprasdet = new ComprasDet();
        comprasdetpk = new ComprasDetPK();  

    }
    
    public void Inicializa() {
        totalgrav5 = BigDecimal.ZERO;
        totalgrav10 = BigDecimal.ZERO;
        totalexentas = BigDecimal.ZERO;
        totaliva5 = BigDecimal.ZERO;
        totaliva10 = BigDecimal.ZERO;
        totaliva = BigDecimal.ZERO;
        total = BigDecimal.ZERO;           
        compras.setFechaComprobante(new Date());
        compras.setFechaVencimiento(new Date());
        compras.setNroComprobante("0");
        compras.setNroTimbrado(BigDecimal.ZERO);         
    }
    
    public void Reporte() throws IOException, JRException, SQLException {
        JasperPrint jasperPrint;
        String nombreJasper = " Compras.jasper";
        String nombrepdf = " Compra Nro:"+compras_rep.getIdCompra()+".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_compra", compras_rep.getIdCompra());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }    

    public void Nuevo() throws ParseException {
        listaComprasPendientes = new ArrayList<>();
        listaCompras = new ArrayList<>();
        listaComprasDet = new ArrayList<>();
        listaComprasDetAux = new ArrayList<>();
        compras = new Compras();
        compras_aux = new Compras();
        comprasdet = new ComprasDet();
        comprasdetpk = new ComprasDetPK();
        
        Inicializa();
        RequestContext.getCurrentInstance().execute("PF('wtbComprasCabecera').unselectAllRows()");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Restablecido con exito"));
        RequestContext.getCurrentInstance().update("formCompras");
    }
    
    public void Recalcular() {
        totalgrav5 = BigDecimal.ZERO;
        totalgrav10 = BigDecimal.ZERO;
        totalexentas = BigDecimal.ZERO;
        totaliva5 = BigDecimal.ZERO;
        totaliva10 = BigDecimal.ZERO;
        totaliva = BigDecimal.ZERO;
        total = BigDecimal.ZERO;
        BigDecimal iva5;
        BigDecimal grav5;
        BigDecimal iva10;
        BigDecimal grav10;
        for (int i = 0; i < listaComprasDet.size(); i++) {
            ComprasDet det = listaComprasDet.get(i);
            BigDecimal totallinea = det.getPrecioUni().multiply(det.getCantidad());
            if (det.getPorcIva().intValue() == 21) {

                iva5 = totallinea.divide(det.getPorcIva());
                grav5 = (totallinea.subtract(iva5));

                totalgrav5 = totalgrav5.add(grav5);
                totaliva5 = totaliva5.add(iva5);
            }
            if (det.getPorcIva().intValue() == 11) {

                iva10 = (totallinea.divide(det.getPorcIva()));
                grav10 = (totallinea.subtract(iva10));

                totalgrav10 = totalgrav10.add(grav10);
                totaliva10 = totaliva10.add(iva10);
            }
            if (det.getPorcIva().intValue() == 0) {
                totalexentas = totalexentas.add(totallinea);
            }
            total = total.add(totallinea);
        }
        totaliva = totaliva.add(totaliva10.add(totaliva5));
        RequestContext.getCurrentInstance().update("formCompras");
    }    
    
    public void CargaDetalle(){
        List<OrdenesComprasDet> lista;
        listaComprasDet.clear();
        if(compras.getIdProveedor().getIdProveedor()!= null && compras.getIdOrdenCompra()!=null){
            lista = OrdenesComprasDetFacade.obtenerOrdenesComprasDetProveedorOrdenCompra(compras.getIdProveedor(),compras.getIdOrdenCompra());
            if(lista != null){
                for (int i = 0; i < lista.size(); i++) {
                    if(compras.getIdCompra()!=null){
/*                        compras.setIdCondicion(lista.get(i).getPresupuestos().getIdCondicion());
                        comprasdet = new ComprasDet();
                        comprasdetpk = new ComprasDetPK();

                        comprasdetpk.setIdCompra(compras.getIdCompra());
                        comprasdetpk.setIdDeposito(lista.get(i).getOrdenesComprasDetPK().getIdDeposito());
                        comprasdetpk.setIdProducto(lista.get(i).getOrdenesComprasDetPK().getIdProducto());

                        comprasdet.setComprasDetPK(comprasdetpk);
                        comprasdet.setStock(lista.get(i).getPresupuestosDet().getStock());
                        comprasdet.setCantidad(lista.get(i).getPresupuestosDet().getCantidad());
                        comprasdet.setPorcIva(lista.get(i).getPresupuestosDet().getPorcIva());
                        comprasdet.setPrecioUni(lista.get(i).getPresupuestosDet().getPrecioUni());*/
                        listaComprasDet.add(comprasdet);
                    }else{
                        comprasdet = new ComprasDet();
                        comprasdetpk = new ComprasDetPK();
                   /*     compras.setIdCondicion(lista.get(i).getPresupuestos().getIdCondicion());

                        comprasdetpk.setIdCompra(0);
                        comprasdetpk.setIdDeposito(lista.get(i).getOrdenesComprasDetPK().getIdDeposito());
                        comprasdetpk.setIdProducto(lista.get(i).getOrdenesComprasDetPK().getIdProducto());

                        comprasdet.setComprasDetPK(comprasdetpk);
                        comprasdet.setStock(lista.get(i).getPresupuestosDet().getStock());
                        comprasdet.setCantidad(lista.get(i).getPresupuestosDet().getCantidad());
                        comprasdet.setPorcIva(lista.get(i).getPresupuestosDet().getPorcIva());
                        comprasdet.setPrecioUni(lista.get(i).getPresupuestosDet().getPrecioUni());
                        listaComprasDet.add(comprasdet);*/
                    }                
                }
                Recalcular();
                RequestContext.getCurrentInstance().update("formCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle de Orden de Compra Cargado"));
                RequestContext.getCurrentInstance().update("formCompras:tbComprasDet");        
            }else{
                RequestContext.getCurrentInstance().update("formCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No existe Detalle de Orden de Compra"));
                RequestContext.getCurrentInstance().update("formOrdenesCompras:tbOrdenesComprasDet");              
            }
        }else{
            listaComprasDet.clear();
            RequestContext.getCurrentInstance().update("formCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar Proveedor y Orden de Compra",""));                
        }        
    }
    
    public void EliminarProducto() {
        for (int i = 0; i < listaComprasDet.size(); i++) {
            ComprasDet fila = listaComprasDet.get(i);
            if (fila.getComprasDetPK().equals(comprasdet.getComprasDetPK())) {
                listaComprasDet.remove(i);
                Recalcular();
                RequestContext.getCurrentInstance().update("formCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                RequestContext.getCurrentInstance().update("formCompras:tbComprasDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");
            }
        }
        
    }

    public void EditarProducto() {
        BigDecimal v_cant = BigDecimal.ZERO;
        List<OrdenesComprasDet> lista = OrdenesComprasDetFacade.obtenerOrdenesComprasDetProveedorOrdenCompra(compras.getIdProveedor(),compras.getIdOrdenCompra());        
        for (int i = 0; i < lista.size(); i++) {
/*            if(lista.get(i).getPresupuestosDet().getStock().equals(comprasdet.getStock())){
                v_cant= lista.get(i).getCantidad();
            }  */
        }
        if(comprasdet.getCantidad().intValue()==0){
            RequestContext.getCurrentInstance().update("formAgregarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
        }else if(comprasdet.getCantidad().compareTo(v_cant)>0){
            RequestContext.getCurrentInstance().update("formAgregarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede pasar "+v_cant,""));            
        }else{
            Recalcular();
            RequestContext.getCurrentInstance().update("formCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
            RequestContext.getCurrentInstance().update("formCompras:tbComprasDet");
            RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");            
        }
    }

    public void Grabar() {
        try {     
            if (listaComprasDet.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede grabar sin detalle",""));
                RequestContext.getCurrentInstance().update("formCompras");
            }else if(!(compras.getIdOrdenCompra()!=null)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede grabar sin Orden de Compra",""));
                RequestContext.getCurrentInstance().update("formCompras");
            }else if(!(compras.getIdProveedor()!=null)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede grabar sin Proveedor",""));
                RequestContext.getCurrentInstance().update("formCompras");
            }else if((compras.getNroComprobante().length())<13){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La longitud del nro comprobante debe ser de 13",""));
                RequestContext.getCurrentInstance().update("formCompras");            
            }else if((compras.getNroTimbrado().toString().length())!=8){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La longitud del nro timbrado debe ser de 8",""));
                RequestContext.getCurrentInstance().update("formCompras");            
            }else if(Metodos.FormatoFecha(compras.getFechaComprobante()).compareTo(Metodos.FormatoFecha(compras.getFechaVencimiento()))>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La Fecha del Comprobante no puede ser mayor que la fecha vencimiento del timbrado",""));
                RequestContext.getCurrentInstance().update("formCompras");            
            }else if(Metodos.FormatoFecha(compras.getFechaComprobante()).compareTo(Metodos.FormatoFecha(new Date()))>0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La Fecha del Comprobante no puede ser mayor a la fecha del dia",""));
                RequestContext.getCurrentInstance().update("formCompras");            
            }else if(ComprasFacade.validaNroComrpobanteProveedor(compras).equals(true)&&compras.getIdCompra()==null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Compra con Nro de Comprobante ya Existe",""));
                RequestContext.getCurrentInstance().update("formCompras");            
            }else if(ComprasFacade.validaNroComrpobanteProveedor(compras).equals(true)&&(!compras.getNroComprobante().equals(compras_aux.getNroComprobante())||!compras.getIdProveedor().getIdProveedor().equals(compras_aux.getIdProveedor().getIdProveedor()))){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Compra con Nro de Comprobante ya Existe",""));
                RequestContext.getCurrentInstance().update("formCompras");            
            }else if(compras.getIdCompra()!=null){       
                compras.setFechaEmision(new Date());
                compras.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                ComprasFacade.edit(compras);
                
                for (int i = 0; i < listaComprasDetAux.size(); i++) {
                    ComprasDetFacade.remove(listaComprasDetAux.get(i));
                }                
                for (int f = 0; f < listaComprasDet.size(); f++) {
                    comprasdet = new ComprasDet();
                    comprasdetpk = new ComprasDetPK(); 

                    comprasdet = listaComprasDet.get(f);                    
                    comprasdetpk.setIdDeposito(comprasdet.getStock().getDepositos().getIdDeposito());
                    comprasdetpk.setIdProducto(comprasdet.getStock().getProductos().getIdProducto());
                    comprasdetpk.setIdCompra(compras.getIdCompra());
                    comprasdet.setStock(comprasdet.getStock());
                    comprasdet.setCompras(compras);
                    comprasdet.setComprasDetPK(comprasdetpk);
                    ComprasDetFacade.create(comprasdet);                    
                }

                RequestContext.getCurrentInstance().update("formCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Editado con Exito.  de Compra Nro: "+compras.getIdCompra()));       
                Nuevo();                                                                     
            }else{
                compras.setEstado("C");
                compras.setFechaEmision(new Date());
                compras.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                ComprasFacade.create(compras);
                
                for (int f = 0; f < listaComprasDet.size(); f++) {
                    comprasdet = new ComprasDet();
                    comprasdetpk = new ComprasDetPK();        
                    
                    comprasdet = listaComprasDet.get(f);                    
                    comprasdetpk.setIdDeposito(comprasdet.getStock().getDepositos().getIdDeposito());
                    comprasdetpk.setIdProducto(comprasdet.getStock().getProductos().getIdProducto());  
                    comprasdetpk.setIdCompra(compras.getIdCompra());
                    comprasdet.setStock(comprasdet.getStock());
                    comprasdet.setCompras(compras);
                    comprasdet.setComprasDetPK(comprasdetpk);
                    ComprasDetFacade.create(comprasdet);                    
                }

                RequestContext.getCurrentInstance().update("formCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito.  de Compra Nro: "+compras.getIdCompra()));       
                Nuevo();                    
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar " + e,""));
        }
    }
    public void ObtieneComprasDet(){
        listaComprasDet=ComprasDetFacade.obtenerComprasDet(compras_aux.getIdCompra());
        listaComprasDetAux = ComprasDetFacade.obtenerComprasDet(compras_aux.getIdCompra());
        
        RequestContext.getCurrentInstance().update("formAnularAprobar:tbComprasDetalle");
        RequestContext.getCurrentInstance().update("formCompras:gCompras");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle Obtenido"));
    }
    
    public void Aprobar(){
        try {        
            if(compras_aux != null){
                compras=ComprasFacade.obtenerCompras(compras_aux);
                    
                    for (int i = 0; i < listaComprasDet.size(); i++) {                        
                        Stock stock = listaComprasDet.get(i).getStock();
                        stock.setExistencia(stock.getExistencia().add(listaComprasDet.get(i).getCantidad()));
                        StockFacade.edit(stock);
                        total=total.add(listaComprasDet.get(i).getCantidad().multiply(listaComprasDet.get(i).getPrecioUni()));
                    }
                    
                    if(compras.getIdCondicion().getIntervaloDias()== BigDecimal.ONE){
                        CuentasPagar cc= new CuentasPagar();
                        cc.setEstado("A");
                        cc.setCuota(compras.getIdCondicion().getIntervaloDias().intValue());
                        cc.setImporte(total);
                        cc.setVencCuota(new Date());
                        cc.setSaldo(total);
                        cc.setIdCompra(compras);
                        CuentasPagarFacade.create(cc);                    
                    }else{
                        BigDecimal importe = total.divide(compras.getIdCondicion().getCantidadCuotas());
                        for (int i = 0; i < compras.getIdCondicion().getCantidadCuotas().intValue(); i++) {
                            CuentasPagar cc= new CuentasPagar();
                            cc.setEstado("A");
                            cc.setCuota(i+1);
                            cc.setImporte(importe);
                            cc.setVencCuota(Metodos.SumarMeses(i, new Date()));
                            cc.setSaldo(importe);
                            cc.setIdCompra(compras);
                            CuentasPagarFacade.create(cc);        
                        }
                    }
                    
                    compras.setEstado("A");
                    compras.setFechaEmision(new Date());
                    compras.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                    ComprasFacade.edit(compras);      

                    RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                    RequestContext.getCurrentInstance().update("formAnularAprobar");
                    RequestContext.getCurrentInstance().update("formCompras");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aprobado con Exito.  de Compra Nro: "+compras.getIdCompra()));               
                    Nuevo();

                    compras_rep = new Compras();
                    compras_rep = compras;           
                    RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()");                              
            }else{
                RequestContext.getCurrentInstance().update("formCompras:gCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe Seleccionar una  de Compra para continuar")); 
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Aprobar" + e,""));            
        }                   
    }
    public void Editar(){
        try {            
            if(compras_aux != null){
                compras=ComprasFacade.obtenerCompras(compras_aux);     
                Recalcular();
                RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobar");
                RequestContext.getCurrentInstance().update("formCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecciono la Compras Nro: "+compras.getIdCompra())); 
            }else{
                RequestContext.getCurrentInstance().update("formCompras:gCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar una compra para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCompras");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Editar" + e,""));            
        }
    }
    public void Anular(){
        try {            
            if(compras_aux != null){
                compras=ComprasFacade.obtenerCompras(compras_aux);
                compras.setEstado("X");
                compras.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                ComprasFacade.edit(compras);            

                RequestContext.getCurrentInstance().execute("PF('digAnularAprobar').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobar");
                RequestContext.getCurrentInstance().update("formCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Anulado con Exito.  de Compra Nro: "+compras.getIdCompra()));   
                Nuevo();
            }else{
                RequestContext.getCurrentInstance().update("formCompras:gCompras");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar una Compra para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCompras");
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
            RequestContext.getCurrentInstance().update("formCompras");
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
            RequestContext.getCurrentInstance().update("formCompras");
        }
    }
}
