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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "intinerarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intinerarios.findAll", query = "SELECT i FROM Intinerarios i"),
    @NamedQuery(name = "Intinerarios.findByIdIntinerario", query = "SELECT i FROM Intinerarios i WHERE i.idIntinerario = :idIntinerario"),
    @NamedQuery(name = "Intinerarios.findByFechaIntinerario", query = "SELECT i FROM Intinerarios i WHERE i.fechaIntinerario = :fechaIntinerario")})
public class Intinerarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_intinerario")
    private Integer idIntinerario;
    @Column(name = "fecha_intinerario")
    @Temporal(TemporalType.DATE)
    private Date fechaIntinerario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "intinerarios")
    private List<IntinerariosDet> intinerariosDetList;
    @JoinColumns({
        @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal"),
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToOne
    private UsuariosSucursales usuariosSucursales;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne
    private Vehiculos idVehiculo;

    public Intinerarios() {
    }

    public Intinerarios(Integer idIntinerario) {
        this.idIntinerario = idIntinerario;
    }

    public Integer getIdIntinerario() {
        return idIntinerario;
    }

    public void setIdIntinerario(Integer idIntinerario) {
        this.idIntinerario = idIntinerario;
    }

    public Date getFechaIntinerario() {
        return fechaIntinerario;
    }

    public void setFechaIntinerario(Date fechaIntinerario) {
        this.fechaIntinerario = fechaIntinerario;
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

    public Vehiculos getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculos idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIntinerario != null ? idIntinerario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intinerarios)) {
            return false;
        }
        Intinerarios other = (Intinerarios) object;
        if ((this.idIntinerario == null && other.idIntinerario != null) || (this.idIntinerario != null && !this.idIntinerario.equals(other.idIntinerario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Intinerarios[ idIntinerario=" + idIntinerario + " ]";
    }
    
}
