/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Pedidos;
import Facades.PedidosFacade;
import Entidades.PedidosDet;
import Entidades.PedidosDetPK;
import Entidades.VentasDet;
import Facades.PedidosDetFacade;
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
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.context.RequestContext;
import utils.Metodos;

/**
 *
 * @author 
 */
@Named(value = "beanPedidos2")
@SessionScoped
public class BeanPedidos2 implements Serializable {

    @EJB
    private PedidosFacade PedidosFacade;
     @EJB
    private PedidosDetFacade PedidosDetFacade;
    private List<Pedidos> listarPedidos;
    private List<PedidosDet> listarPedidosDet, listaPedidosDetAux;   
    private Pedidos pedido, pedido_aux;
    private PedidosDet pedidodet;
    private PedidosDetPK pedidodetpk;
    
    public BeanPedidos2() {
        listarPedidos=new ArrayList<>();
        listarPedidosDet = new ArrayList<>();
        listaPedidosDetAux = new ArrayList<>();
        pedido = new Pedidos();
        pedido_aux = new Pedidos();
        pedidodet = new PedidosDet();
        pedidodetpk = new PedidosDetPK();
    }

   public List<Pedidos> listarPedidos(){
        listarPedidos= PedidosFacade.findAll();
        return listarPedidos;
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
        listarPedidos = new ArrayList<>();
        listarPedidosDet = new ArrayList<>();
        listaPedidosDetAux = new ArrayList<>();
        pedido = new Pedidos();
        pedido_aux = new Pedidos();
        pedidodet = new PedidosDet();
        pedidodetpk = new PedidosDetPK();  
    }
    
    public void Inicializa() {
        
    }
       
     public void Nuevo(){
        listarPedidos = new ArrayList<>();
        listarPedidosDet = new ArrayList<>();
        listaPedidosDetAux = new ArrayList<>();
        pedido = new Pedidos();
        pedido_aux = new Pedidos();
        pedidodet = new PedidosDet();
        pedidodetpk = new PedidosDetPK();
        
        Inicializa();
        RequestContext.getCurrentInstance().execute("PF('wtbPedidosCabecera').unselectAllRows()");
        Metodos.Mensajes("Correcto", "Grabado con Exito");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Restablecido con exito"));
        RequestContext.getCurrentInstance().update("formPedidos2");
    }
    
      public void NuevoProducto() {
        this.pedidodet = new PedidosDet();
    }

    public void EliminarProducto() {
        for (int i = 0; i < listarPedidosDet.size(); i++) {
            PedidosDet fila = listarPedidosDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), pedidodet.getStock().getProductos().getIdProducto())) {
                listarPedidosDet.remove(i);
                RequestContext.getCurrentInstance().update("formPedidos2");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Eliminado"));
                RequestContext.getCurrentInstance().update("formPedidos2:tbPedidosDet2");
                RequestContext.getCurrentInstance().execute("PF('digEditarProductoPedidos2').hide()");
            }
        }
    }
    
    public void EditarProducto() {
        if(pedidodet.getCantidad().intValue()==0){
            RequestContext.getCurrentInstance().update("formAgregarProducto2");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
        }else{
            RequestContext.getCurrentInstance().update("formPedidos2");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Editado"));
            RequestContext.getCurrentInstance().update("formPedidos2:tbPedidosDet2");
            RequestContext.getCurrentInstance().execute("PF('digEditarProductoPedidos2').hide()");            
        }
    }
    
   public void AgregaProducto() {
        Integer v_bandera = 0;
        for (int i = 0; i < listarPedidosDet.size(); i++) {
            PedidosDet fila = listarPedidosDet.get(i);
            if (Objects.equals(fila.getStock().getProductos().getIdProducto(), pedidodet.getStock().getProductos().getIdProducto())) {
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede agregar registro duplicado",""));
                v_bandera = 1;
               
            }
             System.out.println("entro");
        }
        if (v_bandera != 1) {
            if(pedidodet.getCantidad().intValue()==0){
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad no puede ser 0",""));    
            }else if(pedidodet.getStock().getExistencia().intValue()<=0){
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El producto "+pedidodet.getStock().getProductos().getDescripcion()+" no se encuentra disponible",""));
            }else if (pedidodet.getCantidad().intValue() > pedidodet.getStock().getExistencia().intValue()) {
                RequestContext.getCurrentInstance().update("formAgregarProducto");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"La cantidad supera la Existencia de " + pedidodet.getStock().getExistencia().toString(),""));
            } else {
                PedidosDet fila = new PedidosDet(pedidodetpk, pedidodet.getCantidad());
                fila.setStock(pedidodet.getStock());
                listarPedidosDet.add(fila);
             //   Recalcular();
                RequestContext.getCurrentInstance().update("formNuevoPedidos2");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Agregado"));
                RequestContext.getCurrentInstance().update("formNuevoPedidos2:tbPedidosDet2");
                RequestContext.getCurrentInstance().execute("PF('digAgregarProductoPedidos2').hide()");
            }
        }
    }

      public void Grabar(){        
        try {     
             pedido.setEstado("C");
            pedido.setFechaPedido(new Date());
            pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
            PedidosFacade.create(pedido);
            for (int f = 0; f < listarPedidosDet.size(); f++) {
                pedidodet = new PedidosDet();
                pedidodetpk = new PedidosDetPK();
                pedidodet = listarPedidosDet.get(f);
                pedidodetpk.setIdDeposito(pedidodet.getStock().getDepositos().getIdDeposito());
                pedidodetpk.setIdProducto(pedidodet.getStock().getProductos().getIdProducto());                
                pedidodetpk.setIdPedido(pedido.getIdPedido());
                pedidodet.setPedidosDetPK(pedidodetpk);
                pedidodet.setPedidos(pedido);
                pedidodet.setStock(pedidodet.getStock());
                PedidosDetFacade.create(pedidodet);
            }
            RequestContext.getCurrentInstance().update("formPedidos2");    
            Metodos.Mensajes("Correcto", "Grabado con Exito");
          //  FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Grabado con Exito"));
            RequestContext.getCurrentInstance().execute("PF('digNuevoCajas').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPedidos2");
            Metodos.Mensajes("Error", "Error al Grabar"+e);
        }   
    }
      
       
       
           public List<PedidosDet> listarPedidosDet(int idPedido) {
             listarPedidosDet= PedidosDetFacade.obtenerPedidosDet(idPedido);
        return listarPedidosDet;
    }
           
   /*  
     public void Grabar(){        
        // try {
        //bancos.setEstado(estado);
        /*   PedidosFacade.create(pedido);
        RequestContext.getCurrentInstance().update("formPedidos2");
        Metodos.Mensajes("Correcto", "Grabado con Exito");
        RequestContext.getCurrentInstance().execute("PF('digNuevoPedidos2').hide()");
        } catch (Exception e) {
        RequestContext.getCurrentInstance().update("formPedidos2");
        Metodos.Mensajes("Error", "Error al grabar"+e);
        }   */ /*
        if (listarPedidosDet.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe agregar productos para continuar",""));
            RequestContext.getCurrentInstance().update("formPedidos2");
        } else if(pedido.getIdPedido()!=null){
            pedido.setFechaPedido(new Date());
            pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
            PedidosFacade.edit(pedido);
            for (int i = 0; i < listaPedidosDetAux.size(); i++) {
                PedidosDetFacade.remove(listaPedidosDetAux.get(i));
            }
            for (int f = 0; f < listarPedidosDet.size(); f++) {
                pedidodet = new PedidosDet();
                pedidodetpk = new PedidosDetPK();
                pedidodet = listarPedidosDet.get(f);
                pedidodetpk.setIdDeposito(pedidodet.getStock().getDepositos().getIdDeposito());
                pedidodetpk.setIdProducto(pedidodet.getStock().getProductos().getIdProducto());
                pedidodetpk.setIdPedido(pedido.getIdPedido());
                pedidodet.setPedidosDetPK(pedidodetpk);
                pedidodet.setPedidos(pedido);
                pedidodet.setStock(pedidodet.getStock());
                PedidosDetFacade.create(pedidodet);
            }                       
            
            RequestContext.getCurrentInstance().update("formPedidos2");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Grabado con Exito. Pedido Nro: "+pedido.getIdPedido()));
            Nuevo();
            
        } else{
            pedido.setEstado("C");
            pedido.setFechaPedido(new Date());
            pedido.setUsuariosSucursales(BeanAcceso.usuariossucursales);
            PedidosFacade.create(pedido);
            for (int f = 0; f < listarPedidosDet.size(); f++) {
                pedidodet = new PedidosDet();
                pedidodetpk = new PedidosDetPK();
                pedidodet = listarPedidosDet.get(f);
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
    }
     
     public void ObtienePedidoDet(){
        listarPedidosDet= PedidosDetFacade.obtenerPedidosDet(pedido_aux.getIdPedido());
        listaPedidosDetAux = PedidosDetFacade.obtenerPedidosDet(pedido_aux.getIdPedido());
       RequestContext.getCurrentInstance().update("formNuevoPedidos2:tbPedidosDet2");
      //  RequestContext.getCurrentInstance().update("formPedidos2:gPedidos2");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle Obtenido"));
    } */

        
     /*
     public void Editar(){        
        try {
            //bancos.setEstado(estado);
            PedidosFacade.edit(pedido);
            RequestContext.getCurrentInstance().update("formPedidos2");
            Metodos.Mensajes("Correcto", "Editado con Exito");
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrarPedidos2').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPedidos2");
            Metodos.Mensajes("Error", "Error al Editar");
        }   
    }*/
     
      public void Editar(){
        try {            
            if(pedido_aux != null){
                pedido=pedido_aux;
              //  RequestContext.getCurrentInstance().update("formAnularAprobarPedidos");
                RequestContext.getCurrentInstance().update("formPedidos2");
                Metodos.Mensajes("Correcto", "Editado con Exito");
              //  RequestContext.getCurrentInstance().execute("PF('digAnularAprobarPedidos').hide()");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecciono el Pedido Nro: "+pedido.getIdPedido())); 
            
            }else{
                RequestContext.getCurrentInstance().update("formPedidos2:gPedidos2");
                Metodos.Mensajes("Error", "Error al Editar");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar un Pedido para continuar",""));      
            }            
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPedidos2");
            Metodos.Mensajes("Error", "Error al Editar");
        /*    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al Editar" + e,""));  */          
        }
    }
      
      
     public void Borrar(){        
        try {
            //bancos.setEstado(estado);
            PedidosFacade.remove(pedido);
            RequestContext.getCurrentInstance().update("formPedidos2");
            Metodos.Mensajes("Correcto", "Borrado con Exito");
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrarPedidos2').hide()");
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formPedidos2");
            Metodos.Mensajes("Error", "Error al Borrar");
        }   
    }
     
      public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Pedidos.jasper";
        String nombrepdf = "Pedidos.pdf";
        HashMap parameters = new HashMap();
        //Inicio Parametros
        //Fin Parametros
        Metodos.impresion_reporte(parameters,nombreJasper,nombrepdf);
    } 
     
    public void Menu(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update("formPedidos2");
        }
    }
   public void Salir(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        ((HttpSession)ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Acceso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update("formPedidos2");
        }
    }
}  
 

