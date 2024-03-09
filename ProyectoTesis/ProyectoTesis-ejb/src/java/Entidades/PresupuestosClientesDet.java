/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "presupuestos_clientes_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestosClientesDet.findAll", query = "SELECT p FROM PresupuestosClientesDet p"),
    @NamedQuery(name = "PresupuestosClientesDet.findByIdPresupuestoCliente", query = "SELECT p FROM PresupuestosClientesDet p WHERE p.presupuestosClientesDetPK.idPresupuestoCliente = :idPresupuestoCliente"),
    @NamedQuery(name = "PresupuestosClientesDet.findByIdProducto", query = "SELECT p FROM PresupuestosClientesDet p WHERE p.presupuestosClientesDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "PresupuestosClientesDet.findByCantidad", query = "SELECT p FROM PresupuestosClientesDet p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PresupuestosClientesDet.findByPrecioUni", query = "SELECT p FROM PresupuestosClientesDet p WHERE p.precioUni = :precioUni"),
    @NamedQuery(name = "PresupuestosClientesDet.findByPorcIva", query = "SELECT p FROM PresupuestosClientesDet p WHERE p.porcIva = :porcIva")})
public class PresupuestosClientesDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestosClientesDetPK presupuestosClientesDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_uni")
    private BigInteger precioUni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porc_iva")
    private BigInteger porcIva;
    @JoinColumn(name = "id_presupuesto_cliente", referencedColumnName = "id_presupuesto_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PresupuestosClientes presupuestosClientes;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public PresupuestosClientesDet() {
    }

    public PresupuestosClientesDet(PresupuestosClientesDetPK presupuestosClientesDetPK) {
        this.presupuestosClientesDetPK = presupuestosClientesDetPK;
    }

    public PresupuestosClientesDet(PresupuestosClientesDetPK presupuestosClientesDetPK, BigInteger cantidad, BigInteger precioUni, BigInteger porcIva) {
        this.presupuestosClientesDetPK = presupuestosClientesDetPK;
        this.cantidad = cantidad;
        this.precioUni = precioUni;
        this.porcIva = porcIva;
    }

    public PresupuestosClientesDet(int idPresupuestoCliente, int idProducto) {
        this.presupuestosClientesDetPK = new PresupuestosClientesDetPK(idPresupuestoCliente, idProducto);
    }

    public PresupuestosClientesDetPK getPresupuestosClientesDetPK() {
        return presupuestosClientesDetPK;
    }

    public void setPresupuestosClientesDetPK(PresupuestosClientesDetPK presupuestosClientesDetPK) {
        this.presupuestosClientesDetPK = presupuestosClientesDetPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(BigInteger precioUni) {
        this.precioUni = precioUni;
    }

    public BigInteger getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(BigInteger porcIva) {
        this.porcIva = porcIva;
    }

    public PresupuestosClientes getPresupuestosClientes() {
        return presupuestosClientes;
    }

    public void setPresupuestosClientes(PresupuestosClientes presupuestosClientes) {
        this.presupuestosClientes = presupuestosClientes;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presupuestosClientesDetPK != null ? presupuestosClientesDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestosClientesDet)) {
            return false;
        }
        PresupuestosClientesDet other = (PresupuestosClientesDet) object;
        if ((this.presupuestosClientesDetPK == null && other.presupuestosClientesDetPK != null) || (this.presupuestosClientesDetPK != null && !this.presupuestosClientesDetPK.equals(other.presupuestosClientesDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PresupuestosClientesDet[ presupuestosClientesDetPK=" + presupuestosClientesDetPK + " ]";
    }
    
}
