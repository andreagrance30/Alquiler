/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.ArqueosCajas;
import Entidades.ArqueosCajasDet;
import Entidades.ArqueosCajasDetPK;
import Facades.AperturaCierreCajaFacade;
import Facades.ArqueosCajasDetFacade;
import Facades.ArqueosCajasFacade;
import Facades.CobrosFormasDetFacade;
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
import java.util.Objects;
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
@Named(value = "beanArqueosCajas")
@SessionScoped
public class BeanArqueosCajas implements Serializable {

    @EJB
    private AperturaCierreCajaFacade AperturaCierreCajaFacade;
    
    @EJB
    private ArqueosCajasFacade ArqueosCajasFacade;   
    
    @EJB
    private ArqueosCajasDetFacade ArqueosCajasDetFacade;   
    
    @EJB
    private CobrosFormasDetFacade CobrosFormasDetFacade;
    
    private List<ArqueosCajas> listaArqueosCajas;
    private List<ArqueosCajasDet> listaArqueosCajasDet;    
    
    private ArqueosCajas arqueocaja, arqueocaja_aux;
    private ArqueosCajasDet arqueocajadet;
    private ArqueosCajasDetPK arqueocajadetpk;       
    
    public BeanArqueosCajas() {
        listaArqueosCajas=new ArrayList<>();
        arqueocaja=new ArqueosCajas();
        arqueocaja_aux=new ArqueosCajas();
        listaArqueosCajasDet=new ArrayList<>();
        arqueocajadet=new ArqueosCajasDet();
        arqueocajadetpk=new ArqueosCajasDetPK();
    }
    
    public List<ArqueosCajas> listarArqueosCajas(){
        listaArqueosCajas=ArqueosCajasFacade.findAll();
        return listaArqueosCajas;
    }

    public List<ArqueosCajasDet> listarArqueosCajasDet(){
        return listaArqueosCajasDet;
    }    
    
    public ArqueosCajas getArqueocaja() {
        return arqueocaja;
    }

    public void setArqueocaja(ArqueosCajas arqueocaja) {
        this.arqueocaja = arqueocaja;
    }

    public ArqueosCajasDet getArqueocajadet() {
        return arqueocajadet;
    }

    public void setArqueocajadet(ArqueosCajasDet arqueocajadet) {
        this.arqueocajadet = arqueocajadet;
    }

    public ArqueosCajasDetPK getArqueocajadetpk() {
        return arqueocajadetpk;
    }

    public void setArqueocajadetpk(ArqueosCajasDetPK arqueocajadetpk) {
        this.arqueocajadetpk = arqueocajadetpk;
    }
    


    //@PostConstruct
    public void Inicializa(){

    }
    public void Reporte() throws IOException, JRException, SQLException, ParseException {
        JasperPrint jasperPrint;
        String nombreJasper = "Arqueos Cajas.jasper";
        String nombrepdf ="Arqueo de caja "+Metodos.FormatoFecha(new Date()).toString()+".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_arqueo", arqueocaja_aux.getIdArqueoCaja());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }    
    
    public void Nuevo(){
        arqueocaja = new ArqueosCajas();        
        arqueocajadet =new ArqueosCajasDet(); 
        listaArqueosCajasDet = new ArrayList<>();
        Inicializa();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Restablecido con exito"));
        RequestContext.getCurrentInstance().update("formArqueosCajas");
    }
    
    public void NuevaFila(){
        arqueocajadet =new ArqueosCajasDet(); 
    }    
    
    public void EditarFila(){ 
            RequestContext.getCurrentInstance().update("formArqueosCajas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Fila Editada"));       
            RequestContext.getCurrentInstance().update("formArqueosCajas:tbArqueosCajasDet");
            RequestContext.getCurrentInstance().execute("PF('digEditarBorrarArqueo').hide()");

    }    
    
    public void EliminarFila(){
        for (int i = 0; i < listaArqueosCajasDet.size(); i++) {
            ArqueosCajasDet fila = listaArqueosCajasDet.get(i);
            if(Objects.equals(fila.getTransaccionesComerciales().getIdTransaccionComercial(), arqueocajadet.getTransaccionesComerciales().getIdTransaccionComercial())){
                listaArqueosCajasDet.remove(i);
                RequestContext.getCurrentInstance().update("formArqueosCajas");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Fila Eliminada"));       
                RequestContext.getCurrentInstance().update("formArqueosCajas:tbArqueosCajasDet");
                RequestContext.getCurrentInstance().execute("PF('digEditarBorrarArqueo').hide()");
            }
        }
    }      
    
    public void AgregarFila(){
        Integer v_bandera =0;
       /* for (int i = 0; i < listaArqueosCajasDet.size(); i++) {
            ArqueosCajasDet fila = listaArqueosCajasDet.get(i);
            if(Objects.equals(fila.getTransaccionesComerciales().getIdTransaccionComercial(), arqueocajadet.getTransaccionesComerciales().getIdTransaccionComercial())){
                RequestContext.getCurrentInstance().update("formNuevoArqueo:msg");
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"No puede agregar registro ya existente",""));
                v_bandera=1;
            }
        }*/
       /* if(v_bandera !=1){*/
            ArqueosCajasDet fila = new ArqueosCajasDet(arqueocajadetpk, arqueocajadet.getMontoFisico(), BigDecimal.ZERO);    
            fila.setTransaccionesComerciales(arqueocajadet.getTransaccionesComerciales());
            listaArqueosCajasDet.add(fila);
            RequestContext.getCurrentInstance().update("formArqueosCajas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Fila Agregada"));       
            RequestContext.getCurrentInstance().update("formArqueosCajas:tbArqueosCajasDet");
            RequestContext.getCurrentInstance().execute("PF('digNuevoArqueo').hide()");            
       // }       
    }   
    
    public void Grabar(){        
        try {            
            if(arqueocaja.getIdTipoArqueo().getIdTipoArqueo()!=1){
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Tipo Arqueo no puede ser Final",""));                
                RequestContext.getCurrentInstance().update("formArqueosCajas"); 
                Metodos.Mensajes("Error", "Tipo Arqueo no puede ser Final");
                
            }else if(listaArqueosCajasDet.isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe agregar registros para continuar",""));                
                RequestContext.getCurrentInstance().update("formArqueosCajas");     
                Metodos.Mensajes("Error", "Debe agregar registros para continuar");
            }else if(listaArqueosCajasDet.size() < 3){
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Ingresar todas las formas de cobros",""));                
                RequestContext.getCurrentInstance().update("formArqueosCajas");  
                Metodos.Mensajes("Error", "Debe Ingresar todas las formas de cobros");
            }else{
                arqueocaja.setFecha(new Date());
                arqueocaja.setIdAperturaCierreCaja(AperturaCierreCajaFacade.obtenerAperturaAbierta(BeanAcceso.usuariossucursales));
                arqueocaja.setUsuariosSucursales(BeanAcceso.usuariossucursales);
                ArqueosCajasFacade.create(arqueocaja);
                
                for (int i = 0; i < listaArqueosCajasDet.size(); i++) {                    
                    arqueocajadetpk= new ArqueosCajasDetPK();
                    arqueocajadetpk.setIdArqueoCaja(arqueocaja.getIdArqueoCaja());
                    arqueocajadetpk.setIdTransaccionComercial(listaArqueosCajasDet.get(i).getTransaccionesComerciales().getIdTransaccionComercial());
                    if(listaArqueosCajasDet.get(i).getTransaccionesComerciales().getIdTransaccionComercial()==1){
                        listaArqueosCajasDet.get(i).setMontoTeorico(CobrosFormasDetFacade.totalesTransacciones(listaArqueosCajasDet.get(i).getTransaccionesComerciales(),arqueocaja.getIdAperturaCierreCaja()).add(arqueocaja.getIdAperturaCierreCaja().getMontoInicial()));
                    }else{
                        listaArqueosCajasDet.get(i).setMontoTeorico(CobrosFormasDetFacade.totalesTransacciones(listaArqueosCajasDet.get(i).getTransaccionesComerciales(),arqueocaja.getIdAperturaCierreCaja()));
                    }
                    listaArqueosCajasDet.get(i).setArqueosCajasDetPK(arqueocajadetpk);
                    ArqueosCajasDetFacade.create(listaArqueosCajasDet.get(i));
                }                
                FacesContext.getCurrentInstance().addMessage(null , new FacesMessage("Arqueo Caja realizado con Exito"));                
                RequestContext.getCurrentInstance().update("formArqueosCajas");  
                Metodos.Mensajes("Correcto", "Arqueo Caja realizado con Exito");
                arqueocaja_aux = new ArqueosCajas();
                arqueocaja_aux=arqueocaja;
               // RequestContext.getCurrentInstance().execute("document.getElementById('formReporteArqueo:imprimir').click()"); 
                Nuevo();
            }  
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formArqueosCajas:gArqueosCajas");
            FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al realizar la apertura ",""));
             Metodos.Mensajes("Error", "Error al realizar la apertura");
        }   
    }
    
    public void Menu(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_WARN,"Error"+ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formArqueosCajas");
        }
    }
    
    public void Salir(){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        ((HttpSession)ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Acceso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage(FacesMessage.SEVERITY_WARN,"Error"+ex.getMessage(),""));
            RequestContext.getCurrentInstance().update("formArqueosCajas");
        }
    }
}    
