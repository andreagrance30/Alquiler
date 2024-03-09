/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.AperturaCierreCaja;
import Entidades.ArqueosCajas;
import Entidades.ArqueosCajasDet;
import Entidades.ArqueosCajasDetPK;
import Entidades.Cajas;
import Entidades.RecaudacionesDepositar;
import Facades.AperturaCierreCajaFacade;
import Facades.ArqueosCajasDetFacade;
import Facades.ArqueosCajasFacade;
import Facades.CajasFacade;
import Facades.CobrosFormasDetFacade;
import Facades.RecaudacionesDepositarFacade;
import Facades.TiposArqueosFacade;
import Facades.TransaccionesComercialesFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
 * @author 
 */
@Named(value = "beanAperturaCierreCaja")
@SessionScoped
public class BeanAperturaCierreCaja implements Serializable { 
    @EJB
    private AperturaCierreCajaFacade AperturaCierreCajaFacade;
    @EJB
    private CajasFacade CajasFacade;    
    @EJB
    private CobrosFormasDetFacade CobrosFormasDetFacade ;
    @EJB
    private TransaccionesComercialesFacade TransaccionesComercialesFacade ;
    @EJB
    private RecaudacionesDepositarFacade RecaudacionesDepositarFacade ;
    @EJB
    private ArqueosCajasFacade ArqueosCajasFacade ;
    @EJB
    private ArqueosCajasDetFacade ArqueosCajasDetFacade ;
    @EJB
    private TiposArqueosFacade TiposArqueosFacade;
    
    
    private List<AperturaCierreCaja> listaAperturaCierreCaja;
    
    private AperturaCierreCaja aperturacierrecaja;
    private Cajas caja;
           
    public BeanAperturaCierreCaja() {
        listaAperturaCierreCaja=new ArrayList<>();
        aperturacierrecaja=new AperturaCierreCaja();
        caja = new Cajas();
    }
    
    public List<AperturaCierreCaja> listarAperturaCierreCaja(){
        listaAperturaCierreCaja=AperturaCierreCajaFacade.findAll();
        return listaAperturaCierreCaja;
    }

    public AperturaCierreCaja getAperturacierrecaja() {
        return aperturacierrecaja;
    }

    public void setAperturacierrecaja(AperturaCierreCaja aperturacierrecaja) {
        this.aperturacierrecaja = aperturacierrecaja;
        
    }
    //@PostConstruct
    public void Inicializa(){
        aperturacierrecaja = AperturaCierreCajaFacade.obtenerAperturaAbierta(BeanAcceso.usuariossucursales);
        if(aperturacierrecaja == null){   
            aperturacierrecaja =new AperturaCierreCaja();
            aperturacierrecaja.setUsuariosSucursales(BeanAcceso.usuariossucursales);
            aperturacierrecaja.setFechaApertura(new Date());
            aperturacierrecaja.setMontoInicial(new BigInteger("100000"));
            RequestContext.getCurrentInstance().execute("document.getElementById('formAperturaCierreCaja:montotarjeta').readOnly = true");   
            RequestContext.getCurrentInstance().execute("document.getElementById('formAperturaCierreCaja:montocheque').readOnly = true");
            RequestContext.getCurrentInstance().execute("document.getElementById('formAperturaCierreCaja:montoefectivo').readOnly = true");
            RequestContext.getCurrentInstance().execute("document.getElementById('formAperturaCierreCaja:btncierre').style.display = 'none'");
            RequestContext.getCurrentInstance().update("formAperturaCierreCaja");            
            Metodos.Mensajes("Advertencia", "Usuario no cuenta con Caja Abierta ");
        }else{
            aperturacierrecaja.setMontoEfectivoCierre(new BigInteger("0"));
            aperturacierrecaja.setMontoChequeCierre(new BigInteger("0"));
            aperturacierrecaja.setMontoTarjetaCierre(new BigInteger("0"));
            caja = aperturacierrecaja.getIdCaja();
            RequestContext.getCurrentInstance().execute("document.getElementById('formAperturaCierreCaja:montoincial').readOnly = true");
            RequestContext.getCurrentInstance().execute("document.getElementById('formAperturaCierreCaja:caja').disabled = true");
            RequestContext.getCurrentInstance().execute("document.getElementById('formAperturaCierreCaja:btnapertura').style.display = 'none'");
            RequestContext.getCurrentInstance().update("formAperturaCierreCaja");         
            Metodos.Mensajes("Advertencia", "Usuario cuenta con Caja Abierta ");
        }
    }
    public void Apertura(){        
       try {
            if(aperturacierrecaja.getIdCaja().getEstado()== null){
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
                 Metodos.Mensajes("Advertencia", "Debe tener una Caja para la Apertura");
                //FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Debe tener una Caja para la Apertura"));
            }else if(aperturacierrecaja.getMontoInicial()== null){
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
                //FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Debe ingresar Monto Inicial"));      
                Metodos.Mensajes("Advertencia", "Debe ingresar Monto Inicial");
            }
            else if("A".equals(aperturacierrecaja.getIdCaja().getEstado())){
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
                //FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("No puede abrir una caja ya Abierta"));         
                Metodos.Mensajes("Advertencia", "No puede abrir una caja ya Abierta");
            }else{
                caja=CajasFacade.obtenerCaja(aperturacierrecaja.getIdCaja().getIdCaja());
                caja.setEstado("A");
                CajasFacade.edit(caja);
                AperturaCierreCajaFacade.create(aperturacierrecaja);
                 Metodos.Mensajes("Correcto", "Apertura Realizada con Exito");
                //FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Apertura Realizada con Exito"));                
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja");            
                Inicializa();
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
            Metodos.Mensajes("Error", "Error al realizar la apertura");
           //FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Error al realizar la apertura "));
        }   
    }
    
    public void Cierre(){        
        try {
            if(aperturacierrecaja.getMontoEfectivoCierre() == null||aperturacierrecaja.getMontoChequeCierre()==null||aperturacierrecaja.getMontoTarjetaCierre()==null){
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Debe Ingresar Montos de Cierre"));                  
            }else if(aperturacierrecaja.getMontoEfectivoCierre().compareTo(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(1), aperturacierrecaja))!=0){
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Hay diferencia en Monto Cierre Efectivo, verifique"));   
            }else if(aperturacierrecaja.getMontoChequeCierre().compareTo(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(2), aperturacierrecaja))!=0){
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Hay diferencia en Monto Cierre Cheque, verifique"));   
            }else if(aperturacierrecaja.getMontoTarjetaCierre().compareTo(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(3), aperturacierrecaja))!=0){
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Hay diferencia en Monto Cierre Tarjeta, verifique"));   
            }else{
                caja.setEstado("C");
                CajasFacade.edit(caja); 
                aperturacierrecaja.setIdCaja(caja);
                aperturacierrecaja.setDifMontoEfectivoCierre(aperturacierrecaja.getMontoEfectivoCierre().subtract(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(1), aperturacierrecaja)));
                aperturacierrecaja.setDifMontoChequeCierre(aperturacierrecaja.getMontoChequeCierre().subtract(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(2), aperturacierrecaja)));
                aperturacierrecaja.setDifMontoTarjetaCierre(aperturacierrecaja.getMontoTarjetaCierre().subtract(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(3), aperturacierrecaja)));
                AperturaCierreCajaFacade.edit(aperturacierrecaja);
                /*
                RecaudacionesDepositar recaudaciondepositar = new RecaudacionesDepositar();
                recaudaciondepositar.setEstado("C");
                recaudaciondepositar.setFecha(new Date());
                recaudaciondepositar.setIdAperturaCierreCaja(aperturacierrecaja);
                recaudaciondepositar.setTotalEfectivo(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(1), aperturacierrecaja));
                recaudaciondepositar.setTotalCheque(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(2), aperturacierrecaja));
                RecaudacionesDepositarFacade.create(recaudaciondepositar);
                
                ArqueosCajas arqueocaja = new ArqueosCajas();                
                arqueocaja.setFecha(new Date());
                arqueocaja.setIdTipoArqueo(TiposArqueosFacade.find(2));
                arqueocaja.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                arqueocaja.setIdAperturaCierreCaja(aperturacierrecaja);
                ArqueosCajasFacade.create(arqueocaja);
                
                
                ArqueosCajasDet arqueocajadet = new ArqueosCajasDet();
                ArqueosCajasDetPK arqueocajadetpk = new ArqueosCajasDetPK();                
                
                arqueocajadetpk.setIdArqueoCaja(arqueocaja.getIdArqueoCaja());
                arqueocajadet.setTransaccionesComerciales(TransaccionesComercialesFacade.find(1));
                arqueocajadet.setArqueosCajasDetPK(arqueocajadetpk);
                arqueocajadet.setMontoFisico(aperturacierrecaja.getMontoEfectivoCierre());
                arqueocajadet.setMontoTeorico(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(1), aperturacierrecaja));
                ArqueosCajasDetFacade.create(arqueocajadet);
                
                arqueocajadet = new ArqueosCajasDet();
                arqueocajadetpk = new ArqueosCajasDetPK();                
                arqueocajadetpk.setIdArqueoCaja(arqueocaja.getIdArqueoCaja());
                arqueocajadet.setTransaccionesComerciales(TransaccionesComercialesFacade.find(2));
                arqueocajadet.setArqueosCajasDetPK(arqueocajadetpk);
                arqueocajadet.setMontoFisico(aperturacierrecaja.getMontoChequeCierre());
                arqueocajadet.setMontoTeorico(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(2), aperturacierrecaja));
                ArqueosCajasDetFacade.create(arqueocajadet);                
                
                arqueocajadet = new ArqueosCajasDet();
                arqueocajadetpk = new ArqueosCajasDetPK();                
                arqueocajadetpk.setIdArqueoCaja(arqueocaja.getIdArqueoCaja());
                arqueocajadet.setTransaccionesComerciales(TransaccionesComercialesFacade.find(3));
                arqueocajadet.setArqueosCajasDetPK(arqueocajadetpk);
                arqueocajadet.setMontoFisico(aperturacierrecaja.getMontoTarjetaCierre());
                arqueocajadet.setMontoTeorico(CobrosFormasDetFacade.totalesTransacciones(TransaccionesComercialesFacade.find(3), aperturacierrecaja));
                ArqueosCajasDetFacade.create(arqueocajadet);                
                
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Arqueo Caja Realizado con Exito"));  
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Recaudaciones Realizado con Exito"));
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Cierre Realizado con Exito"));    
                RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");*/
                Inicializa();
            }              
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formAperturaCierreCaja:gAperturaCierreCaja");
            Metodos.Mensajes("Error", "Error al realizar el cierre "+e);
        }   
    }
    
    
   public void Menu(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update("formAperturaCierreCaja");
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
            RequestContext.getCurrentInstance().update("formAperturaCierreCaja");
        }
    }
              public void Reporte() throws IOException, JRException, SQLException {
        String nombreJasper = "Apertura_Cierre.jasper";
        String nombrepdf = "Apertura_Cierre.pdf";
        HashMap parameters = new HashMap();
        //Inicio Parametros
     /*   parameters.put("p_estado", estado);
        parameters.put("p_sucursal_desde", sucursal_d);
        parameters.put("p_sucursal_hasta", sucursal_h);   */
        //Fin Parametros
        Metodos.impresion_reporte(parameters,nombreJasper,nombrepdf);
    }  
}    
