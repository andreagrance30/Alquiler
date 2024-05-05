/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import Entidades.Clientes;
import Entidades.Cobros;
import Entidades.CobrosCheques;
import Entidades.CobrosDet;
import Entidades.CobrosDetPK;
import Entidades.CobrosFormasDet;
import Entidades.CobrosFormasDetPK;
import Entidades.CobrosTarjetas;
import Entidades.Condiciones;
import Entidades.CuentasCobrar;
import Entidades.TransaccionesComerciales;
import Facades.AperturaCierreCajaFacade;
import Facades.CobrosChequesFacade;
import Facades.CobrosDetFacade;
import Facades.CobrosFacade;
import Facades.CobrosFormasDetFacade;
import Facades.CobrosTarjetasFacade;
import Facades.CuentasCobrarFacade;
import Facades.TransaccionesComercialesFacade;
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
@Named(value = "beanCobros")
@SessionScoped
public class BeanCobros implements Serializable {

    @EJB
    private AperturaCierreCajaFacade AperturaCierreCajaFacade;
    
    @EJB
    private TransaccionesComercialesFacade TransaccionesComercialesFacade;

    @EJB
    private CobrosFacade CobrosFacade;

    @EJB
    private CobrosDetFacade CobrosDetFacade;    
    
    @EJB
    private CuentasCobrarFacade CuentasCobrarFacade;  
    
    @EJB
    private CobrosTarjetasFacade CobrosTarjetasFacade;

    @EJB
    private CobrosChequesFacade CobrosChequesFacade;    
    
    @EJB
    private CobrosFormasDetFacade CobrosFormasDetFacade;   
      
         
    
    
    public BeanCobros() {
        totalseleccionado= BigInteger.ZERO; 
        intereses= BigInteger.ZERO;
        vuelto= BigInteger.ZERO;
        totalpagar= BigInteger.ZERO;
        
        listaCobrosTarjetas = new ArrayList();
        listaCobrosCheques = new ArrayList();
        listaCobrosFormasDet = new ArrayList();
        listaCuentasCobrarPendiente = new ArrayList();
        
        cliente = new Clientes();
        condicion = new Condiciones();
        cuentacobrar = new listaCuentasCobrar();
        transaccioncomercial = new TransaccionesComerciales();
        cobrotarjeta = new CobrosTarjetas();
        cobrocheque = new CobrosCheques();
        cobroformadet = new CobrosFormasDet();
        cobro= new Cobros();
        cobro_aux= new Cobros();
    }

    private Clientes cliente;
    private Condiciones condicion;
    private listaCuentasCobrar cuentacobrar;
    private TransaccionesComerciales transaccioncomercial;
    private CobrosTarjetas cobrotarjeta;
    private CobrosCheques cobrocheque;
    private CobrosFormasDet cobroformadet;
    private Cobros cobro, cobro_aux;
    
    private BigInteger totalseleccionado, intereses, vuelto, totalpagar;
    
    
    private List<listaCuentasCobrar> listaCuentasCobrarPendiente;
    private List<CobrosFormasDet> listaCobrosFormasDet;
    private List<CobrosTarjetas> listaCobrosTarjetas;
    private List<CobrosCheques> listaCobrosCheques;
    
    public class listaCuentasCobrar implements Serializable{
        private CuentasCobrar cuentacobrar;  
        private Boolean seleccionado;

        public CuentasCobrar getCuentaCobrar() {
            return cuentacobrar;
        }

        public void setCuentaCobrar(CuentasCobrar cuentacobrar) {
            this.cuentacobrar = cuentacobrar;
        }

        public Boolean getSeleccionado() {
            return seleccionado;
        }

        public void setSeleccionado(Boolean seleccionado) {
            this.seleccionado = seleccionado;
        }
        

    }    
    
    //Listas
    public List<listaCuentasCobrar> listarCuentasCobrarPendientes() {
        return listaCuentasCobrarPendiente;
    }        
    
    public List<CobrosFormasDet> listarCobrosFormasDet() {
        return listaCobrosFormasDet;
    }    
    public List<CobrosTarjetas> listarCobrosTarjetas() {
        return listaCobrosTarjetas;
    }

    public List<CobrosCheques> listarCobrosCheques() {
        return listaCobrosCheques;
    }
    
    //Variables
    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Condiciones getCondicion() {
        return condicion;
    }

    public void setCondicion(Condiciones condicion) {
        this.condicion = condicion;
    }

    public listaCuentasCobrar getCuentacobrar() {
        return cuentacobrar;
    }

    public void setCuentacobrar(listaCuentasCobrar cuentacobrar) {
        this.cuentacobrar = cuentacobrar;
    }
    


    public TransaccionesComerciales getTransaccioncomercial() {
        return transaccioncomercial;
    }

    public void setTransaccioncomercial(TransaccionesComerciales transaccioncomercial) {
        this.transaccioncomercial = transaccioncomercial;
    }

    public CobrosTarjetas getCobrotarjeta() {
        return cobrotarjeta;
    }

    public void setCobrotarjeta(CobrosTarjetas cobrotarjeta) {
        this.cobrotarjeta = cobrotarjeta;
    }

    public CobrosCheques getCobrocheque() {
        return cobrocheque;
    }

    public void setCobrocheque(CobrosCheques cobrocheque) {
        this.cobrocheque = cobrocheque;
    }

    public CobrosFormasDet getCobroformadet() {
        return cobroformadet;
    }

    public void setCobroformadet(CobrosFormasDet cobroformadet) {
        this.cobroformadet = cobroformadet;
    }


    
    

    public BigInteger getTotalseleccionado() {
        return totalseleccionado;
    }

    public void setTotalseleccionado(BigInteger totalseleccionado) {
        this.totalseleccionado = totalseleccionado;
    }

    public BigInteger getIntereses() {
        return intereses;
    }

    public void setIntereses(BigInteger intereses) {
        this.intereses = intereses;
    }

    public BigInteger getVuelto() {
        return vuelto;
    }

    public void setVuelto(BigInteger vuelto) {
        this.vuelto = vuelto;
    }

    public BigInteger getTotalpagar() {
        return totalpagar;
    }

    public void setTotalpagar(BigInteger totalpagar) {
        this.totalpagar = totalpagar;
    }

    public Cobros getCobro() {
        return cobro;
    }

    public void setCobro(Cobros cobro) {
        this.cobro = cobro;
    }

    
    public void Inicializa(){
        cobro.setNroRecibo(CobrosFacade.obtenerNroRecibo());
    }    
    public void Reporte() throws IOException, JRException, SQLException {
        JasperPrint jasperPrint;
        String nombreJasper = "Cobros.jasper";
        String nombrepdf ="Recibo Nro: "+cobro_aux.getNroRecibo()+".pdf";
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String rep = ctx.getRealPath(nombreJasper);
        HashMap parameters = new HashMap();
        //Inicio Parametros
        parameters.put("p_id_cobro", cobro_aux.getIdCobro());
        //Fin Parametros
        jasperPrint = JasperFillManager.fillReport(rep, parameters,Conexion.retornaconexion());
        HttpServletResponse httpser = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpser.addHeader("Content-Disposition", "inline; filename=\""+nombrepdf+"\";");    
        ServletOutputStream servletOutputStream = httpser.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream); 
        FacesContext.getCurrentInstance().responseComplete();
    }   
    public void Nuevo(){
        totalseleccionado= BigInteger.ZERO; 
        intereses= BigInteger.ZERO;
        vuelto= BigInteger.ZERO;
        totalpagar= BigInteger.ZERO;
        
        listaCobrosTarjetas = new ArrayList();
        listaCobrosCheques = new ArrayList();
        listaCobrosFormasDet = new ArrayList();
        listaCuentasCobrarPendiente = new ArrayList();
        
        cliente = new Clientes();
        condicion = new Condiciones();
        cuentacobrar = new listaCuentasCobrar();
        transaccioncomercial = new TransaccionesComerciales();
        cobrotarjeta = new CobrosTarjetas();
        cobrocheque = new CobrosCheques();
        cobroformadet = new CobrosFormasDet();
        cobro= new Cobros();
        Inicializa();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Restablecido con exito"));
        RequestContext.getCurrentInstance().update("formCobros");
        RequestContext.getCurrentInstance().update("formCuentasCobrar");
        RequestContext.getCurrentInstance().update("formCobroForma");
    }
    
    public void AceptarClientes(){
        Integer clie =null;
        Integer cond=null;
        if(cliente != null &&condicion !=null){
            clie = cliente.getIdCliente();
            cond = condicion.getIdCondicion();
        }
        if ( clie != null && cond !=null) {
            listaCuentasCobrarPendiente = new ArrayList<>();
            List<CuentasCobrar> listaAux;
            listaAux = CuentasCobrarFacade.listaCuentasClientesCondicon(cliente.getIdCliente(), condicion.getIdCondicion());
            if (listaAux != null) {
                for (int i = 0; i < listaAux.size(); i++) {
                    CuentasCobrar cta = listaAux.get(i);
                    BeanCobros.listaCuentasCobrar dto = new BeanCobros.listaCuentasCobrar();
                    dto.setCuentaCobrar(cta);
                    dto.setSeleccionado(false);
                    listaCuentasCobrarPendiente.add(dto);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registros Recuperados"));
                RequestContext.getCurrentInstance().update("formCobros:gCobros");
                RequestContext.getCurrentInstance().update("formCuentasCobrar:dtCuentasCobrar");
            } else {
                listaCuentasCobrarPendiente = new ArrayList<>();
                SumarSeleccionados();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No existen registros"));
                RequestContext.getCurrentInstance().update("formCobros:gCobros");
                RequestContext.getCurrentInstance().update("formCuentasCobrar:dtCuentasCobrar");
            }
        } else {
            listaCuentasCobrarPendiente = new ArrayList<>();
            SumarSeleccionados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Selecionar un Cliente y una Condicion",""));
            RequestContext.getCurrentInstance().update("formCobros");
        }
    }
    public void SumarSeleccionados(){
        totalpagar = BigInteger.ZERO;
        intereses = BigInteger.ZERO;
        totalseleccionado = BigInteger.ZERO;
        for (int i = 0; i <listaCuentasCobrarPendiente.size(); i++) {
            if(listaCuentasCobrarPendiente.get(i).getSeleccionado().equals(true)){
                totalseleccionado = totalseleccionado.add(listaCuentasCobrarPendiente.get(i).getCuentaCobrar().getImporte());
                intereses = intereses.add(listaCuentasCobrarPendiente.get(i).getCuentaCobrar().getInteres());
            }
        }
        totalpagar= totalseleccionado.add(intereses);
        SumarFormasCobros();
        RequestContext.getCurrentInstance().update("formCuentasCobrar");
    }
    
    public void SumarFormasCobros(){
        BigInteger total=BigInteger.ZERO;
        //Cobro Efectivo
        for (int i = 0; i < listaCobrosFormasDet.size(); i++) {
            total = total.add(listaCobrosFormasDet.get(i).getMontoDet());
        }
        //Cobro Tarjetas
        for (int i = 0; i < listaCobrosTarjetas.size(); i++) {
            total = total.add(listaCobrosTarjetas.get(i).getMontoTarjeta());
        }
        //Cobro Cheques
 /*       for (int i = 0; i < listaCobrosCheques.size(); i++) {
            total = total.add(listaCobrosCheques.get(i).getMontoCheque());
        }        */
        vuelto= total.subtract(totalseleccionado);
        RequestContext.getCurrentInstance().update("formCuentasCobrar:totales");
    }
    
    public void AceptarEditarCuentasCobrar(){
        CuentasCobrar aux_cc = CuentasCobrarFacade.find(cuentacobrar.getCuentaCobrar().getIdCuentaCobrar());
        if(cuentacobrar.cuentacobrar.getImporte()!= BigInteger.ZERO){
            if(aux_cc.getImporte().longValue()<cuentacobrar.cuentacobrar.getImporte().longValue()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El monto no puede ser mayor al ingresado",""));
                RequestContext.getCurrentInstance().update("formEditarCuentasCobrar");
            }else{
                if(cuentacobrar.getSeleccionado().equals(true)){
                    SumarSeleccionados();
                }
                RequestContext.getCurrentInstance().update("formCuentasCobrar:dtCuentasCobrar");
                RequestContext.getCurrentInstance().execute("PF('digEditarCuentasCobrar').hide()");                    
            }            
        }else{            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"El monto debe ser mayor a 0",""));
            RequestContext.getCurrentInstance().update("formEditarCuentasCobrar");
        }            
    }
    
    public void AceptarFormaCobro(){
        Integer v_cont=0;
        if(listaCuentasCobrarPendiente.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe tener datos para continuar ",""));
            RequestContext.getCurrentInstance().update("formCobros:gCobros");
        }else{
            for (int i = 0; i < listaCuentasCobrarPendiente.size(); i++) {
                if(listaCuentasCobrarPendiente.get(i).seleccionado==true){
                    v_cont = v_cont + 1;
                }
            }
            if(v_cont>0){
                RequestContext.getCurrentInstance().execute("PF('digFormaCobro').show()"); 
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar registros para continuar ",""));
                RequestContext.getCurrentInstance().update("formCobros:gCobros");
            }            
        }
    }
    
    public void AceptarTransaccionComercial(){
        Integer id_transaccion =transaccioncomercial.getIdTransaccionComercial();
        if(id_transaccion!=null){
            switch (id_transaccion) {
                case 1:
                    Integer v_result=0;
                    for (int i = 0; i < listaCobrosFormasDet.size(); i++) {
                        if(listaCobrosFormasDet.get(i).getTransaccionesComerciales().equals(transaccioncomercial)){
                            v_result = v_result +1;
                        } 
                    }
                    if(v_result==0){
                        cobroformadet = new CobrosFormasDet();
                        RequestContext.getCurrentInstance().update("formEfectivo");
                        RequestContext.getCurrentInstance().execute("PF('digEfectivo').show()");                        
                    }else{
                        RequestContext.getCurrentInstance().execute("PF('digFormaCobro').hide()");    
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Efectivo ya agregado, elimine y vuelva a agregar",""));
                        RequestContext.getCurrentInstance().update("formCobros:gCobros");
                    }
                    break;
                case 3:
                    cobrotarjeta = new CobrosTarjetas();
                    RequestContext.getCurrentInstance().update("formTarjeta");
                    RequestContext.getCurrentInstance().execute("PF('digTarjeta').show()");
                    break;
                case 2:
                    cobrocheque = new CobrosCheques();
                    RequestContext.getCurrentInstance().update("formCheque");
                    RequestContext.getCurrentInstance().execute("PF('digCheque').show()");
                    break;
                default:
                    break;
            } 
        }   
    }
     
    
    public void AceptarCobroTarjeta(){
        //For para validar nro ticket si esta utilizado
        Integer v_cont=0;
        for (int i = 0; i < listaCobrosTarjetas.size(); i++) {
            if(listaCobrosTarjetas.get(i).getNroTicket() == cobrotarjeta.getNroTicket()){
                v_cont= v_cont+1;
            }
        }        
        if(cobrotarjeta.getMontoTarjeta().equals( BigInteger.ZERO)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Monto debe ser mayor a 0",""));
            RequestContext.getCurrentInstance().update("formTarjeta");
        }else if((BigInteger.ZERO.subtract(vuelto)).compareTo(cobrotarjeta.getMontoTarjeta())==-1){           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Monto Tarjeta no puede pasar el monto de "+Metodos.FormatoNumero(BigInteger.ZERO.subtract(vuelto)),""));
            RequestContext.getCurrentInstance().update("formTarjeta");        
        }/*else if(cobrotarjeta.getNroTarjeta().length()<15){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe ingresar correctamente Nro Tarjeta",""));
            RequestContext.getCurrentInstance().update("formTarjeta");
        }*/else if(cobrotarjeta.getNroTicket()== 0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe ingresar correctamente Nro Ticket",""));
            RequestContext.getCurrentInstance().update("formTarjeta");
        }else if(CobrosTarjetasFacade.verificaNroTicket(cobrotarjeta.getNroTicket())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Nro Ticket ya esta utilizado en un pago",""));
            RequestContext.getCurrentInstance().update("formTarjeta");
        }else if(v_cont>0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Nro Ticket ya esta utilizado",""));
            RequestContext.getCurrentInstance().update("formTarjeta");
        }else{
            
            CobrosTarjetas aux_tar= new CobrosTarjetas();
            aux_tar.setIdCobroTarjeta(listaCobrosTarjetas.size()+1);
            aux_tar.setNroTarjeta(cobrotarjeta.getNroTarjeta());
            aux_tar.setNroTicket(cobrotarjeta.getNroTicket());
            aux_tar.setMontoTarjeta(cobrotarjeta.getMontoTarjeta());
            aux_tar.setIdTarjeta(cobrotarjeta.getIdTarjeta());
            listaCobrosTarjetas.add(aux_tar);

            SumarFormasCobros();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Forma de Cobro Agregado"));
            RequestContext.getCurrentInstance().update("formCobros:gCobros");
            RequestContext.getCurrentInstance().update("formCobroForma");
            RequestContext.getCurrentInstance().execute("PF('digTarjeta').hide()");
            RequestContext.getCurrentInstance().execute("PF('digFormaCobro').hide()");
        }
    }   
    
    public void AceptarCobroCheque() throws ParseException{
        //For para validar cheque si esta utilizado
        Integer v_cont=0;
      /*  for (int i = 0; i < listaCobrosCheques.size(); i++) {
            if(listaCobrosCheques.get(i).getNroCheque().equals(cobrocheque.getNroCheque())&&
               listaCobrosCheques.get(i).getIdEntidadEmisora().getIdEntidadEmisora().equals(cobrocheque.getIdEntidadEmisora().getIdEntidadEmisora())&&
               listaCobrosCheques.get(i).getCuentaEmisor().equals(cobrocheque.getCuentaEmisor())){
                v_cont= v_cont+1;
            }
        }        */
  /*      if(cobrocheque.getMontoCheque().equals( BigInteger.ZERO)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Monto debe ser mayor a 0",""));
            RequestContext.getCurrentInstance().update("formCheque");
        }else if((BigInteger.ZERO.subtract(vuelto)).compareTo(cobrocheque.getMontoCheque())==-1){           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Monto Cheque no puede pasar el monto de "+Metodos.FormatoNumero(BigInteger.ZERO.subtract(vuelto)),""));
            RequestContext.getCurrentInstance().update("formCheque");        
        }else if(cobrocheque.getCuentaEmisor().length()<8){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe ingresar correctamente Cuenta Emisor",""));
            RequestContext.getCurrentInstance().update("formCheque");
        }else */if(cobrocheque.getNroCheque().length()<6){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe ingresar correctamente Nro Cheque",""));
            RequestContext.getCurrentInstance().update("formCheque");
        }else if(!Metodos.FormatoFecha(cobrocheque.getFechaEmision()).equals(Metodos.FormatoFecha(new Date()))){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Fecha Emision debe ser de este dia",""));
            RequestContext.getCurrentInstance().update("formCheque");            
        }else if(cobrocheque.getIdTipoCheque().getIdTipoCheque()==1 && cobrocheque.getFechaRetiro()==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe ingresar Fecha Vencimiento",""));
            RequestContext.getCurrentInstance().update("formCheque");
        }else if(cobrocheque.getIdTipoCheque().getIdTipoCheque()==1&&(Metodos.FormatoFecha(cobrocheque.getFechaRetiro()).before(Metodos.FormatoFecha(new Date())))){ 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Fecha Vencimiento no debe ser menor de este dia",""));
            RequestContext.getCurrentInstance().update("formCheque"); 
        }/*else if(CobrosChequesFacade.verificaCheque(cobrocheque.getNroCheque(),cobrocheque.getIdEntidadEmisora() ,cobrocheque.getCuentaEmisor())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Cheque ya utilizado en un pago",""));
            RequestContext.getCurrentInstance().update("formCheque");
        }*/else if(v_cont>0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Cheque ya utilizado",""));
            RequestContext.getCurrentInstance().update("formCheque");
        }else{            
            CobrosCheques aux_ch= new CobrosCheques();        
            aux_ch.setIdCobroCheque(listaCobrosCheques.size()+1);
            aux_ch.setIdEntidadEmisora(cobrocheque.getIdEntidadEmisora());
            aux_ch.setEstado("P");
            aux_ch.setNroCheque(cobrocheque.getNroCheque());
    //        aux_ch.setCuentaEmisor(cobrocheque.getCuentaEmisor());
            aux_ch.setFechaEmision(cobrocheque.getFechaEmision());
            aux_ch.setIdTipoCheque(cobrocheque.getIdTipoCheque());
            aux_ch.setFechaRetiro(cobrocheque.getFechaRetiro());
     //       aux_ch.setMontoCheque(cobrocheque.getMontoCheque());
            listaCobrosCheques.add(aux_ch);

            SumarFormasCobros();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Forma de Cobro Agregado"));
            RequestContext.getCurrentInstance().update("formCobros:gCobros");
            RequestContext.getCurrentInstance().update("formCobroForma");
            RequestContext.getCurrentInstance().execute("PF('digCheque').hide()");
            RequestContext.getCurrentInstance().execute("PF('digFormaCobro').hide()");
        }        
    }    
    
    public void AceptarCobroEfectivo(){
        if (cobroformadet.getMontoDet().equals(BigInteger.ZERO)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Monto debe ser mayor a 0"));
            RequestContext.getCurrentInstance().update("formEfectivo");
        } else {
            CobrosFormasDet detf = new CobrosFormasDet();
            detf.setTransaccionesComerciales(transaccioncomercial);
            detf.setMontoDet(cobroformadet.getMontoDet());
            listaCobrosFormasDet.add(detf);

            SumarFormasCobros();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Forma de Cobro Agregado"));
            RequestContext.getCurrentInstance().update("formCobros:gCobros");
            RequestContext.getCurrentInstance().update("formCobroForma");
            RequestContext.getCurrentInstance().execute("PF('digEfectivo').hide()");
            RequestContext.getCurrentInstance().execute("PF('digFormaCobro').hide()");
        }        
    }
    
    public void EliminarEfectivo(){
        listaCobrosFormasDet.remove(cobroformadet);
        SumarFormasCobros();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Efectivo Eliminado"));
        RequestContext.getCurrentInstance().update("formCobros:gCobros");        
        RequestContext.getCurrentInstance().update("formCobroForma:dtCobroForma");
    }
    
    public void EliminarTarjeta(){
        listaCobrosTarjetas.remove(cobrotarjeta);
        SumarFormasCobros();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarjeta Eliminado"));
        RequestContext.getCurrentInstance().update("formCobros:gCobros");         
        RequestContext.getCurrentInstance().update("formCobroForma:dtCobroTarjeta");
    }
    
    public void EliminarCheque(){
        listaCobrosCheques.remove(cobrocheque);
        SumarFormasCobros();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cheque Eliminado"));
        RequestContext.getCurrentInstance().update("formCobros:gCobros");         
        RequestContext.getCurrentInstance().update("formCobroForma:dtCobroCheque");
    }
        
    public void Grabar(){
        try{
            Integer v_cant=0;
            for (int i = 0; i < listaCuentasCobrarPendiente.size(); i++) {
                 if(listaCuentasCobrarPendiente.get(i).seleccionado == true){
                     v_cant++;
                     i=listaCuentasCobrarPendiente.size();
                 }
            }
            if(totalpagar.compareTo(BigInteger.ZERO)==0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar registros para continuar",""));
                RequestContext.getCurrentInstance().update("formCobros:gCobros"); 
            }else if(v_cant==0){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe Seleccionar registros para continuar",""));
                RequestContext.getCurrentInstance().update("formCobros:gCobros");             
            }else if(vuelto.compareTo(BigInteger.ZERO)==-1){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aun tiene saldo pendiente de "+Metodos.FormatoNumero(BigInteger.ZERO.subtract(vuelto)),""));
                RequestContext.getCurrentInstance().update("formCobros:gCobros"); 
            }else{
                cobro.setFechaCobro(new Date());
                cobro.setMontoCobro(totalpagar);
                cobro.setEstado("C");
                cobro.setIdAperturaCierreCaja(AperturaCierreCajaFacade.obtenerAperturaAbierta(BeanAcceso.usuariossucursales));
                CobrosFacade.create(cobro);

                for (int i = 0; i < listaCuentasCobrarPendiente.size(); i++) {
                    if(listaCuentasCobrarPendiente.get(i).getSeleccionado()==true){
                        CobrosDet cobrodet = new CobrosDet();
                        CobrosDetPK cobrodetpk= new CobrosDetPK();                

                        cobrodetpk.setIdCobro(cobro.getIdCobro());
                        cobrodetpk.setIdCuentaCobrar(listaCuentasCobrarPendiente.get(i).cuentacobrar.getIdCuentaCobrar());
                        cobrodet.setCobrosDetPK(cobrodetpk);
                        cobrodet.setCobros(cobro);
                        cobrodet.setCuentasCobrar(listaCuentasCobrarPendiente.get(i).cuentacobrar);
                        cobrodet.setMontoCobro(listaCuentasCobrarPendiente.get(i).cuentacobrar.getImporte());
                        CobrosDetFacade.create(cobrodet);

                        if(listaCuentasCobrarPendiente.get(i).cuentacobrar.getImporte().compareTo(listaCuentasCobrarPendiente.get(i).cuentacobrar.getSaldo())==-1){
                            BigInteger result = listaCuentasCobrarPendiente.get(i).cuentacobrar.getSaldo().subtract(listaCuentasCobrarPendiente.get(i).cuentacobrar.getImporte());
                            listaCuentasCobrarPendiente.get(i).cuentacobrar.setSaldo(result);
                            listaCuentasCobrarPendiente.get(i).cuentacobrar.setImporte(result);
                            CuentasCobrarFacade.edit(listaCuentasCobrarPendiente.get(i).cuentacobrar);
                        }else{                                                
                            listaCuentasCobrarPendiente.get(i).cuentacobrar.setSaldo(BigInteger.ZERO);
                            listaCuentasCobrarPendiente.get(i).cuentacobrar.setImporte(BigInteger.ZERO);
                            listaCuentasCobrarPendiente.get(i).cuentacobrar.setEstado("P");
                            CuentasCobrarFacade.edit(listaCuentasCobrarPendiente.get(i).cuentacobrar);
                        } 
                    }
                }
                BigInteger totalcheque= BigInteger.ZERO, totaltarjeta= BigInteger.ZERO;
                CobrosFormasDet cobroformadet_aux = new CobrosFormasDet();
                for (int i = 0; i < listaCobrosCheques.size(); i++) {
                    listaCobrosCheques.get(i).setEstado("C");
                    listaCobrosCheques.get(i).setIdCobro(cobro);
                    CobrosChequesFacade.create(listaCobrosCheques.get(i));
            //        totalcheque= totalcheque.add(listaCobrosCheques.get(i).getMontoCheque());
                }
                if(totalcheque.compareTo(BigInteger.ZERO)==1){ 
                    cobroformadet_aux = new CobrosFormasDet();
                    cobroformadet_aux.setTransaccionesComerciales(TransaccionesComercialesFacade.find(2));
                    cobroformadet_aux.setMontoDet(totalcheque);
                    listaCobrosFormasDet.add(cobroformadet_aux);
                }
                for (int i = 0; i < listaCobrosTarjetas.size(); i++) {
                    listaCobrosTarjetas.get(i).setIdCobro(cobro);
                    CobrosTarjetasFacade.create(listaCobrosTarjetas.get(i));
                    totaltarjeta= totaltarjeta.add(listaCobrosTarjetas.get(i).getMontoTarjeta());
                }
                if(totaltarjeta.compareTo(BigInteger.ZERO)==1){
                    cobroformadet_aux = new CobrosFormasDet();
                    cobroformadet_aux.setTransaccionesComerciales(TransaccionesComercialesFacade.find(3));
                    cobroformadet_aux.setMontoDet(totaltarjeta);
                    listaCobrosFormasDet.add(cobroformadet_aux);
                }
                for (int i = 0; i < listaCobrosFormasDet.size(); i++) {
                    listaCobrosFormasDet.get(i).setCobros(cobro);
                    CobrosFormasDetPK cobroformadetpk = new CobrosFormasDetPK();
                    cobroformadetpk.setIdCobro(cobro.getIdCobro());
                    cobroformadetpk.setIdTransaccionComercial(listaCobrosFormasDet.get(i).getTransaccionesComerciales().getIdTransaccionComercial());
                    listaCobrosFormasDet.get(i).setCobrosFormasDetPK(cobroformadetpk);
                    CobrosFormasDetFacade.create(listaCobrosFormasDet.get(i));
                }
                cobro_aux= new Cobros();
                cobro_aux=cobro;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cobro realizado"));
                RequestContext.getCurrentInstance().update("formCobros:gCobros");
                RequestContext.getCurrentInstance().execute("document.getElementById('formReporte:imprimir').click()"); 
                Nuevo();
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("formCobros");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error al grabar" + e,""));
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
