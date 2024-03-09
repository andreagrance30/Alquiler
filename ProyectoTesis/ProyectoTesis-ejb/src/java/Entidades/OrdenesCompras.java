/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
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
import javax.persistence.JoinColumns;
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
@Table(name = "ordenes_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesCompras.findAll", query = "SELECT o FROM OrdenesCompras o"),
    @NamedQuery(name = "OrdenesCompras.findByIdOrdenCompra", query = "SELECT o FROM OrdenesCompras o WHERE o.idOrdenCompra = :idOrdenCompra"),
    @NamedQuery(name = "OrdenesCompras.findByEstado", query = "SELECT o FROM OrdenesCompras o WHERE o.estado = :estado"),
    @NamedQuery(name = "OrdenesCompras.findByFechaEmision", query = "SELECT o FROM OrdenesCompras o WHERE o.fechaEmision = :fechaEmision")})
public class OrdenesCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_compra")
    private Integer idOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenesCompras")
    private List<OrdenesComprasDet> ordenesComprasDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdenCompra")
    private List<Compras> comprasList;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Pedidos idPedido;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;

    public OrdenesCompras() {
    }

    public OrdenesCompras(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public OrdenesCompras(Integer idOrdenCompra, String estado, Date fechaEmision) {
        this.idOrdenCompra = idOrdenCompra;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
    }

    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @XmlTransient
    public List<OrdenesComprasDet> getOrdenesComprasDetList() {
        return ordenesComprasDetList;
    }

    public void setOrdenesComprasDetList(List<OrdenesComprasDet> ordenesComprasDetList) {
        this.ordenesComprasDetList = ordenesComprasDetList;
    }

    @XmlTransient
    public List<Compras> getComprasList() {
        return comprasList;
    }

    public void setComprasList(List<Compras> comprasList) {
        this.comprasList = comprasList;
    }

    public Pedidos getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedidos idPedido) {
        this.idPedido = idPedido;
    }

    public UsuariosSucursales getUsuariosSucursales() {
        return usuariosSucursales;
    }

    public void setUsuariosSucursales(UsuariosSucursales usuariosSucursales) {
        this.usuariosSucursales = usuariosSucursales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenCompra != null ? idOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesCompras)) {
            return false;
        }
        OrdenesCompras other = (OrdenesCompras) object;
        if ((this.idOrdenCompra == null && other.idOrdenCompra != null) || (this.idOrdenCompra != null && !this.idOrdenCompra.equals(other.idOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OrdenesCompras[ idOrdenCompra=" + idOrdenCompra + " ]";
    }
    
}
