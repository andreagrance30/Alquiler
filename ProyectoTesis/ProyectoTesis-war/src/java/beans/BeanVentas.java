/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.AperturaCierreCaja;
import Entidades.CuentasCobrar;
import Entidades.Stock;
import Entidades.Timbrados;
import Entidades.Ventas;
import Entidades.VentasDet;
import Entidades.VentasDetPK;
import Entidades.PresupuestosClientes;
import Facades.AperturaCierreCajaFacade;
import Facades.CuentasCobrarFacade;
import Facades.StockFacade;
import Facades.TimbradosFacade;
import Facades.VentasDetFacade;
import Facades.VentasFacade;
import Facades.PresupuestosClientesFacade;
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
import java.util.Map;
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
@Named(value = "beanVentas")
@SessionScoped
public class BeanVentas implements Serializable {

    @EJB
    private VentasFacade VentasFacade;
    @EJB
    private VentasDetFacade VentasDetFacade;
    @EJB
    private TimbradosFacade TimbradosFacade;
    @EJB
    private AperturaCierreCajaFacade AperturaCierreCajaFacade;
    @EJB
    private StockFacade StockFacade;
    @EJB
    private CuentasCobrarFacade CuentasCobrarFacade;
    @EJB
    private PresupuestosClientesFacade presuCli;

    private List<Ventas> listaVentas;
    private List<VentasDet> listaVentasDet;

    private Ventas venta;
    private Ventas venta_aux;
    private VentasDet ventadet;
    private VentasDetPK ventadetpk;
    private AperturaCierreCaja aperturacierrecaja;

    private BigInteger totalgrav5, totalgrav10, totalexentas, totaliva5, totaliva10, totaliva, total;

    public BeanVentas() {
        listaVentas = new ArrayList<>();
        listaVentasDet = new ArrayList<>();
        venta = new Ventas();
        venta_aux = new Ventas();
        ventadet = new VentasDet();
        ventadetpk = new VentasDetPK();
        totalgrav5 = BigInteger.ZERO;
        totalgrav10 = BigInteger.ZERO;
        totalexentas = BigInteger.ZERO;
        totaliva5 = BigInteger.ZERO;
        totaliva10 = BigInteger.ZERO;
        totaliva = BigInteger.ZERO;
        total = BigInteger.ZERO;
    }

    public List<Ventas> listarVentas() {
        listaVentas = VentasFacade.findAll();
        return listaVentas;
    }

    public List<VentasDet> listarVentasDet() {
        return listaVentasDet;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public VentasDet getVentadet() {
        return ventadet;
    }

    public void setVentadet(VentasDet ventadet) {
        this.ventadet = ventadet;
    }
    //Variables para calculos

    public BigInteger getTotalgrav5() {
        return totalgrav5;
    }

    public void setTotalgrav5(BigInteger totalgrav5) {
        this.totalgrav5 = totalgrav5;
    }

    public BigInteger getTotalgrav10() {
        return totalgrav10;
    }

    public void setTotalgrav10(BigInteger totalgrav10) {
        this.totalgrav10 = totalgrav10;
    }

    public BigInteger getTotalexentas() {
        return totalexentas;
    }

    public void setTotalexentas(BigInteger totalexentas) {
        this.totalexentas = totalexentas;
    }

    public BigInteger getTotaliva5() {
        return totaliva5;
    }

    public void setTotaliva5(BigInteger totaliva5) {
        this.totaliva5 = totaliva5;
    }

    public BigInteger getTotaliva10() {
        return totaliva10;
    }

    public void setTotaliva10(BigInteger totaliva10) {
        this.totaliva10 = totaliva10;
    }

    public BigInteger getTotaliva() {
        return totaliva;
    }

    public void setTotaliva(BigInteger totaliva) {
        this.totaliva = totaliva;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    @PostConstruct
    public void RutinaIncial(){
        listaVentasDet = new ArrayList<>();
        venta = new Ventas();
        ventadet = new VentasDet();
        ventadetpk = new VentasDetPK();
        totalgrav5 = BigInteger.ZERO;
        totalgrav10 = BigInteger.ZERO;
        totalexentas = BigInteger.ZERO;
        totaliva5 = BigInteger.ZERO;
        totaliva10 = BigInteger.ZERO;
        totaliva = BigInteger.ZERO;
        total = BigInteger.ZERO;    
    }    
    
    public void Inicializa() throws ParseException {
        ObtenerTimbrado();
    }
    public void Reporte() throws IOException, JRException, SQLException {
        JasperPrint jasperPrint;
        String nombreJasper = "Ventas.jasper";
        String nombrepdf = venta_aux.getIdTimbrado().getIdTipoComprobante().getDescripcion()+" "+venta_aux.getNroComprobante()+ ".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_venta", venta_aux.getIdVenta());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }    

    public void ObtenerTimbrado() throws ParseException{
        aperturacierrecaja = AperturaCierreCajaFacade.obtenerAperturaAbierta(BeanAcceso.usuariossucursales);
        venta.setIdTimbrado(TimbradosFacade.obtenerTimbrado(aperturacierrecaja.getIdCaja().getIdCaja(),1));
        if (venta.getIdTimbrado() == null) {
            Metodos.Mensajes("Advertencia", "Sucursal no cuenta con Facturas");
            RequestContext.getCurrentInstance().update("formVentas");
            RequestContext.getCurrentInstance().execute("setTimeout(function(){document.getElementById('formVentas:inicio').click()},1500)");            
        } else {
            venta.setNroTimbrado(venta.getIdTimbrado().getNroTimbrado());
            venta.setFechaVencimiento(venta.getIdTimbrado().getFechaFin());        
            if (Metodos.FormatoFecha(new Date()).after(
                Metodos.FormatoFecha(venta.getIdTimbrado().getFechaFin()))
                ){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El timbrado esta vencido, se cambiara el estado del Timbrado",""));
                Metodos.Mensajes("Advertencia", "El timbrado esta vencido, se modificara el estado del Timbrado");
                //Actualiza timbrado
                Timbrados tim = venta.getIdTimbrado();
                tim.setEstado("V");
                TimbradosFacade.edit(tim);
                RequestContext.getCurrentInstance().update("formVentas");
                RequestContext.getCurrentInstance().execute("setTimeout(function(){document.getElementById('formVentas:inicio').click()},1500)");     
                
            } else if (venta.getIdTimbrado().getNroActual().intValue() < venta.getIdTimbrado().getNroFinal().intValue()) {
                Integer v_cant=(venta.getIdTimbrado().getNroFinal().intValue()-venta.getIdTimbrado().getNroActual().intValue());
                if((v_cant)<5){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso: La cantidad de Comprobate es "+v_cant));
                    Metodos.Mensajes("Advertencia", "Aviso: La cantidad de Comprobate es "+v_cant);
                    RequestContext.getCurrentInstance().update("formVentas");                      
                    if(v_cant==1){
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso: Este es el ultimo comprobantes"));
                       Metodos.Mensajes("Advertencia", "Aviso: Este es el ultimo comprobante");
                       RequestContext.getCurrentInstance().update("formVentas");       
                    }     
                }
                String punto_est, punto_emi,nro_actual;
                punto_est= Metodos.AgregarCeros(BeanAcceso.usuariossucursales.getSucursales().getPuntoEstablecimiento().toString(), 3);
                punto_emi= Metodos.AgregarCeros(aperturacierrecaja.getIdCaja().getPuntoEmision().toString(), 3);                
                nro_actual=Metodos.AgregarCeros((venta.getIdTimbrado().getNroActual().add(BigInteger.ONE)).toString(),7);
                venta.setNroComprobante(punto_est+"-"+punto_emi+"-"+nro_actual);
                RequestContext.getCurrentInstance().update("formVentas");
            } 
        }
    }

    public void Nuevo() throws ParseException {
        listaVentasDet = new ArrayList<>();
        venta = new Ventas();
        ventadet = new VentasDet();
        ventadetpk = new VentasDetPK();
        totalgrav5 = BigInteger.ZERO;
        totalgrav10 = BigInteger.ZERO;
        totalexentas = BigInteger.ZERO;
        totaliva5 = BigInteger.ZERO;
        totaliva10 = BigInteger.ZERO;
        totaliva = BigInteger.ZERO;
        total = BigInteger.ZERO;
        Inicializa();
        Metodos.Mensajes("Correcto", "Restablecido con Exito");
        RequestContext.getCurrentInstance().update("formVentas");
    }

    public void AbreDialogoCliente() {
        //Metodo no se utiliza no se puede actualizar al cerrar
        Map<String, Object> conf = new HashMap<>();
        conf.put("modal", false);
        conf.put("contentWidth", 1000);
        conf.put("contentHeight", 500);
        RequestContext.getCurrentInstance().openDialog("referenciales/Clientes.xhtml", conf, null);
    }

    public void Recalcular() {
        totalgrav5 =   BigInteger.ZERO;
        totalgrav10 =  BigInteger.ZERO;
        totalexentas = BigInteger.ZERO;
        totaliva5 =    BigInteger.ZERO;
        totaliva10 =   BigInteger.ZERO;
        totaliva =     BigInteger.ZERO;
        total =        BigInteger.ZERO;
        BigInteger iva5;
        BigInteger grav5;
        BigInteger iva10;
        BigInteger grav10;
        BigInteger aux5;
        BigInteger aux10;
        for (int i = 0; i < listaVentasDet.size(); i++) {
            VentasDet det = listaVentasDet.get(i);
            BigInteger totallinea = det.getStock().getProductos().getPrecioVenta().multiply(det.getCantidad());
              System.out.println("entra?");
            if (det.getStock().getProductos().getIdImpuesto().getPorcIva().intValue() == 21) {
                aux5=det.getStock().getProductos().getIdImpuesto().getPorcIva();
                System.out.println("divisor recuperado="+aux5);
                iva5 = (totallinea.divide(aux5));
                grav5 = (totallinea.subtract(iva5));
                totalgrav5 = totalgrav5.add(grav5);
                totaliva5 = totaliva5.add(iva5);
            }
            if (det.getStock().getProductos().getIdImpuesto().getPorcIva().intValue() == 11) {
                aux10 = det.getStock().getProductos().getIdImpuesto().getPorcIva();
                iva10 = (totallinea.divide(aux10));
                System.out.println("divisor recuperado 10="+aux10);
                grav10 = (totallinea.subtract(iva10));

                totalgrav10 = totalgrav10.add(grav10);
                totaliva10 = totaliva10.add(iva10);
            }
            if (det.getStock().getProductos().getIdImpuesto().getPorcIva().intValue() == 0) {
                totalexentas = totalexentas.add(totallinea);
            }
            total = total.add(totallinea);
        }
        totaliva = totaliva.add(totaliva10.add(totaliva5));
        RequestContext.getCurrentInstance().update("formVentas");
    }

    public void NuevoProducto() {
        ventadet = new VentasDet();
    }

    public void EliminarProducto() {
        for (int i = 0; i < listaVentasDet.size(); i++) {
            VentasDet fila = listaVentasDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), ventadet.getStock().getProductos().getIdProducto())) {
                listaVentasDet.remove(i);
                Recalcular();
                RequestContext.getCurrentInstance().update("formVentas");
            //    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                Metodos.Mensajes("Error", "Producto Eliminado");
                RequestContext.getCurrentInstance().update("formVentas:tbVentasDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarProductoVentas').hide()");
            }
        }
    }

    public void EditarProductoVentas() {
        if(ventadet.getCantidad().intValue()==0){
                RequestContext.getCurrentInstance().update("formEditarProductoVentas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));
                Metodos.Mensajes("Advertencia", "La cantidad no puede ser 0");
        }else if(ventadet.getStock().getExistencia().intValue()<=0){
            RequestContext.getCurrentInstance().update("formEditarProductoVentas");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El producto "+ventadet.getStock().getProductos().getDescripcion()+" no se encuentra disponible",""));
            Metodos.Mensajes("Advertencia", "El producto "+ventadet.getStock().getProductos().getDescripcion()+" no se encuentra disponible");
        }else if (ventadet.getCantidad().intValue() > ventadet.getStock().getExistencia().intValue()) {
            RequestContext.getCurrentInstance().update("formEditarProductoVentas");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad supera la Existencia de " + ventadet.getStock().getExistencia().toString(),""));
             Metodos.Mensajes("Advertencia", "La cantidad supera la Existencia de " + ventadet.getStock().getExistencia().toString());
        }else{
           Recalcular();
           RequestContext.getCurrentInstance().update("formVentas");
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
           Metodos.Mensajes("Advertencia", "Producto Editado");
           RequestContext.getCurrentInstance().update("formVentas:tbVentasDet");
           RequestContext.getCurrentInstance().execute("PF('digEditarProductoVentas').hide()");   
        }
    }

    public void AgregaProducto() {
        Integer v_bandera = 0;
        for (int i = 0; i < listaVentasDet.size(); i++) {
            VentasDet fila = listaVentasDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), ventadet.getStock().getProductos().getIdProducto())) {
                RequestContext.getCurrentInstance().update("formAgregarProductoVentas");
             //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede agregar registro duplicado",""));
                Metodos.Mensajes("Advertencia", "No puede agregar registro duplicado");
                v_bandera = 1;
            }
        }
        if (v_bandera != 1) {
            if(ventadet.getCantidad().intValue()==0){
                RequestContext.getCurrentInstance().update("formAgregarProductoVentas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));
                Metodos.Mensajes("Advertencia", "La cantidad no puede ser 0");
            }else if(ventadet.getStock().getExistencia().intValue()<=0){
                RequestContext.getCurrentInstance().update("formAgregarProductoVentas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El producto "+ventadet.getStock().getProductos().getDescripcion()+" no se encuentra disponible",""));
                Metodos.Mensajes("Advertencia", "La cantidad no puede ser 0");
            }else if (ventadet.getCantidad().intValue() > ventadet.getStock().getExistencia().intValue()) {
                RequestContext.getCurrentInstance().update("formAgregarProductoVentas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad supera la Existencia de " + ventadet.getStock().getExistencia().toString(),""));
            } else {
                VentasDet fila = new VentasDet(ventadetpk, ventadet.getCantidad(), ventadet.getStock().getProductos().getIdImpuesto().getPorcIva(), ventadet.getStock().getProductos().getPrecioVenta());
                fila.setStock(ventadet.getStock());
                listaVentasDet.add(fila);
                Recalcular();
                RequestContext.getCurrentInstance().update("formVentas");
                 Metodos.Mensajes("Correcto", "Producto Agregado");
                RequestContext.getCurrentInstance().update("formVentas:tbVentasDet");
                RequestContext.getCurrentInstance().execute("PF('digAgregarProductoVentas').hide()");
            }
        }
    }

    public void Grabar() {
        
        try {
            if (listaVentasDet.isEmpty()) {
         //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe agregar productos para continuar",""));
            Metodos.Mensajes("Advertencia", "Debe agregar productos para continuar");
            RequestContext.getCurrentInstance().update("formVentas");
            }else{
                venta.setEstado("A");
                venta.setFechaEmision(new Date());
                venta.setFechaVencimiento(new Date());
                venta.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                VentasFacade.create(venta);
                for (int f = 0; f < listaVentasDet.size(); f++) {
                    ventadet = new VentasDet();
                    ventadetpk = new VentasDetPK();                   
                    ventadet = listaVentasDet.get(f);                    
                    ventadetpk.setIdDeposito(ventadet.getStock().getDepositos().getIdDeposito());
                    ventadetpk.setIdProducto(ventadet.getStock().getProductos().getIdProducto());
                    ventadetpk.setIdVenta(venta.getIdVenta());
                    ventadet.setVentasDetPK(ventadetpk);
                    VentasDetFacade.create(ventadet);
                    
                    //Actualiza Stock
                    Stock stock = StockFacade.find(ventadet.getStock().getStockPK());
                    stock.setExistencia(stock.getExistencia().subtract(ventadet.getCantidad()));
                    StockFacade.edit(stock);
                }
                
                //Actualiza presupuesto cliente
            /*     PresupuestosClientes presu = new PresupuestosClientes();
                   presu.setEstado("A");
                   presu.setFechaPresupuesto(new Date());
                   presu.setIdPresupuestoCliente(venta.getIdVenta());*/
                 /*   cc.setEstado("A");
                    cc.setCuota(venta.getIdCondicion().getIntervaloDias().intValue());
                    cc.setImporte(total);
                    cc.setVencCuota(new Date());
                    cc.setInteres(BigInteger.ZERO);
                    cc.setSaldo(total);
                    cc.setIdVenta(venta);*/
                 //   presuCli.create(presu);  
                
                //Actualiza Timbrado
               if(venta.getIdTimbrado().getNroFinal().intValue() == (venta.getIdTimbrado().getNroActual().add(BigInteger.ONE)).intValue()){
                    Timbrados tim = venta.getIdTimbrado();
                    tim.setEstado("T");
                    tim.setNroActual(venta.getIdTimbrado().getNroActual().add(BigInteger.ONE));
                    TimbradosFacade.edit(tim);
                }else{
                    Timbrados tim = venta.getIdTimbrado();
                    tim.setNroActual(venta.getIdTimbrado().getNroActual().add(BigInteger.ONE));
                    TimbradosFacade.edit(tim);                    
                }
                
                //Inserta Cuentas Cobrar
                if(venta.getIdCondicion().getIntervaloDias()== BigInteger.ONE){
                    CuentasCobrar cc= new CuentasCobrar();
                    cc.setEstado("A");
                    cc.setCuota(venta.getIdCondicion().getIntervaloDias().intValue());
                    cc.setImporte(total);
                    cc.setVencCuota(new Date());
                    cc.setInteres(BigInteger.ZERO);
                    cc.setSaldo(total);
                    cc.setIdVenta(venta);
                    CuentasCobrarFacade.create(cc);                    
                }else{
                    BigInteger importe = total.divide(venta.getIdCondicion().getCantidadCuotas());
                    for (int i = 0; i < venta.getIdCondicion().getCantidadCuotas().intValue(); i++) {
                        CuentasCobrar cc= new CuentasCobrar();
                        cc.setEstado("A");
                        cc.setCuota(i+1);
                        cc.setImporte(importe);
                        cc.setVencCuota(Metodos.SumarMeses(i, new Date()));
                        cc.setInteres(BigInteger.ZERO);
                        cc.setSaldo(importe);
                        cc.setIdVenta(venta);
                        CuentasCobrarFacade.create(cc);      
                    }
                }
                System.out.println("entra?? ");
                RequestContext.getCurrentInstance().update("formVentas");
                 Metodos.Mensajes("Correcto", "Grabado con Exito");
                venta_aux = new Ventas();
                venta_aux = venta;        
                if(venta_aux.getIdCondicion().getDescripcion().equals("CONTADO")){
                    RequestContext.getCurrentInstance().execute("PF('digCobros').show()");    
                    RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()");  
                }else{                    
                    RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()");                         
                    RequestContext.getCurrentInstance().execute("setTimeout(function(){document.getElementById('formCobros:btnsi').click()},5000)");   
                } 
                Nuevo();                
            }
            
        } catch (ParseException e) {
            RequestContext.getCurrentInstance().update("formVentas");
           // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar" + e,""));
             Metodos.Mensajes("Error", "Error al grabar");
        }
    }
    
    public void Cobros() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath + "/faces/formularios/Cobros.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error" + ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formVentas");
        }
    }    
/*
    public void Menu() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath + "/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error" + ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formVentas");
        }
    }
    
    */

    public void Salir() {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        ((HttpSession) ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath + "/faces/formularios/Acceso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error" + ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formVentas");
        }
    }
}
