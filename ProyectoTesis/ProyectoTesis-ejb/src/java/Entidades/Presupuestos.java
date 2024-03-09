/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "presupuestos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuestos.findAll", query = "SELECT p FROM Presupuestos p"),
    @NamedQuery(name = "Presupuestos.findByIdPresupuesto", query = "SELECT p FROM Presupuestos p WHERE p.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "Presupuestos.findByEstado", query = "SELECT p FROM Presupuestos p WHERE p.estado = :estado"),
    @NamedQuery(name = "Presupuestos.findByNroPresupuesto", query = "SELECT p FROM Presupuestos p WHERE p.nroPresupuesto = :nroPresupuesto"),
    @NamedQuery(name = "Presupuestos.findByFechaCarga", query = "SELECT p FROM Presupuestos p WHERE p.fechaCarga = :fechaCarga"),
    @NamedQuery(name = "Presupuestos.findByFechaPresupuesto", query = "SELECT p FROM Presupuestos p WHERE p.fechaPresupuesto = :fechaPresupuesto"),
    @NamedQuery(name = "Presupuestos.findByValidezPresupuesto", query = "SELECT p FROM Presupuestos p WHERE p.validezPresupuesto = :validezPresupuesto")})
public class Presupuestos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_presupuesto")
    private Integer idPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_presupuesto")
    private BigDecimal nroPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_carga")
    @Temporal(TemporalType.DATE)
    private Date fechaCarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_presupuesto")
    @Temporal(TemporalType.DATE)
    private Date fechaPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validez_presupuesto")
    @Temporal(TemporalType.DATE)
    private Date validezPresupuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresupuesto")
    private List<OrdenesComprasDet> ordenesComprasDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestos")
    private List<PresupuestosDet> presupuestosDetList;
    @JoinColumn(name = "id_condicion", referencedColumnName = "id_condicion")
    @ManyToOne(optional = false)
    private Condiciones idCondicion;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Pedidos idPedido;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false)
    private Proveedores idProveedor;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;

    public Presupuestos() {
    }

    public Presupuestos(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Presupuestos(Integer idPresupuesto, String estado, BigDecimal nroPresupuesto, Date fechaCarga, Date fechaPresupuesto, Date validezPresupuesto) {
        this.idPresupuesto = idPresupuesto;
        this.estado = estado;
        this.nroPresupuesto = nroPresupuesto;
        this.fechaCarga = fechaCarga;
        this.fechaPresupuesto = fechaPresupuesto;
        this.validezPresupuesto = validezPresupuesto;
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getNroPresupuesto() {
        return nroPresupuesto;
    }

    public void setNroPresupuesto(BigDecimal nroPresupuesto) {
        this.nroPresupuesto = nroPresupuesto;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaPresupuesto() {
        return fechaPresupuesto;
    }

    public void setFechaPresupuesto(Date fechaPresupuesto) {
        this.fechaPresupuesto = fechaPresupuesto;
    }

    public Date getValidezPresupuesto() {
        return validezPresupuesto;
    }

    public void setValidezPresupuesto(Date validezPresupuesto) {
        this.validezPresupuesto = validezPresupuesto;
    }

    @XmlTransient
    public List<OrdenesComprasDet> getOrdenesComprasDetList() {
        return ordenesComprasDetList;
    }

    public void setOrdenesComprasDetList(List<OrdenesComprasDet> ordenesComprasDetList) {
        this.ordenesComprasDetList = ordenesComprasDetList;
    }

    @XmlTransient
    public List<PresupuestosDet> getPresupuestosDetList() {
        return presupuestosDetList;
    }

    public void setPresupuestosDetList(List<PresupuestosDet> presupuestosDetList) {
        this.presupuestosDetList = presupuestosDetList;
    }

    public Condiciones getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(Condiciones idCondicion) {
        this.idCondicion = idCondicion;
    }

    public Pedidos getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedidos idPedido) {
        this.idPedido = idPedido;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
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
        hash += (idPresupuesto != null ? idPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuestos)) {
            return false;
        }
        Presupuestos other = (Presupuestos) object;
        if ((this.idPresupuesto == null && other.idPresupuesto != null) || (this.idPresupuesto != null && !this.idPresupuesto.equals(other.idPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Presupuestos[ idPresupuesto=" + idPresupuesto + " ]";
    }
    
}
