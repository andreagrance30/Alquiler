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
@Table(name = "presupuestos_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestosClientes.findAll", query = "SELECT p FROM PresupuestosClientes p"),
    @NamedQuery(name = "PresupuestosClientes.findByIdPresupuestoCliente", query = "SELECT p FROM PresupuestosClientes p WHERE p.idPresupuestoCliente = :idPresupuestoCliente"),
    @NamedQuery(name = "PresupuestosClientes.findByFechaPresupuesto", query = "SELECT p FROM PresupuestosClientes p WHERE p.fechaPresupuesto = :fechaPresupuesto"),
    @NamedQuery(name = "PresupuestosClientes.findByEstado", query = "SELECT p FROM PresupuestosClientes p WHERE p.estado = :estado")})
public class PresupuestosClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_presupuesto_cliente")
    private Integer idPresupuestoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_presupuesto")
    @Temporal(TemporalType.DATE)
    private Date fechaPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresupuestoCliente")
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestosClientes")
    private List<PresupuestosClientesDet> presupuestosClientesDetList;
    @JoinColumn(name = "id_solicitud_pedido", referencedColumnName = "id_solicitud_pedido")
    @ManyToOne(optional = false)
    private SolicitudesPedidos idSolicitudPedido;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;

    public PresupuestosClientes() {
    }

    public PresupuestosClientes(Integer idPresupuestoCliente) {
        this.idPresupuestoCliente = idPresupuestoCliente;
    }

    public PresupuestosClientes(Integer idPresupuestoCliente, Date fechaPresupuesto, String estado) {
        this.idPresupuestoCliente = idPresupuestoCliente;
        this.fechaPresupuesto = fechaPresupuesto;
        this.estado = estado;
    }

    public Integer getIdPresupuestoCliente() {
        return idPresupuestoCliente;
    }

    public void setIdPresupuestoCliente(Integer idPresupuestoCliente) {
        this.idPresupuestoCliente = idPresupuestoCliente;
    }

    public Date getFechaPresupuesto() {
        return fechaPresupuesto;
    }

    public void setFechaPresupuesto(Date fechaPresupuesto) {
        this.fechaPresupuesto = fechaPresupuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @XmlTransient
    public List<PresupuestosClientesDet> getPresupuestosClientesDetList() {
        return presupuestosClientesDetList;
    }

    public void setPresupuestosClientesDetList(List<PresupuestosClientesDet> presupuestosClientesDetList) {
        this.presupuestosClientesDetList = presupuestosClientesDetList;
    }

    public SolicitudesPedidos getIdSolicitudPedido() {
        return idSolicitudPedido;
    }

    public void setIdSolicitudPedido(SolicitudesPedidos idSolicitudPedido) {
        this.idSolicitudPedido = idSolicitudPedido;
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
        hash += (idPresupuestoCliente != null ? idPresupuestoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestosClientes)) {
            return false;
        }
        PresupuestosClientes other = (PresupuestosClientes) object;
        if ((this.idPresupuestoCliente == null && other.idPresupuestoCliente != null) || (this.idPresupuestoCliente != null && !this.idPresupuestoCliente.equals(other.idPresupuestoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PresupuestosClientes[ idPresupuestoCliente=" + idPresupuestoCliente + " ]";
    }
    
}
