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
import Facades.AperturaCierreCajaFacade;
import Facades.CuentasCobrarFacade;
import Facades.StockFacade;
import Facades.TimbradosFacade;
import Facades.VentasDetFacade;
import Facades.VentasFacade;
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

    private List<Ventas> listaVentas;
    private List<VentasDet> listaVentasDet;

    private Ventas venta;
    private Ventas venta_aux;
    private VentasDet ventadet;
    private VentasDetPK ventadetpk;
    private AperturaCierreCaja aperturacierrecaja;

    private BigDecimal totalgrav5, totalgrav10, totalexentas, totaliva5, totaliva10, totaliva, total;

    public BeanVentas() {
        listaVentas = new ArrayList<>();
        listaVentasDet = new ArrayList<>();
        venta = new Ventas();
        venta_aux = new Ventas();
        ventadet = new VentasDet();
        ventadetpk = new VentasDetPK();
        totalgrav5 = BigDecimal.ZERO;
        totalgrav10 = BigDecimal.ZERO;
        totalexentas = BigDecimal.ZERO;
        totaliva5 = BigDecimal.ZERO;
        totaliva10 = BigDecimal.ZERO;
        totaliva = BigDecimal.ZERO;
        total = BigDecimal.ZERO;
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
        listaVentasDet = new ArrayList<>();
        venta = new Ventas();
        ventadet = new VentasDet();
        ventadetpk = new VentasDetPK();
        totalgrav5 = BigDecimal.ZERO;
        totalgrav10 = BigDecimal.ZERO;
        totalexentas = BigDecimal.ZERO;
        totaliva5 = BigDecimal.ZERO;
        totaliva10 = BigDecimal.ZERO;
        totaliva = BigDecimal.ZERO;
        total = BigDecimal.ZERO;    
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Sucursal no cuenta con Facturas",""));
            RequestContext.getCurrentInstance().update("formVentas");
            RequestContext.getCurrentInstance().execute("setTimeout(function(){document.getElementById('formVentas:inicio').click()},1500)");            
        } else {
            venta.setNroTimbrado(venta.getIdTimbrado().getNroTimbrado());
            venta.setFechaVencimiento(venta.getIdTimbrado().getFechaFin());        
            if (Metodos.FormatoFecha(new Date()).after(
                Metodos.FormatoFecha(venta.getIdTimbrado().getFechaFin()))
                ){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El timbrado esta vencido, se cambiara el estado del Timbrado",""));
                
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
                    RequestContext.getCurrentInstance().update("formVentas");                      
                    if(v_cant==1){
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso: Este es el ultimo comprobantes"));
                       RequestContext.getCurrentInstance().update("formVentas");       
                    }     
                }
                String punto_est, punto_emi,nro_actual;
                punto_est= Metodos.AgregarCeros(BeanAcceso.usuariossucursales.getSucursales().getPuntoEstablecimiento().toString(), 3);
                punto_emi= Metodos.AgregarCeros(aperturacierrecaja.getIdCaja().getPuntoEmision().toString(), 3);                
                nro_actual=Metodos.AgregarCeros((venta.getIdTimbrado().getNroActual().add(BigDecimal.ONE)).toString(),7);
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
        totalgrav5 = BigDecimal.ZERO;
        totalgrav10 = BigDecimal.ZERO;
        totalexentas = BigDecimal.ZERO;
        totaliva5 = BigDecimal.ZERO;
        totaliva10 = BigDecimal.ZERO;
        totaliva = BigDecimal.ZERO;
        total = BigDecimal.ZERO;
        Inicializa();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Restablecido con exito"));
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
        for (int i = 0; i < listaVentasDet.size(); i++) {
            VentasDet det = listaVentasDet.get(i);
            BigDecimal totallinea = det.getStock().getProductos().getPrecioVenta().multiply(det.getCantidad());
            if (det.getStock().getProductos().getIdImpuesto().getPorcIva().intValue() == 21) {

                iva5 = (totallinea.divide(det.getStock().getProductos().getIdImpuesto().getPorcIva()));
                grav5 = (totallinea.subtract(iva5));

                totalgrav5 = totalgrav5.add(grav5);
                totaliva5 = totaliva5.add(iva5);
            }
            if (det.getStock().getProductos().getIdImpuesto().getPorcIva().intValue() == 11) {

                iva10 = (totallinea.divide(det.getStock().getProductos().getIdImpuesto().getPorcIva()));
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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                RequestContext.getCurrentInstance().update("formVentas:tbVentasDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");
            }
        }
    }

    public void EditarProducto() {
        if(ventadet.getCantidad().intValue()==0){
                RequestContext.getCurrentInstance().update("digEditarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
        }else if(ventadet.getStock().getExistencia().intValue()<=0){
            RequestContext.getCurrentInstance().update("digEditarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El producto "+ventadet.getStock().getProductos().getDescripcion()+" no se encuentra disponible",""));
        }else if (ventadet.getCantidad().intValue() > ventadet.getStock().getExistencia().intValue()) {
            RequestContext.getCurrentInstance().update("digEditarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad supera la Existencia de " + ventadet.getStock().getExistencia().toString(),""));
        }else{
           Recalcular();
           RequestContext.getCurrentInstance().update("formVentas");
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
           RequestContext.getCurrentInstance().update("formVentas:tbVentasDet");
           RequestContext.getCurrentInstance().execute("PF('digEditarProducto').hide()");   
        }
    }

    public void AgregaProducto() {
        Integer v_bandera = 0;
        for (int i = 0; i < listaVentasDet.size(); i++) {
            VentasDet fila = listaVentasDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), ventadet.getStock().getProductos().getIdProducto())) {
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede agregar registro duplicado",""));
                v_bandera = 1;
            }
        }
        if (v_bandera != 1) {
            if(ventadet.getCantidad().intValue()==0){
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
            }else if(ventadet.getStock().getExistencia().intValue()<=0){
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El producto "+ventadet.getStock().getProductos().getDescripcion()+" no se encuentra disponible",""));
            }else if (ventadet.getCantidad().intValue() > ventadet.getStock().getExistencia().intValue()) {
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad supera la Existencia de " + ventadet.getStock().getExistencia().toString(),""));
            } else {
                VentasDet fila = new VentasDet(ventadetpk, ventadet.getCantidad(), ventadet.getStock().getProductos().getIdImpuesto().getPorcIva(), ventadet.getStock().getProductos().getPrecioVenta());
                fila.setStock(ventadet.getStock());
                listaVentasDet.add(fila);
                Recalcular();
                RequestContext.getCurrentInstance().update("formVentas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Agregado"));
                RequestContext.getCurrentInstance().update("formVentas:tbVentasDet");
                RequestContext.getCurrentInstance().execute("PF('digAgregarProducto').hide()");
            }
        }
    }

    public void Grabar() {
        try {
            if (listaVentasDet.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe agregar productos para continuar",""));
            RequestContext.getCurrentInstance().update("formVentas");
            }else{
                venta.setEstado("A");
                venta.setFechaEmision(new Date());
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
                
                //Actualiza Timbrado
                if(venta.getIdTimbrado().getNroFinal().intValue() == (venta.getIdTimbrado().getNroActual().add(BigDecimal.ONE)).intValue()){
                    Timbrados tim = venta.getIdTimbrado();
                    tim.setEstado("T");
                    tim.setNroActual(venta.getIdTimbrado().getNroActual().add(BigDecimal.ONE));
                    TimbradosFacade.edit(tim);
                }else{
                    Timbrados tim = venta.getIdTimbrado();
                    tim.setNroActual(venta.getIdTimbrado().getNroActual().add(BigDecimal.ONE));
                    TimbradosFacade.edit(tim);                    
                }
                
                //Inserta Cuentas Cobrar
                if(venta.getIdCondicion().getIntervaloDias()== BigDecimal.ONE){
                    CuentasCobrar cc= new CuentasCobrar();
                    cc.setEstado("A");
                    cc.setCuota(venta.getIdCondicion().getIntervaloDias().intValue());
                    cc.setImporte(total);
                    cc.setVencCuota(new Date());
                    cc.setInteres(BigDecimal.ZERO);
                    cc.setSaldo(total);
                    cc.setIdVenta(venta);
                    CuentasCobrarFacade.create(cc);                    
                }else{
                    BigDecimal importe = total.divide(venta.getIdCondicion().getCantidadCuotas());
                    for (int i = 0; i < venta.getIdCondicion().getCantidadCuotas().intValue(); i++) {
                        CuentasCobrar cc= new CuentasCobrar();
                        cc.setEstado("A");
                        cc.setCuota(i+1);
                        cc.setImporte(importe);
                        cc.setVencCuota(Metodos.SumarMeses(i, new Date()));
                        cc.setInteres(BigDecimal.ZERO);
                        cc.setSaldo(importe);
                        cc.setIdVenta(venta);
                        CuentasCobrarFacade.create(cc);      
                    }
                }
                
                RequestContext.getCurrentInstance().update("formVentas");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito"));     
                venta_aux = new Ventas();
                venta_aux = venta;        
                if(venta_aux.getIdCondicion().getIdCondicion()!=1){
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar" + e,""));
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
