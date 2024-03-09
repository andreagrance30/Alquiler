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
@Table(name = "notas_remisiones_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasRemisionesC.findAll", query = "SELECT n FROM NotasRemisionesC n"),
    @NamedQuery(name = "NotasRemisionesC.findByIdNotaRemsionC", query = "SELECT n FROM NotasRemisionesC n WHERE n.idNotaRemsionC = :idNotaRemsionC"),
    @NamedQuery(name = "NotasRemisionesC.findByDireccionLlegada", query = "SELECT n FROM NotasRemisionesC n WHERE n.direccionLlegada = :direccionLlegada"),
    @NamedQuery(name = "NotasRemisionesC.findByDireccionPartida", query = "SELECT n FROM NotasRemisionesC n WHERE n.direccionPartida = :direccionPartida"),
    @NamedQuery(name = "NotasRemisionesC.findByEstado", query = "SELECT n FROM NotasRemisionesC n WHERE n.estado = :estado"),
    @NamedQuery(name = "NotasRemisionesC.findByFechaComprobante", query = "SELECT n FROM NotasRemisionesC n WHERE n.fechaComprobante = :fechaComprobante"),
    @NamedQuery(name = "NotasRemisionesC.findByFechaEmision", query = "SELECT n FROM NotasRemisionesC n WHERE n.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "NotasRemisionesC.findByFechaFin", query = "SELECT n FROM NotasRemisionesC n WHERE n.fechaFin = :fechaFin"),
    @NamedQuery(name = "NotasRemisionesC.findByFechaInicio", query = "SELECT n FROM NotasRemisionesC n WHERE n.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "NotasRemisionesC.findByFechaVencimiento", query = "SELECT n FROM NotasRemisionesC n WHERE n.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "NotasRemisionesC.findByMotivo", query = "SELECT n FROM NotasRemisionesC n WHERE n.motivo = :motivo"),
    @NamedQuery(name = "NotasRemisionesC.findByNroComprobante", query = "SELECT n FROM NotasRemisionesC n WHERE n.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "NotasRemisionesC.findByNroTimbrado", query = "SELECT n FROM NotasRemisionesC n WHERE n.nroTimbrado = :nroTimbrado")})
public class NotasRemisionesC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_remsion_c")
    private Integer idNotaRemsionC;
    @Size(max = 255)
    @Column(name = "direccion_llegada")
    private String direccionLlegada;
    @Size(max = 255)
    @Column(name = "direccion_partida")
    private String direccionPartida;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_comprobante")
    @Temporal(TemporalType.DATE)
    private Date fechaComprobante;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Size(max = 255)
    @Column(name = "motivo")
    private String motivo;
    @Size(max = 255)
    @Column(name = "nro_comprobante")
    private String nroComprobante;
    @Column(name = "nro_timbrado")
    private BigInteger nroTimbrado;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    @ManyToOne
    private Compras idCompra;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne
    private UsuariosSucursales usuariosSucursales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notasRemisionesC")
    private List<NotasRemisionesDetC> notasRemisionesDetCList;

    public NotasRemisionesC() {
    }

    public NotasRemisionesC(Integer idNotaRemsionC) {
        this.idNotaRemsionC = idNotaRemsionC;
    }

    public Integer getIdNotaRemsionC() {
        return idNotaRemsionC;
    }

    public void setIdNotaRemsionC(Integer idNotaRemsionC) {
        this.idNotaRemsionC = idNotaRemsionC;
    }

    public String getDireccionLlegada() {
        return direccionLlegada;
    }

    public void setDireccionLlegada(String direccionLlegada) {
        this.direccionLlegada = direccionLlegada;
    }

    public String getDireccionPartida() {
        return direccionPartida;
    }

    public void setDireccionPartida(String direccionPartida) {
        this.direccionPartida = direccionPartida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(Date fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
    public List<NotasRemisionesDetC> getNotasRemisionesDetCList() {
        return notasRemisionesDetCList;
    }

    public void setNotasRemisionesDetCList(List<NotasRemisionesDetC> notasRemisionesDetCList) {
        this.notasRemisionesDetCList = notasRemisionesDetCList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaRemsionC != null ? idNotaRemsionC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasRemisionesC)) {
            return false;
        }
        NotasRemisionesC other = (NotasRemisionesC) object;
        if ((this.idNotaRemsionC == null && other.idNotaRemsionC != null) || (this.idNotaRemsionC != null && !this.idNotaRemsionC.equals(other.idNotaRemsionC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasRemisionesC[ idNotaRemsionC=" + idNotaRemsionC + " ]";
    }
    
}
