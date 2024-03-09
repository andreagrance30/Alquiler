/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "cajas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cajas.findAll", query = "SELECT c FROM Cajas c"),
    @NamedQuery(name = "Cajas.findByIdCaja", query = "SELECT c FROM Cajas c WHERE c.idCaja = :idCaja"),
    @NamedQuery(name = "Cajas.findByEstado", query = "SELECT c FROM Cajas c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cajas.findByPuntoEmision", query = "SELECT c FROM Cajas c WHERE c.puntoEmision = :puntoEmision")})
public class Cajas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caja")
    private Integer idCaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "punto_emision")
    private BigInteger puntoEmision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaja")
    private List<AperturaCierreCaja> aperturaCierreCajaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaja")
    private List<Timbrados> timbradosList;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private Sucursales idSucursal;

    public Cajas() {
    }

    public Cajas(Integer idCaja) {
        this.idCaja = idCaja;
    }

    public Cajas(Integer idCaja, String estado, BigInteger puntoEmision) {
        this.idCaja = idCaja;
        this.estado = estado;
        this.puntoEmision = puntoEmision;
    }

    public Integer getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getPuntoEmision() {
        return puntoEmision;
    }

    public void setPuntoEmision(BigInteger puntoEmision) {
        this.puntoEmision = puntoEmision;
    }

    @XmlTransient
    public List<AperturaCierreCaja> getAperturaCierreCajaList() {
        return aperturaCierreCajaList;
    }

    public void setAperturaCierreCajaList(List<AperturaCierreCaja> aperturaCierreCajaList) {
        this.aperturaCierreCajaList = aperturaCierreCajaList;
    }

    @XmlTransient
    public List<Timbrados> getTimbradosList() {
        return timbradosList;
    }

    public void setTimbradosList(List<Timbrados> timbradosList) {
        this.timbradosList = timbradosList;
    }

    public Sucursales getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursales idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaja != null ? idCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cajas)) {
            return false;
        }
        Cajas other = (Cajas) object;
        if ((this.idCaja == null && other.idCaja != null) || (this.idCaja != null && !this.idCaja.equals(other.idCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cajas[ idCaja=" + idCaja + " ]";
    }
    
}
