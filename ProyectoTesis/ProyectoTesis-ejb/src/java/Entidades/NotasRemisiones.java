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
@Table(name = "notas_remisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasRemisiones.findAll", query = "SELECT n FROM NotasRemisiones n"),
    @NamedQuery(name = "NotasRemisiones.findByIdNotaRemision", query = "SELECT n FROM NotasRemisiones n WHERE n.idNotaRemision = :idNotaRemision"),
    @NamedQuery(name = "NotasRemisiones.findByDireccionLlegada", query = "SELECT n FROM NotasRemisiones n WHERE n.direccionLlegada = :direccionLlegada"),
    @NamedQuery(name = "NotasRemisiones.findByDireccionPartida", query = "SELECT n FROM NotasRemisiones n WHERE n.direccionPartida = :direccionPartida"),
    @NamedQuery(name = "NotasRemisiones.findByEstado", query = "SELECT n FROM NotasRemisiones n WHERE n.estado = :estado"),
    @NamedQuery(name = "NotasRemisiones.findByFechaEmision", query = "SELECT n FROM NotasRemisiones n WHERE n.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "NotasRemisiones.findByFechaFin", query = "SELECT n FROM NotasRemisiones n WHERE n.fechaFin = :fechaFin"),
    @NamedQuery(name = "NotasRemisiones.findByFechaInicio", query = "SELECT n FROM NotasRemisiones n WHERE n.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "NotasRemisiones.findByFechaVenc", query = "SELECT n FROM NotasRemisiones n WHERE n.fechaVenc = :fechaVenc"),
    @NamedQuery(name = "NotasRemisiones.findByMotivo", query = "SELECT n FROM NotasRemisiones n WHERE n.motivo = :motivo"),
    @NamedQuery(name = "NotasRemisiones.findByNroComprobante", query = "SELECT n FROM NotasRemisiones n WHERE n.nroComprobante = :nroComprobante"),
    @NamedQuery(name = "NotasRemisiones.findByNroTimbrado", query = "SELECT n FROM NotasRemisiones n WHERE n.nroTimbrado = :nroTimbrado")})
public class NotasRemisiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota_remision")
    private Integer idNotaRemision;
    @Size(max = 255)
    @Column(name = "direccion_llegada")
    private String direccionLlegada;
    @Size(max = 255)
    @Column(name = "direccion_partida")
    private String direccionPartida;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_venc")
    @Temporal(TemporalType.DATE)
    private Date fechaVenc;
    @Size(max = 255)
    @Column(name = "motivo")
    private String motivo;
    @Size(max = 255)
    @Column(name = "nro_comprobante")
    private String nroComprobante;
    @Column(name = "nro_timbrado")
    private BigInteger nroTimbrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notasRemisiones")
    private List<NotasRemisionesDet> notasRemisionesDetList;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne
    private Empleados idEmpleado;
    @JoinColumn(name = "id_timbrado", referencedColumnName = "id_timbrado")
    @ManyToOne
    private Timbrados idTimbrado;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne
    private UsuariosSucursales usuariosSucursales;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne
    private Vehiculos idVehiculo;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne
    private Ventas idVenta;

    public NotasRemisiones() {
    }

    public NotasRemisiones(Integer idNotaRemision) {
        this.idNotaRemision = idNotaRemision;
    }

    public Integer getIdNotaRemision() {
        return idNotaRemision;
    }

    public void setIdNotaRemision(Integer idNotaRemision) {
        this.idNotaRemision = idNotaRemision;
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

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
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

    @XmlTransient
    public List<NotasRemisionesDet> getNotasRemisionesDetList() {
        return notasRemisionesDetList;
    }

    public void setNotasRemisionesDetList(List<NotasRemisionesDet> notasRemisionesDetList) {
        this.notasRemisionesDetList = notasRemisionesDetList;
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public Vehiculos getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculos idVehiculo) {
        this.idVehiculo = idVehiculo;
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
        hash += (idNotaRemision != null ? idNotaRemision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasRemisiones)) {
            return false;
        }
        NotasRemisiones other = (NotasRemisiones) object;
        if ((this.idNotaRemision == null && other.idNotaRemision != null) || (this.idNotaRemision != null && !this.idNotaRemision.equals(other.idNotaRemision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasRemisiones[ idNotaRemision=" + idNotaRemision + " ]";
    }
    
}
