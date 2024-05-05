/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import beans.BeanAcceso;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.context.RequestContext;

/**
 *
 * @author 
 */
@Named(value = "Metodos")
@SessionScoped
public class Metodos implements Serializable{
    
    public static String AgregarCeros(String numero, int cantidad) {
        String ceros = "";
        for (int i = 0; i < cantidad - numero.trim().length(); i++) {
            ceros = ceros + "0";
        }
        return ceros + numero;
    }
    
    public static Date SumarMeses(int meses, Date fecha){
        Calendar calendario=Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.MONTH,meses);
        return calendario.getTime();
    } 
    public static Date FormatoFecha(Date fecha) throws ParseException{
        Date fecha_formateada;
        if (fecha != null){
            fecha_formateada = new SimpleDateFormat("dd/MM/yyyy").parse(new SimpleDateFormat("dd/MM/yyyy").format(fecha));
            return fecha_formateada;            
        }else{
            return null;
        }
    }
    public static String FormatoNumero(BigInteger numero) {
        String result;
        result =NumberFormat.getNumberInstance().format(numero);
        return result;
    }
    
    public static void impresion_reporte(HashMap parameters,String nombreJasper, String nombrepdf) throws JRException, IOException{
        JasperPrint jasperPrint;
        /*Parametros Globales*/
        parameters.put("p_usuario", BeanAcceso.usuariossucursales.getUsuarios().getIdUsuario());
        parameters.put("p_sucursal", BeanAcceso.usuariossucursales.getSucursales().getDescripcion());
        /*Fin Parametros Globales*/
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();        
    }
   public void Menu(String form){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Menu Principal.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update(form);
        }
    }
   
     public void Caja(String form){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/referenciales/Cajas.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update(form);
        }
    }
     
   public void Salir(String form){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        ((HttpSession)ctx.getSession(false)).invalidate();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Acceso.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update(form);
        }
    }   
   public static void Mensajes(String tipo,String mensaje){
       if(tipo.compareTo("Error")==0){
           FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_ERROR,mensaje,null));
           RequestContext.getCurrentInstance().update("formPrincipal:gError");
       }else if(tipo.compareTo("Advertencia")==0){
           FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_WARN,mensaje,null));
           RequestContext.getCurrentInstance().update("formPrincipal:gWarning");
       }else{
           FacesContext.getCurrentInstance().addMessage(null , new FacesMessage(FacesMessage.SEVERITY_INFO,mensaje,null));
           RequestContext.getCurrentInstance().update("formPrincipal:gInfo");
       }
       
   }

public void Productos (String form){
        ExternalContext ctx=FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath=((ServletContext)ctx.getContext()).getContextPath();
        try {
            ctx.redirect(ctxPath+"/faces/formularios/Productos.xhtml");
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null ,new FacesMessage("Error"+ex.getMessage()));
            RequestContext.getCurrentInstance().update(form);
        }
    }

}