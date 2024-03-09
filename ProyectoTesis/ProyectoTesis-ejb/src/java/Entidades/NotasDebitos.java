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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "notas_debitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasDebitos.findAll", query = "SELECT n FROM NotasDebitos n"),
    @NamedQuery(name = "NotasDebitos.findByIdNotaDebito", query = "SELECT n FROM NotasDebitos n WHERE n.idNotaDebito = :idNotaDebito"),
    @NamedQuery(name = "NotasDebitos.findByEstado", query = "SELECT n FROM NotasDebitos n WHERE n.estado = :estado"),
    @NamedQuery(name = "NotasDebitos.findByFechaEmision", query = "SELECT n FROM NotasDebitos n WHERE n.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "NotasDebitos.findByFechaVencimiento", query = "SELECT n FROM NotasDebitos n WHERE n.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "NotasDebitos.findByNroComprobante", query = "SELECT n FROM NotasDebitos n WHERE n.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "NotasDebitos.findByNroTimbrado", query = "SELECT n FROM NotasDebitos n WHERE n.nroTimbrado = :nroTimbrado")})
public class NotasDebitos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_debito")
    private Integer idNotaDebito;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Size(max = 255)
    @Column(name = "nro_comprobante")
    private String nroComprobante;
    @Column(name = "nro_timbrado")
    private BigInteger nroTimbrado;
    @JoinColumn(name = "id_timbrado", referencedColumnName = "id_timbrado")
    @ManyToOne
    private Timbrados idTimbrado;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne
    private UsuariosSucursales usuariosSucursales;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne
    private Ventas idVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notasDebitos")
    private List<NotasDebitosDet> notasDebitosDetList;

    public NotasDebitos() {
    }

    public NotasDebitos(Integer idNotaDebito) {
        this.idNotaDebito = idNotaDebito;
    }

    public Integer getIdNotaDebito() {
        return idNotaDebito;
    }

    public void setIdNotaDebito(Integer idNotaDebito) {
        this.idNotaDebito = idNotaDebito;
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

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
    }

    @XmlTransient
    public List<NotasDebitosDet> getNotasDebitosDetList() {
        return notasDebitosDetList;
    }

    public void setNotasDebitosDetList(List<NotasDebitosDet> notasDebitosDetList) {
        this.notasDebitosDetList = notasDebitosDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaDebito != null ? idNotaDebito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasDebitos)) {
            return false;
        }
        NotasDebitos other = (NotasDebitos) object;
        if ((this.idNotaDebito == null && other.idNotaDebito != null) || (this.idNotaDebito != null && !this.idNotaDebito.equals(other.idNotaDebito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasDebitos[ idNotaDebito=" + idNotaDebito + " ]";
    }
    
}
