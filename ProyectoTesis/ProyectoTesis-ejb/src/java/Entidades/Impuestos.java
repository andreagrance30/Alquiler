/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigDecimal;
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
@Table(name = "impuestos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impuestos.findAll", query = "SELECT i FROM Impuestos i"),
    @NamedQuery(name = "Impuestos.findByIdImpuesto", query = "SELECT i FROM Impuestos i WHERE i.idImpuesto = :idImpuesto"),
    @NamedQuery(name = "Impuestos.findByDescripcion", query = "SELECT i FROM Impuestos i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Impuestos.findByPorcIva", query = "SELECT i FROM Impuestos i WHERE i.porcIva = :porcIva")})
public class Impuestos implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "porc_iva")
    private BigDecimal porcIva;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_impuesto")
    private Integer idImpuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImpuesto")
    private List<Productos> productosList;

    public Impuestos() {
    }

    public Impuestos(Integer idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public Impuestos(Integer idImpuesto, String descripcion, BigDecimal porcIva) {
        this.idImpuesto = idImpuesto;
        this.descripcion = descripcion;
        this.porcIva = porcIva;
    }

    public Integer getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(Integer idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(BigDecimal porcIva) {
        this.porcIva = porcIva;
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
        hash += (idImpuesto != null ? idImpuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impuestos)) {
            return false;
        }
        Impuestos other = (Impuestos) object;
        if ((this.idImpuesto == null && other.idImpuesto != null) || (this.idImpuesto != null && !this.idImpuesto.equals(other.idImpuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Impuestos[ idImpuesto=" + idImpuesto + " ]";
    }
    
}
