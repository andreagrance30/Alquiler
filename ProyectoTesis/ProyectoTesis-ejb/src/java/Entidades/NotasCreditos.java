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
@Table(name = "notas_creditos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasCreditos.findAll", query = "SELECT n FROM NotasCreditos n"),
    @NamedQuery(name = "NotasCreditos.findByIdNotaCredito", query = "SELECT n FROM NotasCreditos n WHERE n.idNotaCredito = :idNotaCredito"),
    @NamedQuery(name = "NotasCreditos.findByEstado", query = "SELECT n FROM NotasCreditos n WHERE n.estado = :estado"),
    @NamedQuery(name = "NotasCreditos.findByFechaEmision", query = "SELECT n FROM NotasCreditos n WHERE n.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "NotasCreditos.findByFechaVencimiento", query = "SELECT n FROM NotasCreditos n WHERE n.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "NotasCreditos.findByNroComprobante", query = "SELECT n FROM NotasCreditos n WHERE n.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "NotasCreditos.findByNroTimbrado", query = "SELECT n FROM NotasCreditos n WHERE n.nroTimbrado = :nroTimbrado")})
public class NotasCreditos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_credito")
    private Integer idNotaCredito;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notasCreditos")
    private List<NotasCreditosDet> notasCreditosDetList;
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

    public NotasCreditos() {
    }

    public NotasCreditos(Integer idNotaCredito) {
        this.idNotaCredito = idNotaCredito;
    }

    public Integer getIdNotaCredito() {
        return idNotaCredito;
    }

    public void setIdNotaCredito(Integer idNotaCredito) {
        this.idNotaCredito = idNotaCredito;
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

    @XmlTransient
    public List<NotasCreditosDet> getNotasCreditosDetList() {
        return notasCreditosDetList;
    }

    public void setNotasCreditosDetList(List<NotasCreditosDet> notasCreditosDetList) {
        this.notasCreditosDetList = notasCreditosDetList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaCredito != null ? idNotaCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasCreditos)) {
            return false;
        }
        NotasCreditos other = (NotasCreditos) object;
        if ((this.idNotaCredito == null && other.idNotaCredito != null) || (this.idNotaCredito != null && !this.idNotaCredito.equals(other.idNotaCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasCreditos[ idNotaCredito=" + idNotaCredito + " ]";
    }
    
}
