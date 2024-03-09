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
@Table(name = "solicitudes_pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudesPedidos.findAll", query = "SELECT s FROM SolicitudesPedidos s"),
    @NamedQuery(name = "SolicitudesPedidos.findByIdSolicitudPedido", query = "SELECT s FROM SolicitudesPedidos s WHERE s.idSolicitudPedido = :idSolicitudPedido"),
    @NamedQuery(name = "SolicitudesPedidos.findByObservacion", query = "SELECT s FROM SolicitudesPedidos s WHERE s.observacion = :observacion"),
    @NamedQuery(name = "SolicitudesPedidos.findByFechaPedido", query = "SELECT s FROM SolicitudesPedidos s WHERE s.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "SolicitudesPedidos.findByPresupuestoCliente", query = "SELECT s FROM SolicitudesPedidos s WHERE s.presupuestoCliente = :presupuestoCliente"),
    @NamedQuery(name = "SolicitudesPedidos.findByFechaEntrega", query = "SELECT s FROM SolicitudesPedidos s WHERE s.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "SolicitudesPedidos.findByFechaDevolucion", query = "SELECT s FROM SolicitudesPedidos s WHERE s.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "SolicitudesPedidos.findByDireccionEntrega", query = "SELECT s FROM SolicitudesPedidos s WHERE s.direccionEntrega = :direccionEntrega"),
    @NamedQuery(name = "SolicitudesPedidos.findByDireccionDevolucion", query = "SELECT s FROM SolicitudesPedidos s WHERE s.direccionDevolucion = :direccionDevolucion"),
    @NamedQuery(name = "SolicitudesPedidos.findByEstado", query = "SELECT s FROM SolicitudesPedidos s WHERE s.estado = :estado")})
public class SolicitudesPedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud_pedido")
    private Integer idSolicitudPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presupuesto_cliente")
    private BigInteger presupuestoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion_entrega")
    private String direccionEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion_devolucion")
    private String direccionDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudesPedidos")
    private List<SolicitudesPedidosDet> solicitudesPedidosDetList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitudPedido")
    private List<PresupuestosClientes> presupuestosClientesList;

    public SolicitudesPedidos() {
    }

    public SolicitudesPedidos(Integer idSolicitudPedido) {
        this.idSolicitudPedido = idSolicitudPedido;
    }

    public SolicitudesPedidos(Integer idSolicitudPedido, String observacion, Date fechaPedido, BigInteger presupuestoCliente, Date fechaEntrega, Date fechaDevolucion, String direccionEntrega, String direccionDevolucion, String estado) {
        this.idSolicitudPedido = idSolicitudPedido;
        this.observacion = observacion;
        this.fechaPedido = fechaPedido;
        this.presupuestoCliente = presupuestoCliente;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
        this.direccionEntrega = direccionEntrega;
        this.direccionDevolucion = direccionDevolucion;
        this.estado = estado;
    }

    public Integer getIdSolicitudPedido() {
        return idSolicitudPedido;
    }

    public void setIdSolicitudPedido(Integer idSolicitudPedido) {
        this.idSolicitudPedido = idSolicitudPedido;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public BigInteger getPresupuestoCliente() {
        return presupuestoCliente;
    }

    public void setPresupuestoCliente(BigInteger presupuestoCliente) {
        this.presupuestoCliente = presupuestoCliente;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getDireccionDevolucion() {
        return direccionDevolucion;
    }

    public void setDireccionDevolucion(String direccionDevolucion) {
        this.direccionDevolucion = direccionDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<SolicitudesPedidosDet> getSolicitudesPedidosDetList() {
        return solicitudesPedidosDetList;
    }

    public void setSolicitudesPedidosDetList(List<SolicitudesPedidosDet> solicitudesPedidosDetList) {
        this.solicitudesPedidosDetList = solicitudesPedidosDetList;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public UsuariosSucursales getUsuariosSucursales() {
        return usuariosSucursales;
    }

    public void setUsuariosSucursales(UsuariosSucursales usuariosSucursales) {
        this.usuariosSucursales = usuariosSucursales;
    }

    @XmlTransient
    public List<PresupuestosClientes> getPresupuestosClientesList() {
        return presupuestosClientesList;
    }

    public void setPresupuestosClientesList(List<PresupuestosClientes> presupuestosClientesList) {
        this.presupuestosClientesList = presupuestosClientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudPedido != null ? idSolicitudPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudesPedidos)) {
            return false;
        }
        SolicitudesPedidos other = (SolicitudesPedidos) object;
        if ((this.idSolicitudPedido == null && other.idSolicitudPedido != null) || (this.idSolicitudPedido != null && !this.idSolicitudPedido.equals(other.idSolicitudPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SolicitudesPedidos[ idSolicitudPedido=" + idSolicitudPedido + " ]";
    }
    
}
