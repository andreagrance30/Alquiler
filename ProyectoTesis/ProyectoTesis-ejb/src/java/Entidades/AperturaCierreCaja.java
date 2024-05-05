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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "apertura_cierre_caja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AperturaCierreCaja.findAll", query = "SELECT a FROM AperturaCierreCaja a"),
    @NamedQuery(name = "AperturaCierreCaja.findByIdAperturaCierreCaja", query = "SELECT a FROM AperturaCierreCaja a WHERE a.idAperturaCierreCaja = :idAperturaCierreCaja"),
    @NamedQuery(name = "AperturaCierreCaja.findByFechaApertura", query = "SELECT a FROM AperturaCierreCaja a WHERE a.fechaApertura = :fechaApertura"),
    @NamedQuery(name = "AperturaCierreCaja.findByMontoInicial", query = "SELECT a FROM AperturaCierreCaja a WHERE a.montoInicial = :montoInicial"),
    @NamedQuery(name = "AperturaCierreCaja.findByFechaCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "AperturaCierreCaja.findByMontoTarjetaCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.montoTarjetaCierre = :montoTarjetaCierre"),
    @NamedQuery(name = "AperturaCierreCaja.findByDifMontoTarjetaCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.difMontoTarjetaCierre = :difMontoTarjetaCierre"),
    @NamedQuery(name = "AperturaCierreCaja.findByMontoChequeCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.montoChequeCierre = :montoChequeCierre"),
    @NamedQuery(name = "AperturaCierreCaja.findByDifMontoChequeCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.difMontoChequeCierre = :difMontoChequeCierre"),
    @NamedQuery(name = "AperturaCierreCaja.findByMontoEfectivoCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.montoEfectivoCierre = :montoEfectivoCierre"),
    @NamedQuery(name = "AperturaCierreCaja.findByDifMontoEfectivoCierre", query = "SELECT a FROM AperturaCierreCaja a WHERE a.difMontoEfectivoCierre = :difMontoEfectivoCierre")})
public class AperturaCierreCaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_apertura_cierre_caja")
    private Integer idAperturaCierreCaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApertura;
    @Basic(optional = false)
    @Column(name = "monto_inicial")
    private BigDecimal montoInicial;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Column(name = "monto_tarjeta_cierre")
    private BigDecimal montoTarjetaCierre;
    @Column(name = "dif_monto_tarjeta_cierre")
    private BigDecimal difMontoTarjetaCierre;
    @Column(name = "monto_cheque_cierre")
    private BigDecimal montoChequeCierre;
    @Column(name = "dif_monto_cheque_cierre")
    private BigDecimal difMontoChequeCierre;
    @Column(name = "monto_efectivo_cierre")
    private BigDecimal montoEfectivoCierre;
    @Column(name = "dif_monto_efectivo_cierre")
    private BigDecimal difMontoEfectivoCierre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaCierreCaja")
    private List<Cobros> cobrosList;
    @JoinColumn(name = "id_caja", referencedColumnName = "id_caja")
    @ManyToOne(optional = false)
    private Cajas idCaja;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaCierreCaja")
    private List<RecaudacionesDepositar> recaudacionesDepositarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAperturaCierreCaja")
    private List<ArqueosCajas> arqueosCajasList;

    public AperturaCierreCaja() {
    }

    public AperturaCierreCaja(Integer idAperturaCierreCaja) {
        this.idAperturaCierreCaja = idAperturaCierreCaja;
    }

    public AperturaCierreCaja(Integer idAperturaCierreCaja, Date fechaApertura, BigDecimal montoInicial) {
        this.idAperturaCierreCaja = idAperturaCierreCaja;
        this.fechaApertura = fechaApertura;
        this.montoInicial = montoInicial;
    }

    public Integer getIdAperturaCierreCaja() {
        return idAperturaCierreCaja;
    }

    public void setIdAperturaCierreCaja(Integer idAperturaCierreCaja) {
        this.idAperturaCierreCaja = idAperturaCierreCaja;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public BigDecimal getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public BigDecimal getMontoTarjetaCierre() {
        return montoTarjetaCierre;
    }

    public void setMontoTarjetaCierre(BigDecimal montoTarjetaCierre) {
        this.montoTarjetaCierre = montoTarjetaCierre;
    }

    public BigDecimal getDifMontoTarjetaCierre() {
        return difMontoTarjetaCierre;
    }

    public void setDifMontoTarjetaCierre(BigDecimal difMontoTarjetaCierre) {
        this.difMontoTarjetaCierre = difMontoTarjetaCierre;
    }

    public BigDecimal getMontoChequeCierre() {
        return montoChequeCierre;
    }

    public void setMontoChequeCierre(BigDecimal montoChequeCierre) {
        this.montoChequeCierre = montoChequeCierre;
    }

    public BigDecimal getDifMontoChequeCierre() {
        return difMontoChequeCierre;
    }

    public void setDifMontoChequeCierre(BigDecimal difMontoChequeCierre) {
        this.difMontoChequeCierre = difMontoChequeCierre;
    }

    public BigDecimal getMontoEfectivoCierre() {
        return montoEfectivoCierre;
    }

    public void setMontoEfectivoCierre(BigDecimal montoEfectivoCierre) {
        this.montoEfectivoCierre = montoEfectivoCierre;
    }

    public BigDecimal getDifMontoEfectivoCierre() {
        return difMontoEfectivoCierre;
    }

    public void setDifMontoEfectivoCierre(BigDecimal difMontoEfectivoCierre) {
        this.difMontoEfectivoCierre = difMontoEfectivoCierre;
    }

    @XmlTransient
    public List<Cobros> getCobrosList() {
        return cobrosList;
    }

    public void setCobrosList(List<Cobros> cobrosList) {
        this.cobrosList = cobrosList;
    }

    public Cajas getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Cajas idCaja) {
        this.idCaja = idCaja;
    }

    public UsuariosSucursales getUsuariosSucursales() {
        return usuariosSucursales;
    }

    public void setUsuariosSucursales(UsuariosSucursales usuariosSucursales) {
        this.usuariosSucursales = usuariosSucursales;
    }

    @XmlTransient
    public List<RecaudacionesDepositar> getRecaudacionesDepositarList() {
        return recaudacionesDepositarList;
    }

    public void setRecaudacionesDepositarList(List<RecaudacionesDepositar> recaudacionesDepositarList) {
        this.recaudacionesDepositarList = recaudacionesDepositarList;
    }

    @XmlTransient
    public List<ArqueosCajas> getArqueosCajasList() {
        return arqueosCajasList;
    }

    public void setArqueosCajasList(List<ArqueosCajas> arqueosCajasList) {
        this.arqueosCajasList = arqueosCajasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAperturaCierreCaja != null ? idAperturaCierreCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AperturaCierreCaja)) {
            return false;
        }
        AperturaCierreCaja other = (AperturaCierreCaja) object;
        if ((this.idAperturaCierreCaja == null && other.idAperturaCierreCaja != null) || (this.idAperturaCierreCaja != null && !this.idAperturaCierreCaja.equals(other.idAperturaCierreCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AperturaCierreCaja[ idAperturaCierreCaja=" + idAperturaCierreCaja + " ]";
    }
    
}
