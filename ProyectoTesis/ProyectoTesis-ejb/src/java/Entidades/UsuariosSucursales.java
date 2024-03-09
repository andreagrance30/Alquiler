/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "usuarios_sucursales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosSucursales.findAll", query = "SELECT u FROM UsuariosSucursales u"),
    @NamedQuery(name = "UsuariosSucursales.findByIdSucursal", query = "SELECT u FROM UsuariosSucursales u WHERE u.usuariosSucursalesPK.idSucursal = :idSucursal"),
    @NamedQuery(name = "UsuariosSucursales.findByIdUsuario", query = "SELECT u FROM UsuariosSucursales u WHERE u.usuariosSucursalesPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuariosSucursales.findByEstado", query = "SELECT u FROM UsuariosSucursales u WHERE u.estado = :estado")})
public class UsuariosSucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosSucursalesPK usuariosSucursalesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<Pedidos> pedidosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<Compras> comprasList;
    @OneToMany(mappedBy = "usuariosSucursales")
    private List<NotasCreditos> notasCreditosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<AperturaCierreCaja> aperturaCierreCajaList;
    @OneToMany(mappedBy = "usuariosSucursales")
    private List<NotasDebitos> notasDebitosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<NotasDebitosC> notasDebitosCList;
    @OneToMany(mappedBy = "usuariosSucursales")
    private List<NotasRemisionesC> notasRemisionesCList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<OrdenesCompras> ordenesComprasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<OrdenesTrabajos> ordenesTrabajosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<Ventas> ventasList;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sucursales sucursales;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<ArqueosCajas> arqueosCajasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<AjustesInventarios> ajustesInventariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<SolicitudesPedidos> solicitudesPedidosList;
    @OneToMany(mappedBy = "usuariosSucursales")
    private List<NotasRemisiones> notasRemisionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<NotasCreditosC> notasCreditosCList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<Presupuestos> presupuestosList;
    @OneToMany(mappedBy = "usuariosSucursales")
    private List<Intinerarios> intinerariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosSucursales")
    private List<PresupuestosClientes> presupuestosClientesList;

    public UsuariosSucursales() {
    }

    public UsuariosSucursales(UsuariosSucursalesPK usuariosSucursalesPK) {
        this.usuariosSucursalesPK = usuariosSucursalesPK;
    }

    public UsuariosSucursales(UsuariosSucursalesPK usuariosSucursalesPK, String estado) {
        this.usuariosSucursalesPK = usuariosSucursalesPK;
        this.estado = estado;
    }

    public UsuariosSucursales(int idSucursal, String idUsuario) {
        this.usuariosSucursalesPK = new UsuariosSucursalesPK(idSucursal, idUsuario);
    }

    public UsuariosSucursalesPK getUsuariosSucursalesPK() {
        return usuariosSucursalesPK;
    }

    public void setUsuariosSucursalesPK(UsuariosSucursalesPK usuariosSucursalesPK) {
        this.usuariosSucursalesPK = usuariosSucursalesPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Pedidos> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedidos> pedidosList) {
        this.pedidosList = pedidosList;
    }

    @XmlTransient
    public List<Compras> getComprasList() {
        return comprasList;
    }

    public void setComprasList(List<Compras> comprasList) {
        this.comprasList = comprasList;
    }

    @XmlTransient
    public List<NotasCreditos> getNotasCreditosList() {
        return notasCreditosList;
    }

    public void setNotasCreditosList(List<NotasCreditos> notasCreditosList) {
        this.notasCreditosList = notasCreditosList;
    }

    @XmlTransient
    public List<AperturaCierreCaja> getAperturaCierreCajaList() {
        return aperturaCierreCajaList;
    }

    public void setAperturaCierreCajaList(List<AperturaCierreCaja> aperturaCierreCajaList) {
        this.aperturaCierreCajaList = aperturaCierreCajaList;
    }

    @XmlTransient
    public List<NotasDebitos> getNotasDebitosList() {
        return notasDebitosList;
    }

    public void setNotasDebitosList(List<NotasDebitos> notasDebitosList) {
        this.notasDebitosList = notasDebitosList;
    }

    @XmlTransient
    public List<NotasDebitosC> getNotasDebitosCList() {
        return notasDebitosCList;
    }

    public void setNotasDebitosCList(List<NotasDebitosC> notasDebitosCList) {
        this.notasDebitosCList = notasDebitosCList;
    }

    @XmlTransient
    public List<NotasRemisionesC> getNotasRemisionesCList() {
        return notasRemisionesCList;
    }

    public void setNotasRemisionesCList(List<NotasRemisionesC> notasRemisionesCList) {
        this.notasRemisionesCList = notasRemisionesCList;
    }

    @XmlTransient
    public List<OrdenesCompras> getOrdenesComprasList() {
        return ordenesComprasList;
    }

    public void setOrdenesComprasList(List<OrdenesCompras> ordenesComprasList) {
        this.ordenesComprasList = ordenesComprasList;
    }

    @XmlTransient
    public List<OrdenesTrabajos> getOrdenesTrabajosList() {
        return ordenesTrabajosList;
    }

    public void setOrdenesTrabajosList(List<OrdenesTrabajos> ordenesTrabajosList) {
        this.ordenesTrabajosList = ordenesTrabajosList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @XmlTransient
    public List<ArqueosCajas> getArqueosCajasList() {
        return arqueosCajasList;
    }

    public void setArqueosCajasList(List<ArqueosCajas> arqueosCajasList) {
        this.arqueosCajasList = arqueosCajasList;
    }

    @XmlTransient
    public List<AjustesInventarios> getAjustesInventariosList() {
        return ajustesInventariosList;
    }

    public void setAjustesInventariosList(List<AjustesInventarios> ajustesInventariosList) {
        this.ajustesInventariosList = ajustesInventariosList;
    }

    @XmlTransient
    public List<SolicitudesPedidos> getSolicitudesPedidosList() {
        return solicitudesPedidosList;
    }

    public void setSolicitudesPedidosList(List<SolicitudesPedidos> solicitudesPedidosList) {
        this.solicitudesPedidosList = solicitudesPedidosList;
    }

    @XmlTransient
    public List<NotasRemisiones> getNotasRemisionesList() {
        return notasRemisionesList;
    }

    public void setNotasRemisionesList(List<NotasRemisiones> notasRemisionesList) {
        this.notasRemisionesList = notasRemisionesList;
    }

    @XmlTransient
    public List<NotasCreditosC> getNotasCreditosCList() {
        return notasCreditosCList;
    }

    public void setNotasCreditosCList(List<NotasCreditosC> notasCreditosCList) {
        this.notasCreditosCList = notasCreditosCList;
    }

    @XmlTransient
    public List<Presupuestos> getPresupuestosList() {
        return presupuestosList;
    }

    public void setPresupuestosList(List<Presupuestos> presupuestosList) {
        this.presupuestosList = presupuestosList;
    }

    @XmlTransient
    public List<Intinerarios> getIntinerariosList() {
        return intinerariosList;
    }

    public void setIntinerariosList(List<Intinerarios> intinerariosList) {
        this.intinerariosList = intinerariosList;
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
        hash += (usuariosSucursalesPK != null ? usuariosSucursalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosSucursales)) {
            return false;
        }
        UsuariosSucursales other = (UsuariosSucursales) object;
        if ((this.usuariosSucursalesPK == null && other.usuariosSucursalesPK != null) || (this.usuariosSucursalesPK != null && !this.usuariosSucursalesPK.equals(other.usuariosSucursalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuariosSucursales[ usuariosSucursalesPK=" + usuariosSucursalesPK + " ]";
    }
    
}
