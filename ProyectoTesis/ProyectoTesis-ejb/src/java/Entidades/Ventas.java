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
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByIdVenta", query = "SELECT v FROM Ventas v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Ventas.findByEstado", query = "SELECT v FROM Ventas v WHERE v.estado = :estado"),
    @NamedQuery(name = "Ventas.findByFechaEmision", query = "SELECT v FROM Ventas v WHERE v.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Ventas.findByNroComprobante", query = "SELECT v FROM Ventas v WHERE v.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "Ventas.findByNroTimbrado", query = "SELECT v FROM Ventas v WHERE v.nroTimbrado = :nroTimbrado"),
    @NamedQuery(name = "Ventas.findByFechaVencimiento", query = "SELECT v FROM Ventas v WHERE v.fechaVencimiento = :fechaVencimiento")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta")
    private Integer idVenta;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nro_comprobante")
    private String nroComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_timbrado")
    private BigDecimal nroTimbrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<CuentasCobrar> cuentasCobrarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventas")
    private List<VentasDet> ventasDetList;
    @OneToMany(mappedBy = "idVenta")
    private List<NotasCreditos> notasCreditosList;
    @OneToMany(mappedBy = "idVenta")
    private List<NotasDebitos> notasDebitosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<OrdenesTrabajos> ordenesTrabajosList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "id_condicion", referencedColumnName = "id_condicion")
    @ManyToOne(optional = false)
    private Condiciones idCondicion;
    @JoinColumn(name = "id_presupuesto_cliente", referencedColumnName = "id_presupuesto_cliente")
    @ManyToOne(optional = false)
    private PresupuestosClientes idPresupuestoCliente;
    @JoinColumn(name = "id_timbrado", referencedColumnName = "id_timbrado")
    @ManyToOne(optional = false)
    private Timbrados idTimbrado;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;
    @OneToMany(mappedBy = "idVenta")
    private List<NotasRemisiones> notasRemisionesList;

    public Ventas() {
    }

    public Ventas(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Ventas(Integer idVenta, String estado, Date fechaEmision, String nroComprobante, BigDecimal nroTimbrado, Date fechaVencimiento) {
        this.idVenta = idVenta;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.nroComprobante = nroComprobante;
        this.nroTimbrado = nroTimbrado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
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

    public String getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(String nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public BigDecimal getNroTimbrado() {
        return nroTimbrado;
    }

    public void setNroTimbrado(BigDecimal nroTimbrado) {
        this.nroTimbrado = nroTimbrado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @XmlTransient
    public List<CuentasCobrar> getCuentasCobrarList() {
        return cuentasCobrarList;
    }

    public void setCuentasCobrarList(List<CuentasCobrar> cuentasCobrarList) {
        this.cuentasCobrarList = cuentasCobrarList;
    }

    @XmlTransient
    public List<VentasDet> getVentasDetList() {
        return ventasDetList;
    }

    public void setVentasDetList(List<VentasDet> ventasDetList) {
        this.ventasDetList = ventasDetList;
    }

    @XmlTransient
    public List<NotasCreditos> getNotasCreditosList() {
        return notasCreditosList;
    }

    public void setNotasCreditosList(List<NotasCreditos> notasCreditosList) {
        this.notasCreditosList = notasCreditosList;
    }

    @XmlTransient
    public List<NotasDebitos> getNotasDebitosList() {
        return notasDebitosList;
    }

    public void setNotasDebitosList(List<NotasDebitos> notasDebitosList) {
        this.notasDebitosList = notasDebitosList;
    }

    @XmlTransient
    public List<OrdenesTrabajos> getOrdenesTrabajosList() {
        return ordenesTrabajosList;
    }

    public void setOrdenesTrabajosList(List<OrdenesTrabajos> ordenesTrabajosList) {
        this.ordenesTrabajosList = ordenesTrabajosList;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Condiciones getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(Condiciones idCondicion) {
        this.idCondicion = idCondicion;
    }

    public PresupuestosClientes getIdPresupuestoCliente() {
        return idPresupuestoCliente;
    }

    public void setIdPresupuestoCliente(PresupuestosClientes idPresupuestoCliente) {
        this.idPresupuestoCliente = idPresupuestoCliente;
    }

    public Timbrados getIdTimbrado() {
        return idTimbrado;
    }

    public void setIdTimbrado(Timbrados idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public UsuariosSucursales getUsuariosSucursales() {
        return usuariosSucursales;
    }

    public void setUsuariosSucursales(UsuariosSucursales usuariosSucursales) {
        this.usuariosSucursales = usuariosSucursales;
    }

    @XmlTransient
    public List<NotasRemisiones> getNotasRemisionesList() {
        return notasRemisionesList;
    }

    public void setNotasRemisionesList(List<NotasRemisiones> notasRemisionesList) {
        this.notasRemisionesList = notasRemisionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ventas[ idVenta=" + idVenta + " ]";
    }
    
}
