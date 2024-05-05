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
@Table(name = "notas_creditos_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasCreditosC.findAll", query = "SELECT n FROM NotasCreditosC n"),
    @NamedQuery(name = "NotasCreditosC.findByIdNotaCreditoC", query = "SELECT n FROM NotasCreditosC n WHERE n.idNotaCreditoC = :idNotaCreditoC"),
    @NamedQuery(name = "NotasCreditosC.findByEstado", query = "SELECT n FROM NotasCreditosC n WHERE n.estado = :estado"),
    @NamedQuery(name = "NotasCreditosC.findByFechaEmision", query = "SELECT n FROM NotasCreditosC n WHERE n.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "NotasCreditosC.findByFechaComprobante", query = "SELECT n FROM NotasCreditosC n WHERE n.fechaComprobante = :fechaComprobante"),
    @NamedQuery(name = "NotasCreditosC.findByNroComprobante", query = "SELECT n FROM NotasCreditosC n WHERE n.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "NotasCreditosC.findByNroTimbrado", query = "SELECT n FROM NotasCreditosC n WHERE n.nroTimbrado = :nroTimbrado"),
    @NamedQuery(name = "NotasCreditosC.findByFechaVencimiento", query = "SELECT n FROM NotasCreditosC n WHERE n.fechaVencimiento = :fechaVencimiento")})
public class NotasCreditosC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_credito_c")
    private Integer idNotaCreditoC;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notasCreditosC")
    private List<NotasCreditosDetC> notasCreditosDetCList;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    @ManyToOne(optional = false)
    private Compras idCompra;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;

    public NotasCreditosC() {
    }

    public NotasCreditosC(Integer idNotaCreditoC) {
        this.idNotaCreditoC = idNotaCreditoC;
    }

    public NotasCreditosC(Integer idNotaCreditoC, String estado, Date fechaEmision, Date fechaComprobante, String nroComprobante, BigDecimal nroTimbrado, Date fechaVencimiento) {
        this.idNotaCreditoC = idNotaCreditoC;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.fechaComprobante = fechaComprobante;
        this.nroComprobante = nroComprobante;
        this.nroTimbrado = nroTimbrado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdNotaCreditoC() {
        return idNotaCreditoC;
    }

    public void setIdNotaCreditoC(Integer idNotaCreditoC) {
        this.idNotaCreditoC = idNotaCreditoC;
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

    @XmlTransient
    public List<NotasCreditosDetC> getNotasCreditosDetCList() {
        return notasCreditosDetCList;
    }

    public void setNotasCreditosDetCList(List<NotasCreditosDetC> notasCreditosDetCList) {
        this.notasCreditosDetCList = notasCreditosDetCList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaCreditoC != null ? idNotaCreditoC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasCreditosC)) {
            return false;
        }
        NotasCreditosC other = (NotasCreditosC) object;
        if ((this.idNotaCreditoC == null && other.idNotaCreditoC != null) || (this.idNotaCreditoC != null && !this.idNotaCreditoC.equals(other.idNotaCreditoC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasCreditosC[ idNotaCreditoC=" + idNotaCreditoC + " ]";
    }
    
}
