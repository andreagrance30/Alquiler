/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "cobros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cobros.findAll", query = "SELECT c FROM Cobros c"),
    @NamedQuery(name = "Cobros.findByIdCobro", query = "SELECT c FROM Cobros c WHERE c.idCobro = :idCobro"),
    @NamedQuery(name = "Cobros.findByFechaCobro", query = "SELECT c FROM Cobros c WHERE c.fechaCobro = :fechaCobro"),
    @NamedQuery(name = "Cobros.findByMontoCobro", query = "SELECT c FROM Cobros c WHERE c.montoCobro = :montoCobro"),
    @NamedQuery(name = "Cobros.findByEstado", query = "SELECT c FROM Cobros c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cobros.findByNroRecibo", query = "SELECT c FROM Cobros c WHERE c.nroRecibo = :nroRecibo")})
public class Cobros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cobro")
    private Integer idCobro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cobro")
    @Temporal(TemporalType.DATE)
    private Date fechaCobro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_cobro")
    private BigInteger montoCobro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Column(name = "nro_recibo")
    private Integer nroRecibo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCobro")
    private List<CobrosCheques> cobrosChequesList;
    @JoinColumn(name = "id_apertura_cierre_caja", referencedColumnName = "id_apertura_cierre_caja")
    @ManyToOne(optional = false)
    private AperturaCierreCaja idAperturaCierreCaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobros")
    private List<CobrosFormasDet> cobrosFormasDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobros")
    private List<CobrosDet> cobrosDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCobro")
    private List<CobrosTarjetas> cobrosTarjetasList;

    public Cobros() {
    }

    public Cobros(Integer idCobro) {
        this.idCobro = idCobro;
    }

    public Cobros(Integer idCobro, Date fechaCobro, BigInteger montoCobro, String estado) {
        this.idCobro = idCobro;
        this.fechaCobro = fechaCobro;
        this.montoCobro = montoCobro;
        this.estado = estado;
    }

    public Integer getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(Integer idCobro) {
        this.idCobro = idCobro;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public BigInteger getMontoCobro() {
        return montoCobro;
    }

    public void setMontoCobro(BigInteger montoCobro) {
        this.montoCobro = montoCobro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(Integer nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    @XmlTransient
    public List<CobrosCheques> getCobrosChequesList() {
        return cobrosChequesList;
    }

    public void setCobrosChequesList(List<CobrosCheques> cobrosChequesList) {
        this.cobrosChequesList = cobrosChequesList;
    }

    public AperturaCierreCaja getIdAperturaCierreCaja() {
        return idAperturaCierreCaja;
    }

    public void setIdAperturaCierreCaja(AperturaCierreCaja idAperturaCierreCaja) {
        this.idAperturaCierreCaja = idAperturaCierreCaja;
    }

    @XmlTransient
    public List<CobrosFormasDet> getCobrosFormasDetList() {
        return cobrosFormasDetList;
    }

    public void setCobrosFormasDetList(List<CobrosFormasDet> cobrosFormasDetList) {
        this.cobrosFormasDetList = cobrosFormasDetList;
    }

    @XmlTransient
    public List<CobrosDet> getCobrosDetList() {
        return cobrosDetList;
    }

    public void setCobrosDetList(List<CobrosDet> cobrosDetList) {
        this.cobrosDetList = cobrosDetList;
    }

    @XmlTransient
    public List<CobrosTarjetas> getCobrosTarjetasList() {
        return cobrosTarjetasList;
    }

    public void setCobrosTarjetasList(List<CobrosTarjetas> cobrosTarjetasList) {
        this.cobrosTarjetasList = cobrosTarjetasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobro != null ? idCobro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobros)) {
            return false;
        }
        Cobros other = (Cobros) object;
        if ((this.idCobro == null && other.idCobro != null) || (this.idCobro != null && !this.idCobro.equals(other.idCobro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cobros[ idCobro=" + idCobro + " ]";
    }
    
}
