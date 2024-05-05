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
@Table(name = "compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByIdCompra", query = "SELECT c FROM Compras c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compras.findByEstado", query = "SELECT c FROM Compras c WHERE c.estado = :estado"),
    @NamedQuery(name = "Compras.findByFechaEmision", query = "SELECT c FROM Compras c WHERE c.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Compras.findByFechaComprobante", query = "SELECT c FROM Compras c WHERE c.fechaComprobante = :fechaComprobante"),
    @NamedQuery(name = "Compras.findByNroComprobante", query = "SELECT c FROM Compras c WHERE c.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "Compras.findByNroTimbrado", query = "SELECT c FROM Compras c WHERE c.nroTimbrado = :nroTimbrado"),
    @NamedQuery(name = "Compras.findByFechaVencimiento", query = "SELECT c FROM Compras c WHERE c.fechaVencimiento = :fechaVencimiento")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compra")
    private Integer idCompra;
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
    @Column(name = "fecha_comprobante")
    @Temporal(TemporalType.DATE)
    private Date fechaComprobante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nro_comprobante")
    private String nroComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_timbrado")
    private BigInteger nroTimbrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @JoinColumn(name = "id_condicion", referencedColumnName = "id_condicion")
    @ManyToOne
    private Condiciones idCondicion;
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra")
    @ManyToOne(optional = false)
    private OrdenesCompras idOrdenCompra;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false)
    private Proveedores idProveedor;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompra")
    private List<NotasDebitosC> notasDebitosCList;
    @OneToMany(mappedBy = "idCompra")
    private List<NotasRemisionesC> notasRemisionesCList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompra")
    private List<CuentasPagar> cuentasPagarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompra")
    private List<NotasCreditosC> notasCreditosCList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compras")
    private List<ComprasDet> comprasDetList;

    public Compras() {
    }

    public Compras(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compras(Integer idCompra, String estado, Date fechaEmision, Date fechaComprobante, String nroComprobante, BigInteger nroTimbrado, Date fechaVencimiento) {
        this.idCompra = idCompra;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.fechaComprobante = fechaComprobante;
        this.nroComprobante = nroComprobante;
        this.nroTimbrado = nroTimbrado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
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

    public Date getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(Date fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public String getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(String nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public BigInteger getNroTimbrado() {
        return nroTimbrado;
    }

    public void setNroTimbrado(BigInteger nroTimbrado) {
        this.nroTimbrado = nroTimbrado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Condiciones getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(Condiciones idCondicion) {
        this.idCondicion = idCondicion;
    }

    public OrdenesCompras getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(OrdenesCompras idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
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
    public List<CuentasPagar> getCuentasPagarList() {
        return cuentasPagarList;
    }

    public void setCuentasPagarList(List<CuentasPagar> cuentasPagarList) {
        this.cuentasPagarList = cuentasPagarList;
    }

    @XmlTransient
    public List<NotasCreditosC> getNotasCreditosCList() {
        return notasCreditosCList;
    }

    public void setNotasCreditosCList(List<NotasCreditosC> notasCreditosCList) {
        this.notasCreditosCList = notasCreditosCList;
    }

    @XmlTransient
    public List<ComprasDet> getComprasDetList() {
        return comprasDetList;
    }

    public void setComprasDetList(List<ComprasDet> comprasDetList) {
        this.comprasDetList = comprasDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Compras[ idCompra=" + idCompra + " ]";
    }
    
}
