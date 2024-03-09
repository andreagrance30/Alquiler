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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "descuentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuentos.findAll", query = "SELECT d FROM Descuentos d"),
    @NamedQuery(name = "Descuentos.findByIdDescuento", query = "SELECT d FROM Descuentos d WHERE d.idDescuento = :idDescuento"),
    @NamedQuery(name = "Descuentos.findByDescripcion", query = "SELECT d FROM Descuentos d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Descuentos.findByFechaFin", query = "SELECT d FROM Descuentos d WHERE d.fechaFin = :fechaFin"),
    @NamedQuery(name = "Descuentos.findByFechaInicio", query = "SELECT d FROM Descuentos d WHERE d.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Descuentos.findByPorcDesc", query = "SELECT d FROM Descuentos d WHERE d.porcDesc = :porcDesc")})
public class Descuentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descuento")
    private Integer idDescuento;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "porc_desc")
    private BigInteger porcDesc;
    @JoinTable(name = "descuentos_det", joinColumns = {
        @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento")}, inverseJoinColumns = {
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")})
    @ManyToMany
    private List<Productos> productosList;

    public Descuentos() {
    }

    public Descuentos(Integer idDescuento) {
        this.idDescuento = idDescuento;
    }

    public Integer getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Integer idDescuento) {
        this.idDescuento = idDescuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public BigInteger getPorcDesc() {
        return porcDesc;
    }

    public void setPorcDesc(BigInteger porcDesc) {
        this.porcDesc = porcDesc;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescuento != null ? idDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuentos)) {
            return false;
        }
        Descuentos other = (Descuentos) object;
        if ((this.idDescuento == null && other.idDescuento != null) || (this.idDescuento != null && !this.idDescuento.equals(other.idDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Descuentos[ idDescuento=" + idDescuento + " ]";
    }
    
}
