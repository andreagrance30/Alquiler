/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;


import Entidades.Pedidos;
import Entidades.PedidosDet;
import Entidades.PedidosDetPK;
import Facades.PedidosDetFacade;
import Facades.PedidosFacade;
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
@Named(value = "beanPedidos")
@SessionScoped
public class BeanPedidos implements Serializable {

    @EJB
    private PedidosFacade PedidosFacade;
    @EJB
    private PedidosDetFacade PedidosDetFacade;

    private List<Pedidos> listaPedidos,listaPedidosPendientes,listaPedidosAprobados;
    private List<PedidosDet> listaPedidosDet, listaPedidosDetAux;    

    private Pedidos pedido, pedido_aux, pedido_rep;
    private PedidosDet pedidodet;
    private PedidosDetPK pedidodetpk;
    
    public BeanPedidos() {
        listaPedidosPendientes = new ArrayList<>();
        listaPedidos = new ArrayList<>();
        listaPedidosDet = new ArrayList<>();
        listaPedidosDetAux = new ArrayList<>();
        pedido = new Pedidos();
        pedido_aux = new Pedidos();
        pedido_rep = new Pedidos();
        pedidodet = new PedidosDet();
        pedidodetpk = new PedidosDetPK();
    }

    public List<Pedidos> listarPedidos() {
        listaPedidos = PedidosFacade.findAll();
        return listaPedidos;
    }
    
    public List<Pedidos> listarPedidosPendientes() {
        listaPedidosPendientes = PedidosFacade.obtenerPedidosPorEstado("C");
        return listaPedidosPendientes;
    }
    
    public List<Pedidos> listarPedidosAprobados() {
        listaPedidosAprobados = PedidosFacade.obtenerPedidosPorEstado("A");
        return listaPedidosAprobados;
    }    

    public List<PedidosDet> listarPedidosDet() {
        return listaPedidosDet;
    }
        

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Pedidos getPedido_aux() {
        return pedido_aux;
    }

    public void setPedido_aux(Pedidos pedido_aux) {
        this.pedido_aux = pedido_aux;
    }
    

    public PedidosDet getPedidodet() {
        return pedidodet;
    }

    public void setPedidodet(PedidosDet pedidodet) {
        this.pedidodet = pedidodet;
    }

    @PostConstruct
    public void RutinaIncial(){
        listaPedidosPendientes = new ArrayList<>();
        listaPedidos = new ArrayList<>();
        listaPedidosDet = new ArrayList<>();
        listaPedidosDetAux = new ArrayList<>();
        pedido = new Pedidos();
        pedido_aux = new Pedidos();
        pedido_rep = new Pedidos();
        pedidodet = new PedidosDet();
        pedidodetpk = new PedidosDetPK();  
    }
    
    public void Inicializa() {
        
    }
    
    public void Reporte() throws IOException, JRException, SQLException {
        JasperPrint jasperPrint;
        String nombreJasper = "Pedidos.jasper";
        String nombrepdf = "Pedido Nro:"+pedido_rep.getIdPedido()+".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_pedido", pedido_rep.getIdPedido());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }    

    public void Nuevo() throws ParseException {
        listaPedidosPendientes = new ArrayList<>();
        listaPedidos = new ArrayList<>();
        listaPedidosDet = new ArrayList<>();
        listaPedidosDetAux = new ArrayList<>();
        pedido = new Pedidos();
        pedido_aux = new Pedidos();
        pedidodet = new PedidosDet();
        pedidodetpk = new PedidosDetPK();
        
        Inicializa();
        RequestContext.getCurrentInstance().execute("PF('wtbPedidosCabecera').unselectAllRows()");
        Metodos.Mensajes("Correcto", "Grabado con Exito");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Restablecido con exito"));
        RequestContext.getCurrentInstance().update("formPedidos");
    }

    public void NuevoProducto() {
        pedidodet = new PedidosDet();
    }

    public void EliminarProducto() {
        for (int i = 0; i < listaPedidosDet.size(); i++) {
            PedidosDet fila = listaPedidosDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), pedidodet.getStock().getProductos().getIdProducto())) {
                listaPedidosDet.remove(i);
                RequestContext.getCurrentInstance().update("formPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                RequestContext.getCurrentInstance().update("formPedidos:tbPedidosDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarProductoPedidos').hide()");
            }
        }
    }

    public void EditarProducto() {
        if(pedidodet.getCantidad().intValue()==0){
            RequestContext.getCurrentInstance().update("formAgregarProducto");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
        }else{
            RequestContext.getCurrentInstance().update("formPedidos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
            RequestContext.getCurrentInstance().update("formPedidos:tbPedidosDet");
            RequestContext.getCurrentInstance().execute("PF('digEditarProductoPedidos').hide()");            
        }
    }

    public void AgregaProducto() {
       Integer v_bandera = 0;
       /*   for (int i = 0; i < listaPedidosDet.size(); i++) {
            PedidosDet fila = listaPedidosDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), pedidodet.getStock().getProductos().getIdProducto())) {
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede agregar registro duplicado",""));
                v_bandera = 1;
            }
        }*/
        if (v_bandera != 1) {
            if(pedidodet.getCantidad().intValue()==0){
                RequestContext.getCurrentInstance().update("formAgregarProductoPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
            } else {
                    PedidosDet fila = new PedidosDet(pedidodetpk, pedidodet.getCantidad());
                    fila.setStock(pedidodet.getStock());
                    listaPedidosDet.add(fila);
                    RequestContext.getCurrentInstance().update("formPedidos");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Agregado"));
                    RequestContext.getCurrentInstance().update("formPedidos:tbPedidosDet");
                    RequestContext.getCurrentInstance().execute("PF('digAgregarProductoPedidos').hide()");    
            }
        }
   }

    public void Grabar() {
        try {
            if (listaPedidosDet.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe agregar productos para continuar",""));
                RequestContext.getCurrentInstance().update("formPedidos");
            }else if(pedido.getIdPedido()!=null){
                pedido.setFechaPedido(new Date());
                pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                PedidosFacade.edit(pedido);
                for (int i = 0; i < listaPedidosDetAux.size(); i++) {
                    PedidosDetFacade.remove(listaPedidosDetAux.get(i));
                }                
                for (int f = 0; f < listaPedidosDet.size(); f++) {
                    pedidodet = new PedidosDet();
                    pedidodetpk = new PedidosDetPK();                   
                    pedidodet = listaPedidosDet.get(f);   
                    
                    pedidodetpk.setIdDeposito(pedidodet.getStock().getDepositos().getIdDeposito());
                    pedidodetpk.setIdProducto(pedidodet.getStock().getProductos().getIdProducto());
                    pedidodetpk.setIdPedido(pedido.getIdPedido());
                    pedidodet.setPedidosDetPK(pedidodetpk);
                    pedidodet.setPedidos(pedido);
                    pedidodet.setStock(pedidodet.getStock());                    
                    PedidosDetFacade.create(pedidodet);                    
                }
                
                RequestContext.getCurrentInstance().update("formPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito. Pedido Nro: "+pedido.getIdPedido()));       
                Nuevo();                       
            
            }else{
                pedido.setEstado("C");
                pedido.setFechaPedido(new Date());
                pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                PedidosFacade.create(pedido);
                for (int f = 0; f < listaPedidosDet.size(); f++) {
                    pedidodet = new PedidosDet();
                    pedidodetpk = new PedidosDetPK();           
                    
                    pedidodet = listaPedidosDet.get(f);                    
                    pedidodetpk.setIdDeposito(pedidodet.getStock().getDepositos().getIdDeposito());
                    pedidodetpk.setIdProducto(pedidodet.getStock().getProductos().getIdProducto());
                    pedidodetpk.setIdPedido(pedido.getIdPedido());
                    pedidodet.setPedidosDetPK(pedidodetpk);
                    pedidodet.setPedidos(pedido);
                    pedidodet.setStock(pedidodet.getStock());
                    PedidosDetFacade.create(pedidodet);
                }
                
                RequestContext.getCurrentInstance().update("formPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito. Pedido Nro: "+pedido.getIdPedido()));       
                Nuevo();                
            }
        } catch (ParseException e) {
            RequestContext.getCurrentInstance().update("formPedidos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar" + e,""));
        }
    }
    public void ObtienePedidoDet(){
        listaPedidosDet=PedidosDetFacade.obtenerPedidosDet(pedido_aux.getIdPedido());
        listaPedidosDetAux = PedidosDetFacade.obtenerPedidosDet(pedido_aux.getIdPedido());
        RequestContext.getCurrentInstance().update("formAnularAprobarPedidos:tbPedidosDetalle");
        RequestContext.getCurrentInstance().update("formPedidos:gPedidos");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle Obtenido"));
    }
    
    public void Aprobar(){
        try {        
            if(pedido_aux != null){
                pedido=pedido_aux;
                pedido.setEstado("A");
                pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                PedidosFacade.edit(pedido);  
                RequestContext.getCurrentInstance().update("formAnularAprobarPedidos");
                RequestContext.getCurrentInstance().update("formPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aprobado con Exito. Pedido Nro: "+pedido.getIdPedido()));
                Metodos.Mensajes("Correcto", "Aprobado con Exito. Pedido Nro:" + pedido.getIdPedido());
                RequestContext.getCurrentInstance().execute("PF('digAnularAprobarPedidos').hide()");
                Nuevo();

                pedido_rep = new Pedidos();
                pedido_rep = pedido;           
              //  RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()");           
            }else{
                RequestContext.getCurrentInstance().update("formPedidos:gPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe Seleccionar un Pedido para continuar")); 
                Metodos.Mensajes("Advertencia","Debe Seleccionar un Pedido para continuar" );
            }
        } catch (ParseException e) {
            RequestContext.getCurrentInstance().update("formPedidos");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Aprobar" + e,""));     
             Metodos.Mensajes("Error","Error al Aprobar" );
        }                   
    }
    public void Editar(){
        try {            
            if(pedido_aux != null){
                pedido=pedido_aux;
                RequestContext.getCurrentInstance().update("formAnularAprobarPedidos");
                RequestContext.getCurrentInstance().update("formPedidos");
                Metodos.Mensajes("Correcto", "Editado con Exito");
                RequestContext.getCurrentInstance().execute("PF('digAnularAprobarPedidos').hide()");
            /*    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecciono el Pedido Nro: "+pedido.getIdPedido())); */
            
            }else{
                RequestContext.getCurrentInstance().update("formPedidos:gPedidos");
                Metodos.Mensajes("Error", "Error al Editar");
             /*   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Pedido para continuar",""));      */
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPedidos");
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
                PedidosFacade.edit(pedido);            

                RequestContext.getCurrentInstance().execute("PF('digAnularAprobarPedidos').hide()");
                RequestContext.getCurrentInstance().update("formAnularAprobarPedidos");
                RequestContext.getCurrentInstance().update("formPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Anulado con Exito. Pedido Nro: "+pedido.getIdPedido()));   
                Nuevo();
            }else{
                RequestContext.getCurrentInstance().update("formPedidos:gPedidos");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Pedido para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPedidos");
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
            RequestContext.getCurrentInstance().update("formPedidos");
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
            RequestContext.getCurrentInstance().update("formPedidos");
        }
    }
}
