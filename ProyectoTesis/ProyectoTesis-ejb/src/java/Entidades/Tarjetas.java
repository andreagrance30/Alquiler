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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tarjetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjetas.findAll", query = "SELECT t FROM Tarjetas t"),
    @NamedQuery(name = "Tarjetas.findByIdTarjeta", query = "SELECT t FROM Tarjetas t WHERE t.idTarjeta = :idTarjeta"),
    @NamedQuery(name = "Tarjetas.findByDescripcion", query = "SELECT t FROM Tarjetas t WHERE t.descripcion = :descripcion")})
public class Tarjetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tarjeta")
    private Integer idTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_entidad_emisora", referencedColumnName = "id_entidad_emisora")
    @ManyToOne(optional = false)
    private EntidadesEmisoras idEntidadEmisora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTarjeta")
    private List<CobrosTarjetas> cobrosTarjetasList;

    public Tarjetas() {
    }

    public Tarjetas(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Tarjetas(Integer idTarjeta, String descripcion) {
        this.idTarjeta = idTarjeta;
        this.descripcion = descripcion;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EntidadesEmisoras getIdEntidadEmisora() {
        return idEntidadEmisora;
    }

    public void setIdEntidadEmisora(EntidadesEmisoras idEntidadEmisora) {
        this.idEntidadEmisora = idEntidadEmisora;
    }

    @XmlTransient
    public List<CobrosTarjetas> getCobrosTarjetasList() {
        return cobrosTarjetasList;
    }

    public void setCobrosTarjetasList(List<CobrosTarjetas> cobrosTarjetasList) {
        this.cobrosTarjetasList = cobrosTarjetasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarjeta != null ? idTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjetas)) {
            return false;
        }
        Tarjetas other = (Tarjetas) object;
        if ((this.idTarjeta == null && other.idTarjeta != null) || (this.idTarjeta != null && !this.idTarjeta.equals(other.idTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tarjetas[ idTarjeta=" + idTarjeta + " ]";
    }
    
}
