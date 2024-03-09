/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Productos.findByPrecioCompra", query = "SELECT p FROM Productos p WHERE p.precioCompra = :precioCompra"),
    @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Productos p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "Productos.findByEstado", query = "SELECT p FROM Productos p WHERE p.estado = :estado")})
public class Productos implements Serializable {

    @Column(name = "precio_compra")
    private BigDecimal precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @ManyToMany(mappedBy = "productosList")
    private List<Descuentos> descuentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private List<Stock> stockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private List<SolicitudesPedidosDet> solicitudesPedidosDetList;
    @JoinColumn(name = "id_clasificacion", referencedColumnName = "id_clasificacion")
    @ManyToOne(optional = false)
    private Clasificaciones idClasificacion;
    @JoinColumn(name = "id_impuesto", referencedColumnName = "id_impuesto")
    @ManyToOne(optional = false)
    private Impuestos idImpuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private List<PresupuestosClientesDet> presupuestosClientesDetList;

    public Productos() {
    }

    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(Integer idProducto, String descripcion, BigDecimal precioVenta, String estado) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.estado = estado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Descuentos> getDescuentosList() {
        return descuentosList;
    }

    public void setDescuentosList(List<Descuentos> descuentosList) {
        this.descuentosList = descuentosList;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @XmlTransient
    public List<SolicitudesPedidosDet> getSolicitudesPedidosDetList() {
        return solicitudesPedidosDetList;
    }

    public void setSolicitudesPedidosDetList(List<SolicitudesPedidosDet> solicitudesPedidosDetList) {
        this.solicitudesPedidosDetList = solicitudesPedidosDetList;
    }

    public Clasificaciones getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Clasificaciones idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Impuestos getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(Impuestos idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    @XmlTransient
    public List<PresupuestosClientesDet> getPresupuestosClientesDetList() {
        return presupuestosClientesDetList;
    }

    public void setPresupuestosClientesDetList(List<PresupuestosClientesDet> presupuestosClientesDetList) {
        this.presupuestosClientesDetList = presupuestosClientesDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Productos[ idProducto=" + idProducto + " ]";
    }
    
}
