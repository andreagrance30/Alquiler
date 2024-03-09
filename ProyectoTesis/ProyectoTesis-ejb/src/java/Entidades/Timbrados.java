/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "timbrados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timbrados.findAll", query = "SELECT t FROM Timbrados t"),
    @NamedQuery(name = "Timbrados.findByIdTimbrado", query = "SELECT t FROM Timbrados t WHERE t.idTimbrado = :idTimbrado"),
    @NamedQuery(name = "Timbrados.findByEstado", query = "SELECT t FROM Timbrados t WHERE t.estado = :estado"),
    @NamedQuery(name = "Timbrados.findByNroTimbrado", query = "SELECT t FROM Timbrados t WHERE t.nroTimbrado = :nroTimbrado"),
    @NamedQuery(name = "Timbrados.findByFechaCarga", query = "SELECT t FROM Timbrados t WHERE t.fechaCarga = :fechaCarga"),
    @NamedQuery(name = "Timbrados.findByFechaInicio", query = "SELECT t FROM Timbrados t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Timbrados.findByFechaFin", query = "SELECT t FROM Timbrados t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "Timbrados.findByNroInicial", query = "SELECT t FROM Timbrados t WHERE t.nroInicial = :nroInicial"),
    @NamedQuery(name = "Timbrados.findByNroFinal", query = "SELECT t FROM Timbrados t WHERE t.nroFinal = :nroFinal"),
    @NamedQuery(name = "Timbrados.findByNroActual", query = "SELECT t FROM Timbrados t WHERE t.nroActual = :nroActual")})
public class Timbrados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_timbrado")
    private Integer idTimbrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_timbrado")
    private BigDecimal nroTimbrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_carga")
    @Temporal(TemporalType.DATE)
    private Date fechaCarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_inicial")
    private BigDecimal nroInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_final")
    private BigDecimal nroFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_actual")
    private BigDecimal nroActual;
    @OneToMany(mappedBy = "idTimbrado")
    private List<NotasCreditos> notasCreditosList;
    @OneToMany(mappedBy = "idTimbrado")
    private List<NotasDebitos> notasDebitosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimbrado")
    private List<Ventas> ventasList;
    @JoinColumn(name = "id_caja", referencedColumnName = "id_caja")
    @ManyToOne(optional = false)
    private Cajas idCaja;
    @JoinColumn(name = "id_tipo_comprobante", referencedColumnName = "id_tipo_comprobante")
    @ManyToOne(optional = false)
    private TiposComprobantes idTipoComprobante;
    @OneToMany(mappedBy = "idTimbrado")
    private List<NotasRemisiones> notasRemisionesList;

    public Timbrados() {
    }

    public Timbrados(Integer idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public Timbrados(Integer idTimbrado, String estado, BigDecimal nroTimbrado, Date fechaCarga, Date fechaInicio, Date fechaFin, BigDecimal nroInicial, BigDecimal nroFinal, BigDecimal nroActual) {
        this.idTimbrado = idTimbrado;
        this.estado = estado;
        this.nroTimbrado = nroTimbrado;
        this.fechaCarga = fechaCarga;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nroInicial = nroInicial;
        this.nroFinal = nroFinal;
        this.nroActual = nroActual;
    }

    public Integer getIdTimbrado() {
        return idTimbrado;
    }

    public void setIdTimbrado(Integer idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getNroTimbrado() {
        return nroTimbrado;
    }

    public void setNroTimbrado(BigDecimal nroTimbrado) {
        this.nroTimbrado = nroTimbrado;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getNroInicial() {
        return nroInicial;
    }

    public void setNroInicial(BigDecimal nroInicial) {
        this.nroInicial = nroInicial;
    }

    public BigDecimal getNroFinal() {
        return nroFinal;
    }

    public void setNroFinal(BigDecimal nroFinal) {
        this.nroFinal = nroFinal;
    }

    public BigDecimal getNroActual() {
        return nroActual;
    }

    public void setNroActual(BigDecimal nroActual) {
        this.nroActual = nroActual;
    }

    @XmlTransient
    public List<NotasCreditos> getNotasCreditosList() {
        return notasCreditosList;
    }

    public void setNotasCreditosList(List<NotasCreditos> notasCreditosList) {
        this.notasCreditosList = notasCreditosList;
    }

    @XmlTransient
    public List<NotasDebitos> getNotasDebitosList() {
        return notasDebitosList;
    }

    public void setNotasDebitosList(List<NotasDebitos> notasDebitosList) {
        this.notasDebitosList = notasDebitosList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    public Cajas getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Cajas idCaja) {
        this.idCaja = idCaja;
    }

    public TiposComprobantes getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(TiposComprobantes idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    @XmlTransient
    public List<NotasRemisiones> getNotasRemisionesList() {
        return notasRemisionesList;
    }

    public void setNotasRemisionesList(List<NotasRemisiones> notasRemisionesList) {
        this.notasRemisionesList = notasRemisionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTimbrado != null ? idTimbrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timbrados)) {
            return false;
        }
        Timbrados other = (Timbrados) object;
        if ((this.idTimbrado == null && other.idTimbrado != null) || (this.idTimbrado != null && !this.idTimbrado.equals(other.idTimbrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Timbrados[ idTimbrado=" + idTimbrado + " ]";
    }
    
}
