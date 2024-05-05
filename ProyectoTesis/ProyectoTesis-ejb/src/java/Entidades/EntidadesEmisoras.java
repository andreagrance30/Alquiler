/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "entidades_emisoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntidadesEmisoras.findAll", query = "SELECT e FROM EntidadesEmisoras e"),
    @NamedQuery(name = "EntidadesEmisoras.findByIdEntidadEmisora", query = "SELECT e FROM EntidadesEmisoras e WHERE e.idEntidadEmisora = :idEntidadEmisora"),
    @NamedQuery(name = "EntidadesEmisoras.findByDescripcion", query = "SELECT e FROM EntidadesEmisoras e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EntidadesEmisoras.findByEstado", query = "SELECT e FROM EntidadesEmisoras e WHERE e.estado = :estado"),
    @NamedQuery(name = "EntidadesEmisoras.findByDireccion", query = "SELECT e FROM EntidadesEmisoras e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "EntidadesEmisoras.findByTelefono", query = "SELECT e FROM EntidadesEmisoras e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "EntidadesEmisoras.findByEmail", query = "SELECT e FROM EntidadesEmisoras e WHERE e.email = :email")})
public class EntidadesEmisoras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entidad_emisora")
    private Integer idEntidadEmisora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidadEmisora")
    private List<CobrosCheques> cobrosChequesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidadEmisora")
    private List<Tarjetas> tarjetasList;

    public EntidadesEmisoras() {
    }

    public EntidadesEmisoras(Integer idEntidadEmisora) {
        this.idEntidadEmisora = idEntidadEmisora;
    }

    public EntidadesEmisoras(Integer idEntidadEmisora, String descripcion, String estado, String direccion, String telefono, String email) {
        this.idEntidadEmisora = idEntidadEmisora;
        this.descripcion = descripcion;
        this.estado = estado;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getIdEntidadEmisora() {
        return idEntidadEmisora;
    }

    public void setIdEntidadEmisora(Integer idEntidadEmisora) {
        this.idEntidadEmisora = idEntidadEmisora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<CobrosCheques> getCobrosChequesList() {
        return cobrosChequesList;
    }

    public void setCobrosChequesList(List<CobrosCheques> cobrosChequesList) {
        this.cobrosChequesList = cobrosChequesList;
    }

    @XmlTransient
    public List<Tarjetas> getTarjetasList() {
        return tarjetasList;
    }

    public void setTarjetasList(List<Tarjetas> tarjetasList) {
        this.tarjetasList = tarjetasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidadEmisora != null ? idEntidadEmisora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadesEmisoras)) {
            return false;
        }
        EntidadesEmisoras other = (EntidadesEmisoras) object;
        if ((this.idEntidadEmisora == null && other.idEntidadEmisora != null) || (this.idEntidadEmisora != null && !this.idEntidadEmisora.equals(other.idEntidadEmisora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.EntidadesEmisoras[ idEntidadEmisora=" + idEntidadEmisora + " ]";
    }
    
}
