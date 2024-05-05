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
@Table(name = "notas_debitos_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasDebitosC.findAll", query = "SELECT n FROM NotasDebitosC n"),
    @NamedQuery(name = "NotasDebitosC.findByIdNotaDebitoC", query = "SELECT n FROM NotasDebitosC n WHERE n.idNotaDebitoC = :idNotaDebitoC"),
    @NamedQuery(name = "NotasDebitosC.findByEstado", query = "SELECT n FROM NotasDebitosC n WHERE n.estado = :estado"),
    @NamedQuery(name = "NotasDebitosC.findByFechaEmision", query = "SELECT n FROM NotasDebitosC n WHERE n.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "NotasDebitosC.findByFechaComprobante", query = "SELECT n FROM NotasDebitosC n WHERE n.fechaComprobante = :fechaComprobante"),
    @NamedQuery(name = "NotasDebitosC.findByNroComprobante", query = "SELECT n FROM NotasDebitosC n WHERE n.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "NotasDebitosC.findByNroTimbrado", query = "SELECT n FROM NotasDebitosC n WHERE n.nroTimbrado = :nroTimbrado"),
    @NamedQuery(name = "NotasDebitosC.findByFechaVencimiento", query = "SELECT n FROM NotasDebitosC n WHERE n.fechaVencimiento = :fechaVencimiento")})
public class NotasDebitosC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_debito_c")
    private Integer idNotaDebitoC;
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
    private BigDecimal nroTimbrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    @ManyToOne(optional = false)
    private Compras idCompra;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notasDebitosC")
    private List<NotasDebitosDetC> notasDebitosDetCList;

    public NotasDebitosC() {
    }

    public NotasDebitosC(Integer idNotaDebitoC) {
        this.idNotaDebitoC = idNotaDebitoC;
    }

    public NotasDebitosC(Integer idNotaDebitoC, String estado, Date fechaEmision, Date fechaComprobante, String nroComprobante, BigDecimal nroTimbrado, Date fechaVencimiento) {
        this.idNotaDebitoC = idNotaDebitoC;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.fechaComprobante = fechaComprobante;
        this.nroComprobante = nroComprobante;
        this.nroTimbrado = nroTimbrado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdNotaDebitoC() {
        return idNotaDebitoC;
    }

    public void setIdNotaDebitoC(Integer idNotaDebitoC) {
        this.idNotaDebitoC = idNotaDebitoC;
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

    public Compras getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compras idCompra) {
        this.idCompra = idCompra;
    }

    public UsuariosSucursales getUsuariosSucursales() {
        return usuariosSucursales;
    }

    public void setUsuariosSucursales(UsuariosSucursales usuariosSucursales) {
        this.usuariosSucursales = usuariosSucursales;
    }

    @XmlTransient
    public List<NotasDebitosDetC> getNotasDebitosDetCList() {
        return notasDebitosDetCList;
    }

    public void setNotasDebitosDetCList(List<NotasDebitosDetC> notasDebitosDetCList) {
        this.notasDebitosDetCList = notasDebitosDetCList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaDebitoC != null ? idNotaDebitoC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasDebitosC)) {
            return false;
        }
        NotasDebitosC other = (NotasDebitosC) object;
        if ((this.idNotaDebitoC == null && other.idNotaDebitoC != null) || (this.idNotaDebitoC != null && !this.idNotaDebitoC.equals(other.idNotaDebitoC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasDebitosC[ idNotaDebitoC=" + idNotaDebitoC + " ]";
    }
    
}
