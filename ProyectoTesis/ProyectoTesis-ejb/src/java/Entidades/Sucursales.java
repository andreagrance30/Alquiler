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
@Table(name = "sucursales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s"),
    @NamedQuery(name = "Sucursales.findByIdSucursal", query = "SELECT s FROM Sucursales s WHERE s.idSucursal = :idSucursal"),
    @NamedQuery(name = "Sucursales.findByDescripcion", query = "SELECT s FROM Sucursales s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Sucursales.findByTelefono", query = "SELECT s FROM Sucursales s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Sucursales.findByDireccion", query = "SELECT s FROM Sucursales s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursales.findByPuntoEstablecimiento", query = "SELECT s FROM Sucursales s WHERE s.puntoEstablecimiento = :puntoEstablecimiento")})
public class Sucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "punto_establecimiento")
    private BigInteger puntoEstablecimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Depositos> depositosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursales")
    private List<UsuariosSucursales> usuariosSucursalesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSucursal")
    private List<Cajas> cajasList;

    public Sucursales() {
    }

    public Sucursales(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursales(Integer idSucursal, String descripcion, String telefono, String direccion, BigInteger puntoEstablecimiento) {
        this.idSucursal = idSucursal;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.puntoEstablecimiento = puntoEstablecimiento;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getPuntoEstablecimiento() {
        return puntoEstablecimiento;
    }

    public void setPuntoEstablecimiento(BigInteger puntoEstablecimiento) {
        this.puntoEstablecimiento = puntoEstablecimiento;
    }

    @XmlTransient
    public List<Depositos> getDepositosList() {
        return depositosList;
    }

    public void setDepositosList(List<Depositos> depositosList) {
        this.depositosList = depositosList;
    }

    @XmlTransient
    public List<UsuariosSucursales> getUsuariosSucursalesList() {
        return usuariosSucursalesList;
    }

    public void setUsuariosSucursalesList(List<UsuariosSucursales> usuariosSucursalesList) {
        this.usuariosSucursalesList = usuariosSucursalesList;
    }

    @XmlTransient
    public List<Cajas> getCajasList() {
        return cajasList;
    }

    public void setCajasList(List<Cajas> cajasList) {
        this.cajasList = cajasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sucursales[ idSucursal=" + idSucursal + " ]";
    }
    
}
