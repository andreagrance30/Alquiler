/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "cobros_tarjetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CobrosTarjetas.findAll", query = "SELECT c FROM CobrosTarjetas c"),
    @NamedQuery(name = "CobrosTarjetas.findByIdCobroTarjeta", query = "SELECT c FROM CobrosTarjetas c WHERE c.idCobroTarjeta = :idCobroTarjeta"),
    @NamedQuery(name = "CobrosTarjetas.findByNroTarjeta", query = "SELECT c FROM CobrosTarjetas c WHERE c.nroTarjeta = :nroTarjeta"),
    @NamedQuery(name = "CobrosTarjetas.findByMontoTarjeta", query = "SELECT c FROM CobrosTarjetas c WHERE c.montoTarjeta = :montoTarjeta"),
    @NamedQuery(name = "CobrosTarjetas.findByNroTicket", query = "SELECT c FROM CobrosTarjetas c WHERE c.nroTicket = :nroTicket")})
public class CobrosTarjetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cobro_tarjeta")
    private Integer idCobroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_tarjeta")
    private int nroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_tarjeta")
    private BigInteger montoTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_ticket")
    private int nroTicket;
    @JoinColumn(name = "id_cobro", referencedColumnName = "id_cobro")
    @ManyToOne(optional = false)
    private Cobros idCobro;
    @JoinColumn(name = "id_tarjeta", referencedColumnName = "id_tarjeta")
    @ManyToOne(optional = false)
    private Tarjetas idTarjeta;

    public CobrosTarjetas() {
    }

    public CobrosTarjetas(Integer idCobroTarjeta) {
        this.idCobroTarjeta = idCobroTarjeta;
    }

    public CobrosTarjetas(Integer idCobroTarjeta, int nroTarjeta, BigInteger montoTarjeta, int nroTicket) {
        this.idCobroTarjeta = idCobroTarjeta;
        this.nroTarjeta = nroTarjeta;
        this.montoTarjeta = montoTarjeta;
        this.nroTicket = nroTicket;
    }

    public Integer getIdCobroTarjeta() {
        return idCobroTarjeta;
    }

    public void setIdCobroTarjeta(Integer idCobroTarjeta) {
        this.idCobroTarjeta = idCobroTarjeta;
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public BigInteger getMontoTarjeta() {
        return montoTarjeta;
    }

    public void setMontoTarjeta(BigInteger montoTarjeta) {
        this.montoTarjeta = montoTarjeta;
    }

    public int getNroTicket() {
        return nroTicket;
    }

    public void setNroTicket(int nroTicket) {
        this.nroTicket = nroTicket;
    }

    public Cobros getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(Cobros idCobro) {
        this.idCobro = idCobro;
    }

    public Tarjetas getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Tarjetas idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobroTarjeta != null ? idCobroTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobrosTarjetas)) {
            return false;
        }
        CobrosTarjetas other = (CobrosTarjetas) object;
        if ((this.idCobroTarjeta == null && other.idCobroTarjeta != null) || (this.idCobroTarjeta != null && !this.idCobroTarjeta.equals(other.idCobroTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CobrosTarjetas[ idCobroTarjeta=" + idCobroTarjeta + " ]";
    }
    
}
