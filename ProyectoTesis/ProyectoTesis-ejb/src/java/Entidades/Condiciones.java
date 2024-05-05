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
@Table(name = "condiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condiciones.findAll", query = "SELECT c FROM Condiciones c"),
    @NamedQuery(name = "Condiciones.findByIdCondicion", query = "SELECT c FROM Condiciones c WHERE c.idCondicion = :idCondicion"),
    @NamedQuery(name = "Condiciones.findByDescripcion", query = "SELECT c FROM Condiciones c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Condiciones.findByCantidadCuotas", query = "SELECT c FROM Condiciones c WHERE c.cantidadCuotas = :cantidadCuotas"),
    @NamedQuery(name = "Condiciones.findByIntervaloDias", query = "SELECT c FROM Condiciones c WHERE c.intervaloDias = :intervaloDias")})
public class Condiciones implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_cuotas")
    private BigInteger cantidadCuotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intervalo_dias")
    private BigInteger intervaloDias;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_condicion")
    private Integer idCondicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idCondicion")
    private List<Compras> comprasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCondicion")
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCondicion")
    private List<Presupuestos> presupuestosList;

    public Condiciones() {
    }

    public Condiciones(Integer idCondicion) {
        this.idCondicion = idCondicion;
    }

    public Condiciones(Integer idCondicion, String descripcion, BigInteger cantidadCuotas, BigInteger intervaloDias) {
        this.idCondicion = idCondicion;
        this.descripcion = descripcion;
        this.cantidadCuotas = cantidadCuotas;
        this.intervaloDias = intervaloDias;
    }

    public Integer getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(Integer idCondicion) {
        this.idCondicion = idCondicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(BigInteger cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public BigInteger getIntervaloDias() {
        return intervaloDias;
    }

    public void setIntervaloDias(BigInteger intervaloDias) {
        this.intervaloDias = intervaloDias;
    }

    @XmlTransient
    public List<Compras> getComprasList() {
        return comprasList;
    }

    public void setComprasList(List<Compras> comprasList) {
        this.comprasList = comprasList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @XmlTransient
    public List<Presupuestos> getPresupuestosList() {
        return presupuestosList;
    }

    public void setPresupuestosList(List<Presupuestos> presupuestosList) {
        this.presupuestosList = presupuestosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCondicion != null ? idCondicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condiciones)) {
            return false;
        }
        Condiciones other = (Condiciones) object;
        if ((this.idCondicion == null && other.idCondicion != null) || (this.idCondicion != null && !this.idCondicion.equals(other.idCondicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Condiciones[ idCondicion=" + idCondicion + " ]";
    }

}
