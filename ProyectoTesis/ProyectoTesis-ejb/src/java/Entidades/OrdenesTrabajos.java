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
@Table(name = "ordenes_trabajos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesTrabajos.findAll", query = "SELECT o FROM OrdenesTrabajos o"),
    @NamedQuery(name = "OrdenesTrabajos.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenesTrabajos o WHERE o.idOrdenTrabajo = :idOrdenTrabajo"),
    @NamedQuery(name = "OrdenesTrabajos.findByEstado", query = "SELECT o FROM OrdenesTrabajos o WHERE o.estado = :estado"),
    @NamedQuery(name = "OrdenesTrabajos.findByFechaOrden", query = "SELECT o FROM OrdenesTrabajos o WHERE o.fechaOrden = :fechaOrden")})
public class OrdenesTrabajos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_trabajo")
    private Integer idOrdenTrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenesTrabajos")
    private List<IntinerariosDet> intinerariosDetList;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne(optional = false)
    private UsuariosSucursales usuariosSucursales;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(optional = false)
    private Ventas idVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenesTrabajos")
    private List<OrdenesTrabajosDet> ordenesTrabajosDetList;

    public OrdenesTrabajos() {
    }

    public OrdenesTrabajos(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public OrdenesTrabajos(Integer idOrdenTrabajo, String estado, Date fechaOrden) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.estado = estado;
        this.fechaOrden = fechaOrden;
    }

    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    @XmlTransient
    public List<IntinerariosDet> getIntinerariosDetList() {
        return intinerariosDetList;
    }

    public void setIntinerariosDetList(List<IntinerariosDet> intinerariosDetList) {
        this.intinerariosDetList = intinerariosDetList;
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
    public List<OrdenesTrabajosDet> getOrdenesTrabajosDetList() {
        return ordenesTrabajosDetList;
    }

    public void setOrdenesTrabajosDetList(List<OrdenesTrabajosDet> ordenesTrabajosDetList) {
        this.ordenesTrabajosDetList = ordenesTrabajosDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajo != null ? idOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesTrabajos)) {
            return false;
        }
        OrdenesTrabajos other = (OrdenesTrabajos) object;
        if ((this.idOrdenTrabajo == null && other.idOrdenTrabajo != null) || (this.idOrdenTrabajo != null && !this.idOrdenTrabajo.equals(other.idOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OrdenesTrabajos[ idOrdenTrabajo=" + idOrdenTrabajo + " ]";
    }
    
}
