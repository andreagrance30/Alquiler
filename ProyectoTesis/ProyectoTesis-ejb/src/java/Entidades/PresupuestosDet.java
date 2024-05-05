

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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "presupuestos_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestosDet.findAll", query = "SELECT p FROM PresupuestosDet p"),
    @NamedQuery(name = "PresupuestosDet.findByIdPresupuesto", query = "SELECT p FROM PresupuestosDet p WHERE p.presupuestosDetPK.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "PresupuestosDet.findByIdProducto", query = "SELECT p FROM PresupuestosDet p WHERE p.presupuestosDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "PresupuestosDet.findByIdDeposito", query = "SELECT p FROM PresupuestosDet p WHERE p.presupuestosDetPK.idDeposito = :idDeposito"),
    @NamedQuery(name = "PresupuestosDet.findByCantidad", query = "SELECT p FROM PresupuestosDet p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PresupuestosDet.findByPorcIva", query = "SELECT p FROM PresupuestosDet p WHERE p.porcIva = :porcIva"),
    @NamedQuery(name = "PresupuestosDet.findByPrecioUni", query = "SELECT p FROM PresupuestosDet p WHERE p.precioUni = :precioUni")})
public class PresupuestosDet implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porc_iva")
    private BigInteger porcIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_uni")
    private BigInteger precioUni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestosDet")
    private List<OrdenesComprasDet> ordenesComprasDetList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestosDetPK presupuestosDetPK;
 /*   @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestosDet")
    private List<OrdenesComprasDet> ordenesComprasDetList;*/
    @JoinColumn(name = "id_presupuesto", referencedColumnName = "id_presupuesto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Presupuestos presupuestos;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public PresupuestosDet() {
    }

    public PresupuestosDet(PresupuestosDetPK presupuestosDetPK) {
        this.presupuestosDetPK = presupuestosDetPK;
    }

    public PresupuestosDet(PresupuestosDetPK presupuestosDetPK, BigInteger cantidad, BigInteger porcIva, BigInteger precioUni) {
        this.presupuestosDetPK = presupuestosDetPK;
        this.cantidad = cantidad;
        this.porcIva = porcIva;
        this.precioUni = precioUni;
    }

    public PresupuestosDet(int idPresupuesto, int idProducto, int idDeposito) {
        this.presupuestosDetPK = new PresupuestosDetPK(idPresupuesto, idProducto, idDeposito);
    }

    public PresupuestosDetPK getPresupuestosDetPK() {
        return presupuestosDetPK;
    }

    public void setPresupuestosDetPK(PresupuestosDetPK presupuestosDetPK) {
        this.presupuestosDetPK = presupuestosDetPK;
    }


    public BigInteger getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(BigInteger porcIva) {
        this.porcIva = porcIva;
    }

    public BigInteger getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(BigInteger precioUni) {
        this.precioUni = precioUni;
    }
/*
    @XmlTransient
    public List<OrdenesComprasDet> getOrdenesComprasDetList() {
        return ordenesComprasDetList;
    }

    public void setOrdenesComprasDetList(List<OrdenesComprasDet> ordenesComprasDetList) {
        this.ordenesComprasDetList = ordenesComprasDetList;
    }
*/
    public Presupuestos getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(Presupuestos presupuestos) {
        this.presupuestos = presupuestos;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestosDetPK != null ? presupuestosDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestosDet)) {
            return false;
        }
        PresupuestosDet other = (PresupuestosDet) object;
        if ((this.presupuestosDetPK == null && other.presupuestosDetPK != null) || (this.presupuestosDetPK != null && !this.presupuestosDetPK.equals(other.presupuestosDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PresupuestosDet[ presupuestosDetPK=" + presupuestosDetPK + " ]";
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<OrdenesComprasDet> getOrdenesComprasDetList() {
        return ordenesComprasDetList;
    }

    public void setOrdenesComprasDetList(List<OrdenesComprasDet> ordenesComprasDetList) {
        this.ordenesComprasDetList = ordenesComprasDetList;
    }
    
}
